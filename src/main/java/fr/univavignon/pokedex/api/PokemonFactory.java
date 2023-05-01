package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    IPokedex pokedex;
    public void setPokedex(IPokedex pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(index);
        double iv = 76;
        Pokemon pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust,candy,iv);
        return pokemon;
    }

}
