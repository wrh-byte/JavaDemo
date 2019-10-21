import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
    {
        File f=new File("text.txt");
        //File没有读写的能力，所以需要InputStream流
        FileInputStream fis=null;
        try
        {
            fis=new FileInputStream(f);
            //定义一个字节数组，相当于缓存
            byte [] bytes=new byte[1024];

            int n=0;//读取到的字节数
            //循环读取
            while ((n=fis.read(bytes))!=-1)
            {
                String s=new String(bytes,0,n);
                System.out.println(s);
            }
        }
        catch (Exception e)
        {

        }
        finally
        {
            try
            {
                fis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }



    }
}
