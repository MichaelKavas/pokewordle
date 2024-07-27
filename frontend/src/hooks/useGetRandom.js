import { useState, useEffect } from 'react';

function useGetRandom() {
  
  const [pokemon, setPokemon] = useState({});
  
  useEffect(() => {
    const fetchMon = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/pokemon/random');
        const jsonResponse = await response.json();
        setPokemon(jsonResponse);
      } catch (error) {
        console.error('Error fetching data.', error);
      }
    };

    fetchMon();
  }, []);

  return pokemon;
}

export default useGetRandom;