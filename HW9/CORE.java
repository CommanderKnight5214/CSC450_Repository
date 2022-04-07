import java.io.PrintStream;
import java.util.ArrayList;

public class CORE 
{
    private static ArrayList<PrintStream> theClientStreams = new ArrayList<PrintStream>();
    
    public static synchronized void addClientThreadPrintStream(PrintStream ps)
    {
        System.out.println("adding client thread");
        CORE.theClientStreams.add(ps);
    }

    //This method will remove the client from the string.
    public static synchronized void RemoveClientThreadPrintStream(PrintStream cs)
    {
        CORE.theClientStreams.remove(cs);
    }

    public static void broadcastMessage(String message)
    {
        System.out.println("About to broadcast....");
        for (PrintStream ps : CORE.theClientStreams)
        {
            ps.println(message);
        }
    }
}
