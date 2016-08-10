import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] unarray = {5,8,2,3,4,5};

		System.out.println("Before: " + Arrays.toString(unarray));
		HeapSort h = new HeapSort(unarray);
		h.heapSort();
		System.out.println("After: " + Arrays.toString(unarray));

	}
	int[] array;
	int length;
	public HeapSort(int[] unsortedArray){
		array = unsortedArray;
		length = array.length -1;
	}
	
	void heapSort(){
		heapify();
		
		for( int i= length; i>0; i--){
			swap(0,i);
			length = length -1;
			maxNumber(0);
		}
	}
	
	void heapify() {
		for (int i = length/2; i>= 0; i--){
			maxNumber(i);
		}
	}
	void swap(int firstNumber, int secondNumber){
		int tmp = array[firstNumber];
		array[firstNumber] =array[secondNumber];
		array[secondNumber] = tmp;
	}
	
	void maxNumber (int index){
		int left = 2*index;
		int right = 2*index +1;
		int largest = index;
		
		if (left <= length && array[left] >array[index] ){
			largest= left;
		} 
		if (right <= length && array[right] > array[largest]){
			largest = right;
		}
		if (largest != index){
			swap(index, largest);
			maxNumber(largest);
		}
		
	}
}
