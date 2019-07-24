package com.nikoer.helloworld.data;
//181
import java.math.BigDecimal;
import java.util.Stack;

public class BigNumCalc {
    public static Object[] testInput = {
            new BigDecimal("839278959283893263353333394803.5379872"),
            new BigDecimal("2.0"),
            "*",
    };

    public static void mian(String[] args){
        BigNumCalc calc = new BigNumCalc();
        System.out.println(calc.calculate(testInput));
    }
    Stack<BigDecimal> stack = new Stack<>();

    public BigDecimal calculate(Object[] input){
        BigDecimal tmp;
        for(int i=0;i<input.length;i++){
            Object o = input[i];
            if(o instanceof BigDecimal){
                stack.push((BigDecimal) o);
            }else if(o instanceof String){
                switch (((String) o).charAt(0)){
                    case '+':
                        stack.push((stack.pop()).add(stack.pop()));
                        break;
                    case '*':
                        stack.push(stack.pop().multiply(stack.pop()));
                        break;
                    case '-':
                        tmp = (BigDecimal) stack.pop();
                        stack.push((stack.pop()).subtract(tmp));
                        break;
                    case '/':
                        tmp = stack.pop();
                        stack.push((stack.pop()).divide(tmp, BigDecimal.ROUND_HALF_UP));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknow OPERATOR popped");
                }
            }else {
                throw new IllegalArgumentException("Syntax error in input");
            }
        }
        return stack.pop();
    }
}
