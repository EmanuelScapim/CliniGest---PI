import React from 'react';
import { Link } from 'react-router-dom';
import css from '../components/css/Header.module.css';
import { BiMenu, BiBell, BiSolidUserCircle, BiChevronDown } from "react-icons/bi";

// Importação das imagens para o Vite/React
// import menuHamburguerIcon from '../img/menuhamburguer.svg';
import miniLogoIcon from '../assets/LogoCompleteWhite.svg';
// import sinoIcon from '../img/sino.svg';
// import pessoaIcon from '../img/pessoa.svg';
// import setaIcon from '../img/seta.svg';

export default function Header({ toggleSidebar }) {
    return (
        <div className={css.general}>
            <header id="header" className={css.header}>
                <div id="primeiraParte" className={css.primeiraParte}>
                    {/* MENU HAMBURGUER */}
                    <button
                        type="button"
                        className={css.menuHamburguer}
                        aria-expanded="false"
                        aria-controls="sidebar"
                        onClick={toggleSidebar}
                    >
                        <BiMenu></BiMenu>
                    </button>

                    {/* LOGO DA CLÍNICA */}
                    <Link to="/inicio" id="logo" className={css.logo}>
                        <img src={miniLogoIcon} alt="Logo da Clínica" />
                        <p id="nomeClinicaHeader">NOME DA CLÍNICA</p>
                    </Link>
                </div>

                <div id="segundaParte" className={css.segundaParte}>
                    {/* BOTÃO DE NOTIFICAÇÕES */}
                    <button type="button" id="botaoNotificacao" className={css.botaoNotificacao}>
                        <BiBell></BiBell>
                    </button>

                    {/* BOTÃO DE USUÁRIO */}
                    <Link to="/" id="botaoUsuario" className={css.botaoUsuario}>
                        <BiSolidUserCircle className={css.imgUsuario}></BiSolidUserCircle>
                        <div className="label">
                            <p>MAYAN.SILVEIRA</p>
                            <small>Admin</small>
                        </div>
                        <BiChevronDown className={css.botaoUsuarioSeta}></BiChevronDown>
                    </Link>
                </div>
            </header>
        </div>

    );
}