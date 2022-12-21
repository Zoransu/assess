import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    static ArrayList<Stud>list1 =new ArrayList<>();
    static ArrayList<All>list2 = new ArrayList<>();
    public static void save() throws IOException {
        try{
            ObjectOutputStream ooq = new ObjectOutputStream(new FileOutputStream(new File("").getCanonicalPath()+"/Stud.txt"));
            ooq.writeObject((Object) list1);
            ooq.flush();
            ooq.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }//序列化
    public static void input() throws IOException, ClassNotFoundException {
        try {
            File file = new File(new File("").getCanonicalPath()+"/Stud.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            if(file.length()==0){
                save();
            }
            ObjectInputStream oiq = new ObjectInputStream(new FileInputStream(new File("").getCanonicalPath()+"/Stud.txt"));
            Object obj = oiq.readObject();
            ArrayList<Stud> list = (ArrayList<Stud>)obj;
            oiq.close();
            list1 = list;
        }catch (IOException e){
            e.printStackTrace();
        }

    }//反序列化
    public static void start() throws IOException, ClassNotFoundException, IllegalAccessException {
        input();
    Scanner se = new Scanner(System.in);
        System.out.println("-------欢迎来到学生成绩管理系统-------");
    bbc:while (true){
        System.out.println("请选择操作："+"\n"+"1.添加学生"+"\n"+"2.查询学生基本信息"+"\n"+"3.修改学生基本信息"+"\n"+
                "4.查看学生成绩"+"\n"+"5.修改学生成绩"+"\n"+"6.删除学生"+"\n"+"7.保存数据"+"\n"+"8.退出");
        try {
            String choose = se.next();
            if(!(choose.equals("1")||choose.equals("3")||choose.equals("2")||choose.equals("4")||choose.equals("5")||choose.equals("6")||choose.equals("7")||choose.equals("8"))){
                throw new RuntimeException();
            }
            switch (choose){
                case "1"->add(list1);
                case "2"->inquire(list1);
                case "3"-> revise(list1);
                case "4"-> viewGrades(list1);
                case "5"-> editGrades(list1);
                case "6"-> removeStud(list1);
                case "7"-> save();
                case "8"-> {System.out.println("退出");
                    break bbc;}
            }
        } catch (RuntimeException e) {
            System.err.println("输入选项错误！请输入正确的选项：");
        }
    }
        String[] tou = new String[]{"学号","姓名","专业","高数成绩","英语成绩","c或java成绩"};
        String[] shuxing = new String[]{"id","name","profession","course1","course2","course3"};
        String path =new File("").getCanonicalPath()+"/Stud.csv";
        getlist(list1,list2);
    exportCSV(path,tou,shuxing,list2);
}
    public static void add(ArrayList<Stud> list1){
        Stud u = new Stud();
        Scanner se = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name=se.next();
        u.setName(name);
        System.out.println("请输入学生学号：");
        xx:while (true) {
                String id = se.next();
                if(!contain(id,list1)){
                    u.setId(id);
                    break;}
                else {
                    System.out.println("学号已存在，重新输入：");
                }
            }
        professionchoose:while (true) {
            System.out.println("请输入学生专业：");
            System.out.println("1.信管"+"\n"+"2.计科"+"\n"+"3.物联网");
            try {
                String profession=se.next();
                if(!(profession.equals("1")||profession.equals("2")||profession.equals("3"))){
                    throw new RuntimeException();
                }
                switch (profession){
                    case "1"->{u.setProfession("信管");break professionchoose;}
                    case "2"->{u.setProfession("计科");break professionchoose;}
                    case "3"->{u.setProfession("物联网");break professionchoose;}
                }
            } catch (RuntimeException e) {
                System.err.println("输入选项错误！请输入正确的选项：");
                continue professionchoose;
            }
        }
        ArrayList<Course>courseList = new ArrayList<>();
        Course un = new Course();
        Course ud = new Course();
        Course uv = new Course();
        System.out.println("请输入学生相应课程的分数：");
        qq:while (true) {
            try {
                switch (u.getProfession()){
                    case "信管"->{
                        System.out.println("请输入高数成绩：");
                        String math ="高数";
                        double mathGrades = se.nextDouble();
                        un.setCourse(math);un.setCourseGrade(mathGrades);
                        System.out.println("请输入英语成绩：");
                        String English ="英语";
                        double englishGrages = se.nextDouble();
                        ud.setCourse(English);ud.setCourseGrade(englishGrages);
                        System.out.println("请输入java成绩");
                        String java ="java";
                        double javaGrades = se.nextDouble();
                        uv.setCourseGrade(javaGrades);uv.setCourse(java);
                        courseList.add(un);
                        courseList.add(ud);
                        courseList.add(uv);
                        break qq;
                    }
                    case "计科"->{
                        System.out.println("请输入高数成绩：");
                        String math ="高数";
                        double mathGrades = se.nextDouble();
                        un.setCourse(math);un.setCourseGrade(mathGrades);
                        System.out.println("请输入英语成绩：");
                        String English ="英语";
                        double englishGrages = se.nextDouble();
                        ud.setCourse(English);ud.setCourseGrade(englishGrages);
                        System.out.println("请输入c成绩");
                        String c ="c";
                        double javaGrades = se.nextDouble();
                        uv.setCourseGrade(javaGrades);uv.setCourse(c);
                        courseList.add(un);
                        courseList.add(ud);
                        courseList.add(uv);
                        break qq;
                    }
                    case "物联网"->{
                        System.out.println("请输入高数成绩：");
                        String math ="高数";
                        double mathGrades = se.nextDouble();
                        un.setCourse(math);un.setCourseGrade(mathGrades);
                        System.out.println("请输入英语成绩：");
                        String English ="英语";
                        double englishGrages = se.nextDouble();
                        ud.setCourse(English);ud.setCourseGrade(englishGrages);
                        System.out.println("请输入c成绩");
                        String c ="c";
                        double javaGrades = se.nextDouble();
                        uv.setCourseGrade(javaGrades);uv.setCourse(c);
                        courseList.add(un);
                        courseList.add(ud);
                        courseList.add(uv);
                        break qq;
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("成绩在0-100之间，请重新输入成绩！");
                continue qq;
            }
        }
        u.setCoursesList(courseList);
        list1.add(u);
    }//添加学生
    public static void inquire(ArrayList<Stud> list1){
        Scanner se = new Scanner(System.in);
        System.out.println("请输入要查询的学生学号：");
        while (true) {
            try {
                String an = se.next();
                boolean f1 = contain(an,list1);
                if(!f1){
                    throw new InputMismatchException();
                }
                if(f1){
                    for (int i = 0; i < list1.size(); i++) {
                        Stud d = list1.get(i);
                        if(an.equals(d.getId())){
                            System.out.println("学号："+d.getId()+"\n"+"姓名："+d.getName()+"\n"+"专业："+d.getProfession());
                            return;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("无此学生，请重新输入：");
            }
        }

    }//查询学生基本信息
    public static boolean contain(String id,ArrayList<Stud> list1){
        for (int i = 0; i < list1.size(); i++) {
            Stud u = list1.get(i);
            if(id.equals(u.getId())){
                return true;
            }
        }
        return false;
    }//判断学号是否存在
    public static void revise(ArrayList<Stud> list1){
        Scanner se= new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要修改的学生的学号：");
                String an = se.next();
                boolean bn = contain(an,list1);
                if(bn){
                    int a = get(list1,an);
                    System.out.println("请输入修改后的名字：");
                    String newName = se.next();
                    list1.get(a).setName(newName);
                    System.out.println("请输入修改后的学号：");
                    String newid = se.next();
                    list1.get(a).setId(newid);
                    break ;
                    }
                else {
                    System.out.println("输入的学号不存在，请重新输入：");
                    continue ;
                }
            }
        }
    public static int get(ArrayList<Stud> list1, String an){
        boolean bn = contain(an,list1);
        if(bn){
            for (int i = 0; i < list1.size(); i++) {
                Stud u = list1.get(i);
                if(an.equals(u.getId()))
                    return i;
            }
        }
        return -1;
    }//获取输入的学号的索引
    public static int getCourse(ArrayList<Course> coursesList,String course){
        boolean bn = containCourse(course,coursesList);
        if(bn){
            for (int i = 0; i < coursesList.size(); i++) {
                Course u = coursesList.get(i);
                if(course.equals(u.getCourse()))
                    return i;
            }
        }
        return -1;
    }
    public static boolean containCourse(String course,ArrayList<Course> coursesList){
        for (int i = 0; i < coursesList.size(); i++) {
            Course u = coursesList.get(i);
            if(course.equals(u.getCourse())){
                return true;
            }
        }
        return false;
    }
    public static void viewGrades(ArrayList<Stud> list1){
        Scanner se = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要查看成绩的学生学号：");
                String id = se.next();
                boolean an = contain(id,list1);
                if(an){
                    int a = get(list1,id);
                    list1.get(a).show(list1.get(a).coursesList);
                    break;
                }
                else{
                    System.out.println("学号不存在，请重新输入：");
                    continue;
                }
            }
    }//查看学生成绩
    public static void editGrades(ArrayList<Stud> list1){
        Scanner se = new Scanner(System.in);
        System.out.println("请输入需要修改成绩的学生学号：");
        while (true) {
            String id = se.next();
            boolean an = contain(id,list1);
            if(an){
                int a = get(list1,id);
                Stud u = list1.get(a);
                try {
                    for (int i = 0; i < u.coursesList.size(); i++) {
                        System.out.println("请重新输入"+u.coursesList.get(i).getCourse()+"的成绩：");
                        double gr = se.nextDouble();
                        u.coursesList.get(i).setCourseGrade(gr);
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("成绩在0-100之间，请重新输入学号并重新录入成绩");
                    continue ;
                }
            }
            else {
                System.err.println("学号不存在，请重新输入");
            }
        }
    }//修改学生成绩
    public static void removeStud(ArrayList<Stud> list1){
        Scanner se = new Scanner(System.in);
        System.out.println("请输入需要删除的学生学号：");
        try {
            String id = se.next();
            boolean an = contain(id,list1);
            if(an){
                int a = get(list1,id);
                list1.remove(a);
                System.out.println("删除成功！");
            }
            else {
                System.out.println("无该同学");
            }
        } catch (RuntimeException e) {
            System.err.println("学号应由数字组成！");
        }
    }//删除学生
    public static void exportCSV(String path,String tou[],String shuxing[],ArrayList<All> list2) throws IOException, IllegalAccessException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true), Charset.defaultCharset()));
        //写表头
        try{
            for(String stud:tou) {
                writer.write(stud);
                writer.write(",");
            }
            writer.write("\r\n");
                //写内容
                for(Object obj:list2){
                    Field []fields = obj.getClass().getDeclaredFields();
                    for(String property:shuxing){
                        for(Field field:fields){
                            field.setAccessible(true);
                            if(property.equals(field.getName())){
                                writer.write(String.valueOf(field.get(obj)));
                                writer.write(",");
                                continue;
                            }
                        }
                    }
                    writer.write("\r\n");
                }
                writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }//输出为csv
    public static void getlist(ArrayList<Stud> list1,ArrayList<All> list2){
        String[] tou = new String[]{"学号","姓名","专业","高数成绩","英语成绩","c或java成绩"};
        String[] shuxing = new String[]{"id","name","profession","course1","course2","course3"};
        for (int i = 0; i < list1.size(); i++) {
            All all = new All();
            Stud u = list1.get(i);
            all.setId(u.getId());
            String bn =u.getName();
            all.setName(u.getName());
            all.setProfession(u.getProfession());
            if(u.coursesList.size()==3){
                all.setCourse1(u.coursesList.get(0).getCourseGrade());
                all.setCourse2(u.coursesList.get(1).getCourseGrade());
                all.setCourse3(u.coursesList.get(2).getCourseGrade());
            }
            list2.add(all);
        }
    }
}
