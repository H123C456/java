package AA.NetworkClients;

import java.io.IOException;

import java.net.InetAddress;
import java.net.Socket;

public class InetAddrDemo {
    public static void mian(String[] args) throws IOException{
        String hostName = "www.drawinsys.com";
        String ipNumber = "8.8.8.8";

        System.out.println(hostName+"'s name is"+
                InetAddress.getByName(ipNumber).getHostName());
        final InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("My localhost address is "+localhost);

        String someSeeverName = "www.google.com";
        Socket theSocket = new Socket(someSeeverName, 80);
        InetAddress remote = theSocket.getInetAddress();
        System.out.printf("The InetAddress for %s is %s%n",
                someSeeverName, remote);
    }
}
