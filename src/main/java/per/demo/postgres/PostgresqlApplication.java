package per.demo.postgres;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.demo.postgres.model.Student;
import per.demo.postgres.service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * PostgresqlApplication
 *
 * @author Wilson
 * @date 18-4-12
 */
@ComponentScan
@SpringBootApplication
@RestController
public class PostgresqlApplication {

    @Resource
    private StudentService studentService;

    @GetMapping("/list/student")
    public List<Student> list(){
        return studentService.selectList(null);

    }

   @PostMapping("/add")
    public Student add(@RequestParam Integer id,String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(RandomUtils.nextInt(40));
        studentService.insert(student);
        return student;

    }

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlApplication.class);
    }
}
