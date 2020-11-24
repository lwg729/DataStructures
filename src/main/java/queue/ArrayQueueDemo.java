package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户的输入
        char key =' ';
        Scanner scan = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show): 显 示 队 列 ");
            System.out.println("e(exit): 退 出 程 序 ");
            System.out.println("a(add): 添 加 数 据 到 队 列 ");
            System.out.println("g(get): 从 队 列 取 出 数 据 ");
            System.out.println("h(head): 查看队列头的数据");
            //接收字符串
            key=scan.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scan.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int getValue = queue.getQueue();
                    System.out.printf("取出的数据为%d\n",getValue);
                    break;
                case 'h':
                    try {
                        int headQueue = queue.headQueue();
                        System.out.printf("队列头的信息为%d\n",headQueue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scan.close();
                    loop = false;
                    break;
                default:
                    break;

            }

        }
        System.out.println("程序退出");
    }


}

//使用数组模拟队列
class ArrayQueue {
    private int maxSzie; //表示数组的最大容量
    private int front; //队列头
    private int rear;  //队列尾
    private int[] arr; //该数组用于存放数据，模拟队列

    //创建队列的构造函数 用来输入数字表示数组的容量
    public ArrayQueue(int arrMaxSize) {
        maxSzie = arrMaxSize;
        arr = new int[maxSzie];
        front = -1;  //指向队头 ，指向队列头的前一个位置
        rear = -1;   //指向队尾  指向队尾的数据(即队列的最后一个数据)
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSzie - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }


    //添加数据到队列
    public void addQueue(int n){
        //判断是否满了
        if (isFull()){
            System.out.println("队列满了,不能输入数据");
            return;
        }
        //添加一个队尾向后移一位
        rear++;
        arr[rear]=n;

    }

    //获取队列的数据输出数据
    public int getQueue(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空,不能输出数据");
        }
        //向后移一位 因为front指向第一个数据的头
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //1.判断是否为空
        if (isEmpty()){
            System.out.println("队列为空,没有数据");
            return;
        }
        //2.循环遍历
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n", i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空,不能输出数据");
        }
        return arr[front+1];
    }



    //显示队列的头数据，注意不是取出数据
}