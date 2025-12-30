package edu.touro.mcon264.sorting;

import java.util.Comparator;

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(T[] a, Comparator<? super T> comp) {
        if (a == null || a.length <= 1) return;

        @SuppressWarnings("unchecked")
        T[] aux= (T[]) new Object[a.length];
        class MergeSorter {
            void mergeSort(int left, int right) {
                if (left >= right) return;
                int mid = left + (right - left) / 2;
                mergeSort(left, mid);
                mergeSort(mid + 1, right);
                for (int i = left; i <= right; i++) {
                    aux[i] = a[i];
                }
                int i = left;
                int j = mid + 1;
                int k = left;
                while (i <= mid && j <= right) {
                    if (comp.compare(aux[i], aux[j]) <= 0) {
                        a[k++] = aux[i++];
                    } else {
                        a[k++] = aux[j++];
                    }
                }
                while (i <= mid) {
                    a[k++] = aux[i++];
                }
            }
        }
        new MergeSorter().mergeSort(0, a.length - 1);
            }
}
