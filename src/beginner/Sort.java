package beginner;

public interface Sort{
    static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    static void exch(Comparable[] a, int i,int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;;
    }
    static void show(Comparable[] a){
//вывод массива одной строкой
        for (Comparable comparable : a) {
            System.out.println(comparable + " ");
        }
    }
    static boolean isSorted(Comparable[] a){
//проверка упорядочености
        for(int i = 0; i < a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }
}
