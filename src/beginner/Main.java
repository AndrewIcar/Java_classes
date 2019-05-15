package beginner;
import javax.annotation.processing.Messager;
import java.lang.Math;
import java.nio.Buffer;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
public class Main {
    //crazy sh*t here, look at your own risk
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }
    public static class NoteThread extends Thread {
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Note.addNote(getName() + "-Note" + i);
                    Thread.currentThread().sleep(1);
                    Note.removeNote(getName());
                }
                catch (InterruptedException e){

                }
            }
        }
    }
}
/*
public class Main {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new t1()));
        threads.add(new Thread(new t2()));
        threads.add(new Thread(new t3()));
        threads.add(new Thread(new t4()));
        threads.add(new Thread(new t5()));
    }
        public static void main(String[] args) {
            for (Thread t: threads) {
                t.start();
            }
            }

        public static class t1 extends Thread{
            public void run(){
                while(true){}
            }
        }
        public static class t2 extends Thread {
            public void run(){
                try{
                    throw new InterruptedException();
                    //while(!Thread.currentThread().isInterrupted()){}
                }
                catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        }
        public static class t3 extends Thread {
            public void run(){
                try {
                    System.out.println("Ура");
                    Thread.currentThread().sleep(500);
                }
                catch (InterruptedException e){
                    System.out.println("InterruptedException in 3rd Thread");
                }
            }
        }
        public static class t4 extends Thread implements Message {
            public void showWarning(){
                Thread.currentThread().interrupt();
            }
            public void run(){
                while(!t4.currentThread().isInterrupted()){

                }
            }
        }
        public static class t5 extends Thread {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            public void run(){
                try {
                    while(!reader.readLine().equals("N"))
                    sum += parseInt(reader.readLine());
                }
                catch (IOException e){
                    System.out.println("IOexception");
                }
            }
        }
}


        //Object obj = new Integer(10);
        //String str = (String) obj;
        //System.out.println(str);



        // int e = new int[4][8].length;
        // System.out.println(new int[][]{{1,2,7},{3,4,5}}[1][2]);
        // Set<String> s = new TreeSet<String>();
        // HashSet<String> s1 = new TreeSet<String>();
        // HashSet<String> s2 = new LinkedHashSet<>();
        // Set<String> s3 = new HashSet<>();

        //  NavigableMap<String, Integer> s4 = new TreeMap<>();

        //  Collection<String, Integer> s6 = new HashMap<>();
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(1);
            }
        });
        Thread t = new Thread(t1);
        t.start();

    }*/
