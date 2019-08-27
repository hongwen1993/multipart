package com.kagura;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/27 17:47
 * @since 1.0.0
 */
public class StudentService {

    private static volatile StudentService studentService;

    private StudentService() {

    }

    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }

}
