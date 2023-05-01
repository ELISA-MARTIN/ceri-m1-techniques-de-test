package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex, IPokemonMetadataProvider {

    private ArrayList<Pokemon> pokemons;
    private PokemonMetadataProvider pokemonMetadataProvider;
    private PokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider iPokemonMetadataProvider,
                   IPokemonFactory iPokemonFactory) {
        pokemons = new ArrayList<>();
        this.pokemonMetadataProvider = (PokemonMetadataProvider) iPokemonMetadataProvider;
        this.pokemonFactory = (PokemonFactory) iPokemonFactory;
    }

    @Override
    public int size() {
        return this.pokemons.size();
    }
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (int i = 0; i < pokemons.size(); i++) {
            if (id == pokemons.get(i).getIndex()) {
                return pokemons.get(i);
            }
        }
        throw new PokedexException("Cet ID n'est pas dans la liste");
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemon.getIndex() == pokemons.get(i).getIndex()) {
                return -1;
            }
            else{
                this.pokemons.add(pokemon);
                return pokemon.getIndex();
            }
        }
        this.pokemons.add(pokemon);
        return pokemon.getIndex();
    }
    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> comparator) {
        List<Pokemon> sortedPokemons = new ArrayList<>(this.pokemons);
        sortedPokemons.sort(comparator);
        return sortedPokemons;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        Pokemon pokemon = getPokemon(index);
        PokemonMetadata pokemonMetadata = new PokemonMetadata(index, pokemon.getName(), pokemon.getAttack(),
                pokemon.getDefense(), pokemon.getStamina());
        return pokemonMetadata;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        return pokemon;
    }
}
