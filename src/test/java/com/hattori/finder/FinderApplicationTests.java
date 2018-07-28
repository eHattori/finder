package com.hattori.finder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FinderApplication.class)
@ActiveProfiles(value = { "test" })
public class FinderApplicationTests {

	@Test
	public void contextLoads() {
	}

}
