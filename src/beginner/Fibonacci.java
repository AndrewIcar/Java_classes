package beginner;

import java.util.ArrayList;

public class Fibonacci {
    private static ArrayList<Long> getSequencePeriod(long m){
        //метод через период Пизано
        ArrayList<Long> s = new ArrayList();
        s.add((long)0);
        s.add((long)1);
        for(int i = 2; i < m * 6; i++){
            s.add((s.get(i - 1) + s.get(i - 2)) % m);
            if(s.get(i) == 1 && s.get(i-1) == 0){
                break;
            }
        }
        return s;
    }
    private static long getFibonacciRest(long n, long m){
        ArrayList<Long> s = getSequencePeriod(m);
        long period = s.size() - 2; // находим период Пизано
        int val = (int)(n % period);
        return s.get(val);
    }
    private static long Fibonacci(int n){
        long a = 0,b = 1,c = 0;
        for (int i = 0; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return a;
    }
}
