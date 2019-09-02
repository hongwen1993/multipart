package proxy.cglib.classtest;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/9/2 16:47
 * @since 1.0.0
 */
public class Student {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void show() {
        System.err.println("I am " + name);
    }

}
