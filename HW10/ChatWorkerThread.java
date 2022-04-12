import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
            //System.out.println("About to add a printstream");
            CORE.changeTheClientStreams(this.ClientInput, "add");

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
        //this is what the thread does
        this.clientOutput.println("What is your name?");
        String name = clientInput.nextLine();
        CORE.broadcastMessage(name + " has joined!");
        
        String message;
        while(true)
        {
            message = clientInput.nextLine();
            int ByteFormat = clientInput.nextLine();
            String tempMessage;
            
            //Send Function on server end
            if(message.equals("/send"))
            {
                for(int i = 0; i < ByteFomrat; i++)
                {
                    tempMessage = tempMessage + tempMessage.readByte(ByteFormat);
                }
                CORE.sendFile(tempMessage, this.ClientOutput);
            }
            
            else if(message.equals("/quit"))
            {
                CORE.broadcastMessage(name + " has left the server!");
                CORE.changeTheClientStreams(this.ClientOutput, "remove");
                break;
            }
            else
            {
                CORE.broadcastMessage(message);
            }
        }
    }
}
