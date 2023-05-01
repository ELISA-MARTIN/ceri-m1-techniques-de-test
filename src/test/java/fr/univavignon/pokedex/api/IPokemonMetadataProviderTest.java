package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    // Vérifier que PokemonMetadata getPokemonMetadata(int index) throws PokedexException; retourne une exception si l'index n'est pas valide
    @Test
    public void testGetPokemonMetadataThrowsPokedexExceptionForInvalidIndex() throws PokedexException {
        //IPokemonMetadataProvider metadataProviderMock = Mockito.mock(PokemonMetadataProvider.class);
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        int invalidIndex = -1;
        try {
            pokemonMetadataProvider.getPokemonMetadata(133);
            fail("La méthode getPokemonMetadata aurait dû lancer une exception PokedexException");
        } catch (PokedexException e) {
            assertEquals("Index de Pokémon invalide : " + invalidIndex, e.getMessage());
        }
    }

    // Vérifie que la fonction retorune bien un PokemonMetadata
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider metadataProviderMock = Mockito.mock(PokemonMetadataProvider.class);
        PokemonMetadata expectedMetadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        Mockito.when(metadataProviderMock.getPokemonMetadata(133)).thenReturn(expectedMetadata);
        PokemonMetadata actualMetadata = metadataProviderMock.getPokemonMetadata(133);
        assertEquals(expectedMetadata, actualMetadata);
        Mockito.verify(metadataProviderMock).getPokemonMetadata(133);
    }
}
