package com.digitalinnovation.heroesapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.digitalinnovation.heroesapi.repository.HeroesRepository;
import static com.digitalinnovation.heroesapi.constans.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@SpringBootTest
@AutoConfigureWebTestClient
public class HeroesApiApplicationTests {
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	HeroesRepository heroesRepository;

	@Test
	public void getOneHeroesById() {
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"1")
		.exchange()
		.expectStatus().isOk()
		.expectBody();
	}


}
