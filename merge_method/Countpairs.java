package exercise.merge_method;

import java.util.ArrayList;
import java.util.Arrays;

public class Countpairs {

    public static int Pairscounting(int[] A) {
        return mergeSortCount(A, 0, A.length - 1);
    }


    private static int mergeSortCount(int[] A, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortCount(A, left, mid);
            count += mergeSortCount(A, mid + 1, right);
            count += mergeAndCount(A, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(int[] A, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(A, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(A, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        int count = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                A[k++] = leftArr[i++];
            } else {
                A[k++] = rightArr[j++];
                count += (leftArr.length - i);
            }
        }


        while (i < leftArr.length) {
            A[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            A[k++] = rightArr[j++];
        }


        return count;
    }
}