import java.io.FileReader;
import java.io.FileWriter;

public class Demo
{
    public static void main(String[] args)
    {
        //文件取出字符流对象
        FileReader fr=null;
        //写入到文件(输出流)
        FileWriter fw=null;

        try{
            fr=new FileReader("test.txt");
            fw=new FileWriter("src\\test.txt");
            int n=0;//实际读取的字符数
            char buffer[]=new char[1024];
            //读入内存
            while ((n=fr.read(buffer))!=-1)
            {
                fw.write(buffer,0,n);//从0到n写出
                //fw.write(buffer);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        try{
            fr.close();
            fw.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
