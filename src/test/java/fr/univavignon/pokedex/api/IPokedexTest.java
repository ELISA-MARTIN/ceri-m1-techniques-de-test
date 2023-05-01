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
    @Test
    public void testPokedexSize() {
        IPokedex pokedex = Mockito.mock(Pokedex.class);
        Mockito.when(pokedex.size()).thenReturn(0);
        assertEquals(pokedex.size(), 0);
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);

        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        assertEquals(pokemon1.getIndex(), 0);
        assertEquals(pokemon1.getName(), "Bulbizarre");
        assertEquals(pokemon1.getAttack(), 126);
        assertEquals(pokemon1.getDefense(), 126);
        assertEquals(pokemon1.getStamina(), 90);
        assertEquals(pokemon1.getCp(), 613);
        assertEquals(pokemon1.getAttack(), 64);
        assertEquals(pokemon1.getDust(), 4000);
        assertEquals(pokemon1.getCandy(), 4);
        //assertEquals(pokemon1.getIv(), 56);
        assertEquals(pokedex.size(), 2);
    }

    @Test
    public void testIsBetween0And150() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        //Pokemon pokemon2 = new Pokemon(155, "Bulb", 126, 126, 90, 613, 64, 4000, 4, 56 );

        assertTrue("L'index est bien compris entre 0 et 150", pokemon1.getIndex() >= 0 && pokemon1.getIndex() <= 150);
        //assertTrue("L'index devrait être compris entre 0 et 150", pokemon2.getIndex() < 0 || pokemon2.getIndex() > 150);
    }

    @Test
    public void testGetPokemon() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        try {
            Pokemon pokemon = pokedex.getPokemon(133);
            assertTrue("Le bon pokemon est retourné", pokemon == pokemon2);
        }
        catch  (PokedexException e) {
            throw new RuntimeException(e);
        }
    }

    // Vérifier qu'on retourne bien une liste
    @Test
    public void testGetPokemons() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);

        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemon1);
        expectedPokemons.add(pokemon2);

        Mockito.when(pokedex.getPokemons()).thenReturn(expectedPokemons);

        Mockito.verify(pokedex).getPokemons();
        assertEquals(pokedex.getPokemons(), expectedPokemons);
    }

    @Test
    public void testGetPokemonsComparator() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        pokedex.addPokemon(pokemon2);
        pokedex.addPokemon(pokemon1);

        List<Pokemon> expectedPokemons = new ArrayList<>();
        expectedPokemons.add(pokemon1);
        expectedPokemons.add(pokemon2);

        // Définition du comparateur
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);

        // Appel de la fonction à tester
        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(expectedPokemons);

        assertEquals(pokedex.getPokemons(comparator), expectedPokemons);
        // Vérification des appels aux méthodes sur les mocks
        Mockito.verify(pokedex, Mockito.times(1)).getPokemons(comparator);
    }

    @Test
    public void testGetPokemonMetadata(){
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        PokemonMetadata pokemonMetadata;
        try {
            pokemonMetadata = pokedex.getPokemonMetadata(pokemon.getIndex());
            assertEquals(pokemonMetadata.getIndex(), pokemon.getIndex());
            assertEquals(pokemonMetadata.getName(), pokemon.getName());
            assertEquals(pokemonMetadata.getAttack(), pokemon.getAttack());
            assertEquals(pokemonMetadata.getStamina(), pokemon.getStamina());
            assertEquals(pokemonMetadata.getDefense(), pokemon.getDefense());
        }
        catch  (PokedexException e) {
            fail("L'exception ne devrait pas être lancée" + e.getMessage());
        }
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        try {
            Pokemon pokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);
            assertEquals(pokemon.getIndex(), 0);
            assertEquals(pokemon.getCp(), 613);
            assertEquals(pokemon.getHp(), 64);
            assertEquals(pokemon.getDust(), 4000);
            assertEquals(pokemon.getCandy(), 4);
        } catch (PokedexException e) {
            throw new RuntimeException(e);
        }
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

}
