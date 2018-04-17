package per.demo.postgres.model;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author Wilson
 * @since 2018-04-17
 */
@TableName("student")
@ApiModel("")
public class Student implements Serializable {

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private String name;

    @ApiModelProperty("")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                "}";
    }
}
