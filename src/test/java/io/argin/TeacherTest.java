package io.argin;

import io.argin.mapper.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TeacherTest {

    @Autowired
    private TeacherMapper mapper;

    @Test
    public void findAll() {
        mapper.select(null).forEach(System.out::println);
    }
}
