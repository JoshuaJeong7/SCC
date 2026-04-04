import random
# If you've seen Intermediate/Advanced Java's PokemonBattle, this is an easier
# version of that code!
# Both you (P1) and P2 get identical "Pokemon" with identical moves, and you
# both try to attack each other until one of you wins!
# You can still change this code to change your moves to something different that you want to see!

hp1 = 150
hp2 = 150
atk1 = 10
atk2 = 10

while True:
    print("What do you want to do, Player 1?")
    print("(1) Attack")
    print("(2) Heal")
    print("(3) Gamble")
    print("(4) Crit Atk")
    p1_input = input("Player 1, choose a number for your move!")

    if p1_input == 1:
        #Make player 2 lose atk1 hp
        print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
    elif p1_input == 2:
        #Make player 1 heal 15% of its current hp
        print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
    elif p1_input == 3:
        #This is a fun one! Make it so that you have a 10% chance to increase your hp by 200! Otherwise, lose 10 hp.
        print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
    elif p1_input == 4:
        #This is a fun one too! Make there a 20% chance for you to deal 50 damage to player 2! Otherwise, deal only 5 damage to player 2.
        print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")

    #Now repeat this code for the other side (player 2)!

    
#Checking which player won:
#If both player's hp is zero, then it's a draw.
#Otherwise, if player 2's hp is zero, player 1 wins!
#Lastly, if player 1's hp is zero, then player 2 wins!
print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
