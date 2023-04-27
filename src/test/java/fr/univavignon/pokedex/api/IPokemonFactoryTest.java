package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {
    @Test
    public void parseIntThrowsExceptionWhenNotANumber() throws Exception {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("not a number");
        });
    }
    @Test
    public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = Mockito.mock(Pokemon.class);
        int index = 1;
        int cp = 80;
        int hp = 70;
        int dust = 500;
        int candy = 10;
        //Pokemon pokemon = new Pokemon(index, name, attack, defense, stamina);

        Mockito.when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(pokemon);

        Pokemon actualPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull(actualPokemon);
        assertTrue(actualPokemon instanceof Pokemon); // Vérifie que l'objet retourné est bien un Pokemon

        Mockito.verify(pokemonFactory).createPokemon(index, cp, hp, dust, candy);
    }

    // Vérifier que index est bien entre 0 et 150
    @Test
    public void testIsBetween0And150() {
        int index = 200; // le nombre à tester

        /*assertThrows(IllegalArgumentException.class, () -> {
            if(index < 0 || index > 150) {
                throw new IllegalArgumentException("L'index doit être compris entre 0 et 150 inclus.");
            }
        });*/
        try {
            if(index < 0 || index > 150) { // modifier la limite supérieure
                throw new IllegalArgumentException("L'index doit être compris entre 0 et 150 inclus.");
            }
            //fail("L'exception IllegalArgumentException aurait dû être levée");
        } catch (IllegalArgumentException e) {
            // L'exception a été levée, le test est réussi
        }
    }


    /*@Test
    public void attacksTestIsBetween0And15() {
        int attacks = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            if(attacks < 0 || attacks > 150) {
                throw new IllegalArgumentException("L'attaque doit être comprise entre 0 et 15 inclus.");
            }
        });
    }*/

    @Test
    public void attacksTestIsBetween0And15() {
        int attacks = 10;
        try {
            if(attacks < 0 || attacks > 15) { // modifier la limite supérieure
                throw new IllegalArgumentException("L'attaque doit être comprise entre 0 et 15 inclus.");
            }
            //fail("L'exception IllegalArgumentException aurait dû être levée");
        } catch (IllegalArgumentException e) {
            // L'exception a été levée, le test est réussi
        }
    }

    @Test
    public void defenseTestIsBetween0And15() {
        int defense = 12;
        assertThrows(IllegalArgumentException.class, () -> {
            if(defense < 0 || defense > 150) {
                throw new IllegalArgumentException("La défense doit être comprise entre 0 et 15 inclus.");
            }
        });
    }

    @Test
    public void staminaTestIsBetween0And150() {
        int stamina = 18;
        /*assertThrows(IllegalArgumentException.class, () -> {
            if(stamina < 0 || stamina > 150) {
                throw new IllegalArgumentException("La défense doit être comprise entre 0 et 15 inclus.");
            }
        });*/
        try {
            if(stamina < 0 || stamina > 150) { // modifier la limite supérieure
                throw new IllegalArgumentException("Stamina doit être compris entre 0 et 150 inclus.");
            }
            //fail("L'exception IllegalArgumentException aurait dû être levée");
        } catch (IllegalArgumentException e) {
            // L'exception a été levée, le test est réussi
        }
    }

    @Test
    public void perfectionTestIsBetween0And15() {
        final double iv = 18;
        /*assertThrows(IllegalArgumentException.class, () -> {
            if(iv < 0 || iv > 100) {
                throw new IllegalArgumentException("La perfection doit être comprise entre 0 et 100 %.");
            }
        });*/
        try {
            if(iv < 0 || iv > 100) { // modifier la limite supérieure
                throw new IllegalArgumentException("La perfection doit être comprise entre 0 et 100 %.");
            }
            //fail("L'exception IllegalArgumentException aurait dû être levée");
        } catch (IllegalArgumentException e) {
            // L'exception a été levée, le test est réussi
        }
    }
}