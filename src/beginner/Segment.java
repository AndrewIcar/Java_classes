package beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

//Задача о выборе заявок, улучшенный алгориттм
public class Segment {
    private int begin;
    private int end;
    public Segment(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    public static int getEnd(Segment segment){
        return segment.end;
    }
    public static Segment compareTo(Segment segment1, Segment segment2){
        if(getEnd(segment1)>getEnd(segment2))return segment1;
        else return segment2;
    }
    public static int sort(ArrayList<Segment> sort) {
        if()

    }
    public static void main(String[] args){
        ArrayList<Segment> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = reader.read();
            while (!(n == 0)) {
                list.add(new Segment(reader.read(), reader.read()));
            }
        }
        catch (Exception e){}
    }
}
