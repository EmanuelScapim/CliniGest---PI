import { Routes, Route } from 'react-router-dom';
import Login from './screens/Login';
import TelaInicio from './screens/Inicio';
import DashboardLayout from './hooks/DashboardLayout';

function App() {
  return (
    <main>
      <Routes>
        {/* Tela sem Sidebar */}
        <Route path="/" element={<Login />} />

        {/* Rotas com Sidebar através do Layout */}
        <Route element={<DashboardLayout />}>
          <Route path="/inicio" element={<TelaInicio />} />
          {/* Futuras telas: <Route path="/pacientes" element={<Pacientes />} /> */}
        </Route>
      </Routes>
    </main>
  );
}

export default App;