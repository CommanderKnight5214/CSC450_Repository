import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;

public class TrackerThread extends Thread
{
    private Socket theClient;
    private PrintStream clientOutput;

    public TrackerThread(Socket theClient)
    {
        this.theClient = theClient;
        //Added this part down
        try 
        {
            this.clientOutput = new PrintStream(this.theClient.getOutputStream());
            CORE.addDOS(this.clientOutput);
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public void run()
    {
        //Added this part as well. 
        System.out.println("Tracker Thread Started....");
        CORE.broadcastMessage();
        //get the IP address of our connect client
        //add it to our list of peers, then broadcast
        //the current list of peers to this connected client
        //as well as all previous clients
    }
}
