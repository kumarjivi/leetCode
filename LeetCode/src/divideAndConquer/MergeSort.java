package divideAndConquer;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,4,7,2,5,7,3,6,8,5};
		arr = sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static int[] sort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
		return arr;
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		int mid = 0;
		if(start < end) {
			mid = (start + end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
		
	}
	
	public static void merge(int[] arr, int s, int m, int e) {
		int len1 = m-s+1;
		int len2 = e-m;
		int[] temp1 = new int[len1];
		int[] temp2 = new int[len2];
		int index = 0;
		int index1 = 0;
		int index2 = 0;
		for(int i=s; i<=m; i++) {
			temp1[index1] = arr[i];
			index1++;
		}
		for(int i=m+1; i<=e; i++) {
			temp2[index2] = arr[i];
			index2++;
		}
		index1 = 0;
		index2 = 0;
		index = s;
		while(index1 < len1 && index2 < len2) {
			if(temp1[index1] <= temp2[index2]) {
				arr[index++] = temp1[index1++];
//				index1++;
			} else {
				arr[index++] = temp2[index2++];
//				index2++;
			}
//			index++;
		}
		while(index1 < len1) {
			arr[index++] = temp1[index1++];
		}
		while(index2 < len2) {
			arr[index++] = temp2[index2++];
		}
	}
}
