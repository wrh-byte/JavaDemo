import java.io.*;

public class Demo
{
    public static void main(String[] args)
    {
        BufferedReader br=null;
        BufferedWriter bw=null;
        try
        {
            //需要先用FileReader读取出文件
            FileReader fr=new FileReader("text.txt");
            br=new BufferedReader(fr);

            FileWriter fw=new FileWriter("src\\aa.txt");
            bw=new BufferedWriter(fw);
            //循环读取文件
            String s="";
            while ((s=br.readLine())!=null)
            {
                //System.out.println(s);
                //输出到磁盘
                bw.write(s+"\r\n");
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                bw.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
