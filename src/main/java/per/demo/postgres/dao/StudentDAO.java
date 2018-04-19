package per.demo.postgres.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import per.demo.postgres.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Wilson
 * @date 2018-04-17
 */
@Repository
public interface StudentDAO extends BaseMapper<Student> {
    List<Student> listByParam(Map<String, Object> param);
}
