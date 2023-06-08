# Import pandas
import pandas as pd

# Create a Dictionary that will hold our data
data = {
  "Usernames": ["admin", "Susanta", "Rama"],
  "Passwords": ["password", "password1", "password2"]
}

# Create a DataFrame using that data
dataframe = pd.DataFrame(data)

# Print the DataFrame
print(dataframe)

#Write dataframe to csv
dataframe.to_csv("sample.csv", index=False)