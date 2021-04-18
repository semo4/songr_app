package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {



	}

	@Test
	void getterTest(){
		Album a1 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");
		String expected = a1.getArtist();
		assertThat("osama").isEqualTo(expected);
	}
	@Test
	void setterTest(){
		Album a1 = new Album("osama", "osama",20,200,"https://filedn.com/ltOdFv1aqz1YIFhf4gTY8D7/ingus-info/BLOGS/Photography-stocks3/stock-photography-slider.jpg");

		a1.setTitle("Blue");
		assertThat("Blue").isEqualTo(a1.getTitle());
	}

}
