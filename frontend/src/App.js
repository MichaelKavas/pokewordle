import logo from './logo.svg';
import './App.css';
import Mon from './components/Mon';
import Game from './components/Game';

function App() {
  return (
    <div>
      <Mon id={5}></Mon>
      <Game></Game>
    </div>
  );
}

export default App;
