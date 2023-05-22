import requests as rq
import pandas as pd
import os

currentDir = os.path.dirname(os.path.realpath(__file__))
os.chdir(currentDir)

def validationProcess():
    print("Initializing Testing process")
    testCases = pd.read_excel("test_cases.xlsx",dtype=str)
    result = ''
    for index,row in testCases.iterrows():
        response = checksRequest(row['rate'], row['annuity'], row['periods'], row['annuityToGo'],row['periodsToGo'])
        result = 'success' if response == float(row['expectedOut']) else 'fail'
        print ("---------------------------------")
        print ("Test case Number " + str(index+1))
        print ("Expected Value = " + row['expectedOut'] + " Calculated value= " + str(response) + " result " + result)

def checksRequest(rate, annuity, periods, annuityToGo, periodsToGo):

    checkRequest = rq.get("http://localhost:8081/rateconverter/api/convert",
                      params={"rate":rate,
                              "annuity":annuity,
                              "periods":periods,
                              "annuityToGo":annuityToGo,
                              "periodsToGo":periodsToGo})
    return float(checkRequest.text)



if __name__ == "__main__":
    validationProcess()