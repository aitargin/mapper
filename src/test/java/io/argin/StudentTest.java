package io.argin;

import com.github.abel533.entity.Example;
import io.argin.bean.Student;
import io.argin.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

//加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class StudentTest {

    @Autowired
    private StudentMapper mapper;

    @Test
    public void insert() {
        Student s1 = new Student();
        s1.setName("成凯");
        s1.setAge(66);
        mapper.insert(s1);

        Student s2 = new Student();
        s2.setName("张洋");
        s2.setAge(66);
        mapper.insertSelective(s2);
    }

    @Test
    public void delete() {
        Student s1 = new Student();
        s1.setName("张洋");
        mapper.delete(s1);

        mapper.deleteByPrimaryKey(8);
    }

    @Test
    public void update() {
        Student s1 = new Student();
        s1.setId(5);
        s1.setName("朱炳权");
        s1.setAge(77);
        mapper.updateByPrimaryKey(s1);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("李旭升");
        s2.setAge(22);
        mapper.updateByPrimaryKeySelective(s2);
    }

    @Test
    public void select() {
        Student s1 = new Student();
        s1.setAge(22);
        List<Student> ls1 = mapper.select(s1);

        Student s2 = mapper.selectByPrimaryKey(6);

        Student s3 = new Student();
        s3.setSex("男");
        int count = mapper.selectCount(s3);

        System.out.println("==================================================================");
        System.out.println("select()方法输出结果为");
        ls1.forEach(System.out::println);
        System.out.println("==================================================================");
        System.out.println("selectByPrimaryKey()输出结果为");
        System.out.println(s2);
        System.out.println("==================================================================");
        System.out.println("selectCount()方法输出结果为");
        System.out.println(count);
        System.out.println("==================================================================");
    }

    @Test
    public void selectOne() {
        Student s1 = new Student();
        s1.setName("朱炳权");
        mapper.selectOne(s1);
        System.out.println("selectOne()方法输出结果为");
        System.out.println(s1);
        Student s2 = new Student();
        s2.setName("张三");
        mapper.selectOne(s2);
    }

    @Test
    public void selectAll() {
        List<Student> list = mapper.select(null);
        List<Student> all = mapper.findAll();

        System.out.println("select(null)方法输出结果为");
        list.forEach(System.out::println);

        System.out.println("findAll()方法输出结果为");
        all.forEach(System.out::println);
    }

    @Test
    public void single() {
        Example example = new Example(Student.class);
        example.createCriteria()
                .andLike("name", "张%")//姓名以张开头的，也就是姓张
                .andGreaterThan("age", 20);//年龄大于20的
        mapper.selectByExample(example).forEach(System.out::println);
    }

    @Test
    public void andIsNull() {
        Example example = new Example(Student.class);
        example.createCriteria().andIsNull("sex");
        mapper.selectByExample(example);//查询sex列是空的数据
    }

    @Test
    public void andIsNotNull() {
        Example example = new Example(Student.class);
        example.createCriteria().andIsNotNull("sex");
        mapper.selectByExample(example);//查询sex列不是空的数据
    }

    @Test
    public void andEqualTo() {
        Example example = new Example(Student.class);
        example.createCriteria().andEqualTo("name", "张三");
        mapper.selectByExample(example);//查询name列是张三的数据
    }

    @Test
    public void andNotEqualTo() {
        Example example = new Example(Student.class);
        example.createCriteria().andNotEqualTo("name", "张三");
        mapper.selectByExample(example);//查询name列不是张三的数据
    }

    @Test
    public void andLike() {
        Example example = new Example(Student.class);
        example.createCriteria().andLike("name", "张%");
        mapper.selectByExample(example);//查询name列以'张'开头的数据
    }

    @Test
    public void andNotLike() {
        Example example = new Example(Student.class);
        example.createCriteria().andNotLike("name", "张%");
        mapper.selectByExample(example);//查询name列不以'张'开头的数据
    }

    @Test
    public void andGreaterThan() {
        Example example = new Example(Student.class);
        example.createCriteria().andGreaterThan("age", "20");
        mapper.selectByExample(example);//查询age列大于20的数据
    }

    @Test
    public void andGreaterThanOrEqualTo() {
        Example example = new Example(Student.class);
        example.createCriteria().andGreaterThanOrEqualTo("age", "20");
        mapper.selectByExample(example);//查询age列大于或等于20的数据
    }

    @Test
    public void andLessThan() {
        Example example = new Example(Student.class);
        example.createCriteria().andLessThan("age", "20");
        mapper.selectByExample(example);//查询age列小于20的数据
    }

    @Test
    public void andLessThanOrEqualTo() {
        Example example = new Example(Student.class);
        example.createCriteria().andLessThanOrEqualTo("age", "20");
        mapper.selectByExample(example);//查询age列小于或等于20的数据
    }

    @Test
    public void andIn() {
        Example example = new Example(Student.class);
        List<Object> list = new ArrayList<>();
        list.add(18);
        list.add(22);
        example.createCriteria().andIn("age", list);
        mapper.selectByExample(example);//查询age列是18或者22的数据
    }

    @Test
    public void andNotIn() {
        Example example = new Example(Student.class);
        List<Object> list = new ArrayList<>();
        list.add(18);
        list.add(22);
        example.createCriteria().andNotIn("age", list);
        mapper.selectByExample(example);//查询age列不是18或者22的数据
    }

    @Test
    public void andBetween() {
        Example example = new Example(Student.class);
        example.createCriteria().andBetween("age", 21, 23);
        mapper.selectByExample(example);//查询age列在21-23之间的数据(包含21和23)
    }

    @Test
    public void andNotBetween() {
        Example example = new Example(Student.class);
        example.createCriteria().andNotBetween("age", 21, 23);
        mapper.selectByExample(example);//查询age列在21-23之间的数据(不包含21和23)
    }
}
