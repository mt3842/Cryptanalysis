import java.lang.Math;

public class crypt {
    public static void main(String args[]) {
        String cryptEx1 = "NFGXN PRIKA ERKNV VUINH ONPIH BKFXV ZTRXJ BTNDB XRRUN EMIEQ WUEXS ZRBNI OQUAD OIXUE OFLWL OUGWL CMIES PVAWA VHTWA ZQXKS CDXXH ERXKQ GLAWN WKFXL OSTUD RULXX SQUQB JKXGS ZBWIE LDQPQ NRIKW NUITA BKFXJ OZSXN EHBGX HKFXZ ZBSKQ XTXKX ZXUIO NHAPL VYUGN JQFPW LXAXO OIPRA ECXKQ LFDOJ LRMPH HTIWN EDPNZ LFIUW WRWTA GFEKQ JBXIQ BMGXU ODDXC KTNXH GLUSQ ECXYJ OHNWO OKFXZ XQUQB BQWEA CDXXN MTAAL LSFPU O";
        String cryptEx = "NFGXNPRIKAERKNVVUINHONPIHBKFXVZTRXJBTNDBXRRUNEMIEQWUEXSZRBNIOQUADOIXUEOFLWLOUGWLCMIESPVAWAVHTWAZQXKSCDXXHERXKQGLAWNWKFXLOSTUDRULXXSQUQBJKXGSZBWIELDQPQNRIKWNUITABKFXJOZSXNEHBGXHKFXZZBSKQXTXKXZXUIONHAPLVYUGNJQFPWLXAXOOIPRAECXKQLFDOJLRMPHHTIWNEDPNZLFIUWWRWTAGFEKQJBXIQBMGXUODDXCKTNXHGLUSQECXYJOHNWOOKFXZXQUQBBQWEACDXXNMTAALLSFPUO";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        //////////////////// FREQUENCY FOR EVERY 4 LETTERS
        int[] letterFrequencyFour = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {
            if (i%4 == 0) {
                letterFrequencyFour[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;
            }
        }
        int freq4N = 0;
        for (int i : letterFrequencyFour) {freq4N = freq4N + i;}

        double freq4 = 0.0;
        for (int i : letterFrequencyFour) {
            if (i > 1) {
                freq4  = freq4 + (i * (i-1));
            }
        } freq4 = freq4 / (freq4N * (freq4N - 1));

        //System.out.println("Freq for 4 letters: " + freq4);



        //////////////////// FREQUENCY FOR EVERY 5 LETTERS
        int[] letterFrequencyFive = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {
            if (i%5 == 0) {
                letterFrequencyFive[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;
            }
        }
        int freq5N = 0;
        for (int i : letterFrequencyFive) {freq5N = freq5N + i;}

        double freq5 = 0.0;
        for (int i : letterFrequencyFive) {
            if (i > 1) {
                freq5  = freq5 + (i * (i-1));
            }
        } freq5 = freq5 / (freq5N * (freq5N - 1));

        //System.out.println("Freq for 5 letters: " + freq5);



        //////////////////// FREQUENCY FOR EVERY 6 LETTERS
        int[] letterFrequencySix = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {
            if (i%6 == 0) {
                letterFrequencySix[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;
            }
        }
        int freq6N = 0;
        for (int i : letterFrequencySix) {freq6N = freq6N + i;}

        double freq6 = 0.0;
        for (int i : letterFrequencySix) {
            if (i > 1) {
                freq6  = freq6 + (i * (i-1));
            }
        } freq6 = freq6 / (freq6N * (freq6N - 1));

        //System.out.println("Freq for 6 letters: " + freq6);



        // FREQUENCY OF EACH LETTER IN 5 ALPHABET
        //System.out.println("freq5First: " + freq5);        

        int[] freq5Second = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {if (i%5 == 1) {freq5Second[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;}}
        int Nsecond  = 0; for (int i : freq5Second) {Nsecond = Nsecond + i;}
        double Fsecond = 0.0;
        for (int i : freq5Second) {if (i > 1) {Fsecond  = Fsecond + (i * (i-1));}
        } Fsecond = Fsecond / (Nsecond * (Nsecond - 1));
        //System.out.println("freq5Second: " + Fsecond);        

        int[] freq5Third = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {if (i%5 == 2) {freq5Third[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;}}
        int NThird  = 0; for (int i : freq5Third) {NThird = NThird + i;}
        double FThird = 0.0;
        for (int i : freq5Third) {if (i > 1) {FThird  = FThird + (i * (i-1));}
        } FThird = FThird / (NThird * (NThird - 1));
        //System.out.println("freq5Third: " + FThird);        

        int[] freq5Fourth = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {if (i%5 == 3) {freq5Fourth[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;}}
        int NFourth  = 0; for (int i : freq5Fourth) {NFourth = NFourth + i;}
        double FFourth = 0.0;
        for (int i : freq5Fourth) {if (i > 1) {FFourth  = FFourth + (i * (i-1));}
        } FFourth = FFourth / (NFourth * (NFourth - 1));
        //System.out.println("freq5Fourth: " + FFourth);   
        
        int[] freq5Fifth = new int[26];
        for (int i = 0; i < cryptEx.length(); i++) {if (i%5 == 4) {freq5Fifth[ alphabet.indexOf(cryptEx.charAt(i)) ] += 1;}}
        int NFifth  = 0; for (int i : freq5Fifth) {NFifth = NFifth + i;}
        double FFifth = 0.0;
        for (int i : freq5Fifth) {if (i > 1) {FFifth  = FFifth + (i * (i-1));}
        } FFifth = FFifth / (NFifth * (NFifth - 1));
        //System.out.println("freq5Fifth: " + FFifth);  

        //System.out.println("Average per letter = " + (freq5 + Fsecond + FThird + FFourth + FFifth)/5);


        ////////////////// Histogram making:
        String alphabet2 = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        String firstLetters = "";
        for (int i : letterFrequencyFive) {firstLetters = firstLetters + i + " ";}
        //System.out.println(alphabet2);
        //System.out.println(firstLetters);

        String secondLetters = "";
        for (int i : freq5Second) {secondLetters = secondLetters + i + " ";}
        //System.out.println(alphabet2);
        //System.out.println(secondLetters);

        String thirdLetters = "";
        for (int i : freq5Third) {thirdLetters = thirdLetters + i + " ";}
        //System.out.println(alphabet2);
        //System.out.println(thirdLetters);

        String fourthLetters = "";
        for (int i : freq5Fourth) {fourthLetters = fourthLetters + i + " ";}
        //System.out.println(fourthLetters);

        String fifthLetters = "";
        for (int i : freq5Fifth) {fifthLetters = fifthLetters + i + " ";}
       //System.out.println(fifthLetters);


        ////////////////////// COLLAPSING ALPHABET
        String s1 = "F";
        String s2 = "L";
        String s3 = "O";
        String s4 = "O";
        String s5 = "R";
        String singAlph = "";
        for (int i = 0; i < cryptEx.length(); i++) {
            if (i % 5 == 0) { 
                if ((alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s1)) >= 0) {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s1));}
                else {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s1) + 26);}
            }
            if (i % 5 == 1) { 
                if ((alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s2)) >= 0) {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s2));}
                else {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s2) + 26);}
            }
            if (i % 5 == 2) { 
                if ((alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s3)) >= 0) {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s3));}
                else {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s3) + 26);}
            }
            if (i % 5 == 3) { 
                if ((alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s4)) >= 0) {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s4));}
                else {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s4) + 26);}
            }
            if (i % 5 == 4) { 
                if ((alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s5)) >= 0) {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s5));}
                else {singAlph += alphabet.charAt(alphabet.indexOf(cryptEx.charAt(i)) - alphabet.indexOf(s5) + 26);}
            }
        }
        //System.out.println(singAlph);



        ///////////////// TRIGRAPH ANALYSIS

        // Manually add first:
        String[] trigraph = new String[26];
        trigraph[ alphabet.indexOf( singAlph.charAt(0)) ] = trigraph[alphabet.indexOf( singAlph.charAt(0))] + "." + singAlph.charAt(1) + ", ";

        for (int i = 1; i < singAlph.length()-1; i++) { 
            trigraph[ alphabet.indexOf( singAlph.charAt(i)) ] = trigraph[alphabet.indexOf( singAlph.charAt(i))] + singAlph.charAt(i-1) + singAlph.charAt(i+1) + ", ";
        }

        // Manually add last:
        trigraph[ alphabet.indexOf( singAlph.charAt(singAlph.length() - 1)) ] = trigraph[alphabet.indexOf( singAlph.charAt(singAlph.length() - 1))] + singAlph.charAt(singAlph.length() - 2) + "." + ", ";

        for (int i = 0; i < alphabet.length(); i++) {
            //System.out.println(alphabet.charAt(i) + ": " + trigraph[i]);
        }

        int[] letterFrequency = new int[26];
        for (int i = 0; i < singAlph.length(); i++) {
            letterFrequency[alphabet.indexOf(singAlph.charAt(i))] += 1;
        }

        for (int i = 0; i < 26; i++){
            //System.out.println(alphabet.charAt(i) + ": " + letterFrequency[i]);
        }
        //System.out.println(singAlph);


        /////// DECODING
        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key =        "BAMVUCOWIEPXLFQYDHRZNJSGKT";
        String decoded = "";
        for (int i = 0; i < singAlph.length(); i++) {
                decoded = decoded + (key.charAt(alphabet.indexOf(singAlph.charAt(i))));
        }
        System.out.println(decoded);

    }
}







// HELPFUL



