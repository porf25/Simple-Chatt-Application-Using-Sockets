package TCPclient;

import java.io.*;
import java.net.*;

public class UDPincomingMessages extends Thread {
    DatagramSocket serverSocket;
    byte[] receiveDataChat;
    byte[] sendDataChat;
    String displayMessage;
    NewGui window;

    public UDPincomingMessages() throws Exception {
        this.serverSocket = new DatagramSocket(9873);        
    }
    
    public void run() {
        
        window = new NewGui();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        
        while(true)
        {
            byte[] receiveDataChat = new byte[1024];
            byte[] sendDataChat = new byte[1024];
            System.out.println("Ready to receive from the server");
            try{
                DatagramPacket receivePacketChat
                            = new DatagramPacket(receiveDataChat, receiveDataChat.length);
                    serverSocket.receive(receivePacketChat);
                    String sentenceChat = new String(receivePacketChat.getData());
                    InetAddress IPAddressChat = receivePacketChat.getAddress();
                    int port = receivePacketChat.getPort();
                    System.out.println("Someone sent: " + sentenceChat);
                    displayMessage = new String(sentenceChat);
                    window.ShowChatText(displayMessage);
                    String capSentence = sentenceChat.toUpperCase();
                    sendDataChat = capSentence.getBytes();
                    DatagramPacket sendPacketChat = new DatagramPacket(
                            sendDataChat, sendDataChat.length, IPAddressChat, port);
                    serverSocket.send(sendPacketChat);
                    sentenceChat = "";
                    capSentence = "";
                    //displayMessage = "";
            } 
            catch (Exception e){
                System.out.println("Error from incoming : " + e.toString());
            }
        }       
        
    }   
    
}
