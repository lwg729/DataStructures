package linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");


        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.List();


        System.out.println("链表修改前************");

        HeroNode2 heroNode2 = new HeroNode2(3, "伊布", "太阳精灵");
        doubleLinkedList.update(heroNode2);
        doubleLinkedList.List();

        doubleLinkedList.delete(3);
        System.out.println("删除后的节点情况");
        doubleLinkedList.List();
    }
}


class DoubleLinkedList {

    //初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    //循环遍历列表
    public void List() {
        HeroNode2 cur = head.next;
        //判断该链表是否为空
        if (cur == null) {
            System.out.println("该链表为空");
            return;
        }
        while (true) {
            //判断指针是否到底尾部
            if (cur == null) {
                break;
            }
            System.out.println(cur);
            cur = cur.next;
        }

    }

    public void add(HeroNode2 heroNode2) {
        //创建一个辅助指针
        HeroNode2 cur = head;

        //判断是否到尾部  到达则跳出循环
        while (true) {
            if (cur.next == null) {
                break;
            }
            //如果没有找到最后则向后移动
            cur = cur.next;
        }
        //在尾部添加数据
        cur.next = heroNode2;
        heroNode2.pre = cur;

    }

    public void update(HeroNode2 heroNode2) {
        //创建一个临时变量代替head
        HeroNode2 cur = head.next;
        Boolean flag = false;  //判断哪是否找到改数据
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        while (true) {
            //已到达该链表的尾部
            if (cur == null) {
                break;
            }
            if (cur.no == heroNode2.no) {
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if (flag) {
            cur.name = heroNode2.name;
            cur.nickname = heroNode2.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode2.no);
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            return;
        }

        HeroNode2 cur = head.next;
        boolean flag=false;
        while (true) {
            if (cur==null){  //已经到链表的最后一个节点
                break;
            }
            if (cur.no == no) {
                flag=true;
                break;
            }

            cur=cur.next;
        }

        if (flag){
            cur.pre.next=cur.next;

            //避免要指向删除最后一个节点
            if (cur.next!=null){
                cur.next=cur.pre;
            }
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点, 默认为null
    public HeroNode2 pre; // 指向前一个节点, 默认为null
    // 构造器

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    // 为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}