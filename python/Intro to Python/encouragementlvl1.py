# This program prints encouraging messages to the user to uplfit their spirits!
# There are up to 12 (add more if you want to!) messages that the user can receive.
# Depending on which number the user gets, they will receive their encouraging message!
# This program ends when the user enters -1.

msg1 = "You are loved!"
msg2 = "You can do this!"
msg3 = "It's okay to take a break and enjoy life."
msg4 = "Add your own encouraging message!"

#Add more encouraging messages for msg5 to msg12!

user_input = ""
while user_input != -1:
    user_input = int(input("Enter a number from 1-12 for a word of encouragement!"))

    # Here, print every word of encouragement from msg1 to msg12 depending on the user input!

