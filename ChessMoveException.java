package AA.thirty;
//271
public class ChessMoveException extends Exception {
    private static final long seriaVersionUID = 2165165843146165654L;

    public ChessMoveException(){
        super();
    }
    public ChessMoveException (String msg){
        super(msg);
    }
    public ChessMoveException(String msg , Exception cause){
        super(msg, cause);
    }
}
