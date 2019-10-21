import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
    {
        //url为当前项目文件夹下
        File f = new File("ss.txt");
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(f);

            String s = "王睿涵 hello";
            //定义字节数组
            //byte[] bytes = new byte[1024];

            fos.write(s.getBytes());
        } catch (Exception e)
        {

        } finally
        {
            try
            {
                fos.close();
            }
           catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
