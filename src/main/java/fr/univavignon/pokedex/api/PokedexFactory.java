package fr.univavignon.pokedex.api;

/**
 *
 * PokedexFactory class implementing IPokedexFactory interface.
 *
 * @author MARTIN Elisa
 *
 */

public class PokedexFactory implements IPokedexFactory {

    /**
     * Creates a new pokedex instance using the given
     * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider,
                                  IPokemonFactory pokemonFactory) {
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
        return pokedex;
    }
}
