
import random
"""
You will be coding a game of rock paper scissors. Add in any of your own fun functionality,
such as making 5 decisions that the user and opponent have to pick from! Happy coding!
"""
#With an infinite loop like this, we will keep playing Rock Paper Scissors UNTIL the user wants to stop.
while True:

  # Checking if the user wants to keep playing. If not, then end the game immediately.
  is_quitting = int(input("\nWould you like to play Rock-Paper-Scissors?  (0 for no, any other number for yes))")
  if is_quitting == 0:
    break

  """
  Ask the user to pick their response between rock, paper, or scissors.
   Treat "rock" as the number 0, "paper" as 1, and "scissors" as 2.
   Process:
   - 1: Ask the user for a NUMBER. (If you're getting a NUMBER as input, make sure to typecast with int()! )
   - 2: After getting the user input, test to see if they actually entered a number between 0 and 2.
        If not, use a loop to keep asking the user for a valid number to input, until they input a valid number!
  """
  #START YOUR CODE HERE AND FINISH THE TASK DESCRIBED ABOVE

  
  """
  Have the second player pick their response between rock, paper, or scissors.
  To make things simple, I will create a computer opponent who will randomly guess between 3 numbers.
  """
  computer_choice = random.randint(0, 2)

  """
  Use logic to determine which player won that round of rock-paper-scissors.
  Process:
   - 1: If the user entered 0 (rock) and the computer entered 2 (scissors), the user wins.
   - 2: If the user entered 1 (paper) and the computer entered 0 (rock), the user wins.
   - 3: If the user entered 2 (scissors) and the computer entered 1 (paper), the user wins.
   - 4: Otherwise, if both the user and the computer entered the same number, it's a tie.
   - 5: If none of the previous conditions are met, the computer must have won.

   Use an if-elif-else block structure to figure out who won. Happy coding!
  """
  
  #START YOUR CODE HERE AND FINISH THE TASK ABOVE


  
