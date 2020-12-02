package recursion;

public class MiGong {

    public static void main(String[] args) {


        //利用数组创建迷宫
        int[][] map = new int[8][7];

        //第一行和第八行都为墙
        for (int j = 0; j < 7; j++) {
            map[0][j] = 1;
            map[7][j] = 1;
        }
        //第一列和第七列都为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][0] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        getWay(map,1,1);//设置起点
        System.out.println("小球走过 并表示过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean getWay(int[][] map, int i, int j) {
        //确定终结点
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {  //此条路还没有走过
                map[i][j] = 2;  //记录能走通的路
                //判断走的路程  每走一步记录i,j的路程记录
                if (getWay(map, i + 1, j)) {  //向下走
                    return true;
                } else if (getWay(map, i, j + 1)) {  //向右走
                    return true;
                } else if (getWay(map, i - 1, j)) {  //向上走
                    return true;
                } else if (getWay(map, i, j - 1)) {  //向左走
                    return true;
                } else {
                    //走不通的路设置为3
                    map[i][j] = 3;
                    return false;
                }
            } else {  //其他的情况 1 2 3
                return false;
            }
        }


    }


}
