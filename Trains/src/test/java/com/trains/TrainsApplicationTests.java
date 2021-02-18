package com.trains;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.trains.services.ITrainsService;

@SpringBootTest
class TrainsApplicationTests {

	@Autowired
	private ITrainsService trainsService;

	private static ArrayList<String> routes;

	@BeforeAll
	public static void setUp() {
		routes = new ArrayList<String>();

		routes.add("A-B-C");
		routes.add("A-D");
		routes.add("A-D-C");
		routes.add("A-E-B-C-D");
		routes.add("A-E-D");
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testDistance() {
		try {
			assertThat(this.trainsService.getDistance(routes.get(0))).isEqualTo("9");
			assertThat(this.trainsService.getDistance(routes.get(1))).isEqualTo("5");
			assertThat(this.trainsService.getDistance(routes.get(2))).isEqualTo("13");
			assertThat(this.trainsService.getDistance(routes.get(3))).isEqualTo("22");
			
			this.trainsService.getDistance(routes.get(4));
		} catch (Exception ex) {
			assertThat(ex.getMessage()).isEqualTo("No such route");
		}
	}

}
