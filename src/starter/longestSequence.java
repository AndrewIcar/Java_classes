package starter;

import java.io.*;
import java.util.ArrayList;
public class longestSequence {

    /*
    Cамая длинная последовательность
    */
            public static void main(String[] args) throws IOException {
            //напишите тут ваш код
            ArrayList<Integer> list = new ArrayList<Integer>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 10; i++) {
                list.add(Integer.parseInt(reader.readLine()));
            }


            int count = 1;
            int max = 1;
            for (int i=0; i<list.size()-1;i++)
            {
                if (list.get(i).equals(list.get(i + 1)))
                {
                    count++;
                    if (max < count)
                        max = count;
                }
                else
                    count=1;
            }
            System.out.println(max);

        }
    }