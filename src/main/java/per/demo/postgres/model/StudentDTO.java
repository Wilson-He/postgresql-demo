package per.demo.postgres.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;

/**
 * StudentDTO
 *
 * @author Wilson
 * @date 18-5-4
 */
@ToString
public class StudentDTO {
    @ApiModelProperty("")
    private Integer studentId;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name=" + name +
                ", age=" + age +
                "}";
    }
}
