import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class ChatServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket s = new ServerSocket(2222);
        System.out.println("Listenning for Connection...");
        Socket client = s.accept(); //blocks
        System.out.println("Connection Established...");
        //DataOutputStream dos = new DataOutputStream(client.getOuputStream());
        PrintStream clientOutput = new PrintStream(client.getOutputStream());
        Scanner clientInput = new Scanner(client.getInputStream());
        clientOutput.println("Enter Your Name...");
        String name = clientInput.nextLine();
        System.out.println("read: " + name);
    }
}