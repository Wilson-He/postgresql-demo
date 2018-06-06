package per.demo.postgres.service;

import com.baomidou.mybatisplus.service.IService;
import per.demo.common.PagingResults;
import per.demo.postgres.model.Student;

import java.util.Map;

/**
 * @author Wilson
 * @since 2018-04-17
 */
public interface StudentService extends IService<Student> {
    PagingResults<Student> pageStudent(Integer page, Integer size, Map<String, Object> param);
}
