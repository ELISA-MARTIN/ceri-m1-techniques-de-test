package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

public class IPokedexFactoryTest {

    // Vérifier que la fonction createPokedex() retourne bien une instance de type IPokedex
    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProviderMock = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(PokemonFactory.class);
        IPokedexFactory pokedexFactory  = Mockito.mock(PokedexFactory.class);

        IPokedex pokedex = Mockito.mock(IPokedex.class);
        Mockito.when(pokedexFactory.createPokedex(metadataProviderMock, pokemonFactory)).thenReturn(pokedex);

        assertNotNull(pokedex);
        assertTrue(pokedex instanceof IPokedex);
    }

}
