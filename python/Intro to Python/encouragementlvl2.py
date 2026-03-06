# This program prints encouraging messages to the user to uplfit their spirits!
# There are up to 12 (add more if you want to!) messages that the user can receive

# THIS time, try printing a RANDOM word of encouragement upon request of the user!
import random

msg1 = "You are loved!"
msg2 = "You can do this!"
msg3 = "It's okay to take a break and enjoy life."
msg4 = "Add your own encouraging message!"

#Add more encouraging messages for msg5 to msg12!

user_input = ""
while user_input != "quit":
    user_input = input('Press enter to receive a random word of encouragement! Type "quit" to end the program.')

    # Here, print every word of encouragement from msg1 to msg12,
    # depending on a RANDOM number between 1-12 (not chosen by the user)!

