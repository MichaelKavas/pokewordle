import logo from './logo.svg';
import './App.css';
import Mon from './components/Mon';
import Game from './components/Game';
import GuessForm from './components/GuessForm';

function App() {
  return (
    <div>
      <Mon id={5}></Mon>
      <Game></Game>
      <GuessForm></GuessForm>
    </div>
  );
}

export default App;
