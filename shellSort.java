public static void shellSort(int[] array) {
       int gap = array.length;
       while (gap > 1) {
        insertSortGap(array, gap);
        gap = (gap / 3) + 1;
        // OR gap = gap / 2; 
           }
           insertSortGap(array, 1); 
}
    private static void insertSortGap(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int j = i - gap;
            for (; j >= 0 && array[j] > v; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = v;
        }
    }
