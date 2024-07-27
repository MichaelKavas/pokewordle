import useGetRandom from '../hooks/useGetRandom';

function Game() {
  //const [pokemon, setPokemon] = useState({});

  //setPokemon(useGetRandom());

  const pokemon = useGetRandom();

  console.log(pokemon.name);

  return (
    <div>{pokemon.name}</div>
  );
}

export default Game;