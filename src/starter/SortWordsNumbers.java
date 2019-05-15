package starter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class SortWordsNumbers {


/*
Задача по алгоритмам
*/

        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<String> list = new ArrayList<>();
            while (true) {
                String s = reader.readLine();
                if (s.isEmpty()) break;
                list.add(s);
            }

            String[] array = list.toArray(new String[0]);
            sort(array);

            for (String x : array) {
                System.out.println(x);
            }
        }
        //максимально неадекватная херня ниже(якобы сортировка), но работает и мне понятно. Когда-нибудь переделаю (:
        public static void sort(String[] array) {
            ArrayList<Integer> indexForNumbers = new ArrayList<Integer>();// запоминаем индексы массива в которых лежат слова и цифры
            ArrayList<Integer> indexForWords = new ArrayList<Integer>();
            for(int i = 0; i<array.length; i++){
                if(isNumber(array[i])){
                    indexForNumbers.add(i);
                }
                else indexForWords.add(i);
            }
            // сортировка слов
            for (int i = 0; i < indexForWords.size(); i++){
                for (int k = i+1; k < indexForWords.size(); k++){
                    if(isGreaterThan(array[indexForWords.get(i)], array[indexForWords.get(k)])){
                        String str = array[indexForWords.get(i)];
                        array[indexForWords.get(i)] = array[indexForWords.get(k)];
                        array[indexForWords.get(k)] = str;
                    }
                }
            }
            //сортировка цифр
            for(int i = 0; i<indexForNumbers.size();i++){
                for (int k = i+1; k < indexForNumbers.size(); k++){
                    if(Integer.parseInt(array[indexForNumbers.get(i)]) < Integer.parseInt(array[indexForNumbers.get(k)])){
                        Integer num = Integer.parseInt(array[indexForNumbers.get(i)]);
                        array[indexForNumbers.get(i)] = array[indexForNumbers.get(k)];
                        array[indexForNumbers.get(k)] = String.valueOf(num);
                    }
                }
            }
        }

        // Метод для сравнения строк: 'а' больше чем 'b'
        public static boolean isGreaterThan(String a, String b) {
            return a.compareTo(b) > 0;
        }


        // Переданная строка - это число?
        public static boolean isNumber(String s) {
            if (s.length() == 0) return false;

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if ((i != 0 && c == '-') // Строка содержит '-'
                        || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                        || (chars.length == 1 && c == '-')) // или одиночный '-'
                {
                    return false;
                }
            }
            return true;
        }
    }

