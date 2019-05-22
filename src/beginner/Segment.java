package beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

//Задача о выборе заявок, улучшенный алгориттм
//Улучшенный алгоритм(nlogn): нужно отсортировать n отрезков по правым концам. Для всех отрезком в в получннном порядке:
//	если текущий отрезок не пересекает
//		последний добавленный
//		взять его в решение
//	вернуть построенное решение.
public class Segment implements Comparable<Segment>  {
    private Integer begin;
    private Integer end;

    private Segment(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Segment o) {
            return Integer.compare(this.end , o.end);
    }

    public static int getEnd(Segment segment){
        return segment.end;
    }
    public static void run(){

        try(Scanner input = new Scanner(System.in)){

            int n = input.nextInt();
            ArrayList<Segment> segments = new ArrayList<>(n);
            for(int i = 0; i<n ; i++){
                int a = input.nextInt();
                int b = input.nextInt();
                segments.add(new Segment(a, b));
            }
            Collections.sort(segments);
            int number = 0;
            int j=0;
            ArrayList<Integer> numbers = new ArrayList<>();
           while(j<n){
                if(segments.get(j).compareTo(segments.get(j + 1)) > 0){
                    number++;
                }
                System.out.println(segments);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        run();
    }
}
