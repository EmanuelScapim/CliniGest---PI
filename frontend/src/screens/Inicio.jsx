import { useState } from 'react';
import './css/Pacientes.css';
import './css/General.css'
import { BiFilter, BiUserPlus, BiTrash, BiSelectMultiple, BiMenu, BiX } from "react-icons/bi";
import { LuChevronsDownUp } from "react-icons/lu";
import MiniBtnType1 from '../components/buttons/MiniButtonType1';
import MiniBtnType2 from '../components/buttons/MiniButtonType2';
import Searchbar from '../components/inputs/Searchbar';

export default function Inicio() {
  const [isMobileMenuOpen, setIsMobileMenuOpen] = useState(false);

  const mobileActionButtons = (
    <>
      <MiniBtnType1 type="button" className="mobile-sidebar-button">
        <BiUserPlus className="icon" />Novo
      </MiniBtnType1>
      <MiniBtnType2 type="button" className="mobile-sidebar-button">
        <BiTrash className="icon" />Excluir
      </MiniBtnType2>
      <MiniBtnType2 type="button" className="mobile-sidebar-button">
        <LuChevronsDownUp className="icon" />Ordenar
      </MiniBtnType2>
      <MiniBtnType2 type="button" className="mobile-sidebar-button">
        <BiSelectMultiple className="icon" />Selecionar
      </MiniBtnType2>
    </>
  );

  return (
    <main>
      <form action="#" id="form">

        <div className="title-header">
          <a href="#">
            <h1 className='title'>Pacientes</h1>
          </a>

          <div className="action-buttons" id="pac-action-buttons">
            <div id="searchbar-group">
              <Searchbar id="searchbar" className="searchbar" />
              <MiniBtnType2 type="button" className="mobile-action-button">
                <BiFilter className="icon" />
              </MiniBtnType2>
            </div>

            <div id="desktop-actions">
              {mobileActionButtons}
            </div>

            <div id="mobile-menu-wrapper">
              <MiniBtnType2
                id="menu-button"
                className="mobile-action-button"
                type="button"
                aria-expanded={isMobileMenuOpen}
                aria-controls="mobile-action-menu"
                onClick={() => setIsMobileMenuOpen(true)}
              >
                <BiMenu className="icon" />
              </MiniBtnType2>

              <button
                id="mobile-sidebar-backdrop"
                className={isMobileMenuOpen ? 'visible' : ''}
                type="button"
                aria-label="Fechar menu de ações"
                onClick={() => setIsMobileMenuOpen(false)}
                aria-hidden={!isMobileMenuOpen}
                tabIndex={isMobileMenuOpen ? 0 : -1}
              ></button>

              <aside
                id="mobile-sidebar"
                className={isMobileMenuOpen ? 'open' : ''}
                aria-hidden={!isMobileMenuOpen}
                inert={!isMobileMenuOpen}
              >
                <div className="mobile-sidebar-header">
                  <MiniBtnType2
                    id="mobile-sidebar-close"
                    className="mobile-sidebar-close"
                    onClick={() => setIsMobileMenuOpen(false)}
                    type="button"
                  >
                    <BiX className="icon" />
                    Fechar
                  </MiniBtnType2>
                </div>
                <div id="mobile-action-menu" className="mobile-action-menu">
                  {mobileActionButtons}
                </div>
              </aside>
            </div>
          </div>
        </div>

        {/* CARDS */}
        <div id="lista-pacientes"></div>
      </form>
    </main>
  )
}