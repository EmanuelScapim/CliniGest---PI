import React from 'react';
import { Link } from 'react-router-dom';
// import '../components/css/Sidebar.css';
import { BiUser, BiDetail, BiMoneyWithdraw, BiGroup, BiCalendar, BiLogoWhatsapp, BiReceipt, BiSlider } from "react-icons/bi";
import { RiMoneyDollarCircleLine } from "react-icons/ri";
import { IoSettingsOutline } from "react-icons/io5";
import css from '../components/css/Sidebar.module.css';
// Importação das imagens para o bundler (Vite)
// import personIcon from '../img/person.svg';
// import bookmarkIcon from '../img/bookmark.svg';
// import cifraoIcon from '../img/cifrao.svg';
// import calendarIcon from '../img/calendar.svg';
// import whatsapIcon from '../img/whatsap.svg';
// import configIcon from '../img/config.svg';
import Logo from '../assets/ClinigestLogo.svg';

export default function Sidebar() {
  return (
    <nav className={css.sidebar}>
      <ul>
        <li>
          <BiGroup className={css.icon}></BiGroup>
          <Link to="/pacientes">Pacientes</Link>
        </li>
        <li>
          <BiReceipt className={css.icon}></BiReceipt>
          <Link to="/consultas">Consultas</Link>
        </li>
        <li>
          <RiMoneyDollarCircleLine className={css.icon}></RiMoneyDollarCircleLine>
          <Link to="/financeiro">Financeiro</Link>
        </li>
        <li>
          <BiCalendar className={css.icon}></BiCalendar>
          <Link to="/calendario">Calendário</Link>
        </li>
        <li>
          <BiLogoWhatsapp className={css.icon}></BiLogoWhatsapp>
          <Link to="/whatsapp">WhatsApp</Link>
        </li>

        <div className={css.separator}>
          <small className={css.small}>OUTROS</small>
        </div>

        <li className={css.other}>
          <IoSettingsOutline className={css.icon}></IoSettingsOutline>
          <Link to="/cadastro">Configurações</Link>
        </li>
      </ul>

      <Link to="/" className={css.logo}>
        <img src={Logo} alt="Logo Saco" />
      </Link>
    </nav>


  );
}