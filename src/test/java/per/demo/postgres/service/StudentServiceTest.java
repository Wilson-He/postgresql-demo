package per.demo.postgres.service;

import com.baomidou.mybatisplus.toolkit.SystemClock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import per.demo.postgres.PostgresqlApplication;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * StudentServiceTest
 *
 * @author Wilson
 * @date 18-5-9
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(classes = PostgresqlApplication.class)
class StudentServiceTest {
    @Autowired
    private WebApplicationContext context;
    @Resource
    private StudentService studentService;

    @Autowired
    private MockMvc mvc;

    static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceTest.class);

    @Test
    @DisplayName("查询所有")
    void selectAllStudent() {
        LOGGER.info("======={}-------","selectAllStudent测试");
        Assertions.assertTrue(studentService.selectList(null).size() > 0);
        LOGGER.info("=======selectAllStudent end-------");
    }

    @Test
    void test() {
        Long accessTime = 1527662662298L;
        accessTime = accessTime == null ? SystemClock.now() / 1000 : accessTime;
        if (String.valueOf(accessTime).length() == 13) {
            accessTime = accessTime / 1000;
        }
        System.out.println("accessTime:" + accessTime);
    }

    @Test
    void checkMock() {
        assertTrue(mvc != null);
    }
}
