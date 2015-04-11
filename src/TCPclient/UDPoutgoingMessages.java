package TCPclient;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;


public class UDPoutgoingMessages extends Thread {
    DatagramSocket clientSocket;
    byte[] sendData;
    byte[] receiveData;   
    
        
    public UDPoutgoingMessages() throws Exception {
       
        this.clientSocket = new DatagramSocket();
    }
    
    public void run(){
        

        while (true) {
            //byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            
            
            try {
                
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
            
            

        }
    }
    
    public void sendMessage(String message){
        byte[] sendData = new byte[1024];
        
        try {
                InetAddress IPAddress = InetAddress.getByName("192.168.1.129");
                System.out.println("Me:" + message);
                sendData = message.getBytes();
                DatagramPacket sendPacket
                        = new DatagramPacket(sendData, sendData.length,
                                IPAddress, 9873);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket
                        = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence
                        = new String(receivePacket.getData());
                System.out.println("Them: " + modifiedSentence);
                //clientSocket.close();
                message = "";
                modifiedSentence = "";
            } catch (Exception e) {
                System.out.println("Error from outgoing: " + e.toString());
            }
    }
    
}
