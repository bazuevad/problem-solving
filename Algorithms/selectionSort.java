
//average and worst times are O(n^2)
public static int[] selectionSort(int[] array) {
    if(array.length <=0){
			return array;
		}
    for(int i = 0; i< array.length; i++){
			int min = Integer.MAX_VALUE;
			int min_index = 0;
			for(int j = i; j< array.length;j++){
				if(array[j]<min){
					min = array[j];
					min_index = j;
				}
			}
			int tmp = array[min_index];
			array[min_index] = array[i];
			array[i] = tmp;
		}
    return array;
  }