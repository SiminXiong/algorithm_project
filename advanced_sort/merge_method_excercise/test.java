package advanced_sort.merge_method_excercise;

import static advanced_sort.merge_method_excercise.Countpairs.Pairscounting;

public class test {
    public static void main(String[] args) {
        int[] A = {2,3,8,6,1};
        int pairs =Pairscounting(A);
        System.out.println("Number of out-of-order pairs: " + pairs);
    }
}
