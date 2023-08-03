package com.example.springbootjpa.dao;

import com.example.springbootjpa.model.dto.UserDTO;
import com.example.springbootjpa.model.po.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 测试连表查询
 * 因为测试后没有删除数据，所以每个方法需要分别测试
 */
@SpringBootTest
public class PersonRepositoryTest2 {
    @Autowired
    private PersonRepository personRepository;

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void find_person_age_older_than_18() {
        List<Person> personList = personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_get_user_info() {
        Optional<UserDTO> userInformation = personRepository.getUserInformation(1L);
        System.out.println(userInformation.get().toString());
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_get_user_info_list() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC, "age");
        Page<UserDTO> userInformationList = personRepository.getUserInformationList(pageRequest);
        //查询结果总数
        System.out.println(userInformationList.getTotalElements());// 6
        //按照当前分页大小，总页数
        System.out.println(userInformationList.getTotalPages());// 2
        System.out.println(userInformationList.getContent());
        userInformationList.forEach(System.out::println);
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_filter_user_info() {
        List<String> personList=new ArrayList<>(Arrays.asList("person1","person2"));
        List<UserDTO> userDTOS = personRepository.filterUserInfo(personList);
        System.out.println(userDTOS);
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_filter_user_info_by_age() {
        List<UserDTO> userDTOS = personRepository.filterUserInfoByAge(19,20);
        System.out.println(userDTOS);
    }
}
