#Currency calculator 

def currency_calculator():
    fro=int(input("Input currency in INR: "))

    print("If you want to convert to foolowing currency type: \n ")
    print("GBP for Pounds ")
    print("USD for US dollars")
    print("CHF for Swiss Franc")
    print("JPY for Japanese Yen ")
    print("CAD for Cannadian Dollars ")
    print("AUD for Australian Dollars ")
    print("KRW for South Korean Won ")
    choice=input("Enter your choice: ")



    if choice=="GBP":
        a= fro*0.0099
        print("INR",fro, "in GBP(Pounds) is ",round(a,2))
    elif choice=="USD":
        a=fro*0.012
        print("INR", fro, "in USD(US Dollars) is " ,round(a,2))
    elif choice=="CHF":
        a=fro*0.011
        print("INR", fro, "in CHF(Swiss Franc) is ",round(a,2))
    elif choice=="JPY":
        a=fro*1.59
        print("INR", fro, "in JPY(Japanese Yen) is ",round(a,2))
    elif choice=="CAD":
        a=fro*0.016
        print("INR", fro, "in CAD(Cannadian Dollars) is ",round(a,2))
    elif choice=="AUD":
        a=fro*0.017
        print("INR", fro , "in AUD(Australian Dollars) is ",round(a,2))
    elif choice=="KRW":
        a=fro*15.02
        print("INR",fro, "in KRW(South Korean Won) is ",round(a,2))
    else:
        print("Enter correct value ")

currency_calculator()
