# Custom function to calculate sum
def calSum(no):
	sum = 0
	for no in no:
		sum += no
	return sum

# Define the list of numbers
noList = [20, 30, 40, 60]

# Call the sum() function with numList as argument
result = calSum(noList)

# Print result with message
print("The sum of all the elements is: " + str(result))