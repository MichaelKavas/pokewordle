import Mon from "./Mon";
import { useState } from "react";

export default function GuessForm() {
  const [guessList, setGuessList] = useState([]);
  
  function handleSubmit(e) {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData(form);

    const formJson = Object.fromEntries(formData.entries());
    const guess = formJson.guessInput;
    console.log(guess);

    // With every guess, a new value is added to the state array.
    setGuessList([...guessList, guess]);
  }

  return (
    <form method="post" onSubmit={handleSubmit}>
      <label>
        Guess a Pokemon: <input name="guessInput" defaultValue="Pikachu"></input>
      </label>
      {
        guessList.map((item) => (
          <Mon id={item}></Mon>
        ))
      }
    </form>
  );
}