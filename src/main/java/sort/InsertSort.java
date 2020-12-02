package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 32, 1, -1, 66};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }


        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy--MM-dd HH-mm-ss");
        String date1Str = format.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

       /* System.out.println(Arrays.toString(arr));
        System.out.println("排序前");*/
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        Date data2 = new Date();
        String date2Str = format.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {  //arr一个有6个   只需要利用第一个后面的五个与前面的进行比较
            //待插入的值
            int insertVal = arr[i];
            //要插入的位置
            int insertIndex = i - 1;  //arr[1]前面的一个位置

            //保证要插入的索引>=0 不越界   要插入的值 小于前一个位置的数
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];  //后移一位  把前面的位置给腾出来
                insertIndex--;
            }
            while (insertIndex + 1 != i) {  //当位置变化时在进行移位  可写可不写
                arr[insertIndex + 1] = insertVal;
            }

           // System.out.println(Arrays.toString(arr));
        }
        /*//待插入的值
        int insertVal = arr[1];
        //要插入的位置
        int insertIndex = 1 - 1;  //arr[1]前面的一个位置

        //保证要插入的索引>=0 不越界   要插入的值 小于前一个位置的数
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];  //后移一位
            insertIndex--;
        }

        arr[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(arr));

        //待插入的值
         insertVal = arr[2];
        //要插入的位置
        insertIndex = 2 - 1;  //arr[1]前面的一个位置

        //保证要插入的索引>=0 不越界   要插入的值 小于前一个位置的数
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {   //满足这两个条件进入此判断条件
            arr[insertIndex + 1] = arr[insertIndex];  //后移一位
            insertIndex--;       //继续判断前一个数与要插入的数进行比较  当=-1时跳出循环
        }

        arr[insertIndex+1] = insertVal;
        System.out.println(Arrays.toString(arr));*/

    }
}
