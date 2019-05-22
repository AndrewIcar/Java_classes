package beginner;

public interface ShellSort extends Sort {

        static void sort(Comparable[] a){

            int N = a.length;
            int h = 1;
            while(h < N/3) h = 3*h + 1;
            while(h>=1){
                for(int i = h; i < N; i++){
                    //вставка a[i] среди a[i-h], a[i-2*h], ... .
                    for(int j = i; j >= h && Sort.less(a[j], a[j-h]); j -= h)
                        Sort.exch(a,i,j-h);
                }
                h = h/3;
            }
        }
}

