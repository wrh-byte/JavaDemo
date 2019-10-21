public class Reflect
{
    public static void main(String[] args)
    {
       Student stu1=new Student();
       Class stuClass=stu1.getClass();
        System.out.println(stuClass.getName());



    }
}

class Student
{
    public String name;
    public int age;
    Student()
    {
        super();
    }
}
