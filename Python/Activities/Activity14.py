def fibbonaci(number):
    if number<=1:
        return number
    else:
        return(fibbonaci(number-1)+fibbonaci(number-2))
nterms = int(input("Enter a number"))

if nterms<=0:
    print("Enter a positive number")
else:
    print("Fibonacci sequence")
    for i in range(nterms):
        print(fibbonaci(i))