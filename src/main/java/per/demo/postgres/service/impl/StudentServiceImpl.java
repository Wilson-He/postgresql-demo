package per.demo.postgres.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.demo.postgres.dao.StudentDAO;
import per.demo.postgres.model.Student;
import per.demo.postgres.service.StudentService;

import javax.annotation.Resource;

/**
 * @author Wilson
 * @since 2018-04-17
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDAO, Student> implements StudentService {
    @Resource
    private StudentDAO studentDAO;

}
