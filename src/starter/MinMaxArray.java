package starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class MinMaxArray {


/*
Минимаксы в массивах
*/

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] numbers = new int[20];

            int maximum;
            int minimum;
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(reader.readLine());
            }
            maximum = numbers[0];
            minimum = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < minimum){
                    minimum = numbers[i];
                }
            }

            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > maximum){
                    maximum = numbers[i];
                }
            }

            System.out.print(maximum + " " + minimum);
        }
}

