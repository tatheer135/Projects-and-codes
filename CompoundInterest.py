
#To  find the compund interest

def compound_interest(principal,rate,time):
    Amount=principal * (pow((1+rate/100),time))
    CI=Amount-principal
    print("Compund Interest is: ", round(CI,2))

principal=int(input("Enter principal amount: "))
rate=int(input("Enter rate of interest: "))
time=int(input("Enter time in years: "))
compound_interest(principal,rate,time)

