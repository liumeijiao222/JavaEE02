package example.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {
    public static void main(String[] args){
       ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
       //文件方式路径复杂，还是这种方式简单
        Homework work=(Homework) ac.getBean("homework");
        System.out.println(work.getId()+" "+work.getTitle());

        Student stu=(Student)ac.getBean("student");
        System.out.println(stu.getId()+" "+stu.getName());

        StudentHomework stuwork=(StudentHomework)ac.getBean("studenthomework");
        System.out.println(stuwork.getStudentId()+" "+stuwork.getHomeworkId()+" "+stuwork.getHomeworkTitle()+" "+stuwork.getHomeworkContent());


       //ApplicationContext context=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
       //TestBean service=context.getBean("testBean",TestBean.class);
       //System.out.println(service.toString());

    }

}
