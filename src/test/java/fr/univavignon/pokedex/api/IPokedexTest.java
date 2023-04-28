package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class IPokedexTest {

    // test pour la fonction int size()
    @Test
    public void testPokedexSize() {
        // Création d'un mock de IPokedex
        IPokedex pokedex = Mockito.mock(IPokedex.class);

        // Configuration du mock pour qu'il renvoie un nombre de Pokemons supérieur à zéro
        Mockito.when(pokedex.size()).thenReturn(-1);

        // Vérification que la méthode size() retourne un entier supérieur à zéro
        if(pokedex.size() >= 0) {
            throw new IllegalArgumentException("Le nombre de pokemon dans pokedex est forcement > 0");
        }
    }

    // Vérifier que le pokemon a bien été ajouté
    /*@Test
    public void testAddPokemon() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon = Mockito.mock(Pokemon.class);

        // Configuration du mock pour que getPokemons renvoie une liste vide
        Mockito.when(pokedex.getPokemons()).thenReturn(new ArrayList<>());
        assertEquals(0, pokedex.getPokemons().size());

        Mockito.when(pokedex.addPokemon(pokemon)).thenReturn();
        int id = pokedex.addPokemon(pokemon);
        assertEquals(1, id);
        assertEquals(1, pokedex.getPokemons().size());
    }*/

    @Test
    public void testAddPokemon() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon = Mockito.mock(Pokemon.class);

        Mockito.when(pokedex.getPokemons()).thenReturn(new ArrayList<>());

        // Vérifier que la méthode addPokemon a été appelée
        Mockito.verify(pokedex).addPokemon(pokemon);


        // Définir la réponse par défaut pour la méthode getPokemons
        List<Pokemon> pokemonList = new ArrayList<Pokemon>();
        pokemonList.add(pokemon);
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);

        // Vérifier que la liste de Pokémon retournée par la méthode getPokemons contient bien le Pokemon
        List<Pokemon> returnedList = pokedex.getPokemons();
        assertTrue(returnedList.contains(pokemon));

        // Vérifier que la méthode getPokemons retourne une liste contenant le Pokemon ajouté
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertTrue(pokemons.contains(pokemon));
    }

    // Tester que la fonction getPokemon lève bien une exception quand on met un indice de pokemon inexistant
    /*@Test
    public void testGetPokemonException() throws PokedexException {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon1 = Mockito.mock(Pokemon.class);
        Pokemon pokemon2 = Mockito.mock(Pokemon.class);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        assertEquals(pokemon1, pokedex.getPokemon(0));
        assertEquals(pokemon2, pokedex.getPokemon(1));
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(2);
        });
    }*/

    @Test
    public void testIsBetween0And150() {
        int index = 100; // le nombre à tester
        assertTrue("L'index devrait être compris entre 0 et 150", index >= 0 && index <= 150);
    }

    // Vérifier qu'on retourne bien une liste
    @Test
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

    @Test
    public void testGetPokemonsComparator() {
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Pokemon pokemon1 = Mockito.mock(Pokemon.class);
        Pokemon pokemon2 = Mockito.mock(Pokemon.class);
        Pokemon pokemon3 = Mockito.mock(Pokemon.class);

        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemon1);
        expectedPokemons.add(pokemon2);
        expectedPokemons.add(pokemon3);
        Mockito.when(pokedex.size()).thenReturn(3);

        // Définition du comparateur
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);

        // Appel de la fonction à tester
        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(expectedPokemons);
        List<Pokemon> pokemons = pokedex.getPokemons(comparator);

        // Vérification du résultat
        assertNotNull(pokemons);
        assertEquals(3, pokedex.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
        assertEquals(pokemon3, pokemons.get(2));

        // Vérification des appels aux méthodes sur les mocks
        Mockito.verify(pokedex, Mockito.times(1)).getPokemons(comparator);
        Mockito.verify(pokedex, Mockito.times(1)).size();
    }

}
