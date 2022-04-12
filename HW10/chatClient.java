import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class chatClient 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 2222); 
        Scanner clientInput = new Scanner(s.getInputStream());
        String question = clientInput.nextLine();

        //If Bytes are Recieved
        int ByteInt = clientInput.nextLine();
        string ByteString;
        if(question.equals("Recieve"))
        {
            for(int i = 0; i < BytesSent.length(); i++)
            {
                ByteString = ByteString + ByteString.readByte(ByteInt);
            }
            FileOutputStream Output = new FileOutputStream(ByteString, "C\\Downloads");
        }

        else
        {
            System.out.println(question);
        }
        Scanner localInput = new Scanner(System.in);
        PrintStream clientOutput = new PrintStream(s.getOutputStream());
        
        int Counter = 0;
        Thread lt = new Thread() {
            public void run()
            {
                String line;
                while(true)
                {
                    line = clientInput.nextLine();
                    System.out.println(line);
                }
            }
        };

        lt.start();

        String line;
        while(true)
        {
            line = localInput.nextLine();
            int ByteTransfer;

            //SendFunction
            if(line.equals("/send"))
            {
                clientOutput.println(line);
                FileInputStream fin = new FileInputStream("D:\\FileToSend");
                for(int i = 0; i < fin.length(); i++)
                {
                    ByteTransfer = ByteTransfer + ByteTransfer.writeByte(fin(i));
                }
                clientOutput.println(ByteTransfer);
            }

            
            else if(line.equals("/quit"))
            {
                break;
            }
            else
            {
                clientOutput.println(line);
                clientOutput.println(0);
            }
        }
        System.out.println("Goodbye");
        System.exit(0);
        
    }
}