import random

print("\n \n This program will print one line that stores a wide" +
      " variety of random characters and symbols. \n (NOTE: Depending on the size" +
      " of the window, this \"one line\" will actually appear as multiple lines.) \n" +
      " Depending on the input of your choice, your job is to find which index" +
      " one specific character is located inside of that line of characters. \n")

print("RULES: \n Your chosen character will only appear once. \n \n" +
      " -You can only enter valid characters (characters that appear when typed in general). \n" +
      " For example: Space CAN BE TYPED, letters and numbers can be typed, but delete cannot be typed. \n \n" +
      " -Only symbols with easy access on the keyboard can be typed. \n" +
      " GOOD EXAMPLES (ALLOWED): $, %, ^, & (They can all be easily found on a regular keyboard) \n" +
      " BAD EXAMPLES (PROHIBITED): , ±, œ, ☺ (not universally available for easy access) \n \n" +
      " -The first character is index 0, the second character is index 1, and so on. \n \n" +
      " -If the line of characters extends past one line on your window (that is," +
      " multiple lines appear on your window), the next index will be the first character" +
      " on the very next line. \n \n" +
      " -Be careful when using space as your character, as it is possible " +
      " for space to be the last character in the line and thus become invisible." +
      " \n \n Good luck! \n")

input_char = input("Choose the character that you want to find: ")

length = int(input("How long do you want your line of characters to be? "))

print(" \n \n THE GENERATED LINE: \n")
random_line = generate_random_line(input_char, length)

print(random_line)

index_guess = int(input("\n In which index is the character \'" + input_char + "\' found? "))

# Code the algorithm that checks if the user entered the right index






# Don't worry about this code. It just creates the random line as described at the beginning.
def generate_random_line(target_char, length):
    current_line = ""
    inserted_char = False
    
    for i in range(length):
        new_char = chr(random.randint(32, 126))
        
        while inserted_char and new_char == target_char:
            new_char = chr(random.randint(32, 126))
        
        if new_char == target_char:
            inserted_char = True
        
        current_line += new_char
    
    if current_line.find(target_char) == -1:
        random_index = random.randint(0, len(current_line) - 1)
        
        if random_index > 0:
            current_line = current_line[:random_index - 1] + target_char + current_line[random_index + 1:]
        else:
            current_line = target_char + current_line[1:]
    
    return current_line

