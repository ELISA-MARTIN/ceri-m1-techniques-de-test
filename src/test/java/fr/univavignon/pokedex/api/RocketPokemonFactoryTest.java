package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {
    @Test
    public void createPokemonTest(){
        RocketPokemonFactory rocketPokemonFactory = new RocketPokemonFactory();
        Pokemon pokemon = rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(pokemon.getIndex(),  0);
        assertEquals(pokemon.getCp(), 613);
        assertEquals(pokemon.getHp(), 64);
        assertEquals(pokemon.getDust(), 4000);
        assertEquals(pokemon.getCandy(), 4);

    }
}
