/**2. Попробовать сгенерировать все перестановки длины N из K чисел с повторениями. 
Пример: N = 2, K = 3 ответ "00 01 02 10 11 12 20 21 22"*/

import java.util.Arrays;

public class ZadDom1 {

    
    public static void combination(int [] arr,int index, int amount){
                       
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }            
        for(int i = 0; i < amount; i++ ){
            arr[index] = i;
            combination(arr, index + 1, amount);
        }
    }
    public static void main(String[] args){
        int N = 2;
        int amount = 5;
        int[] arr = new int [N];
        combination(arr, 0, amount);
    }
        
}  

