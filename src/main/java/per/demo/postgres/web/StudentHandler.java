package per.demo.postgres.web;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import per.demo.common.PagingResults;
import per.demo.postgres.model.Student;
import per.demo.postgres.service.StudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * StudentHandler
 *
 * @author Wilson
 * @date 18-5-8
 */
@Component
public class StudentHandler {
    private final StudentService studentService;

    public StudentHandler(StudentService studentService) {
        this.studentService = studentService;
    }


    public Mono<ServerResponse> listStudent(ServerRequest request) {
        List<Student> students =  studentService.selectList(null);
        Flux<Object> people = Flux.fromArray(students.toArray());
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Object.class);
    }

    public Mono<ServerResponse> pageStudent(ServerRequest request) {
        int page = Integer.valueOf(request.queryParam("page").orElse("1"));
        int size = Integer.valueOf(request.queryParam("size").orElse("2"));
        PagingResults<Student> pagingResults = studentService.pageStudent(page, size, null);
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(Mono.just(pagingResults), PagingResults.class);
    }
}
