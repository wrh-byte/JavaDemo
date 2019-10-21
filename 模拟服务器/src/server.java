import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("等待链接");
        ServerSocket serverSocket = new ServerSocket(4545);
        Socket s=serverSocket.accept();
        OutputStream os=s.getOutputStream();

        BufferedReader br=new BufferedReader(new FileReader("index.html"));
        String buf="";
        while ((buf=br.readLine())!=null)
        {
            os.write(buf.getBytes());
        }
        br.close();
        os.close();
        s.close();
    }
}
