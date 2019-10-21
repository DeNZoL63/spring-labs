package com.luxoft.springioc.lab3.model;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;

@ImportResource("classpath:/application-context.xml")
public class SimpleAppTest {

	private AbstractApplicationContext context;

	private UsualPerson expectedPerson;
	private Language expectedLanguage;

	@Before

	public void setUp() {
		context = new AnnotationConfigApplicationContext(SimpleAppTest.class);
		expectedPerson = getExpectedPerson();
		expectedLanguage = getExpectedLanguage();
	}

	@Test
	public void testInitPerson() {
//		UsualPerson person = (UsualPerson) context.getBean("person");
//		FYI: Another way to achieve the bean
		UsualPerson person = context.getBean(UsualPerson.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	@Test
	public void testInitLanguage() {
		Language language = context.getBean(Language.class);
		assertEquals(expectedLanguage, language);
		System.out.println(language);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("Ivan Ivanov");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}

	private Language getExpectedLanguage() {
		Language lang = new Language();
		lang.setId(1L);
		lang.setName("English");
		lang.setCode("en");

		return lang;
	}

	@After
	public void tearDown() {
		context.close();
	}
}
