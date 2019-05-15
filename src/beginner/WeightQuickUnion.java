package beginner;

/*
глубина любого узла в лесе, созданном ввешенным быстрым объединением для N узлов,
не превышает lgN
*/
import java.io.*;
import java.util.Scanner;
public class WeightQuickUnion{
    private int[] id;// родительская ссылка(индексация узлами)
    private int[] sz;// размер компонента для корней(индексация узлами)
    private int count;// количество компонентов

    public WeightQuickUnion1(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i<N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i<N; i++) sz[i] = i;
    }
    public int count(){return count;}
    public boolean connected(int p, int q){ return find(p)==find(q); }

    private int find(int p){
        //переходы по ссылкам до корня.
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union (int p, int q){
        //приведение  p и q к общему корню
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        //меньший корень должен указывать на больший
        if(sz[i] <sz[j]){ id[i] = j; sz[j] += sz[i]; }
        else 		{ id[j] = i; sz[i] += sz[j]; }
        count--;
    }

    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner keyboard = new Scanner(System.in);

        int N = keyboard.nextInt();
        WeightQuickUnion uf = new WeightQuickUnion(N);
        try{
            while (!keyboard.equals("exit")){
                System.out.println("vvedite p ");
                int p = keyboard.nextInt();
                System.out.println("vvedite q ");
                int q = keyboard.nextInt();
                if (uf.connected(p,q)) continue;
                uf.union(p,q);
                System.out.println(p + " " +q);

            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
        System.out.println(uf.count() + " componetns");
    }

}

