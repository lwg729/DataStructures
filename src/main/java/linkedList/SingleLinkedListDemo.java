package linkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);*/
        singleLinkedList.addOrder(hero1);
        singleLinkedList.addOrder(hero4);
        singleLinkedList.addOrder(hero2);
        singleLinkedList.addOrder(hero3);

        singleLinkedList.list();

        System.out.println("原来链表的情况~~");

        HeroNode hero5 = new HeroNode(2,"小卢","玉麒麟------");
        singleLinkedList.update(hero5);
        singleLinkedList.delete(1);
        singleLinkedList.list();
    }


}

class SingleLinkedList {
    //初始化头结点,不存放数据,头结点不动
    private HeroNode head = new HeroNode(0, "", "");


    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    public void addOrder(HeroNode heroNode) {

        HeroNode temp = head;

        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {  //表示下一个节点的数据大于新节点的数据
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }

            //继续往下对比
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("准备插入的编号%d已存在,不能加入", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        boolean flag=false;

        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }

        if (flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;
        }else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
    public void delete(int no){
        if (head.next==null){
            return;
        }
        HeroNode temp=head;
        boolean flag = false;

        while (true){
            if (temp==null){
                break;
            }
            if (temp.next.no==no){
                flag=true;
                break;
            }

            temp=temp.next;
        }

        if (flag){
            temp.next=temp.next.next;

        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }

}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "linkedList.HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}