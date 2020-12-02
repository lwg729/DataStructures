package recursion;

//回溯问题
public class Queue8 {
    //定义一个数组 表示拥有8个皇后
    int max = 8;
    static int count = 0;
    static int judgeCount = 0;
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法\n", count);
        System.out.printf("一共判断冲突的次数%d次\n", judgeCount);
    }

    //放置皇后
    public void check(int n) {
        if (n == max) {
            print();   //n=8 表示8个皇后都已放好
            return;
        }

        //以此放入皇后,判断是否冲突
        for (int i = 0; i < max; i++) {

            //现将当前这个皇后n,放到该列的第一列
            array[n] = i;      //n表示n-1行    i表示i-1列
            if (judge(n)) {   //判断是否冲突
                check(n + 1);  //n不停的增加   如果冲突则会回溯
            }

        }
    }

    //检测和前面的摆放的皇后是否冲突

    /**
     * @param n n表示第几个皇后
     * @return
     */
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {  //i表示i行  n要和i对应

            //前一个表示是否是同一列,后面一个是否在对线上
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    //将皇后的摆放位置打印出来
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {  //表示第几行
            System.out.print(array[i] + " ");  //表示八个皇后各在第几列
        }
        System.out.println();
    }

}
