package BinarySortTree;

/**
 * 功能描述：二叉排序树
 *
 * @Author: lwg
 * @Date: 2021/3/12 20:59
 */
public class BinarySortTree {

    //定义根节点
    private Node root;

    //查找要删除节点的值
    public Node search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * @param node 传入的目标节点的右子树
     * @return 返回的右子树中子节点的最小值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

    //删除叶子节点
    public void delete(int value) {
        if (root == null) {
            System.out.println("根节点为空,无法删除根节点");
            return;
        }
        //查找要删除的叶子结点
        Node targetNode = search(value);
        if (targetNode == null) {
            System.out.println("没有找到要删除的节点");
            return;
        }

        //如果我们发现根节点没有左右节点 置为空
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }

        //找到targetNode的父节点
        Node parent = searchParent(value);
        //如果删除的节点是叶子节点
        if (targetNode.left == null && targetNode.right == null) {   //没有子节点
            //判断删除的节点是父节点的左节点还是右节点
            if (parent.left != null && parent.left.value == targetNode.value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == targetNode.value) {
                parent.right = null;
            }
        } else if (targetNode.right != null && targetNode.left != null) {  //有两个子节点
            int min = delRightTreeMin(targetNode.right);
            targetNode.value = min;
        } else {
            //删除节点的子节点有左节点
            if (targetNode.left != null) {
                if (parent != null) {
                    //如果要删除的节点是父节点的左节点还是右节点
                    if (parent.left != null && parent.left.value == targetNode.value) {
                        parent.left = targetNode.left;
                    } else if (parent.right != null && parent.right.value == targetNode.value) {
                        parent.right = targetNode.left;
                    }
                } else {
                    root = targetNode.left;
                }

            } else {
                if (parent != null) {
                    //删除节点有右子节点
                    if (parent.left != null && parent.left.value == targetNode.value) {
                        parent.left = targetNode.right;
                    } else if (parent.right != null && parent.right.value == targetNode.value) {
                        parent.right = targetNode.right;
                    }
                } else {
                    root = targetNode.right;
                }

            }
        }

    }

    //添加节点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //调用中序遍历的方法
    public void infixOrder() {
        if (root == null) {
            System.out.println("根节点为空，无法遍历");
            return;
        } else {
            root.infixOrder();
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree sortTree = new BinarySortTree();
        //循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            sortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉树
        sortTree.infixOrder();
        System.out.println("删除前----------------------------");

        sortTree.delete(2);
        sortTree.delete(5);
        sortTree.delete(9);
        sortTree.delete(12);
        sortTree.delete(7);
        sortTree.delete(3);
        sortTree.delete(10);
        sortTree.delete(1);

        System.out.println("删除后------------");
        sortTree.infixOrder();
    }


}

//定义节点信息
class Node {
    //需要值 左右指针
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortTree.Node{" +
                "value=" + value +
                '}';
    }

    //添加节点需要用到递归  并且加入的节点比当前节点值小的放左边 大的放右边  相同的值不需要再插入
    public void add(Node node) {
        //如果传入的节点为空,直接返回
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            //如果节点没有叶子结点
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            //添加的节点大于当前节点 放右边
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的叶子节点
     *
     * @param value 希望删除的值
     * @return 返回的是要删除的节点
     */
    public Node search(int value) {
        //找到该节点
        if (this.value == value) {
            return this;
        }
        if (value < this.value) {  //如果要查找的值小于当前节点的值  向左节点递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param value 要找到删除的值
     * @return 返回父节点  没有则返回null
     */
    public Node searchParent(int value) {
        //当前节点就是要删除的节点的父节点,返回
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前节点的值,并且当前节点的左子节点不为空
            if (value < this.value && this.left != null) {
                //递归往左节点继续查找要删除的值
                return this.left.searchParent(value);
            } else if (value > this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;   //没有找到父节点
            }
        }
    }
}
