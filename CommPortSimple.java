package AA.IO;
//355
import java.io.*;
import java.util.Enumeration;

public class CommPortSimple {
    private static final String HELLO = "Hello?";

    public static final int TIMEOUTSECONDS =30;
    public static final int BAUD = 19200;
    protected BufferedReader is;
    protected PrintStream os;
    CommPortIdentifier thePortID;
    ComPort thePort;

    public static void main(String[] argv)throws IOException{
        if (argv.length !=1){
            System.err.println("Usage:CommPortSimple deviceName");
            System.exit(1);
        }
        new CommPortSimple(String devName) throw IOException{
            @SuppressWarnings("unchecked")
            Enumeration<CommPortIdentifier>PList =
                    CommPortIdentifier.getPortIdentifiers();
            CommPortIdentifier cpi = null;
            boolean atLeasOneSerialPresent = false;
            while (pList.hasMoreElements()){
                CommPortIdentifier c=pList.nextElement();
                if (c.getPortType()!=CommPortIdentifier.PORT_SERIAL){
                    System.err.println("Not a serial port:"+c.getName());
                    continue;
                }
                if (devName.equals(c.getName())){
                    cpi = c;
                    break;
                }
                atLeasOneSerialPresent = true;
                System.out.println("Not a serial port:"+c.getName());
            }
            if (cpi == null){
                System.err.println("Did not find serial port"+devName+"`");
                if (atLeasOneSerialPresent)
            System.err.println("Try again with one of the listed names");
                else
                    System.err.println("In fact, I didn't see ANY serial ports !");
                System.exit(1);
            }
            thePort = cpi.open("JavaCook DataComm",TIMEOUTSECONDS*10000);
            SerialPort myPort = (SerialPort) thePort;

            myPort.setSerialPortParams(BAUD, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

            is = new BufferedReader(new InputStreamReader(thePort.getInputStream()));
            os = new PrintStream(thePort.getOutputStream(),true);
        }
        protect void holdConversation()throw IOException{
            System.out.println("Ready to read and write port.");

            os.println(HELLO);
            String response = is.readLine();

            System.out.printf("I said %s , and the other end replied %s%n",HELLO,response);

            if (is != null)
                is.close();
            if (os !=null)
                os.close();
        }
    }
}
