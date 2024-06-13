package com.pokewordle.pokeapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pokewordle.pokeapi.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    
    List<Pokemon> findByNumber(Integer number);

    List<Pokemon> findByName(String name);
}
