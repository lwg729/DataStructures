package sparseArray;



public class SparseArray {
    public static void main(String[] args) {


        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //chessArr1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("----------原始的二维数组-----------------");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转化为 稀疏数组

        System.out.println("----------将二维数组转化为 稀疏数组---------");

        //1.得到二维数组中的数据个数
        int sum=0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparseArray[][]=new int[sum+1][3]; //此数组为sum+1行 3列
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        //3.遍历数组 将数据的行列以及值赋给稀疏函数
        int count=0;//用于记录第几个非0数据
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;  //第一个数据需要放在第二行
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArr1[i][j];
                }
            }
        }
        //4.输出稀疏数组
        for (int i=0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],
                    sparseArray[i][2]);
        }

        System.out.println("--------将稀疏数组转化为原型数组");
        //1.根据稀疏数组的第一行得到原始数组的范围大小
        int chessArr2[][]=new int[sparseArray[0][0]][sparseArray[0][1]];
        //2.根据稀疏数组的位置信息第二行得到原始数组的数据
        for (int i=1;i<sparseArray.length;i++){
            chessArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        System.out.println("--------回复后的原始数组-------------");

        for (int[] row : chessArr2) {
            for (int data : row) {

                System.out.printf("%d\t",data);

            }
            System.out.println();

        }
    }
}
