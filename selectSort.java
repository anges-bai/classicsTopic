 public static void selectSort(int[] array) { 
    for (int i = 0; i < array.length - 1; i++) { 
        // 无序区间: [0, array.length - i) 
        // 有序区间: [array.length - i, array.length) 
        int max = 0; 
        for (int j = 1; j < array.length - i; j++) {
            if (array[j] > array[max]) { 
                max = j;
            }
        }
        int t = array[max]; 
        array[max] = array[array.length - i - 1];
        array[array.length - i - 1] = t; 
    }
}
