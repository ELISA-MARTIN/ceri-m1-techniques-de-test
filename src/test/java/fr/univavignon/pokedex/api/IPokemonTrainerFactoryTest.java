package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainerWithMockito() {
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();
        PokedexFactory pokedexFactory = new PokedexFactory();
        PokemonTrainer pokemonTrainer = trainerFactory.createTrainer("Picatchu", Team.VALOR, pokedexFactory);

        assertEquals(pokemonTrainer.getName(), "Picatchu");
        assertEquals(pokemonTrainer.getTeam(), Team.VALOR);
        assertNotNull(pokemonTrainer.getPokedex());
    }
}




