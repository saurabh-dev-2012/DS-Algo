package com.java.practice.dsalgo.ik;

public class MergeTwoSortedArrays {

public static void main(String[] args) {
// TODO Auto-generated method stub
      int[] arr1 = {1,10,11,12,13};
      int[] arr2 = {2,3,4,13,15,0,0,0,0,0};
      merger_first_into_second(arr1,arr2);
}

// public static void merger_first_into_second(int[] arr1, int[] arr2) {
//        /*
//         * Write your code here.
//         */
//        int i=0;
//        int j=0;
//        int[] mergedArray = new int[arr2.length];
//        int mergedIndex=0;
//        while(i < arr1.length && j < arr1.length) {
//            if(arr1[i] <= arr2[j]) {
//                mergedArray[mergedIndex] = arr1[i];
//                i++;
//            }
//            else {
//                mergedArray[mergedIndex] = arr2[j];
//                j++;
//            }
//            mergedIndex++;
//        }
//        
//        while (i < arr1.length) {
//            mergedArray[mergedIndex] = arr1[i];
//            i++;
//            mergedIndex++;
//        }
//        
//        while (j < arr1.length) {
//            mergedArray[mergedIndex] = arr2[j];
//            j++;
//            mergedIndex++;
//        }
//        
//        arr2 = mergedArray;
//        System.out.println("Something...");
//    }
//1 10 11 12 13
//2 3 4 13 15 0 0 0 0 0
/***
* 1st iteration
* 1 3 0
* 2 4 0 0 5 6
*
*/


  public static void merger_first_into_second(int[] arr1, int[] arr2) {
        /*
         * Write your code here.
         */
        int i = arr1.length - 1;
        int j = arr1.length - 1;
        int array2Index = arr2.length - 1;;
        while(i >= 0 && j >= 0) {
            if(arr1[i] >= arr2[j]) {
                arr2[array2Index--] = arr1[i];
                //arr2[array2Index--] = arr2[j];
                i--;
            }
            else {
        arr2[array2Index--] = arr2[j];
        //arr2[array2Index--] = arr1[i];
        j--;
            }
           
        }
        // fill the rest of the elements in arr2
        while(i >= 0) {
        arr2[array2Index--] = arr1[i];
        i--;
        }
       
        while(j >= 0) {
        arr2[array2Index--] = arr2[j];
        j--;
        }
    }

}
