package package1.something.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class stuTest {
    public static void main(String[] args) {
        ArrayList<student> list = new ArrayList<student>();
        menu(list);
    }

    public static void menu(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);

        lo:while (true){
            System.out.println("-----欢迎来到学生管理系统----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
//                    System.out.println("1.添加学生");
                    addStudent(list);
                    break;
                case 2:
//                    System.out.println("2.删除学生");
                    deleteStudent(list);
                    break;
                case 3:
                    System.out.println("3.修改学生");
                    updateStudent(list);
                    break;
                case 4:
//                    System.out.println("4.查看学生");
                    queryStudent(list);
                    break;
                case 5:
                    System.out.println("欢迎下次光临");
                    break lo;
                default:
                    System.out.println("输入错误请重新输入");
                    break ;
            }
        }
    }

    public static void updateStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        int i = queryStudent(list);
        //由于不知道这个i是否为负数，所以说还是只能在这个里面进行修改的，正确的话还是要需要在当时函数中
        System.out.println("请再输入你想要修改的数据");
        System.out.println("请输入学号");
        String sid = sc.next();
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入地址");
        String from = sc.next();
        student stu = new student(sid, name, age, from);
        list.set(i, stu);
        System.out.println("修改成功");
    }

    public static void deleteStudent(ArrayList<student> list) {
        Scanner sc = new Scanner(System.in);
        int i = queryStudent(list);
        System.out.println("确定要删除吗");
        String choice = sc.next();
        if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice)){
            list.remove(i);
            System.out.println("删除成功");
        }
        else {
            System.out.println("犹豫什么呢孩子");
        }


    }

    public static int queryStudent(ArrayList<student> list) {
        //首先需要进行判断一下是否有数据，如果没有那么就报错
        int index = -1;//先给默认的索引默认为-1
        Scanner sc = new Scanner(System.in);
        student stu = new student();
        if(list.size() == 0){
            System.out.println("数据为空请先存入数据后再查询");
        }
        else{
            //提示输入查询的学号
            System.out.println("请输入你要查询的学号");
            String sid = sc.next();
            for (int i = 0; i < list.size(); i++) {
                    stu = list.get(i);
                    if(sid.equalsIgnoreCase(stu.getSid())){
                        index = i;
                    }

            }
            if(index != -1){
                System.out.println("学号\t姓名\t年龄\t地址");
                System.out.println(stu.getSid()+'\t'+stu.getName()+'\t'+stu.getAge()+'\t'+stu.getFrom());
            }
            else {
                System.out.println("查询失败，未找到该学号");

            }
        }
        return index;

    }

    public static void addStudent(ArrayList<student> list){
        //进行添加学生信息的method
        Scanner sc = new Scanner(System.in);
        student stu = new student();
        //首先进行询问添加什么String sid, String name, int age, String from
        System.out.println("请添加 学号");
        //由于有int所以不能直接使用nextln了因为这个是以回车为结束依据
        String sid = sc.next();
        System.out.println("请添加 姓名");
        String name = sc.next();
        System.out.println("请添加 年龄");
        int age = sc.nextInt();
        System.out.println("请添加 地址");
        String from = sc.next();
        stu.setSid(sid);
        stu.setName(name);
        stu.setAge(age);
        stu.setFrom(from);
        list.add(stu);
    }
}
