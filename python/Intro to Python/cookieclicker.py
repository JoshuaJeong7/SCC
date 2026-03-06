cookies = 0     # The amount of cookies you have
click_power = 1      # The amount of cookies you gain from one "click"
operation_power = 1 # Whether each click adds (1), multiplies (2), or exponentiates (3) your cookie count by your click power.
cost_multiplier = 1

# This game is essentially all you expect from a simple Cookie Clicker:
#   1: Click to make cookies! (Pretty hard to code "click detection",
#      so instead the user will just press the enter key during an input prompt)
#   2: To make cookies even faster, open the shop and buy upgrades
#      by spending the cookies you've previously made!
#   3: Perhaps unlike what you're used to, later on you get ESPECIALLY
#      powerful upgrades by turning clicks from additive cookie gain to
#      multiplicative and even exponential gain, at the cost of a
#      titanic amount of cookies.
# Good luck! Hope you have fun coding this game!

user_decision = ""
while user_decision != "quit":
    print("TOTAL COOKIES: " + str(cookies) + "¢")
    printed_msg = "\nENTER-KEY: Click to make cookies! \nshop: Open the shop! \nquit: Quit your game session.\n"
    user_decision = input(printed_msg)
    
    if user_decision == "quit":
        break
    elif user_decision != "shop":
        # THIS IS THE IF-STATEMENT WHERE THE USER CLICKS REGULARLY! THIS IS NOT THE CODE FOR THE SHOP!
        # FIRST, you must check what the operation_power is. Then follow this key:
        #   operation_power == 1: Add click_power to [cookies.
        #   operation_power == 2: Multiply click_power to cookies.
        #   operation_power >= 3: cookies is raised to the click_power'th power. (cookies ** click_power)
        print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
    else:
        buy_decision = -3 #Default value to allow the loop to start but WON'T trigger an unwanted shop buy
        while buy_decision != -1:
            print("\n{SHOP}\nHere are the items you can buy:")
            #This below is the f string, basically it acts like a normal string except wherever there are brackets inside, you can subsitute ACTUAL calculated values for what should be printed
            print(f"1: Cookie Increment - Clicks now give {click_power + 1} cookies per click. ({click_power * 10 * cost_multiplier}¢)")
            print(f"2: Shop Discount - All items are now permanently 1% cheaper. ({100 * (1 ** -cost_multiplier)}¢)")
            print(f"3: Cookie Loan - Gives {cookies * 15} cookies immediately. Makes every other item in the shop 5% more expensive. ({cookies}¢)")

            print("\nFeel free to code more shop items yourself and decide what they do!")
            print("Note: If you don't have enough variables to code the items you want to add, then add more variables of your own! Have fun with creating your own items!\n")

            print(f"\n0: OPERATOR UPGRADE - 'Prestiges' your cookie clicker! Reset your cookies to one and cookie power to 2, however promotes your cookie adder into a cookie multiplier, or a cookie multiplier into a cookie exponentiator! (100^{(100 * operation_power)} ¢)")
            print("-1: Exit the shop")
            buy_decision = int(input("\nChoose which item you would like to buy by entering its respective number:"))

            if buy_decision == 1:
                # This should be a simple one. Simply add 1 to click_power, BUT ONLY if the user can afford it.
                print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
            elif buy_decision == 2:
                # If the user can afford it, multiply cost_multiplier by 0.99.
                print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")
            elif buy_decision == 3:
                # If the user can afford it, add (15 * cookies) to their cookie count.
                # However, prices get more expensive, so multiple cost_multiplier by 1.05.
                print("If you are seeing this message, you haven't finished the code in Python! Go follow the directions in the comments and delete this print statement after you finish the code's function.")

            elif buy_decision == 0:
                #We will provide this code for you. Use the cost flow-chart to see how to handle whether or not the user can afford this item!
                if cookies >= 100 ** (100 * operation_power):
                    operation_power += 1
                    cookies = 1
                    cookie_power = 2
                    input(f"Item bought! (COOKIES LEFT: {cookies}¢)\nPRESS ENTER TO CONTINUE")
                else:
                    input(f"Sorry, not enough cookies! (MISSING {100 ** (100 * operation_power) - cookies}¢)\nPRESS ENTER TO CONTINUE")
            elif buy_decision == -1:
                print("Thanks for shopping!\n")

        