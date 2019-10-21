import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo
{
    public static void main(String[] args)
    {
        //1.读入图片到内存
        //2.写入到某个文件
        //输入流
        FileInputStream fis = null;
        //输出流
        FileOutputStream fos = null;
        try
        {
            fis = new FileInputStream("img.png");
            fos = new FileOutputStream("src\\a.png");
            byte buf[] = new byte[1024];

            //循环读取
            while (fis.read(buf) != -1)
            {
                //输出到指定文件
                fos.write(buf);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fis.close();
                fos.close();

            } catch (Exception e)
            {


            }
        }
    }
}
