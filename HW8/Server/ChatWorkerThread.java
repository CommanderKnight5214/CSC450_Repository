import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public final class Singleton {

    //Singleton i found
    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

public class ChatWorkerThread extends Thread
{
    private Socket theClientSocket;
    private PrintStream clientOutput;
    private Scanner clientInput;

    public ChatWorkerThread(Socket theClientSocket)
    {
        try 
        {
            System.out.println("Connection Established...");
            this.theClientSocket = theClientSocket;
            this.clientOutput = new PrintStream(this.theClientSocket.getOutputStream());    
            this.clientInput = new Scanner(this.theClientSocket.getInputStream());
        } 
        catch (Exception e) 
        {
            System.err.println("Bad things happened in thread!!!!!");
            e.printStackTrace();
        }
        
    }

    public void run()
    {
        this.clientOutput.println("What is your name?");
        String name = clientInput.nextLine();
        System.out.println("read: " + name);
        //Attempt at a implementation of this singleton.
        Singleton thread = theClientSocket.getInstance();
        this.clientOutput = new PrintStream(this.thread.getOutputStream());
        this.clientOutput.println("Your name is: " + name);
    }
}
