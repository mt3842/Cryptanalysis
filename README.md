# Cryptanalysis

## Overview

This project walks through the process of solving a basic cryptanalysis problem. The encrypted cryptogram is provided along with the clue that there are two keywords used to transpose the message. Using this infomration, we will attempt to break the cryptogram using various methods.

## Index of Coincidence

The Index of Coincidence is typically used to determine whether a code is monoalphabetic or polyalphabetic, and if the latter, how many alphabets are used. In this case we will use it to help determine the number of letters in the transposed keywords. 

To compute the index of coincidence, we use the following formula:

IMAGE

We test for different frequencies of letter length, namely 4, 5, and 6 letter lengths. We are computing the IC for the first letter of the word, and testing the length of the word.

Freq for 4 letters: 0.044564890093345376
Freq for 5 letters: 0.07132867132867132
Freq for 6 letters: 0.04713804713804714

The frequency for the first letter as every 5 letters is high, thus we assume that the length of the word is 5 and we look at each letter:

freq5First: 0.07132867132867132
freq5Second: 0.057692307692307696
freq5Third: 0.06634615384615385
freq5Fourth: 0.09903846153846153
freq5Fifth: 0.058173076923076925
Average per letter = 0.07051573426573426

The average letter frequency meets our threshold of 0.07, thus it seems likely that the length of one of the codewords is five letters. We will refer to this as the second keyword, since it is used after the first keyword transposes the plain text. 

## Cracking the Second Keyword

We know that the second keyword is five letters, so we look st the frequency of each of the 5 letters.

A B C D E F G H I J K L M N  O P Q R S T U V W X Y Z		First Letters
0 5 3 0 7 0 3 2 0 3 1 6 1 4 12 2 0 1 1 0 0 3 3 3 0 6 		(frequency of letter)


A B C D E F G H I J K L M N O P Q R S T U V W X Y Z		Second Letters
0 3 2 5 0 5 0 4 2 0 6 2 3 1 0 0 6 8 2 6 5 1 0 2 1 1 


A B C D E F G H I J K L M N O P Q R S T U V W  X Y Z		Third Letters
5 2 0 2 2 7 3 0 8 0 1 2 1 3 0 3 1 2 2 2 6 0 3 10 0 0 


A B C D E F G H I J K L M N O P Q R S T U V W  X Y Z		Fourth Letters
2 0 0 1 3 0 3 0 4 0 8 0 0 4 1 5 2 1 1 2 4 0 7 16 1 0 


A B C D E F G H I J K L M N O P Q R S T U V W X Y Z		Fifth Letters
7 3 1 2 2 0 0 5 1 4 0 5 0 7 3 0 8 0 4 0 2 2 3 3 0 3 


Through a rough visual analysis, we can align the five alphabets to find the code word. By aligning certain frequency hotspots and areas with 0 frequency, we can spell out the keyword FLOOR. This part requires the most speculation, as there were other candidate keywords like IVORY, FAVOR, NORTH, and FLOCK. However, it seems most likely to be the word FLOOR. 

Using this information, we can convert the code into a single alphabet, where each letter corresponds to the alphabet for each letter. For example, the first letter is the code letter N, which corresponds to the keyword letter F. When we "shift" F back to A, we also shift N back to the letter I to give us the first letter of the single alphabet. Repeating this process in cycles of 5 give us the new collapsed alphabet:

New Single Alphabet:
IUSJWKGUWJZGWZEQJUZQJCBUQWZRJEUIDJSWIZPKSGDGWZBUQZRJQJBUGNZRJFGMMJXJGNJUXIUJJSIUXBUQBKKMIJQWFIJUFJWBXSJJQZGJWZBAMIWRZRJUJHFGMMJXJGNFGCKEZJSBUQIUNGSCBZIGUWFIJUFJWZRJSJOEJWZWNSGCZRJIUQEWZSIJWGUMGUXIWMBUQNGSWEFRBFGMMJXJXBDJZRJWZGUPASGGYBQCIUIWZSBZIGUUGFRGIFJBUQWZEQJUZWBSJDJSPJLFIZJQBAGEZZRJKSJWZIXJZRJISFGCKWFIQJXSJJWHIMMUGHRBDJ




