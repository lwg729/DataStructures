package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};

        /*int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }*/

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy--MM-dd HH-mm-ss");
        String date1Str = format.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

       /* System.out.println(Arrays.toString(arr));
        System.out.println("排序前");*/
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        Date data2 = new Date();
        String date2Str = format.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

    }

    public static void bubbleSort(int[] arr) {
        //boolean flag = false;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            /*if (!flag) {  //在一趟排序中,以此交换都没有发生过
                break;
            } else {
                flag = false;  //重置flag 进行下次判断
            }*/
        }
    }
}
