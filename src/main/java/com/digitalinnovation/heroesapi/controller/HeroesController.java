package com.digitalinnovation.heroesapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.digitalinnovation.heroesapi.document.Heroes;
import com.digitalinnovation.heroesapi.repository.HeroesRepository;
import com.digitalinnovation.heroesapi.service.HeroesService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.digitalinnovation.heroesapi.constans.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
public class HeroesController {
	
	HeroesService heroesService;
	HeroesRepository heroesRepository;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroesController.class);
	
	public HeroesController(HeroesService heroesService,HeroesRepository heroesRepository) {
		this.heroesRepository=heroesRepository;
		this.heroesService=heroesService;
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL)
	public Flux<Heroes> getAllItems() {
		log.info("requesting the list off all heroes");
		return heroesService.findAll();
	}

	@GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
	public Mono<ResponseEntity<Heroes>> findByHero(@PathVariable String id) {
		log.info("reuqesting the hero with id", id);
		return heroesService.findByHero(id)
		    .map((item -> new ResponseEntity<>(item, HttpStatus.OK)))
		    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping(HEROES_ENDPOINT_LOCAL)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono <Heroes> createHero(@RequestBody Heroes heroes){
		log.info("a new hero was created");
		return heroesService.save(heroes);
	}
	
	@DeleteMapping(HEROES_ENDPOINT_LOCAL+"/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Mono<HttpStatus> deletebyIDHero(@PathVariable String id){
		heroesService.deleteByHero(id);
		log.info("deleting a hero with id {}",id);
		return Mono.just(HttpStatus.NO_CONTENT);
	}

}
