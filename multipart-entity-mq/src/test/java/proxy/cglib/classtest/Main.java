package proxy.cglib.classtest;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 16:48
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new UserInterceptor(new Student("Ana")));
        Student student = (Student)enhancer.create();
        student.show();

        //Enhancer enhancer = new Enhancer();
        //enhancer.setSuperclass(User.class);
        //enhancer.setCallback(new UserInterceptor(new UserImpl()));
        //User user = (User)enhancer.create();
        //user.eatClass();





    }

}
