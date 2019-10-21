import java.io.File;
import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
    {
        //创建一个文件对象
        File file = new File("test.txt");
        System.out.println("文件路径："+file.getAbsolutePath());
        System.out.println("文件大小:"+file.length());
        System.out.println("文件可读性"+file.canRead());
        //创建文件
//        File f=new File("bb.txt");
//        if(!f.exists())
//        {
//            try
//            {
//                f.createNewFile();
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        } else
//        {
//            System.out.println("文件已存在");
//        }
        //创建文件夹
//        File f=new File("\\ff");
//        if(f.isDirectory())
//        {
//            System.out.println("isexists");
//        }
//        f.mkdir();
        //文件夹下文件名称
//        File f=new File("d:\\");
//        File lists[]=f.listFiles();
//        for(int i=0;i<lists.length;i++)
//        {
//            System.out.println("文件名:"+lists[i].getName());
//        }

    }
}
