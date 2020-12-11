package io.argin.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;

@Data
public class Student {
    @Id
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Integer tid;
    @Transient
    private String teacher;
}
