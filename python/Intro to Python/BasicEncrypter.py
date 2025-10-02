print("This program takes in a string and encrypts it," +
      " or shifts all letters two positions down the alphabet. \n" + 
      "For example, 'A' will become 'C', 'D' will become 'F', " +
      " and so on. \n At the end of the alphabet, 'X' becomes 'A' and " +
      " 'Z' becomes 'B'. \n Non-letters (numbers, symbols, etc.)" +
      " will not be shifted at all. \n \n")
print("Enter your 5-letter word to encrypt:")
word = #Finish the code here (take in the user input for a 5-letter word)

letter1 = #Finish the code here (get the first letter of your 'word' variable)
letter2 = #Finish the code here (get the second letter of your 'word' variable)
letter3 = #Finish the code here (get the third letter of your 'word' variable)
letter4 = #Finish the code here (get the fourth letter of your 'word' variable)
letter5 = #Finish the code here (get the fifth letter of your 'word' variable)

print("The encrypted word:")
encryptLetterAndPrint(letter1)

#Encrypt the letter and print for the rest of the other four letters




# Don't worry about this code, it just encrypts a letter.
def encryptLetterAndPrint(word):
    letter = word[0]
    
    if ('A' <= letter <= 'Z') or ('a' <= letter <= 'z'):
        letter = chr(ord(letter) + 2)
        if (('A' < letter < 'a') or (letter > 'Z' and letter > 'z')):
            letter = chr(ord(letter) - 26)
    print(letter)

