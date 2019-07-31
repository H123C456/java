package AA.thirty;
//296
public class ReferencesDemo3 {
    interface Funinterface{
        void process(int i,String j,char c,double d);
    }
    public static void work(int i,String j,char c,double d){
        System.out.println("Moo");
    }
    public static void main(String[] args){
        Funinterface sample = ReferencesDemo3::work;
        System.out.println("My process method is"+sample);
    }
}
