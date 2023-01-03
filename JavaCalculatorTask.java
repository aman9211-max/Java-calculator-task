
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class JavaCalculatorTask {

    public static double calculate(String s) {
        double len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Double> stack = new Stack<Double>();
        double num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
    
        double re = 0;
        for(double i:stack){
            re += i;
        }
        return re;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.next();
        double result = calculate(expression);
        if(result > (double) (Math.floor(result))) {
            DecimalFormat numberFormat = new DecimalFormat("0.00000");
            System.out.println(numberFormat.format(result));
        }
        else {
            System.out.println((long) (Math.floor(result)));
        }
       
    }
}
