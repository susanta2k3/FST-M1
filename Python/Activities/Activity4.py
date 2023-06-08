user1=input("Enter user 1's name:")
user2 = input("Enter user 2's name")

while True:
    user1_answer=input("What is user1's answer?")
    user2_answer=input("What is user2's answer?")

    if user1_answer==user2_answer:
        print("Its a tie.")
    elif user1_answer=='rock':
        if(user2_answer=='scissors'):
            print ("Rock wins!")
        else :
            print("Paper wins!")
    elif user1_answer =='scissors':
        if(user2_answer=='paper'):
            print("Scissors wins!")
        else:
            print("Rock wins!")
    elif(user1_answer=='paper'):
        if(user2_answer=='rock'):
            print("Rock wins!")
        else:
            print("Scissors wins!")
    else:
        print("Invalid input, you have not entered rock, paper or scissors. Try again.")
    repeat=input("Do you want to play again. Say Yes/No").lower()
    if(repeat=="yes"):
        pass
    elif(repeat=="no"):
        raise SystemExit
else:
    print("You have entered an invalid option. Existing now")
    raise SystemExit
    

