package com.singtel.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.singtel.demo.ctrl.Controller;
import com.singtel.demo.data.DummyData;
import com.singtel.demo.service.AnimalServiceImpl;

@SpringBootTest
public class DemoApplicationTests {
	Controller ctrl;
	AnimalServiceImpl animalServiceImpl;
	DummyData dummyData;

	@Before
	public void setUp() {
		ctrl = new Controller();
		animalServiceImpl = new AnimalServiceImpl();
		ctrl.animalService = animalServiceImpl;
		dummyData = new DummyData();
		animalServiceImpl.dummyData = dummyData;
	}

	@Test
	public void contextLoads() {
		Assert.assertNotNull(ctrl);
	}

	@Test
	public void flyCountTest() {
		Assert.assertEquals(5, ctrl.flyCount().longValue());
	}

	@Test
	public void walkCountTest() {
		Assert.assertEquals(8, ctrl.walkCount().longValue());

	}

	@Test
	public void swimCountTest() {
		Assert.assertEquals(8, ctrl.swimCount().longValue());

	}

	@Test
	public void singCountTest() {
		Assert.assertEquals(5, ctrl.singCount().longValue());
	}

}
