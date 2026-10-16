import { Routes, Route } from 'react-router-dom';
import Login from './screens/Login';
import TelaInicio from './screens/Inicio';
import DashboardLayout from './hooks/DashboardLayout';

function App() {
  return (
    <Routes>
      {/* Tela de Login sem Header/Sidebar */}
      <Route path="/" element={<Login />} />

      {/* Tela com Layout completo */}
      <Route element={<DashboardLayout />}>
        <Route path="/inicio" element={<TelaInicio />} />
        {/* Futuras telas como /pacientes entrarão aqui */}
      </Route>
    </Routes>
  );
}

export default App;