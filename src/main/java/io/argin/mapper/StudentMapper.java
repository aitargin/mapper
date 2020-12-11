package io.argin.mapper;

import com.github.abel533.mapper.Mapper;
import io.argin.bean.Student;

import java.util.List;

public interface StudentMapper extends Mapper<Student> {
    List<Student> findAll();
}
