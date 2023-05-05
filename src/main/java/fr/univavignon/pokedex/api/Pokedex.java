package fr.univavignon.pokedex.api;

import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Pokedex class implementing IPokedex interface.
 *
 * @author MARTIN Elisa
 *
 */
public class Pokedex implements IPokedex, IPokemonMetadataProvider {
    /** List of the pokemon. **/
    private ArrayList<Pokemon> pokemons;
    /** PokemonMetadataProvider. **/
    private PokemonMetadataProvider pokemonMetadataProvider;
    /** PokemonFactory. **/
    private PokemonFactory pokemonFactory;
    /** IPokedex. **/
    private IPokedex pokedex;

    /**
     * Default constructor.
     * @param iPokemonMetadataProvider IPokemonMetadataProvider iPokemonMetadataProvider.
     * @param iPokemonFactory IPokemonFactory iPokemonFactory.
     */
    public Pokedex(IPokemonMetadataProvider iPokemonMetadataProvider,
                   IPokemonFactory iPokemonFactory) {
        /**
         * List of pokemons.
         */
        pokemons = new ArrayList<>();
        this.pokemonMetadataProvider = (PokemonMetadataProvider) iPokemonMetadataProvider;
        this.pokemonFactory = (PokemonFactory) iPokemonFactory;
    }

    /**
     * setter for the pokedex.
     * @param pokedex the updated Ipokedex.
     */
    public void setPokedex(IPokedex pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return this.pokemons.size();
    }

    /**
     * Locates the pokemon identified by the given id.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (int i = 0; i < pokemons.size(); i++) {
            if (id == pokemons.get(i).getIndex()) {
                return pokemons.get(i);
            }
        }
        throw new PokedexException("Cet ID n'est pas dans la liste");
    }

    /**
     * Adds the given pokemon to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemon.getIndex() == pokemons.get(i).getIndex()) {
                return -1;
            }
        }
        this.pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        List<Pokemon> copy = new ArrayList<>(pokemons.size());
        for (Pokemon p : pokemons) {
            copy.add(p);
        }
        return copy;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given order.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(this.pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    /**
     * Retrieves and returns the metadata for the pokemon denoted by the given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Index doit être compris entre 0 et 150 or le votre est :" + index);
        }
        Pokemon pokemon = getPokemon(index);
        PokemonMetadata pokemonMetadata = new PokemonMetadata(index, pokemon.getName(), pokemon.getAttack(),
                pokemon.getDefense(), pokemon.getStamina());
        return pokemonMetadata;
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
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        return pokemon;
    }
}
