import { useState } from 'react';
import useGetRandom from '../hooks/useGetRandom';
import Mon from './Mon';

function Game() {
  const [guess, setGuess] = useState(1);

  const pokemon = useGetRandom();

  console.log(pokemon.name);

  /* TODO: Figure out how to keep updating current Pokemon object with
  form results. Maybe use callbacks between parent and child components.
  But you need a name to write logic with, to compare with the main Pokemon.
  
  Figure out how to add components under each other dynamically.
  */

  return (
    <div>{pokemon.name}</div>
  );
}

export default Game;