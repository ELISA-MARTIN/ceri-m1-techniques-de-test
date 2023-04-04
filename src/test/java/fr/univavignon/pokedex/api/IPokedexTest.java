package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class IPokedexTest {

    // Vérifier que le pokemon a bien été ajouté
    @Test
    public void testAddPokemon() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon = Mockito.mock(Pokemon.class);

        assertEquals(0, pokedex.getPokemons().size());
        int id = pokedex.addPokemon(pokemon);
        assertEquals(1, id);
        assertEquals(1, pokedex.getPokemons().size());
    }

    // Tester que la fonction getPokemon lève bien une exception quand on met un indice de pokemon inexistant
    @Test
    public void testGetPokemon() throws PokedexException {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon1 = Mockito.mock(Pokemon.class);
        Pokemon pokemon2 = Mockito.mock(Pokemon.class);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        assertEquals(pokemon1, pokedex.getPokemon(1));
        assertEquals(pokemon2, pokedex.getPokemon(2));
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(3);
        });
    }

    @Test
    public void testIsBetween0And150() {
        int number = 100; // le nombre à tester
        assertTrue("Le nombre devrait être compris entre 0 et 150", number >= 0 && number <= 150);
    }

    // Vérifier qu'on retourne bien une liste
    public void testGetPokemons() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon1 = Mockito.mock(Pokemon.class);
        Pokemon pokemon2 = Mockito.mock(Pokemon.class);
        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemon1);
        expectedPokemons.add(pokemon2);

        Mockito.when(pokedex.getPokemons()).thenReturn(expectedPokemons);

        List<Pokemon> actualPokemons = pokedex.getPokemons();

        Mockito.verify(pokedex).getPokemons();

        assertEquals(expectedPokemons, actualPokemons);
    }





}
