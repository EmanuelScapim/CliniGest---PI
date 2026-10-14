import { useNavigate } from 'react-router-dom';
import style from './css/Inicio.module.css';

export default function Inicio() {
    const navigate = useNavigate();

    const sair = (e) => {
        e.preventDefault(); // Evita que a página recarregue

        // Redireciona para a rota da tela de login
        navigate('/');
    };

    return (
        <div className={style.body}>
            <div className={style.group}>
                <h1>TELA DE INICIO</h1>
                <button onClick={sair}>SAIR</button>
            </div>

        </div>
    )
}