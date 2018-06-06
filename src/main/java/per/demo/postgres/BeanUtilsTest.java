package per.demo.postgres;

import per.demo.postgres.model.Student;
import per.demo.postgres.model.StudentDTO;

/**
 * BeanUtilsTest
 *
 * @author Wilson
 * @date 18-5-4
 */
public class BeanUtilsTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(11);
        student.setName("Wilson");
        student.setId(132121);
        StudentDTO studentDTO = new StudentDTO();
        String str1 = new StringBuilder()
                .append("aaa")
                .append("bbb")
                .toString();
        System.out.println(str1 == str1.intern());
//        System.out.println(ObjectUtils.copyProperties(student,new Student(),"id"));
        String java = new StringBuilder().append("ja").append("va").toString();
        System.out.println(java == java.intern());
        System.gc();
    }
}
