package red.kalos.usersystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Data)实体类
 *
 * @author makejava
 * @since 2022-05-15 20:45:28
 */
public class Data implements Serializable {
    private static final long serialVersionUID = 613320706773725967L;
    
    private Integer id;
    
    private String name;
    
    private String password;
    
    private Integer sex;
    
    private Integer age;
    
    private Date regtime;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

}

