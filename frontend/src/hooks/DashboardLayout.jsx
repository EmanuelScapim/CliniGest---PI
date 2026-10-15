import { Outlet } from 'react-router-dom';
import Sidebar from '../components/Sidebar';

export default function DashboardLayout() {
  return (
    <div style={{ display: 'flex' }}>
      <Sidebar />
      <div style={{ flex: 1 }}>
        {/* O Outlet renderiza a tela filha atual (Inicio, Pacientes, etc) */}
        <Outlet />
      </div>
    </div>
  );
}