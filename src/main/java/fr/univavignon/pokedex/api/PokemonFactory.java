package fr.univavignon.pokedex.api;

/**
 *
 * PokemonFactory class implementing IPokemonFactory interface.
 *
 * @author MARTIN Elisa
 *
 */

public class PokemonFactory implements IPokemonFactory {

    /** A pokedex Ipokedex. **/
    IPokedex pokedex;

    /**
     * Constructor by default.
     */
    public PokemonFactory() {
    }

    /**
     * setter for the pokedex.
     * @param pokedex the updated Ipokedex.
     */
    public void setPokedex(IPokedex pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(index);
        double iv = 76;
        if(pokemonMetadata == null) {
            throw new PokedexException("Impossible de créer le Pokemon pour l'index " + index + ". Les métadonnées sont manquantes.");
        }
        Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust,candy,iv);
        return pokemon;
    }

}
