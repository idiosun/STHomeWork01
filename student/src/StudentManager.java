import java.util.ArrayList;
import java.util.Scanner;
public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array =new ArrayList<Student>();
        while(true){
            System.out.println("-------------��ӭ����ѧ������ϵͳ-------------");
            System.out.println("1 ����ѧ��");
            System.out.println("2 ɾ��ѧ��");
            System.out.println("3 �޸�ѧ��");
            System.out.println("4 �鿴����ѧ��");
            System.out.println("5 �˳�");
            System.out.println("���������ѡ��");
            Scanner sc=new Scanner(System.in);
            String line = sc.nextLine();
            switch(line)
            {
                case "1":
//                    System.out.println("����ѧ��");
                    addstudent(array);
                    break;
                case "2":
//                    System.out.println("ɾ��ѧ��");
                    remove(array);
                    break;
                case "3":
//                    System.out.println("�޸�ѧ��");
                    change(array);
                    break;
                case "4":
//                    System.out.println("�鿴����ѧ��");
                    findstudent(array);
                    break;
                case "5":
                    System.out.print("ллʹ�ã�");
                    System.exit(0);
            }
        }
        }
    public static void addstudent(ArrayList<Student> array){
        int q=0;//�˴�q��Ϊ����ı�־������������ظ�Ԫ�أ���q�Լ�
        Scanner sc = new Scanner(System.in);
        System.out.println("������ѧ��");
        String sid =sc.nextLine();
        for(int i=0;i<array.size();i++){//���Ѿ����Ӽ��ϵ�Ԫ�ؽ��жԱȣ������ͬ�������Ӧ����
            Student s= array.get(i);
            if(s.getSid().equals(sid)){//Ԫ�ص�sid������ջ�ȡ�ı������÷������жԱ�
                System.out.println("�����ѧ�����ظ���������������룡");
                q++;
                break;
            }
        }
         if(q==0){
            System.out.println("����������");
            String name =sc.nextLine();
            System.out.println("����������");
            String age =sc.nextLine();
            System.out.println("�������ס��");
            String address =sc.nextLine();
            Student s = new Student();
            s.setSid(sid);
            s.setAddress(address);
            s.setName(name);
            s.setAge(age);
            array.add(s);
            System.out.println("����ѧ���ɹ���");
        }

    }
    public static void findstudent(ArrayList<Student> array){
        if(array.size()==0)
            System.out.println("��ʱû��ѧ��������!");
        else {
            System.out.println("ѧ��\t����\t����\t��ס��");
            for(int i =0;i<array.size();i++) {
                Student s= array.get(i);
                System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"��\t"+s.getAddress());
            }
        }
    }
    public static void remove(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫɾ��ѧ����ѧ��");
        String sid = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                array.remove(i);
                System.out.println("ɾ����ѧ���ɹ���");

                break;
            } else if(i==array.size()-1)
            {
                System.out.println("û���ҵ���ѧ��������ѧ���Ƿ���ȷ��");
                remove(array);
            }
        }
    }
    public static void change (ArrayList<Student> array){

        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫ�޸�ѧ����ѧ��");
        String sid = sc.nextLine();
        for(int i=0;i<array.size();i++){
            Student s =array.get(i);
            if(s.getSid().equals(sid)){
                System.out.println("������Ҫ�޸ĵ�����");
                System.out.println("1 ѧ��");
                System.out.println("2 ����");
                System.out.println("3 ����");
                System.out.println("4 ��ס��");
                String q = sc.nextLine();
                System.out.println("�������޸ĺ����ݣ�");
                String date = sc.nextLine();
                 switch(q){
                    case "1":s.setSid(date);
                        System.out.println("�޸ĳɹ���");
                        break;
                    case "2":s.setName(date);
                        System.out.println("�޸ĳɹ���");
                        break;
                    case "3":s.setAge(date);
                        System.out.println("�޸ĳɹ���");
                        break;
                    case "4":s.setAddress(date);
                        System.out.println("�޸ĳɹ���");
                        break;                }
                break;
            }
            else if (i==array.size()-1)
            {
                System.out.println("û���ҵ���ѧ��������ѧ���Ƿ����");
                change(array);
            }
        }
    }
}