package m.ermolaev.springApp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        TestBean tB = context.getBean("testBean", TestBean.class);
        System.out.println(tB.getName());

        context.close();
    }
}
