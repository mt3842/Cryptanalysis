from flask import Flask, request, render_template, render_template_string, jsonify
app = Flask(__name__)


'''
while True:
    firstKeyword = input("First Keyword: ")
    if firstKeyword.strip().isalpha():  # Check if input is a non-empty string with only alphabetic characters
        break
    else:
        print("Invalid input. Please enter a string with only alphabetic characters.")

while True:
    secondKeyword = input("Second Keyword: ")
    if secondKeyword.strip().isalpha():  # Check if input is a non-empty string with only alphabetic characters
        break
    else:
        print("Invalid input. Please enter a string with only alphabetic characters.")

while True:
    textToEncode = input("Input text to encode: ")
    if textToEncode.strip().isalpha():  # Check if input is a non-empty string with only alphabetic characters
        break
    else:
        print("Invalid input. Please enter a string with only alphabetic characters.")
'''



def encoder(firstKeyword, secondKeyword, textToEncode):
    standard_alphabet = list(map(chr, range(97, 123)))
    for letter in standard_alphabet:
        standard_alphabet[standard_alphabet.index(letter)] = letter.upper()
    firstKeyword = firstKeyword.upper()
    secondKeyword = secondKeyword.upper()
    textToEncode = textToEncode.upper()
    textToEncode = textToEncode.replace(" ", "")


    ## Step 1: Transpose:
    firstKeywordCleaned = ""
    usedLetters = []
    for letter in firstKeyword:
        if letter not in usedLetters:
            firstKeywordCleaned += letter
            usedLetters.append(letter)

    plainTextKey = ""
    usedLetters = []
    for letter in firstKeywordCleaned:
        if letter not in usedLetters:
            plainTextKey += letter
            usedLetters.append(letter)
    for letter in standard_alphabet:
        if letter not in usedLetters:
            plainTextKey += letter
            usedLetters.append(letter) 

    col = len(firstKeywordCleaned)
    indexTransposeCreation = 0
    transposeArray = []
    while indexTransposeCreation < col:
        transposeArray.append([])
        indexTransposeCreation += 1

    indexTransposeCreation = 0
    while indexTransposeCreation < 26:
        transposeArray[indexTransposeCreation % col].append(plainTextKey[indexTransposeCreation])
        indexTransposeCreation += 1

    transposeArrLetters = ""
    for arr in transposeArray:
        for letter in arr:
            transposeArrLetters += letter

    transposedMessage = ""
    for letter in textToEncode:
        transposedMessage += standard_alphabet[transposeArrLetters.index(letter)]

    ## Step 2: Vignere:
    secondKeywordShifts = []
    for letter in secondKeyword:
        secondKeywordShifts.append(standard_alphabet.index(letter))

    indexOfCurrentShift = 0
    vigneredMessage = ""

    for letter in transposedMessage:
        vigneredMessage += standard_alphabet[
            (standard_alphabet.index(letter) 
            + 
            secondKeywordShifts[indexOfCurrentShift % len(secondKeyword)]
            ) % 26
            ]
        indexOfCurrentShift += 1
    
    return vigneredMessage

### DECODING

def decoder(firstKeyword, secondKeyword, textToDecode):
    standard_alphabet = list(map(chr, range(97, 123)))
    for letter in standard_alphabet:
        standard_alphabet[standard_alphabet.index(letter)] = letter.upper()
    firstKeyword = firstKeyword.upper()
    secondKeyword = secondKeyword.upper()
    textToDecode = textToDecode.upper()
    textToDecode = textToDecode.replace(" ", "")

    # Step 1: Decoding Vignere
    secondKeywordShifts = []
    for letter in secondKeyword:
        secondKeywordShifts.append(standard_alphabet.index(letter))

    indexOfCurrentShift = 0
    PreVigneredMessage = ""

    for letter in textToDecode:
        PreVigneredMessage += standard_alphabet[
        (standard_alphabet.index(letter) 
        - 
        secondKeywordShifts[indexOfCurrentShift % len(secondKeyword)]
        )
        ]
        indexOfCurrentShift += 1

    # Step 2: Decoding Transpose
    firstKeywordCleaned = ""
    usedLetters = []
    for letter in firstKeyword:
        if letter not in usedLetters:
            firstKeywordCleaned += letter
            usedLetters.append(letter)

    plainTextKey = ""
    usedLetters = []
    for letter in firstKeywordCleaned:
        if letter not in usedLetters:
            plainTextKey += letter
            usedLetters.append(letter)
    for letter in standard_alphabet:
        if letter not in usedLetters:
            plainTextKey += letter
            usedLetters.append(letter)

    col = len(firstKeywordCleaned)
    indexTransposeCreation = 0
    transposeArray = []
    while indexTransposeCreation < col:
        transposeArray.append([])
        indexTransposeCreation += 1

    indexTransposeCreation = 0
    while indexTransposeCreation < 26:
        transposeArray[indexTransposeCreation % col].append(plainTextKey[indexTransposeCreation])
        indexTransposeCreation += 1

    transposeArrLetters = ""
    for arr in transposeArray:
        for letter in arr:
            transposeArrLetters += letter

    originalMessage = ""
    for letter in PreVigneredMessage:
        originalMessage += transposeArrLetters[standard_alphabet.index(letter)]
        
    return originalMessage



@app.route('/', methods=['GET'])
def index():
    return render_template('index.html')


@app.route('/encode', methods=['POST'])
def encode():
    data = request.get_json()
    firstKeyword = data['firstKeyword']
    secondKeyword = data['secondKeyword']
    textToChange = data['textToChange']
    # Encode the text using your encoding logic
    encodedText = encoder(firstKeyword, secondKeyword, textToChange)
    return jsonify({'output': encodedText})

@app.route('/decode', methods=['POST'])
def decode():
    data = request.get_json()
    firstKeyword = data['firstKeyword']
    secondKeyword = data['secondKeyword']
    textToChange = data['textToChange']
    # Decode the text using your decoding logic
    decodedText = decoder(firstKeyword, secondKeyword, textToChange)
    return jsonify({'output': decodedText})


if __name__ == '__main__':
    app.run(debug=True)