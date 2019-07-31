package AA.thirty;

public class ReferencesDemo {
    public void walk(){
        System.out.println("ReferenceDemo.walk():Stand-in run method called ");
    }
    public void doIt(){
        Runnable r = this::walk;
        new Thread(r).start();
    }
    public static void main(String[] args){
        new ReferencesDemo().doIt();
    }
}
