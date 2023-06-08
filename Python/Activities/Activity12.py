# Define function to calculate sum
def calSum(no):
  if no:
    # Recursive function call
    return no + calSum(no-1)
  else:
    return 0

# Call calculateSum() function
res = calSum(10)

# Print result
print(res)