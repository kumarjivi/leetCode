package divideAndConquer;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,2,5,7,3,6,8,5};
		arr = sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		//System.out.println(sort(arr));
	}
	
	public static int[] sort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public static int partition(int[] arr, int start, int end) {
		//taking the last element as pivot.
		int pivot = arr[end];
		int i = start-1;
		int temp = 0;
		if(start < end) {
			for(int j=start; j<end; j++) {
				if(arr[j] < pivot) {
					//swap j and i+1
					i++;
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			//swap i+1 and pivot.
			i++;
			temp = arr[i];
			arr[i] = pivot;
			arr[end] = temp;
		}
		return i;
	}

	public static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pIndex = partition(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
}
