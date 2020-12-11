package io.argin.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "s_teacher")
public class Teacher {
    @Id
    @Column(name = "t_id")
    private Integer id;
    @Column(name = "t_name")
    private String name;
}
