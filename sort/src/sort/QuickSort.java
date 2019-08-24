package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = {7,5,2,6,4,3,1};
		quickSort(array);
		
		for(int i=0; i<array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
	}
	public static void quickSort(int[] array) {
		if(array.length<=1)
			return;
		
		int right = array.length-1;
		int left = 0;
		int pivotIndex = array.length/2;
		int pivot = array[array.length/2];
		int tmp;
		
		while(right>pivotIndex && left<pivotIndex) 
			while(array[right]>pivot && right!=pivotIndex+1) {
				right--;
			}
			while(array[left]<pivot && left!=pivotIndex-1) {
				left++;
			}
			
			tmp = array[right];
			array[right] = array[left];
			array[left] = tmp;
		}
		
		quickSort(Arrays.copyOfRange(array, 1, pivotIndex));
		quickSort(Arrays.copyOfRange(array, pivotIndex, array.length-1));
		
	}
}

