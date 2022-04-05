import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class chatClient 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 2222); 
        Scanner clientInput = new Scanner(s.getInputStream());
        String question = clientInput.nextLine();
        System.out.println(question);
        Scanner localInput = new Scanner(System.in);
        PrintStream clientOutput = new PrintStream(s.getOutputStream());

        //The part below is what I implemented, in a sence I the client to communicate to the server at the very least.
        clientOutput.println(localInput.nextLine());
        clientInput = new Scanner(s.getInputStream());
        String ResponsiveText = clientInput.nextLine();
        System.out.println(ResponsiveText);
    }
}

