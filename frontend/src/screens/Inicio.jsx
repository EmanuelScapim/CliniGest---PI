// import { useNavigate } from 'react-router-dom';
import './css/Pacientes.css';
import './css/General.css'
import { BiFilter, BiUserPlus, BiTrash, BiSelectMultiple, BiSearch } from "react-icons/bi";
import { LuChevronsDownUp } from "react-icons/lu";
import MiniBtnType1 from '../components/buttons/MiniButtonType1';
import MiniBtnType2 from '../components/buttons/MiniButtonType2';

export default function Inicio() {
  return (
    <main>
      <form action="#" id="form">
        {/* HEADER DA MAIN */}
        <div className="title-header">

          {/* TÍTULO DO HEADER */}
          <a href="#">
            <h1>Pacientes</h1>
          </a>

          {/* BOTÕES DE AÇÃO DO HEADER */}
          <div className="action-buttons" id="pac-action-buttons">
            <div id="searchbar-group">
              <div id="searchbar-container">
                <input
                  type="text"
                  placeholder="🔎︎  Pesquisar pacientes...  "
                  id="searchbar"
                />
              </div>

              {/* <button className="action-button" id="filtrar" type="button">
                <BiFilter className='icon'></BiFilter>
              </button> */}

              <MiniBtnType2>{<BiFilter className='icon'></BiFilter>}</MiniBtnType2>
            </div>

            <div id="desktop-actions">
              <a href="../telas/cadastro-pac.html" className="action-button" id="novoa">
                {/* <button className="action-button" id="novo" type="button">
                  <BiUserPlus className='icon'></BiUserPlus>
                  <p>Novo</p>
                </button> */}
                <MiniBtnType1>{<BiUserPlus className='icon'></BiUserPlus>}Novo</MiniBtnType1>
              </a>

              {/* <button className="action-button" id="excluir" type="button">
                <BiTrash className='icon'></BiTrash>
                <p>Excluir</p>
              </button> */}
              <MiniBtnType2>{<BiTrash className='icon'></BiTrash>}Excluir</MiniBtnType2>
              {/* <button className="action-button" id="ordenar" type="button">
                <LuChevronsDownUp className='icon'></LuChevronsDownUp>
                <p>Ordenar</p>
              </button> */}
              <MiniBtnType2>{<LuChevronsDownUp className='icon'></LuChevronsDownUp>}Ordenar</MiniBtnType2>
              {/* <button className="action-button" id="selecionar" type="button">
                <BiSelectMultiple className='icon'></BiSelectMultiple>
                <p>Selecionar</p>
              </button> */}
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