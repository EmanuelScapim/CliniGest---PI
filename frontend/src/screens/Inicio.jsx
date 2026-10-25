// import { useNavigate } from 'react-router-dom';
import './css/Pacientes.css';
import './css/General.css'
import { BiFilter, BiUserPlus, BiTrash, BiSelectMultiple, BiSearch } from "react-icons/bi";
import { LuChevronsDownUp } from "react-icons/lu";
import MiniBtnType1 from '../components/buttons/MiniButtonType1';
import MiniBtnType2 from '../components/buttons/MiniButtonType2';
import Searchbar from '../components/inputs/Searchbar'

export default function Inicio() {
  return (
    <main>
      <form action="#" id="form">

        <div className="title-header">
          <a href="#">
            <h1>Pacientes</h1>
          </a>

          <div className="action-buttons" id="pac-action-buttons">
            <div id="searchbar-group">
              <Searchbar></Searchbar>
              <MiniBtnType2>{<BiFilter className='icon'></BiFilter>}</MiniBtnType2>
            </div>

            <div id="desktop-actions">
              <a href="../telas/cadastro-pac.html" className="action-button" id="novoa">
                <MiniBtnType1>{<BiUserPlus className='icon'></BiUserPlus>}Novo</MiniBtnType1>
              </a>
              <MiniBtnType2>{<BiTrash className='icon'></BiTrash>}Excluir</MiniBtnType2>
              <MiniBtnType2>{<LuChevronsDownUp className='icon'></LuChevronsDownUp>}Ordenar</MiniBtnType2>
              <MiniBtnType2>{<BiSelectMultiple className='icon'></BiSelectMultiple>}Selecionar</MiniBtnType2>
            </div>

            <div id="mobile-menu-wrapper">
              <button
                className="action-button"
                id="menu-button"
                type="button"
                aria-expanded="false"
                aria-controls="mobile-action-menu"
              >
                <span className="menu-icon">☰</span>
              </button>

              {/* overlay que bloqueia o conteúdo ao abrir a sidebar */}
              <div
                id="mobile-sidebar-backdrop"
                className="hidden"
                aria-hidden="true"
              ></div>

              {/* sidebar direita que conterá os botões */}
              <aside
                id="mobile-sidebar"
                className="mobile-sidebar"
                aria-hidden="true"
              >
                <div className="mobile-sidebar-header">
                  <button
                    id="mobile-sidebar-close"
                    className="action-button"
                    aria-label="Fechar menu"
                    type="button"
                  >
                    <img src="../img/Vector.svg" alt="Fechar" />
                    <p>Fechar</p>
                  </button>
                </div>
                <div id="mobile-action-menu" className="mobile-action-menu"></div>
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