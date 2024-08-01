export default function GuessForm() {
  function handleSubmit(e) {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData(form);

    const formJson = Object.fromEntries(formData.entries());
    
  }

  return (
    <form method="post" onSubmit={handleSubmit}>
      <label>
        Guess a Pokemon: <input name="guessInput" defaultValue="Pikachu"></input>
      </label>
    </form>
  );
}