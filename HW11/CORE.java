import java.io.DataOutputStream;
import java.util.ArrayList;
import java.io.PrintStream;

public class CORE 
{
    private static ArrayList<PrintStream> theClientIPs= new ArrayList<PrintStream>();

    public synchronized static void addDOS(PrintStream dos)
    {
        CORE.theClientIPs.add(dos);
    }

    //Broadcasting method, that doesn't work, but it is the best I could do given the circumstances. 
    public static void broadcastMessage()
    {
        System.out.println("About to broadcast....");
        for (int i = 0; i < (theClientIPs.length(); i++)
        {
            System.out.println(theClientIPs[i]);
        }
    }
}
