package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class IPokedexFactoryTest {
    /*@Test
    public void testCreateTrainerWithNullName() {
        // Crée un objet mock pour l'interface IPokemonMetadataProvider en utilisant Mockito
        IPokemonMetadataProvider metadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);

        // Crée un objet mock pour l'interface IPokemonFactory en utilisant Mockito
        IPokemonFactory pokemonFactoryMock = Mockito.mock(IPokemonFactory.class);

        // Création d'un objet simulé pour la méthode createPokedex
        IPokedex pokedexMock = Mockito.mock(IPokedex.class);

        // crée un objet mock pour l'interface IPokemonTrainerFactory en utilisant Mockito
        IPokedexFactory pokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
        // Vérifie si l'exception IllegalArgumentException est levée
        assertThrows(IllegalArgumentException.class, () -> {
            // Appelle la méthode createPokedex avec un IPokemonMetadataProvider null
            pokedexFactoryMock.createPokedex(null, pokemonFactoryMock);
        });
    }*/

    // Vérifier que la fonction createPokedex() retourne bien une instance de type IPokedex
    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactoryMock = Mockito.mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory  = Mockito.mock(IPokedexFactory.class);
        //IPokedexFactory pokedexFactory = new IPokedexFactory();
        IPokedex pokedexMock = Mockito.mock(IPokedex.class);
        Mockito.when(pokedexFactory.createPokedex(metadataProviderMock, pokemonFactoryMock)).thenReturn(pokedexMock);
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProviderMock , pokemonFactoryMock);

        assertNotNull(pokedex);
        assertTrue(pokedex instanceof IPokedex); // Vérifie que l'objet retourné est bien un Pokedex
    }

}
