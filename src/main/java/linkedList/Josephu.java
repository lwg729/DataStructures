package linkedList;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);// 加入5个小孩节点
        circleSingleLinkedList.list();
        System.out.println("\n");
        System.out.println("小孩出圈前\n----------");
        circleSingleLinkedList.countBoy(1, 2, 5);
        circleSingleLinkedList.list();
    }
}


//创建环形循环单链表
class CircleSingleLinkedList {
    //创建一个first节点,当前没有编号
    private Boy first = null;
    //创建添加方法
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不准确");
            return;
        }

        //创建一个辅助节点
        Boy curBoy = null;

        //循环遍历
        for (int i = 1; i <= nums; i++) {
            //多次创建boy节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;  //让first节点指向第一个boy
                first.setNext(first);  //构成环
                curBoy = first;  //让辅助节点指向第一个Boy  因为first节点不动
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);  //再次构成环
                curBoy = boy;  //让辅助节点往后挪

            }
        }
    }

    public void list() {
        //先判断链表是否为空
        if (first == null) {
            System.out.println("该链表为空");
            return;
        }
        //first不能动,因此用辅助节点先代替第一个节点
        Boy curboy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curboy.getNo());
            if (curboy.getNext() == first) {
                break;
            }
            curboy = curboy.getNext();
        }
    }

    //根据用户的输入,计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数
     * @param countNum //表示数几下
     * @param nums     //表示有几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //对数据进行校验
        if (first == null || countNum < 0 || countNum > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

        //创建一个辅助节点,并且这个辅助节点一开始指向最后的节点
        Boy cur = first;  //说明存在数据 设置为空的话后面设置的移动等则依旧是空指针
        while (true) {
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();   //一直循环到指向最后一个节点 跳出循环
        }
        //小孩报数前,先让first和cur移动k-1次 意思是从第几个小孩开始数  比如说从第三个 那么移动2次指向第三个孩子
        for (int j = 1; j <= startNo - 1; j++) {
            first = first.getNext();
            cur = cur.getNext();
        }

        //当小孩报数时,让两个指针同时移动countnum-1次 然后出圈
        while (true) {
            if (cur == first) {
                break;    //说明圈中只有一个节点
            }
            for (int j = 1; j <= countNum - 1; j++) {
                first = first.getNext();
                cur = cur.getNext();
            }

            //这时 first指向的节点为要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //出圈
            first = first.getNext();  //移动first指向下一个节点
            cur.setNext(first);  //出圈  剔除节点
        }

        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());

    }
}

//创建boy节点

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
