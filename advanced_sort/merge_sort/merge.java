package advanced_sort.merge_sort;

public class merge {

    //assistant array
    private static Comparable[] assist;


    //compare v and w
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //change the place of i and j
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //ordering array a
    public static void sort(Comparable[] a) {
        assist=new Comparable[a.length];
        int lo=0;
        int hi=a.length-1;
        sort(a,lo,hi);
    }


    //ordering from lo to hi
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo){
            return;
        }

        int mid=lo+(hi-lo)/2;//

        sort(a,lo,mid);
        sort(a,mid+1,hi);

        merge(a,lo,mid,hi);
    }

    //group lo to mid and mid to hi
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        //three pointer
        int i=lo;
        int p1=lo;
        int p2=mid+1;

          while(p1<=mid && p2<=hi){
              //compare the value of index
              if(less(a[p1],a[p2])){
                  assist[i++]=a[p1++];
              }
              else{
                  assist[i++]=a[p2++];
              }
          }
          while(p1<=mid){
              assist[i++]=a[p1++];

          }
          while(p2<=hi){
              assist[i++]=a[p2++];
          }
        for(int index=lo;index<=hi;index++){
            a[index]=assist[index];
        }
    }

}