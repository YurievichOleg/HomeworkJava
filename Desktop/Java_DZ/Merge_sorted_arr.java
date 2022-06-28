/*Вам даны два массива целых чисел nums1 и nums2, отсортированные в неубывающем порядке, 
и два целых числа m и n, представляющие количество элементов в nums1 и nums2 соответственно.

Объедините nums1 и nums2 в один массив, отсортированный в неубывающем порядке.

Окончательный отсортированный массив не должен возвращаться функцией, 
а должен храниться внутри массива nums1. Чтобы приспособиться к этому, 
nums1 имеет длину m + n, где первые m элементов обозначают элементы, 
которые должны быть объединены, а последние n элементов устанавливаются 
равными 0 и должны игнорироваться. nums2 имеет длину n. */

public class Merge_sorted_arr {

    /* Для неотстортировенных массивов */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n - 1; i >= 0; i--) {
            nums1[m - 1] = nums2[i];
            m--;
        }
        for (int i = 0; i < nums1.length - 1; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] > nums1[j]) {
                    int replacement = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = replacement;
                }
            }
        }
    }


    /* Для отсортированных массивов */
    public static void mergeForSortedArr(int[] nums1, int m, int[] nums2, int n) {
        int position = m + n - 1;
        while (n > 0 && m > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[position] = nums1[m - 1];
                position--;
                m--;
            } else {
                nums1[position] = nums2[n - 1];
                position--;
                n--;
            }
        }

        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, 9, 0, 0, 0 };
        int[] arr2 = new int[] { 2, 3, 8 };
        mergeForSortedArr(arr, 3, arr2, 3);
        for (int item : arr) {
            System.out.print(item + " ");

        }

    }

}
