package per.demo.postgres.model;

import per.demo.common.model.BaseModel;

/**
 * Desk
 *
 * @author Wilson
 * @date 18-4-12
 */
public class Desk extends BaseModel{
    private Integer id;
    private Integer studentId;
    private Integer deskNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(Integer deskNo) {
        this.deskNo = deskNo;
    }
}
