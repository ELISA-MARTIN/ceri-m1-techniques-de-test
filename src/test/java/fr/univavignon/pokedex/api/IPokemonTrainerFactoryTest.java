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

    /* public IPokemonTrainerFactory getMock() {
        return Mockito.mock(IPokemonTrainerFactory.class);
    } */

    // A voir si on garde + tard (pour l(instant inutile)
    @Before
    public void testRepeat(){
        IPokemonTrainerFactory trainerFactoryMock = Mockito.mock(IPokemonTrainerFactory.class);
    }

    /*@Test
    public void testIsBetween0And150() {
        int number = 100; // le nombre à tester
        assertTrue("Le nombre devrait être compris entre 0 et 150", number >= 0 && number <= 150);
    }*/

    /*@Test
    public void testCreateTrainerWithMockito() {
        // crée un objet mock pour l'interface IPokemonTrainerFactory en utilisant Mockito
        IPokemonTrainerFactory trainerFactoryMock = Mockito.mock(IPokemonTrainerFactory.class);
        // Création d'un objet simulé
        PokemonTrainer trainerMock = Mockito.mock(PokemonTrainer.class);
        // Lorsque le test appellera trainerFactory.createTrainer("Ash Ketchum", Team.VALOR), la méthode renverra trainerMock au lieu de créer une instance de PokemonTrainer normale
        Mockito.when(trainerFactoryMock.createTrainer(Mockito.anyString(), Mockito.any(Team.class)))
                .thenReturn(trainerMock);

        PokemonTrainer trainer = trainerFactoryMock.createTrainer("Ash Ketchum", Team.VALOR);
        assertEquals(trainerMock, trainer);
    }*/

    /*@Test
    public void testCreateTrainerWithNullName() {
        // crée un objet mock pour l'interface IPokemonTrainerFactory en utilisant Mockito
        IPokemonTrainerFactory trainerFactoryMock = Mockito.mock(IPokemonTrainerFactory.class);
        // Création d'un objet simulé
        PokemonTrainer trainerMock = Mockito.mock(PokemonTrainer.class);
        // vérifié si l'exception IllegalArgumentException est levée en utilisant la méthode assertThrows de JUnit
        assertThrows(IllegalArgumentException.class, () -> {
            trainerFactoryMock.createTrainer(null, Team.MYSTIC);
        });
    }*/
}




