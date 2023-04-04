package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    // Vérifier que PokemonMetadata getPokemonMetadata(int index) throws PokedexException; retourne une exception si l'index n'est pas valide
    @Test
    public void testGetPokemonMetadataThrowsPokedexExceptionForInvalidIndex() throws PokedexException {
        IPokemonMetadataProvider metadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
        int invalidIndex = -1;
        Mockito.when(metadataProviderMock.getPokemonMetadata(invalidIndex)).thenThrow(new PokedexException("Index de Pokémon invalide : " + invalidIndex));

        try {
            metadataProviderMock.getPokemonMetadata(invalidIndex);
            fail("La méthode getPokemonMetadata aurait dû lancer une exception PokedexException");
        } catch (PokedexException e) {
            assertEquals("Index de Pokémon invalide : " + invalidIndex, e.getMessage());
        }
    }

    // Vérifie que la fonction retorune bien un PokemonMetadata
    @Test
    public void testCreatePokemonMetadataProvider() {
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        assertNotNull(pokemonMetadataProvider);
        assertTrue(pokemonMetadataProvider instanceof PokemonMetadata); // Vérifie que l'objet retourné est bien une instance de PokemonMetadata
    }
}
