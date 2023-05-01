package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    /*@Test
    public void testCreatePokemon() throws PokedexException {
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        Pokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        pokedex.addPokemon(pokemon);
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        pokemonFactory.setPokedex(pokedex);

        assertEquals(actualPokemon, pokemon);
        //assertNotNull(actualPokemon);
        assertTrue(actualPokemon instanceof Pokemon); // Vérifie que l'objet retourné est bien un Pokemon

        Mockito.verify(pokemonFactory).createPokemon(0, 613, 64, 4000, 4);
    }*/

    @Test
    public void testIsBetween0And150() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        assertTrue("L'index est bien compris entre 0 et 150", pokemon1.getIndex() >= 0 && pokemon1.getIndex() <= 150);
    }

    @Test
    public void attacksTestIsBetween0And150() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        assertTrue("L'attaque est bien compris entre 0 et 150", pokemon1.getAttack() >= 0 && pokemon1.getAttack() <= 150);

    }

    @Test
    public void defenseTestIsBetween0And150() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        assertTrue("La défense est bien compris entre 0 et 150", pokemon1.getDefense() >= 0 && pokemon1.getDefense() <= 150);
    }

    @Test
    public void staminaTestIsBetween0And150() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56 );
        assertTrue("Stamina est bien compris entre 0 et 150", pokemon1.getStamina() >= 0 && pokemon1.getStamina() <= 150);

    }
}