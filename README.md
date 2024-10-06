# Cryptanalysis of a Polyalphabetic Cipher

Encode and decode your text using this cipher with this [web demonstration](https://tanm2024.pythonanywhere.com/).


This project walks through the cryptanalysis of polyalphabetic cipher. We aim to decode an encrypted message using clues about the encryption methods. Using this information, we will attempt to break the cryptogram using various methods. Many of these processes were automated using Java, which is included within the repository. However, many methods were used by hand and are detailed throughout the project.

## Encoding

This purpose of this project is to demonstrate and test the knowledge of basic cryptanalysis techniques on a polyalphabetic cipher, so the methods of encoding are known to aid with the direction of the decoding. The plaintext is encoding using monoalphabetic substitution using a keyword (which will be referred to as the first keyword), then is transposed using that keyword with columnar transposition, and finally encoded again using a vignere cipher with another keyword (which will be referred to as the second keyword).

## Decoding

The cipher given is:

> NFGXN PRIKA ERKNV VUINH ONPIH BKFXV ZTRXJ BTNDB XRRUN EMIEQ WUEXS ZRBNI OQUAD OIXUE OFLWL OUGWL CMIES PVAWA VHTWA ZQXKS CDXXH ERXKQ GLAWN WKFXL OSTUD RULXX SQUQB JKXGS ZBWIE LDQPQ NRIKW NUITA BKFXJ OZSXN EHBGX HKFXZ ZBSKQ XTXKX ZXUIO NHAPL VYUGN JQFPW LXAXO OIPRA ECXKQ LFDOJ LRMPH HTIWN EDPNZ LFIUW WRWTA GFEKQ JBXIQ BMGXU ODDXC KTNXH GLUSQ ECXYJ OHNWO OKFXZ XQUQB BQWEA CDXXN MTAAL LSFPU O

The cipher is formatted with spaces every five letters, although the deciphered text will contain no spaces. <br>

Our first step is to solving this is to collapse the cipher into a single-alphabet code. To do this, we must find the second keyword. We begin by attempting to find the length of the second keyword using the Index of Coincidence. <br><br>

### Index of Coincidence

The Index of Coincidence tells us is generally used on polyalphabetic ciphers to find the width of a repeating-key matrix, which in turn is a multiple of the key length. 

To compute the index of coincidence, we use the following formula:

<img title="a title" alt="Index of coincidence" src="/images/cryptIC.png">

where N is the length of the cipher and n is the frequency of the letters of the alphabet. <br>

We test for different frequencies of letter length, namely 4, 5, and 6 letter lengths. We are computing the IC for the first letter of the word, and testing the length of the word.


> Freq for 4 letters: 0.044564890093345376 <br>
> Freq for 5 letters: 0.07132867132867132 <br>
> Freq for 6 letters: 0.04713804713804714


The frequency for the first letter as every 5 letters is high, thus we assume that the length of the word is 5 and we look at each letter:


>freq5FirstLetter: 0.07132867132867132
>
>freq5SecondLetter: 0.057692307692307696
>
>freq5ThirdLetter: 0.06634615384615385
>
>freq5FourthLetter: 0.09903846153846153
>
>freq5FifthLetter: 0.058173076923076925
>
>Average per letter = 0.07051573426573426


The average letter frequency meets our threshold of 0.07, thus it seems likely that the length of one of the codewords is five letters. We will refer to this as the second keyword, since it is used after the first keyword transposes the plain text. <br>


### Cracking the Second Keyword

We know that the second keyword is five letters, so we look at the frequency of each of the 5 letters.

<img title="a title" alt="Frequency of Five Letters" src="/images/freq5.png">


Through a rough visual analysis, we can align the five alphabets to find the code word. By aligning certain frequency hotspots and areas with 0 frequency, we can spell out the keyword FLOOR. This part requires the most speculation, as there were other candidate keywords like IVORY, FAVOR, NORTH, and FLOCK. However, it seems most likely to be the word FLOOR. 

Using this information, we can convert the code into a single alphabet. Since this is a Vignere Cipher, we know that each letter has its own alphabet corresponding to the keyword. Since the keyword is five letters long, the alphabets cycle every five letters. The first letter is the code letter N, which corresponds to the keyword letter F. When we "shift" F back to A, we also shift N back to the letter I to give us the first letter of the single alphabet. Repeating this process in cycles of 5 give us the new collapsed alphabet:

New Single-coded Alphabet:
>IUSJWKGUWJZGWZEQJUZQJCBUQWZRJEUIDJSWIZPKSGDGWZBUQZRJQJBUGNZRJFGMMJXJGNJUXIUJJSIUXBUQBKKMIJQWFIJUFJWBXSJJQZGJWZBAMIWRZRJUJHFGMMJXJGNFGCKEZJSBUQIUNGSCBZIGUWFIJUFJWZRJSJOEJWZWNSGCZRJIUQEWZSIJWGUMGUXIWMBUQNGSWEFRBFGMMJXJXBDJZRJWZGUPASGGYBQCIUIWZSBZIGUUGFRGIFJBUQWZEQJUZWBSJDJSPJLFIZJQBAGEZZRJKSJWZIXJZRJISFGCKWFIQJXSJJWHIMMUGHRBDJ
<br>

### Cracking the First Keyword

Now with the single-coded alphabet, we can begin to convert the coded text (labeled code or c) into plain text (labeled plain or p). We will do this using analysis of the English language and find patterns that appear in the code. We look at the frequency of three consecutive letters, known as a trigraph: <br>


<img title="a title" alt="Trigraph" src="/images/trigraph.png">

<br>

We note that the frequent trigraphs: ZRJ, BUQ, JWZ. We further look at letter frequencies:



<img title="a title" alt="Letter Frequency Table" src="/images/letterFreq.png">



Given the frequency of each letter, it is safe to assume that BUQ (code) is not THE (plain), as E (p) is the most common letter while Q (c) is not. Thus it is either: ZRJ, JWZ. Both J and Z (c) can be E (p), since they are very common. Given that J (c) is the most common letter by a large margin, we will look at the case ZRJ (c) = THE (p)


We can use these clues to figure out the keyword length used in the transposition. We do so by creating sample arrays and using context clues to figure out the most likely length. The length of the keyword corresponds to the number of columns of the array, and we can use that to our advantage. The way tranposition works is that the keyword is listed at the top, and the remaining letters of the alphabet are placed in successive order beneath the keyword.

Keyword Transpose Arrays:

Top letter = code text, bottom letter = plain text


<img title="a title" alt="Arrays" src="/images/cryptArrays.png">

We now perform some deductive analysis about each of the columns.<br>

For Ncol 6:
- Ncol 6 has E as the very last letter, whereas even if the keyword used the last six letters of the alphabet (UVWXYZ), the last letter must be T. Thus it is impossible for the keyword to have 6 letters.

For Ncol 8:
- Ncol 8 has T near the end of the alphabet, meaning the keyword has four of the remaining six letters: UVWXYZ. This is not very likely, thus we assume that the keyword is in Ncol = 7.

For Ncol 7:
- We notice that in the coded alphabet, T and V have 0 frequency, while L, O, Y have 1 frequency, and A, H, P have 3 frequency. We can create potential matchings with plain letters J, Q, X, Z.
- We can assume that T (c) = Z (p)
- Using that, we can assume that L (c) = X (p) and P (c) = Y (p)
- We can also pair V (c) = J (p), meaning that I (p) is in the first keyword.
- If we assume that O (c) = Q (p), then it means S and W (c) correspond to R and S (p)
- Other frequent code letters: G, J, U, W, Z.
- D (c) contains trigraph JDJ ,and since J = E(p) then it means D is a consonant. It also can only be U, V, or W, and positionally it can only be U or V. Thus it is V (p) and H (c) is W (p). 
- This also means that U (p) is in the keyword.
- In code, B has trigraph RD, which translates to H_V. Also, B can only be A,B,C,D (p). It makes sense that B (c) = A (p).
- Y (c) has 1 frequency, making it likely to be K (p).
- Plugging it what is decoded so far, we find certain keywords like:

    EUIVERSITY

    - This implies that E and U (c) are U and N (p) respectively.

    STUQENT

    - Implies that Q (c) = D (p)

    ENXINEER

    - Implies that X (c) = G (p)

    - Meaning N (c) = F (p)

    EXFITED

    - Implies that F (c) = C (p)

    AAGUT

    - Implies that A (c) = B (p), G (c) = O (p)

    - Meaning K (c) = P (p)

    DECANDS

    - Implies that C (c) = M (p)

- The remaining letters are I,M (c) = I,L (p)
- Since I (c) has almost double the frequency of M (c), we can infer that 
- I (c) = I (p) and that M (c) = L (p)


### Decoding the Cryptogram

<img title="a title" alt="Cryptogram Key" src="/images/cryptKey.png">


Our solved key now allows us to decode the message. 

Turning the code:

IUSJWKGUWJZGWZEQJUZQJCBUQWZRJEUIDJSWIZPKSGDGWZBUQZRJQJBUGNZRJFGMMJXJGNJUXIUJJSIUXBUQBKKMIJQWFIJUFJWBXSJJQZGJWZBAMIWRZRJUJHFGMMJXJGNFGCKEZJSBUQIUNGSCBZIGUWFIJUFJWZRJSJOEJWZWNSGCZRJIUQEWZSIJWGUMGUXIWMBUQNGSWEFRBFGMMJXJXBDJZRJWZGUPASGGYBQCIUIWZSBZIGUUGFRGIFJBUQWZEQJUZWBSJDJSPJLFIZJQBAGEZZRJKSJWZIXJZRJISFGCKWFIQJXSJJWHIMMUGHRBDJ


Into the plain text:


INRESPONSETOSTUDENTDEMANDSTHEUNIVERSITYPROVOSTANDTHEDEANOFTHECOLLEGEOFENGINEERINGANDAPPLIEDSCIENCESAGREEDTOESTABLISHTHENEWCOLLEGEOFCOMPUTERANDINFORMATIONSCIENCESTHEREQUESTSFROMTHEINDUSTRIESONLONGISLANDFORSUCHACOLLEGEGAVETHESTONYBROOKADMINISTRATIONNOCHOICEANDSTUDENTSAREVERYEXCITEDABOUTTHEPRESTIGETHEIRCOMPSCIDEGREESWILLNOWHAVE

With proper spacing:

IN RESPONSE TO STUDENT DEMANDS THE UNIVERSITY PROVOST AND THE DEAN OF THE COLLEGE OF ENGINEERING AND APPLIED SCIENCES AGREED TO ESTABLISH THE NEW COLLEGE OF COMPUTER AND INFORMATION SCIENCES THE REQUESTS FROM THE INDUSTRIES ON LONG ISLAND FOR SUCH A COLLEGE GAVE THE STONY BROOK ADMINISTRATION NO CHOICE AND STUDENTS ARE VERY EXCITED ABOUT THE PRESTIGE THEIR COMPSCI DEGREES WILL NOW HAVE



Finished! <br><br>


## RESOURCES 

https://www.geeksforgeeks.org/keyword-cipher/
https://www.dcode.fr/columnar-transposition-cipher
https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher





