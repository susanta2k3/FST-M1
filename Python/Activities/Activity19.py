# Import pandas
import pandas as pd
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
	'FirstName':["Susanta", "Rama", "Kumar"],
	'LastName':["Kumar", "Garg", "Sinha"],
	'Email':["Susanta@example.com", "RamaG@example.com", "KumarS@example.com"],
	'PhoneNumber':["812344361", "4123484058", "4432127830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pd.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)

# Commit data to the Excel file
writer.save()