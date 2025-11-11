package advanced_sort.quick_sort;

public class quick {
    //compare v and w
    private static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
    }

    //change i and j
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void sort(Comparable[] a) {
      int lo=0;
      int hi=a.length-1;
      sort(a,lo,hi);
    }


    //orideing from lo to hi
    private static void sort(Comparable[] a,int lo,int hi){

        if(hi<=lo){
            return;
        }

        //group to left group and right group
        int partition=partition(a,lo,hi);


        sort(a,lo,partition-1);

        sort(a,partition+1,hi);


    }

    //group from lo to hi
    private static int partition(Comparable[] a,int lo,int hi){
        //confirm border value
        Comparable key=a[lo];


        int left=lo;
        int right=hi+1;

        //cut
        while(true){
             while(less(key,a[--right])){
                 if(right==lo){
                     break;
                 }
             }
            while(less(a[++left],key)){
                if(left==hi){
                    break;
                }
            }
            if(left>=right){
                break;
            }
            else{
                exch(a,left,right);
            }
        }
        exch(a,lo,right);
        return right;
    }
}
