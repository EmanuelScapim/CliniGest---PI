import React from 'react';
import { Link } from 'react-router-dom';
import '../components/css/Sidebar.css';

// Importação das imagens para o bundler (Vite)
// import personIcon from '../img/person.svg';
// import bookmarkIcon from '../img/bookmark.svg';
// import cifraoIcon from '../img/cifrao.svg';
// import calendarIcon from '../img/calendar.svg';
// import whatsapIcon from '../img/whatsap.svg';
// import configIcon from '../img/config.svg';
// import sacoLogo from '../img/saco-logo.svg';

export default function Sidebar() {
  return (
    <nav className="sidebar">
      <ul>
        <li>
          <img src='' alt="Pacientes" />
          <Link to="/pacientes">Pacientes</Link>
        </li>
        <li>
          <img src='' alt="Consultas" />
          <Link to="/consultas">Consultas</Link>
        </li>
        <li>
          <img src='' alt="Financeiro" />
          <Link to="/financeiro">Financeiro</Link>
        </li>
        <li>
          <img src='' alt="Calendário" />
          <Link to="/calendario">Calendário</Link>
        </li>
        <li>
          <img src='' alt="WhatsApp" />
          <Link to="/whatsapp">WhatsApp</Link>
        </li>

        <hr />

        <li className="other">
          <img src='' alt="Configurações" />
          <Link to="/cadastro">Configurações</Link>
        </li>
      </ul>

      <Link to="/" className="saco">
        <img src='' alt="Logo Saco" />
      </Link>
    </nav>
  );
}