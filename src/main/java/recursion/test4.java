package recursion;

public class test4 {
    public static void main(String[] args) {
        int test = test(10);
        System.out.println("结果为="+test);


    }

   /* public static void test(int n){
        if (n>2){
            test(n-1);
            System.out.println("n="+n);
        }
        //System.out.println("n="+n);
    }*/

    public static int test(int n){
        if (n==1){
            return 1;
        }else {
            return test(n-1)*n;   //1*2*3*4

        }
    }


}
