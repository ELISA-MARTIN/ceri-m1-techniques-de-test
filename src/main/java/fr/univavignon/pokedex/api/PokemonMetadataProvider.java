package fr.univavignon.pokedex.api;

import java.util.List;

/**
 *
 * PokemonMetadataProvider class implementing IPokemonMetadataProvider interface.
 *
 * @author MARTIN Elisa
 *
 */

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    /** Pokedex. **/
    private Pokedex pokedex;

    /** List of PokemonMetadata. **/
    private List<PokemonMetadata> pokemonMetadataList;

    /**
     * Constructor by default.
     */
    public PokemonMetadataProvider() {
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */


    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for (int i = 0; i < pokemonMetadataList.size(); i++) {
            if (index == pokemonMetadataList.get(i).getIndex()) {
                //PokemonMetadata pokemonMetadata = pokemonMetadataList.get(index);
                //Pokemon pokemon = pokedex.getPokemon(index);
                PokemonMetadata pokemonMetadata = new PokemonMetadata(index, pokemonMetadataList.get(i).getName(), pokemonMetadataList.get(i).getAttack(), pokemonMetadataList.get(i).getDefense(), pokemonMetadataList.get(i).getStamina());
                return pokemonMetadata;
            }
        }
        throw new PokedexException("Invalid index: " + index);
    }
}