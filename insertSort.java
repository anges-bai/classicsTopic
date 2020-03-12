
public static void insertSort(int[] array) {

           for (int i = 1; i < array.length; i++) {
           // 有序区间: [0, i)
           // 无序区间: [i, array.length)
           int v = array[i];
           // 无序区间的第一个数 
           int j = i - 1;
           // 不写 array[j] == v 是保证排序的稳定性 
           for (; j >= 0 && array[j] > v; j--) {
                array[j + 1] = array[j];
                }
                  array[j + 1] = v;
                  }
                  }
