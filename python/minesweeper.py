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

def set_mine(grid, num_mine):
    row = random.randint(0, GRID_SIZE - 1)
    col = random.randint(0, GRID_SIZE - 1)
    while num_mine > 0:
        while (grid[row][col] == -1):
            row = random.randint(0, GRID_SIZE - 1)
            col = random.randint(0, GRID_SIZE - 1)
        grid[row][col] = -1
        num_mine -= 1

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


discovered_locs = set()
def reveal_location(answer_map, tested_map, y, x):
    if x < 0 or y < 0 or x >= GRID_SIZE or y >= GRID_SIZE:
        return True
    if tested_map[y][x] == -3:
        input("You cannot reveal a flagged location. [Press enter to acknowledge]")
        return True

    discovered_locs.add((y, x))
    tested_map[y][x] = answer_map[y][x]
    
    if answer_map[y][x] == -1:
        return False
    
    if answer_map[y][x] != 0:
        return True
    
    all_adj = ((y - 1, x - 1), (y - 1, x), (y - 1, x + 1), (y, x - 1), (y, x + 1), (y + 1, x - 1), (y + 1, x), (y + 1, x + 1))
    found_all_locs = True
    for (r, c) in all_adj:
        if (r, c) not in discovered_locs:
            found_all_locs = found_all_locs and reveal_location(answer_map, tested_map, r, c)
    return found_all_locs


def flag_loc(grid, y, x):
    if grid[y][x] == -2:
        grid[y][x] = -3
    elif grid[y][x] == -3:
        grid[y][x] = -2
    else:
        input("Cannot flag an already explored tile. [Press enter to acknowledge]")

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