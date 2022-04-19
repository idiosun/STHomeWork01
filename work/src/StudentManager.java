import java.util.ArrayList;
import java.util.Scanner;
public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array =new ArrayList<Student>();
        while(true){
            System.out.println("-------------欢迎来到学生管理系统-------------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            Scanner sc=new Scanner(System.in);
            String line = sc.nextLine();
            switch(line)
            {
                case "1":
//                    System.out.println("添加学生");
                    addstudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    remove(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    change(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findstudent(array);
                    break;
                case "5":
                    System.out.print("谢谢使用！");
                    System.exit(0);
            }
        }
    }
    public static void addstudent(ArrayList<Student> array){
        int q=0;//此处q作为检验的标志，如果发现了重复元素，则q自加
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        String sid =sc.nextLine();
        for(int i=0;i<array.size();i++){//与已经添加集合的元素进行对比，如果相同则输出相应内容
            Student s= array.get(i);
            if(s.getSid().equals(sid)){//元素的sid变量与刚获取的变量利用方法进行对比
                System.out.println("输入的学号有重复，请检查后重新输入！");
                q++;
                break;
            }
        }
        if(q==0){
            System.out.println("请输入姓名");
            String name =sc.nextLine();
            System.out.println("请输入年龄");
            String age =sc.nextLine();
            System.out.println("请输入居住地");
            String address =sc.nextLine();
            Student s = new Student();
            s.setSid(sid);
            s.setAddress(address);
            s.setName(name);
            s.setAge(age);
            array.add(s);
            System.out.println("添加学生成功！");
        }

    }
    public static void findstudent(ArrayList<Student> array){
        if(array.size()==0)
            System.out.println("暂时没有学生被添加!");
        else {
            System.out.println("学号\t姓名\t年龄\t居住地");
            for(int i =0;i<array.size();i++) {
                Student s= array.get(i);
                System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+s.getAddress());
            }
        }
    }
    public static void remove(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                array.remove(i);
                System.out.println("删除该学生成功！");

                break;
            } else if(i==array.size()-1)
            {
                System.out.println("没有找到该学生，请检查学号是否正确！");
                remove(array);
            }
        }
    }
    public static void change (ArrayList<Student> array){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号");
        String sid = sc.nextLine();
        for(int i=0;i<array.size();i++){
            Student s =array.get(i);
            if(s.getSid().equals(sid)){
                System.out.println("请输入要修改的内容");
                System.out.println("1 学号");
                System.out.println("2 姓名");
                System.out.println("3 年龄");
                System.out.println("4 居住地");
                String q = sc.nextLine();
                System.out.println("请输入修改后内容：");
                String date = sc.nextLine();
                switch(q){
                    case "1":s.setSid(date);
                        System.out.println("修改成功！");
                        break;
                    case "2":s.setName(date);
                        System.out.println("修改成功！");
                        break;
                    case "3":s.setAge(date);
                        System.out.println("修改成功！");
                        break;
                    case "4":s.setAddress(date);
                        System.out.println("修改成功！");
                        break;                }
                break;
            }
            else if (i==array.size()-1)
            {
                System.out.println("没有找到该学生，请检查学号是否错误！");
                change(array);
            }
        }
    }
}
