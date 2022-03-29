import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class HW7
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket NewSocket = new ServerSocket(42);
        System.out.println("Waiting for a Connection...");
        Socket client = NewSocket.accept(); //blocks
        System.out.println("Connection Established.");
        PrintStream clientOutput = new PrintStream(client.getOutputStream());
        Scanner clientInput = new Scanner(client.getInputStream());
        clientOutput.println("Enter your name.");
        String name = clientInput.nextLine();
        System.out.println("Name read: " + name);
        clientOutput.println("Your name is: " + name);
        clientOutput.println("It is nice to meet you!");
    }
}