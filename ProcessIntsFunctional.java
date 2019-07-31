package AA.thirty;
//289
import java.util.function.Function;

public class ProcessIntsFunctional {
    static int[] integers = {0,1,2,3,4,5};

    static int doTheMath(int n, Function<Integer,Integer>func){
        return func.apply(n);
    }
    public static void main(String[] args){

        int total = 0;
        for(int i:integers){
            total +=doTheMath(i,k->k*k+1);
        }
        System.out.println(total);
    }

}
