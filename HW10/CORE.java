
import java.io.PrintStream;
import java.util.ArrayList;

public class CORE 
{
    private static ArrayList<PrintStream> theClientStreams = new ArrayList<PrintStream>();
    
    public static synchronized void changeTheClientStreams(PrintStream ps, String doWhatWithIt)
    {
        if(doWhatWithIt.equals("add"))
        {
            CORE.theClientStreams.add(ps);
        }
        else if(doWhatWithIt.equals("remove"))
        {
            CORE.theClientStreams.remove(ps);
        }
    }
    
    public static void broadcastMessage(String message)
    {
        System.out.println("About to broadcast....");
        for (PrintStream ps : CORE.theClientStreams)
        {
            ps.println(message);
            ps.println(0);
        }
    }

    //Broadcast specifically to ByteBroadcast.
    public static void BytebroadcastMessage(String message, int ByteTransfer, PrintStream SendToClient)
    {
        System.out.println("About to broadcast....");
        for (int i = 0; i < ArrayList.length(); i++)
        {
            if(ArrayList(i) == SendToClient)
            {
                ps.println(message);
                ps.println(ByteTransfer);
            }
        }
    }

    //Converts the bytes
    public static void sendFile(string byteMessage, PrintStream currentClient)
    {
        int ByteTransfer;
        string tempByteMessage;
        for(int i = 0; i < ArrayList.length(); i++)
        {
            if(currentClient != ArrayList(i))
            {
                for(int Twoi = 0; Twoi <= byteMessage; Twoi++)
                {
                    ByteTransfer = ByteTransfer + ByteTransfer.writeByte(byteMessage(i));
                }
                CORE:BytebroadcastMessage("Recieve", ByteTransfer, ArrayList(i));
            }
        }
    }
}
