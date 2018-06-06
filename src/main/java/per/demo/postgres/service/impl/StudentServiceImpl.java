package per.demo.postgres.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import per.demo.common.PagingResults;
import per.demo.postgres.dao.StudentDAO;
import per.demo.postgres.model.Student;
import per.demo.postgres.service.StudentService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Wilson
 * @since 2018-04-17
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDAO, Student> implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public PagingResults<Student> pageStudent(Integer page, Integer size, Map<String, Object> param) {
        PageHelper.startPage(page, size);
        PageInfo<Student> pageInfo = new PageInfo<>(studentDAO.listByParam(param));
        return new PagingResults<>(pageInfo.getTotal(), pageInfo.getSize(), pageInfo.getPages(), pageInfo.getList());
    }
}
