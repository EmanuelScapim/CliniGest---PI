import { Outlet } from 'react-router-dom';
import Sidebar from '../components/Sidebar';
import Header from '../components/header';

export default function DashboardLayout() {
  return (
    <div style={{ display: 'flex' }}>
      <Header/>
      <Sidebar />
      <div style={{ flex: 1 }}>
        {/* O Outlet renderiza a tela filha atual (Inicio, Pacientes, etc) */}
        <Outlet />
      </div>
    </div>
  );
}