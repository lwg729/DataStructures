package sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1, -1, 90, 123};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  //要比较6次 之所以呢使用arr.length-1（此时为6）总共为7 是因为 下方循环中是从第二个开始提取与前一个数比较的
            int minIndex = i;   //先定义一个最小数的索引
            int minNumber = arr[i];  //表示最小数
            for (int j = i + 1; j < arr.length; j++) {   //当i=0时，用101后面的数与之比较  遍历6次
                if (minNumber > arr[j]) {  //如果自定义的最小的数  后面存在存在更小的数 则重置最小数和最小数的索引  每次循环都会出现一个最小的数与后面的进行比较
                    //重置arr[min]
                    minNumber = arr[j];   //将后方更小的数重置     等一轮比较完后 跳出循环  进行位置的互换(因为此时只是把更小的数给找到了,后面需要更换位置)
                    minIndex = j;
                }
            }
            //如果不是原先定义的最小值 需要互换
            if (minIndex != i) {  //换位置
                arr[minIndex] = arr[i];  //把第一个换到原先最小的位置  此时最小数的位置是j=minIndex
                arr[i] = minNumber;
            }

        }
    }
}
