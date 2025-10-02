import random
GRID_SIZE = 15
default_rows = [0] * GRID_SIZE
correct_map = [default_rows.copy() for i in default_rows] 
#Creates a square grid of 0s with side length GRID_SIZE.
#This square grid uses copies of rows, so that each row is a separate list and do not reference each other.
#This allows us to create separate grids unrelated to each other, 
#but be aware that correct_map itself can still be referenced twice by two variables,
#so if you want to create a new grid, you should use correct_map.copy() to create a new, unlinked grid.

player_rows = [-2] * GRID_SIZE
player_map = [player_rows.copy() for i in player_rows]

def reset_map(grid):
    grid.clear()
    for i in range(0, GRID_SIZE):
        grid.append(default_rows.copy())

"""
This is one of the methods you have to complete.
Given the parameter num_mine, which defines the number of mines that are to be placed on the board,
place all of these mines in a random position on the 2D list "grid".
Make sure you prevent one mine from being placed at a location where a mine already exists!
"""
def set_mine(grid, num_mine):
    #Method code here!

def find_nums(grid):
    # r = 0
    # c = 0
    for r in range(0, GRID_SIZE):
        
        for c in range(0, GRID_SIZE):
            count = 0
            all_adj = ((r - 1, c - 1), (r - 1, c), (r - 1, c + 1), (r, c - 1), (r, c + 1), (r + 1, c - 1), (r + 1, c), (r + 1, c + 1))
            #all_adj contains a tuple, which contains 8 tuples for all adjacent locations to the current tile location.

            for coords in all_adj:
                adj_r = coords[0]
                adj_c = coords[1]
                if adj_r < 0 or adj_r >= GRID_SIZE or adj_c < 0 or adj_c >= GRID_SIZE:
                    continue
                        
                if grid[adj_r][adj_c] == -1:
                    count+=1

            if (grid[r][c] != -1):
                grid[r][c] = count


"""
This is probably the hardest method that you will need to code.
You are given a set that contains all the discovered locations.
This function returns either True or False depending on if the user has lost.
If the user has stepped on a mine
(i.e. the given coordinates is the location of a mine in the answer_map),
then the function returns False (lose handling will happen automatically).
If the user has revealed a number on the current location, then modify the
tested_map to show the same number on the answer_key.

However, if the user reveals a spot where there is zero adjacent mines
(i.e. the current coordinates have a value of 0 on the answer key),
then initially update that location on the tested_map with the value of 0, and afterwords
USE RECURSIVE BACKTRACKING to call this function again, but with all locations
adjacent to that current location.

The base case is if the user goes out of bounds OR discovers a non-empty location.
"""
discovered_locs = set()
def reveal_location(answer_map, tested_map, y, x):
    #Code your method here

"""
This is another method you will have to complete.
Given the row and column coordinates (y and x), determine if the current coordinate given
(grid[y][x]) is currently unexplored. 
If it is unexplored (-2), then flag the location (-3).
If the location is already flagged (-3), then unflag it and show the unexplored location (-2).
Otherwise, if the location is any sort of value that indicates it has been explored, 
print an error stating that you cannot flag already explored tiles.
"""
def flag_loc(grid, y, x):
    #Add code here

def print_horiz_bar():
    message = "\t# "
    for i in range(GRID_SIZE):
        message += "# "
    message += "#"
    print(message)

def print_top_bar():
    message = "\t  "
    for i in range(0, min(GRID_SIZE, 10)):
        message += str(i) + " "

    for j in range(10, GRID_SIZE):
        message += str(j)

    print(message)

def print_grid(grid):
    print_top_bar()
    print_horiz_bar()
    count = 0
    for row in grid:
        message = f"{count}\t#" 
        for index in row:
            if index == -1: #bomb
                message += " \033[1;7;31m\033[0m"
            elif index == 0: #empty tile
                message += "  "
            elif index == -2: #UNEXPLORED tile
                message += " -"
            elif index == -3: #flagged tile
                message += " \033[3m¶\033[0m"
            else:
                message += " " #+ str(index)
                #OPTIONAL: See if you can create an entire key for which number corresponds to which color, like in base Minesweeper!
                """-----------------------------------------------SOLUTION"""
                colored = str(index)
                if colored == "1":
                    message += "\033[0;34m" + colored + "\033[0m"
                elif colored == "2":
                    message += "\033[0;32m" + colored + "\033[0m"
                elif colored == "3":
                    message += "\033[0;31m" + colored + "\033[0m"
                elif colored == "4":
                    message += "\033[0;35m" + colored + "\033[0m"
                elif colored == "5":
                    message += "\033[0;33m" + colored + "\033[0m"
                elif colored == "6":
                    message += "\033[1;36m" + colored + "\033[0m"
                elif colored == "7":
                    message += "\033[1;37m" + colored + "\033[0m"
                elif colored == "8":
                    message += "\033[7m" + colored + "\033[0m"
                else:
                    message += "¿"

        message += " #"
        count+=1
        print(message)

    print_horiz_bar()
    print()


def input_coordinate():
    print_grid(player_map)
    (y, x) = tuple(input("Format of input: 1 9\nEnter your coordinates as formatted above to either reveal or flag:").split(" "))
    (y, x) = ( int(y), int(x) )
    return (y, x)

def play_game():
    num_mines = 40
    set_mine(correct_map, num_mines)
    find_nums(correct_map)

    #Here is an example of how you can set the map to a fixed generation during testing:
    """
    correct_map = [[2, -1, 2, 0, 0, 1, -1, 3, -1, 1],
                   [2, -1, 3, 2, 1, 3, 3, -1, 2, 1],
                   [1, 2, -1, 2, -1, 2, -1, 3, 2, 0],
                   [1, 2, 3, 3, 2, 3, 3, -1, 1, 0],
                   [1, -1, 2, -1, 1, 1, -1, 2, 1, 0],
                   [1, 2, 4, 3, 2, 1, 1, 1, 0, 0],
                   [1, 2, -1, -1, 2, 1, 1, 0, 0, 0],
                   [3, -1, 4, 2, 2, -1, 1, 0, 0, 0],
                   [-1, -1, 3, 1, 3, 2, 2, 0, 0, 0],
                   [2, 2, 2, -1, 2, -1, 1, 0, 0, 0]
                   ]
    """

    print("Welcome to Minesweeper!\n")
    print("Would you like to make the game easier by starting on a tile with 0 mines?")
    user_request = input("Enter Y or y to agree, enter anything else to skip")
    if (user_request == 'Y' or user_request == 'y'):
        (y, x) = input_coordinate()
        while (correct_map[y][x] != 0):
            reset_map(correct_map)
            set_mine(correct_map, num_mines)
            find_nums(correct_map)
        reveal_location(correct_map, player_map, y, x)

    while True:
        (y, x) = input_coordinate()
        flagresult = input("Enter 'F' or 'f' if you would like to flag this location, enter any other input to reveal the location")
        if (flagresult == 'F' or flagresult == 'f'):
            flag_loc(player_map, y, x)
        else:
            if not reveal_location(correct_map, player_map, y, x):
                print("You lose!")
                print_grid(correct_map)
                break



if __name__ == "__main__":
    play_game()
