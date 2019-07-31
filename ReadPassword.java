package AA.thirty;



import java.io.Console;

public class ReadPassword {
    public static void mian(String[] args){
        Console cons;
        if((cons = System.console()) !=null){
            char[] passwd = null;
            try{
                passwd = cons.readPassword("Password");
                System.out.println("Your password was:"+new String(passwd));
            }finally{
                if(passwd != null){
                    java.util.Arrays.fill(passwd,' ');
                }
            }
        }else{
            throw new RuntimeException("No console, can`t get password");
        }
    }

}
