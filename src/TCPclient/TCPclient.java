
package TCPclient;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class TCPclient {

    public static void main(String[] args) throws Exception {
        
        UDPincomingMessages in = new UDPincomingMessages();
        in.start();
    }   
      
}
