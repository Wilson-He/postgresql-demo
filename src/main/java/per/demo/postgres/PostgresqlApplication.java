package per.demo.postgres;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import per.demo.common.PagingResults;
import per.demo.postgres.model.Student;
import per.demo.postgres.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * PostgresqlApplication
 *
 * @author Wilson
 * @date 18-4-12
 */
@RestController
@Api("controller-test")
@SpringBootApplication
public class PostgresqlApplication {

    @Resource
    private StudentService studentService;

    @GetMapping("/list/student")
    public List<Student> list() {
        return studentService.selectList(null);
    }

    @GetMapping("/page/student/mono")
    @ApiOperation("分页查询")
    public Mono<PagingResults<Student>> pageMono(@RequestParam Integer page,
                                                 @RequestParam Integer size) {
        return Mono.just(studentService.pageStudent(page, size, null));
    }

    @GetMapping("/page/student/flux")
    @ApiOperation("分页查询")
    public Mono<ServerResponse> pageFlux(@RequestParam Integer page,
                                         @RequestParam Integer size) {
        return ServerResponse.ok()
                .body(Flux.just(studentService.pageStudent(page, size, null)), PagingResults.class)
                ;

    }

    @GetMapping("/page/student")
    @ApiOperation("分页查询")
    public PagingResults<Student> page(@RequestParam Integer page,
                                       @RequestParam Integer size) {
        return studentService.pageStudent(page, size, null);
    }

    @GetMapping("/mono/test")
    @ApiOperation("分页查询")
    public Mono<Object> mono(@RequestParam Integer size) {
        return Mono.justOrEmpty(null);
    }

    @GetMapping("/flux/test")
    @ApiOperation("分页查询")
    public Mono<ServerResponse> flux(@RequestParam Integer size) {
        return ServerResponse.ok()
                .body(Mono.just(1), Integer.class);
    }

    @PostMapping("/add")
    public Student add(@RequestParam Integer id, String name) {
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
