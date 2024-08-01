package com.pokewordle.pokeapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokewordle.pokeapi.model.Pokemon;
import com.pokewordle.pokeapi.repository.PokemonRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PokemonController {
    
    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon(@RequestParam(required = false) String name) {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            if (name == null)
                pokemonRepository.findAll().forEach(pokemon::add);
            else
                pokemonRepository.findByName(name).forEach(pokemon::add);
            
            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pokemon/{number}")
    public ResponseEntity<Pokemon> getPokemonByNumber(@PathVariable("number") Integer number) {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();

            pokemonRepository.findByNumber(number).forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pokemon/random")
    public ResponseEntity<Pokemon> getRandomPokemon() {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();
            Random rnd = new Random();
            int number = rnd.nextInt(9) + 1;
            
            pokemonRepository.findByNumber(number).forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon.get(0), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void savePokemonList(List<Pokemon> pokemonList) {
        for (Pokemon pokemon : pokemonList) {
            pokemonRepository.save(new Pokemon(pokemon.getNumber(), pokemon.getName(), pokemon.getImage(), pokemon.getGen(), pokemon.getType1(), pokemon.getType2(), pokemon.getHeight(), pokemon.getWeight()));
        }
    }

    @PostMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> createPokemon(@RequestBody List<Pokemon> pokemonList) {
        try {
            savePokemonList(pokemonList);
            return new ResponseEntity<>(pokemonList, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("id") Long id, @RequestBody Pokemon pokemon) {
        Optional<Pokemon> pokemonData = pokemonRepository.findById(id);

        if (pokemonData.isPresent()) {
            Pokemon _pokemon = pokemonData.get();
            _pokemon.setNumber(pokemon.getNumber());
            _pokemon.setName(pokemon.getName());
            _pokemon.setImage(pokemon.getImage());
            _pokemon.setGen(pokemon.getGen());
            _pokemon.setType1(pokemon.getType1());
            _pokemon.setType2(pokemon.getType2());
            _pokemon.setHeight(pokemon.getHeight());
            _pokemon.setWeight(pokemon.getWeight());
            return new ResponseEntity<>(pokemonRepository.save(_pokemon), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<HttpStatus> deletePokemon(@PathVariable("id") Long id) {
        try {
            pokemonRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pokemon")
    public ResponseEntity<HttpStatus> deleteAllPokemon() {
        try {
            pokemonRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
