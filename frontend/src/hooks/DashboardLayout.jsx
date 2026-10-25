import React, { useState, useEffect } from 'react';
import { Outlet } from 'react-router-dom';
import Sidebar from '../components/Sidebar';
import Header from '../components/Header'; // Verifique se o arquivo se chama Header.jsx com 'H' maiúsculo

export default function DashboardLayout() {
  const [isDesktop, setIsDesktop] = useState(window.innerWidth >= 1024);
  const [isSidebarOpen, setIsSidebarOpen] = useState(window.innerWidth >= 1024);

  useEffect(() => {
    const handleResize = () => {
      const desktop = window.innerWidth >= 1024;
      setIsDesktop(desktop);
      setIsSidebarOpen(desktop);
    };

    window.addEventListener("resize", handleResize);
    return () => window.removeEventListener("resize", handleResize);
  }, []);

  return (
    <div style={{ display: 'flex', flexDirection: 'column', height: '100vh', overflow: 'hidden' }}>
      
      {/* Header ocupando 100% da largura no topo */}
      <Header toggleSidebar={() => setIsSidebarOpen(!isSidebarOpen)} />

      {/* Container inferior dividindo Sidebar e Conteúdo Principal */}
      <div style={{ display: 'flex', flex: 1, position: 'relative', overflow: 'hidden' }}>
        
        <Sidebar 
          isOpen={isSidebarOpen} 
          setIsOpen={setIsSidebarOpen} 
          isDesktop={isDesktop} 
        />
        
        {/* Área onde o conteúdo da página (Outlet) renderiza */}
        <main style={{ 
          flex: 1, 
          overflowY: 'auto', 
          backgroundColor: '#f4f5f7' // Cor de fundo cinza claro visível nos prints
        }}>
          <Outlet />
        </main>

      </div>
    </div>
  );
}