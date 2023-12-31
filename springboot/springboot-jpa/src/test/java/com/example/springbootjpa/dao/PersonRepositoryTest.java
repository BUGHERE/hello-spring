package com.example.springbootjpa.dao;

import com.example.springbootjpa.model.po.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试查询
 */
@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    private Long id;

    /**
     * 保存person到数据库
     */
    @BeforeEach
    public void setUp() {
        assertNotNull(personRepository);
        Person person = new Person(123L, "SnailClimb", 23, 1L, 1L);
        Person savedPerson = personRepository.saveAndFlush(person);
        id = savedPerson.getId();
    }

    /**
     * 使用 JPA 自带的方法查找 person
     */
    @Test
    public void should_get_person() {
        Optional<Person> personOptional = personRepository.findById(id);
        assertTrue(personOptional.isPresent());
        assertEquals("SnailClimb", personOptional.get().getName());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());

        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());
        // 清空数据库
        personRepository.deleteAll();
    }

    /**
     * 自定义 query sql 查询语句查找 person
     */

    @Test
    public void should_get_person_use_custom_query() {
        List<Person> all = personRepository.findAll();
        System.out.println("all = " + all);
        // 查找所有字段
        Optional<Person> personOptional = personRepository.findByNameCustomQuery("SnailClimb");
        assertTrue(personOptional.isPresent());
        assertEquals(Integer.valueOf(23), personOptional.get().getAge());
        // 查找部分字段
        String personName = personRepository.findPersonNameById(id);
        assertEquals("SnailClimb", personName);
        System.out.println(id);
        // 更新
        personRepository.updatePersonNameById("UpdatedName", id);
        Optional<Person> updatedName = personRepository.findByNameCustomQuery("UpdatedName");
        assertTrue(updatedName.isPresent());
        // 清空数据库
        personRepository.deleteAll();
    }


}
