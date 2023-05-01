package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    private Pokedex pokedex;
    private List<PokemonMetadata> pokemonMetadataList;
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

/*@Override
public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index >= pokedex.size()) {
        throw new PokedexException("Invalid index: " + index);
        }
        Pokemon pokemon = pokedex.getPokemon(index);
        PokemonMetadata pokemonMetadata = new PokemonMetadata(index, pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());
        return pokemonMetadata;
        }*/