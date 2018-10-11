largest = 0
i_max = 0
j_max = 0

for i in range(100,1000):
    for j in range(100,1000):
        if str(i*j) == str(i*j)[::-1]:
            #print("{} is a palindrome, its is a product of {} and {}".format(i*j, i, j))
            if i*j > largest:
                largest = i*j
                i_max = i
                j_max = j
if largest == 0:
    print("There are no palindromes that are the product of two 3-digit numbers.")
else:
    print("The largest palindrome made of two 3-digit numbers is {}".format(largest))
    print("It is a product of {} and {}".format(i_max, j_max))
