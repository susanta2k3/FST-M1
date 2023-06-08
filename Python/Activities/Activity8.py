# Given list of numbers
element_list=list(input("Enter numbers").split(","))
print("Given list is ", element_list)

# Get first element in list
firstElement = element_list[0]
# Get last element in list
lastElement = element_list[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)