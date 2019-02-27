import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class letters {


/*
Количество букв
*/


        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            // Алфавит
            String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            char[] abcArray = abc.toCharArray();

            ArrayList<Character> alphabet = new ArrayList<Character>();
            for (int i = 0; i < abcArray.length; i++) {
                alphabet.add(abcArray[i]);
            }
            //каждая ячейка содержит количество букв
            ArrayList<Integer> counting = new ArrayList<Integer>();
            for (int i = 0; i < 33; i++) {
                counting.add(0);
            }// не получается бес инициализации

            // Ввод строк 10 строк с клавиатуры
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < 10; i++) {
                String s = reader.readLine();
                list.add(s.toLowerCase());
            }

            int count = 0;

            for(int i = 0; i<list.size(); i++){                         //i-ое введенное слово из list,
                for(int k = 0; k<alphabet.size();k++){                  //взяв k-ую букву алфавита,
                    for (int j = 0; j<list.get(i).length();j++){        //пролистываем i-ый элемент list на наличие k-ой буквы, и считаем количество
                        if(alphabet.get(k) == list.get(i).charAt(j)){
                            count++;
                        }
                    }
                    if(counting.get(k)!=0){                             //записываем в массив counting количество найденных букв
                        count = count+counting.get(k);
                    }
                    counting.set(k, count);
                    count = 0;
                }
            }

            // выходной массива
            ArrayList<String> out = new ArrayList<String>();
            for(int i = 0; i<33; i++) {
                out.add(i, alphabet.get(i).toString() + " " + counting.get(i));
                System.out.println(out.get(i));
            }
        }
    }
