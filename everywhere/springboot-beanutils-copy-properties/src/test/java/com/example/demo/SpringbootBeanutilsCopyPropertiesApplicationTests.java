package com.example.demo;

import com.example.demo.entity.PersonDest;
import com.example.demo.entity.PersonSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBeanutilsCopyPropertiesApplicationTests {

	@Test
	void contextLoads() {
		PersonSource personSource = new PersonSource(1, "c", "12345", 21);
        PersonDest personDest = new PersonDest();
        BeanUtils.copyProperties(personSource, personDest);
		System.out.println("personDest = " + personDest);
	}

}
