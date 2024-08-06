import React, { useState, useEffect } from 'react';

function Mon({ id = 1 }) {

  const [pokemon, setPokemon] = useState({});

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
  
  if (pokemon.name) {
    return (
      <div class="grid mx-auto w-1/2">
        <div class="flex p-2 gap-4 text-lg">
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-12 rounded-lg">Name</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-500 h-12 rounded-lg">Image</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-12 rounded-lg">Type 1</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-500 h-12 rounded-lg">Type 2</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-12 rounded-lg">Height</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-500 h-12 rounded-lg">Weight</div>
        </div>
        <div class="flex p-2 gap-4 text-lg">
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-24 rounded-lg">{pokemon.name}</div>
          <img class="flex justify-center items-center w-1/6 bg-gray-500 h-24 object-cover rounded-lg" src={pokemon.image} alt=""></img>
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-24 rounded-lg">{pokemon.type1}</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-500 h-24 rounded-lg">{pokemon.type2}</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-400 h-24 rounded-lg">{pokemon.height}</div>
          <div class="flex justify-center items-center w-1/6 bg-gray-500 h-24 rounded-lg">{pokemon.weight}</div>
        </div>
      </div>
    );
  }
  return;
}

export default Mon;