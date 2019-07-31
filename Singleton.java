package AA.thirty;

public class Singleton {
    public static Singleton instance;

    private Singleton(){

    }

    static {
        instance = new Singleton();
    }
    public static Singleton getInstance(){
        return instance;
    }
    public String demoMethod(){
        return "demo";
    }
    public class SingletonDemo{
        public void main(String[] args){
            Singleton tmp = Singleton.getInstance();
            tmp.demoMethod();
        }
    }
}
