
import random
"""
You will be coding a game of Fireball.
In default Fireball, there are two players and three options for both players:
   1. Charge - Does nothing by itself, but allows you to use Fireball.
   2. Fireball - If you use this to attack your opponent, you win!
      Note 1: Using Fireball will exhaust your charge and you will have to Charge again to use Fireball.
      Note 2: If both players use Fireball, they cancel each other out and nothing happens.
   3. Block - If you use this while your opponent uses Fireball, you defend and stay alive while the opponent exhausts their charge.

Each round, both players must choose one option to use at the same time.
Keep playing rounds until one player uses a Fireball that is undefended and wins!

Add in any of your own fun functionality,
such as new attacking and defending options! Happy coding!
"""
p1Charges = 0
p2Charges = 0
#With an infinite loop like this, we will keep playing Fireball UNTIL the user wants to stop.
while True:

  # Checking if the user wants to keep playing. If not, then end the game immediately.
    is_quitting = int(input("\nWould you like to play Fireball?  (0 for no, any other number for yes)"))
    if is_quitting == 0:
        break

    """
    Ask the user to pick their response between charge, block, or fireball.
    Treat "charge" as the number 0, "block" as 1, and "fireball" as 2.
    Process:
    - 1: Ask the user for a NUMBER. (If you're getting a NUMBER as input, make sure to typecast with int()! )
    - 2: After getting the user input, test to see if they actually entered a number between 0 and 2.
            If not, use a loop to keep asking the user for a valid number to input, until they input a valid number!
    """
  #START YOUR CODE HERE AND FINISH THE TASK DESCRIBED ABOVE
    input("(1) If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")

    

    """
    Have the second player pick their response between charge, block, or fireball.
    Follow the same structure as player 1!
    """
    print("\n\n\n\n\nThis print statement is to preserve privacy of player 1's answer choice. Please don't scroll up!\n\n\n\n\n")
     #START YOUR CODE HERE AND FINISH THE TASK DESCRIBED ABOVE
    input("(2) If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")

    """
    Here is the process of what to do for each action
    Process:
    - Charge: Both players have an int for how many charges they have. Just add one to that charge!
    - Block: Does nothing, but is crucial for if the OTHER player uses Fireball.
    - Fireball: Fireball will always use up one charge. If no charges left, you cannot lose Fireball.
        - If the other opponent Blocks, your Fireball does nothing.
        - If the other opponent Fireballs, both of your Fireballs do nothing.
        - If the other opponent Charges, you win! All you need to do is print a win message for the player who won

    Use an if-elif-else block structure to figure out what to do each turn. Happy coding!
    """
    
    #START YOUR CODE HERE AND FINISH THE TASK ABOVE
    input("(3) If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")

    """
    Repeat the same exact code structure from above, but for Player 2 now!
    As a reminder, here is the process of what to do for each action
    Process:
    - Charge: Both players have an int for how many charges they have. Just add one to that charge!
    - Block: Does nothing, but is crucial for if the OTHER player uses Fireball.
    - Fireball: Fireball will always use up one charge. If no charges left, you cannot lose Fireball.
        - If the other opponent Blocks, your Fireball does nothing.
        - If the other opponent Fireballs, both of your Fireballs do nothing.
        - If the other opponent Charges, you win! All you need to do is print a win message for the player who won

    Use an if-elif-else block structure to figure out what to do each turn. Happy coding!
    """

    #START YOUR CODE HERE AND FINISH THE TASK ABOVE
    input("(4) If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")




  