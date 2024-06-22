import React, { useState, useEffect } from 'react';

function Mon() {

  const [pokemon, setPokemon] = useState({});
  let id = 1;

  useEffect(() => {
    const fetchMon = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/pokemon/' + id);
        const jsonResponse = await response.json();
        setPokemon(jsonResponse);
      } catch (error) {
        console.error('Error fetching data.', error);
      }
    };

    fetchMon();
  }, []);

  // console.log(pokemon);
  
  return (
    <div class="grid justify-items-center p-6">
      <div class="flex justify-items-center items-center content-center w-1/2 p-6">
        <div class="w-1/6 bg-gray-400 h-12">Name</div>
        <div class="w-1/6 bg-gray-500 h-12">Image</div>
        <div class="w-1/6 bg-gray-400 h-12">Type 1</div>
        <div class="w-1/6 bg-gray-500 h-12">Type 2</div>
        <div class="w-1/6 bg-gray-400 h-12">Height</div>
        <div class="w-1/6 bg-gray-500 h-12">Weight</div>
      </div>
      <div class="flex w-1/2 content-center justify-items-center p-6">
        <div class="w-1/6 bg-gray-400 h-12 content-center justify-items-center justify-center">{pokemon.name}</div>
        <img class="w-1/6 bg-gray-500 h-12 object-contain" src={pokemon.image} alt=""></img>
        <div class="w-1/6 bg-gray-400 h-12">{pokemon.type1}</div>
        <div class="w-1/6 bg-gray-500 h-12">{pokemon.type2}</div>
        <div class="w-1/6 bg-gray-400 h-12">{pokemon.height}</div>
        <div class="w-1/6 bg-gray-500 h-12">{pokemon.weight}</div>
      </div>
    </div>
  );
}

export default Mon;