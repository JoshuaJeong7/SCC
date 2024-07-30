print("This program takes in a string and encrypts it," +
      " or shifts all letters two positions down the alphabet. \n" + 
      "For example, 'A' will become 'C', 'D' will become 'F', " +
      " and so on. \n At the end of the alphabet, 'X' becomes 'A' and " +
      " 'Z' becomes 'B'. \n Non-letters (numbers, symbols, etc.)" +
      " will not be shifted at all. \n \n")
print("Enter your 5-letter word to encrypt:")
word =

letter1 = 
letter2 = 
letter3 = 
letter4 = 
letter5 = 

print("The encrypted word:", end=' ')
encryptLetterAndPrint(letter1)
encryptLetterAndPrint(letter2)
encryptLetterAndPrint(letter3)
encryptLetterAndPrint(letter4)
encryptLetterAndPrint(letter5)

print()


# Don't worry about this code, it just encrypts a letter.
def encryptLetterAndPrint(word):
    letter = word[0]
    
    if ('A' <= letter <= 'Z') or ('a' <= letter <= 'z'):
        letter = chr(ord(letter) + 2)
        if (('A' < letter < 'a') or (letter > 'Z' and letter > 'z')):
            letter = chr(ord(letter) - 26)
    print(letter, end='')

