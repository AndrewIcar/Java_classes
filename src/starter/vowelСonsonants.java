package starter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;


public class vowelСonsonants {

/*
Гласные и согласные
*/
        public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
//по хорошему все скинуть бы в одну проверку...хотя и так сойдет
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        //ArrayList<String> list = new ArrayList<String>();
        String list = keyboard.nextLine();
        char[] charList = list.toCharArray();

        for(int i = 0; i<charList.length; i++){
            if(isVowel(charList[i])){
                System.out.print(charList[i]+" ");
            }

        }
        System.out.println();
        for(int i = 0; i<charList.length; i++){
            if(!isVowel(charList[i])&&!(Character.toString(charList[i])).equals(" ")){
                System.out.print(charList[i]+" ");
            }

        }
    }

        // метод проверяет, гласная ли буква
        public static boolean isVowel(char c) {
            c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

            for (char d : vowels)   // ищем среди массива гласных
            {
                if (c == d)
                    return true;
            }
            return false;
        }
    }

