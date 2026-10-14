import { Routes, Route } from 'react-router-dom';
import Login from './screens/Login'
import TelaInicio from './screens/Inicio'
import './App.css'

function App() {
  return (
    <main>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/inicio" element={<TelaInicio />} />
      </Routes>
    </main>
  )
}

export default App
