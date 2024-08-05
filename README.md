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

New Single-coded Alphabet:
IUSJWKGUWJZGWZEQJUZQJCBUQWZRJEUIDJSWIZPKSGDGWZBUQZRJQJBUGNZRJFGMMJXJGNJUXIUJJSIUXBUQBKKMIJQWFIJUFJWBXSJJQZGJWZBAMIWRZRJUJHFGMMJXJGNFGCKEZJSBUQIUNGSCBZIGUWFIJUFJWZRJSJOEJWZWNSGCZRJIUQEWZSIJWGUMGUXIWMBUQNGSWEFRBFGMMJXJXBDJZRJWZGUPASGGYBQCIUIWZSBZIGUUGFRGIFJBUQWZEQJUZWBSJDJSPJLFIZJQBAGEZZRJKSJWZIXJZRJISFGCKWFIQJXSJJWHIMMUGHRBDJ


## Cracking the First Keyword

Now with the single-coded alphabet, we can begin to convert the coded text (labeled code or c) into plain text (labeled plain or p). We will do this using analysis of the English language and find patterns that appear in the code. We look at the frequency of three consecutive letters:


A: BG,BM,PS 

B: CU,CZ,JU,JU,MU,QA,QK,RD,RF,SU,SZ,WS,WX,XD,XU,YQ,ZA,ZU 

C: GK,GK,GZ,JB,QI,SB 

D: BJ,BJ,GG,IJ,JJ 

E: GZ,JU,KZ,OJ,QW,WF,ZQ,ZQ

F: BG,ER,GR,HG,IJ,JG,LI,NG,SG,UJ,UJ,WI,WI,WI

G: AE,DW,FC,FC,FM,FM,FM,GY,IU,IU,JN,JN,KU,MU,NS,NS,RI,SC,SD,SG,UF,UH,UN,WU,ZJ,ZU,ZW 

H: GR, JF, WI, 

I: .U,CU,FJ,FJ,FQ,FZ,GF,HM,JS,JU,MJ,MW,QU,SJ,SU,UD,UW,WZ,XU,XW,ZG,ZG,ZX

J: D.,DS,DS,DZ,EW,FB,FW,FW,GW,IQ,IU,IU,IW,JQ,JS,JW,MX,MX,MX,NU,PL,QB,QC,QU,QU,QX,RE,RF,

RI,RI,RK,RQ,RS,RU,RW,SD,SJ,SJ,SO,SW,SW,UH,UJ,WZ,XG,XG,XX,XZ,ZQ,ZS 

K: BK,CE,CW,JS,KM,PS,WG

L: JF, 

M: AI,GM,GM,GM,IM,KI,MJ,MJ,MJ,MU,UG,WB

N: GF,GJ,GZ,QG,UG,WS

O: JE, 

P: SJ,UA,ZK

Q: BC,EJ,EJ,IJ,JB,JJ,JW,JZ,UB,UE,UI,UN,UW,UW,UZ,ZJ

R: FB,FG,HB,WZ,ZJ,ZJ,ZJ,ZJ,ZJ,ZJ,ZJ,ZJ,ZJ 

S: AG,BJ,GC,GW,IF,JB,JI,JJ,JP,JW,KG,KJ,NG,UJ,XJ,XJ,ZB,ZI

T: 

U: BG,BQ,BQ,BQ,BQ,BQ,BQ,EI,GM,GP,GU,GW,GW,GX,II,IJ,IN,IQ,IS,IX,JF,JF,JJ,JX,JZ,JZ,MG,UG

V: 

W: EZ,GZ,GZ,IM,IR,IZ,JB,JG,JH,JK,JZ,JZ,JZ,JZ,JZ,KF,QF,QZ,QZ,SE,SI,UF,UJ,ZB,ZN

X: BS,IJ,JB,JJ,JJ,JJ,JS,UB,UI,UI

Y: GB, 

Z: BI,BI,CR,EJ,EZ,IJ,IP,JG,JR,JR,NR,QG,QR,RR,UQ,UW,WB,WB,WE,WE,WG,WI,WR,WR,WS,WS,WW,ZR


We note that the frequent trigraphs: ZRJ, BUQ, JWZ. We further look at letter frequencies:

Letter Frequency Table

A: 3

B: 18

C: 6

D: 5

E: 8

F: 14

G: 27

H: 3

I: 23

J: 50

K: 7

L: 1

M: 12

N: 6

O: 1

P: 3

Q: 16

R: 13

S: 18

T: 0

U: 28

V: 0

W: 25

X: 10

Y: 1

Z: 28


Given the frequency of each letter, it is safe to assume that BUQ (code) is not THE (plain), as E (p) is the most common letter while Q (c) is not. Thus it is either: ZRJ, JWZ. Both J and Z (c) can be E (p), since they are very common. Given that J (c) is the most common letter by a large margin, we will look at the case ZRJ (c) = THE (p)


We now create arrays to figure out the length of the first keyword. A keyword is used to The length of the keyword determines the number of columns of the array, and we can use that 

Keyword Transpose Arrays:

Top letter = code text, bottom letter = plain text


IMAGE


Ncol 6 has E as the very last letter, thus it is not possible.

Ncol 8 has T near the end of the alphabet, meaning the keyword has four of the remaining six letters: UVWXYZ. This is not very likely, thus we assume that the keyword is in Ncol = 7.

We notice that in the coded alphabet, T and V have 0 frequency, while L, O, Y have 1 frequency, and A, H, P have 3 frequency. We can create potential matchings with plain letters J, Q, X, Z.

We can assume that T (c) = Z (p)

Using that, we can assume that L (c) = X (p) and P (c) = Y (p)

We can also pair V (c) = J (p), meaning that I (p) is in the first keyword.

If we assume that O (c) = Q (p), then it means S and W (c) correspond to R and S (p)

Other frequent code letters: G, J, U, W, Z.

D (c) contains trigraph JDJ ,and since J = E(p) then it means D is a consonant. It also can only be U, V, or W, and positionally it can only be U or V. Thus it is V (p) and H (c) is W (p). 

This also means that U (p) is in the keyword.

In code, B has trigraph RD, which translates to H_V. Also, B can only be A,B,C,D (p). It makes sense that B (c) = A (p).

Y (c) has 1 frequency, making it likely to be K (p).

Plugging it what is decoded so far, we find certain keywords like:

EUIVERSITY

This implies that E and U (c) are U and N (p) respectively.

STUQENT

Implies that Q (c) = D (p)

ENXINEER

Implies that X (c) = G (p)

Meaning N (c) = F (p)

EXFITED

Implies that F (c) = C (p)

AAGUT

Implies that A (c) = B (p), G (c) = O (p)

Meaning K (c) = P (p)

DECANDS

Implies that C (c) = M (p)

The remaining letters are I,M (c) = I,L (p)

Since I (c) has almost double the frequency of M (c), we can infer that 

I (c) = I (p) and that M (c) = L (p)







