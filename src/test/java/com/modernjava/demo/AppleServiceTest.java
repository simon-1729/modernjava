package com.modernjava.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.modernjava.demo.model.Apple;
import com.modernjava.demo.model.AppleColor;
import com.modernjava.demo.service.AppleService;
import com.modernjava.demo.service.Impl.AppleServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppleServiceImpl.class)
public class AppleServiceTest {
	private final String BY_WEIGHT = "byWeight";
	private final String BY_COLOR = "byColor";

	@Autowired
	private AppleService appleService;

	@Test
	public void testFilterApplesJ8() {
		List<Apple> resultByColor = appleService
			.filterApplesJ8(BY_COLOR);

		Boolean redAppleExists = false;

		//There should be no Red apples in list
		for( Apple apple: resultByColor) {
			if(apple.getColor().equals(AppleColor.RED)) {
				redAppleExists = true;
				break;
			}
		}
		assertThat(redAppleExists).isEqualTo(false);
	}

}
