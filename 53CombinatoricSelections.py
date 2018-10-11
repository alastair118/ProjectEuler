count = 0

def factorial(n):
    fact = 1
    for i in range(1,n+1):
        fact *= i
    return fact

for n in range(1,101):
    for r in range(n):
        #print(factorial(n)/(factorial(r)*factorial(n-r)))
        if (float(factorial(n))/(factorial(r)*factorial(n-r)) > 1000000):
            count += 1
print(count)
