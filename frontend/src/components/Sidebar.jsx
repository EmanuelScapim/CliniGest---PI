import { Link } from 'react-router-dom';
import { BiGroup, BiCalendar, BiLogoWhatsapp, BiReceipt } from "react-icons/bi";
import { RiMoneyDollarCircleLine } from "react-icons/ri";
import { IoSettingsOutline } from "react-icons/io5";
import css from '../components/css/Sidebar.module.css';
import Logo from '../assets/ClinigestLogo.svg';

export default function Sidebar({ isOpen, setIsOpen, isDesktop }) {
  // Fecha a sidebar ao clicar nos links, mas apenas em ecrãs móveis
  const handleLinkClick = () => {
    if (!isDesktop) {
      setIsOpen(false);
    }
  };

  return (
    <>
      {!isDesktop && (
        <div
          className={`${css.sidebarBackdrop} ${isOpen ? css.open : ''}`}
          onClick={() => setIsOpen(false)}
          aria-hidden="true"
        ></div>
      )}

      <div className={`${css.sidebarContainer} ${isOpen ? css.open : css.closed}`}>
        <nav className={css.sidebar} aria-hidden={!isOpen}>
          <ul>
            <li onClick={handleLinkClick}>
              <BiGroup className={css.icon} />
              <Link to="/pacientes">Pacientes</Link>
            </li>
            <li onClick={handleLinkClick}>
              <BiReceipt className={css.icon} />
              <Link to="/consultas">Consultas</Link>
            </li>
            <li onClick={handleLinkClick}>
              <RiMoneyDollarCircleLine className={css.icon} />
              <Link to="/financeiro">Financeiro</Link>
            </li>
            <li onClick={handleLinkClick}>
              <BiCalendar className={css.icon} />
              <Link to="/calendario">Calendário</Link>
            </li>
            <li onClick={handleLinkClick}>
              <BiLogoWhatsapp className={css.icon} />
              <Link to="/whatsapp">WhatsApp</Link>
            </li>

            <div className={css.separator}>
              <small className={css.small}>OUTROS</small>
            </div>

            <li className={css.other} onClick={handleLinkClick}>
              <IoSettingsOutline className={css.icon} />
              <Link to="/cadastro">Configurações</Link>
            </li>
          </ul>

          <Link to="/" className={css.logo}>
            <img src={Logo} alt="Logo Clinigest" />
          </Link>
        </nav>
      </div>
    </>
  );
}