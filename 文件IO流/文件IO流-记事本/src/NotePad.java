import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NotePad extends JFrame implements ActionListener
{
    String filepath = "";
    //需要的组件
    //文本域
    JTextArea jTextArea = null;
    //菜单
    JMenuBar jMenuBar = null;
    JMenu jMenu = null;
    JMenuItem jMenuItem1 = null;
    JMenuItem jMenuItem2 = null;
    JMenuItem jMenuItem3 = null;
    JMenuItem jMenuItem4 = null;

    public static void main(String[] args)
    {
        NotePad np = new NotePad();
    }

    public NotePad()
    {
        jTextArea = new JTextArea();
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("文件");
        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenu.setMnemonic('F');

        jMenuItem1 = new JMenuItem("打开", new ImageIcon(""));
        //注册监听
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("open");

        jMenuItem2 = new JMenuItem("保存", new ImageIcon(""));
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("save");

        jMenuItem3 = new JMenuItem("另存为", new ImageIcon(""));
        jMenuItem3.addActionListener(this);
        jMenuItem3.setActionCommand("othersave");

        jMenuItem4 = new JMenuItem("退出");
        jMenuItem4.addActionListener(this);
        jMenuItem4.setActionCommand("exit");

        this.setJMenuBar(jMenuBar);
        //MenuBar中添加Menu
        jMenuBar.add(jMenu);
        //Menu中添加MenuItem
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);
        jMenu.add(jMenuItem4);
        this.add(jTextArea);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0)
    {

        //判断是哪个菜单点击
        if (arg0.getActionCommand().equals("open"))
        {
            //文件选择组件
            JFileChooser jFileChooser = new JFileChooser();
            //设置名字
            jFileChooser.setDialogTitle("请选择文件");
            //默认方式
            jFileChooser.showOpenDialog(null);
            //显示
            jFileChooser.setVisible(true);
            //得到用户文件路径
            filepath = jFileChooser.getSelectedFile().getAbsolutePath();
            //读取文件
            FileReader fr = null;
            BufferedReader br = null;
            try
            {
                fr = new FileReader(filepath);
                br = new BufferedReader(fr);
                String s = "";
                String allCon = "";
                while ((s = br.readLine()) != null)
                {
                    allCon += s + "\r\n";
                }
                //放置到文本框
                jTextArea.setText(allCon);
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    br.close();
                    fr.close();

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if (arg0.getActionCommand().equals("save"))
        {
            FileWriter fw = null;
            BufferedWriter bw = null;
            try
            {
                fw=new FileWriter(filepath);
                bw=new BufferedWriter(fw);
                bw.write(this.jTextArea.getText());
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    bw.flush();
                    fw.close();
                    bw.close();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else if (arg0.getActionCommand().equals("othersave"))
        {
            //选择另存为位置
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("另存为...");
            //按默认方式显示
            jFileChooser.showSaveDialog(null);
            jFileChooser.setVisible(true);

            //得到保存的位置
            filepath = jFileChooser.getSelectedFile().getAbsolutePath();
            FileWriter fw = null;
            BufferedWriter bw = null;
            try
            {
                fw = new FileWriter(filepath);
                bw = new BufferedWriter(fw);
                bw.write(this.jTextArea.getText());
            } catch (Exception e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    bw.flush();//写入无数据时加入此行
                    fw.close();
                    bw.close();
                } catch (Exception e)
                {

                }
            }
        }
        else if (arg0.getActionCommand().equals("exit"))
        {
            System.exit(0);
        }
    }

}
