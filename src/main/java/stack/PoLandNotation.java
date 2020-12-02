package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PoLandNotation {
    public static void main(String[] args) {

      /*  String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList="+list);
        int res=calculate(list);
        System.out.println("计算的结果是："+res);*/

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> list = toInfixExpression(expression);
        System.out.println("中缀表达式对应的List=" + list); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]

        //中缀转后缀
        //将中缀转换成对应的list
        List<String> infixExpression = toInfixExpression(expression);
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpression);
        System.out.println("后缀表达式:"+parseSuffixExpressionList);

    }

    //将中缀表达式对应的list转换成后缀表达式对应的list
    public static List<String> toInfixExpression(String s) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;   //用于遍历的移动
        String str;  //用于拼接数字和运算符    String str="";  结果 [1, +, (, (, 12, +, 123, ), *, 1234, ), -, 12345]
        // 原因:因为while会把每个数字自动保存并连接在一起

        char c;      //用于存放运算符
        do {
            //判断是否是运算符
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";      //???为什么会有不同的结果    [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {

                    str += c;    //将数字转化为字符串类型 并将数字拼接起来
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());  //防止超出字符串的长度
        return list;
    }

    //将一个逆波兰表达式,依次放入ArrayList中
    public static List<String> getListString(String suffixExpression) {
        ArrayList<String> list = new ArrayList<>();

        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if (item.matches("\\d+")) {//匹配的是多位数
                stack.push(item);
            } else {
                //等到匹配的是运算符后
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }
        }
        //最后的运算结果
        return Integer.parseInt(stack.pop());
    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : ls) {
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                //栈的顶部没碰到）之前  s1中的符号不断弹出放入s2
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //当栈中顶部的运算符的优先级大于等于将要放入的运算符时 弹出并放入s2
                while (s1.size()!=0 &&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符放入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}

