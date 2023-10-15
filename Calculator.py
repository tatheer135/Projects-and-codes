#calculator in Python 

number=int(input("Enter the first number: "))
number2=int(input("Enter the second number: "))
print ("Please select the operation.")    
print ("'a' Add")    
print ("'b' Subtract")    
print ("'c' Multiply")    
print ("'d' Divide")   
choice =input("Enter your choice: ")
if choice == "a":    
   print (number, " + ", number2, " = ", number+number2)    
    
elif choice == "b":    
   print (number, " - ", number2, " = ", number-number2)    
    
elif choice == "c":    
   print (number, " * ", number2, " = ", number*number2)    
elif choice == "d":    
   print (number, " / ", number2, " = ", number/number2)    
else:    
   print ("This is an invalid input")    
