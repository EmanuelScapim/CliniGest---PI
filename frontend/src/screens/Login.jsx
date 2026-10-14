import { useNavigate } from 'react-router-dom';
import style from '../screens/css/Login.module.css'
import '../components/buttons/LoginButton'
import '../components/inputs/Label'
import '../components/inputs/LoginInput'
import '../components/inputs/Checkbox'
import logoSvg from '../assets/Logo.svg';
import LoginButton from '../components/buttons/LoginButton';
import Label from '../components/inputs/Label';
import LoginInput from '../components/inputs/LoginInput';
import Checkbox from '../components/inputs/Checkbox'
import ClinigestLogo from '../assets/ClinigestLogo.svg';

export default function Login() {
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault(); // Evita que a página recarregue
    
    // Redireciona para a rota da tela de início
    navigate('/inicio');
  };

  const styles = {
    logoDiv: {
      padding: '2rem'
    },
    logoPhoto: {
      width: '4rem',
      height: '4rem'
    }
  }
  return (
    <div className={style.body}>
      <div className={style.clinigestLogo}>
        <img src={ClinigestLogo} alt="" />
      </div>
      <div className={style.loginCard}>
        <div className={style.logo} style={styles.logoDiv}>
          {/* <div id='logoPhoto' style={styles.logoPhoto}></div> */}
          <img src={logoSvg} alt="" style={styles.logoPhoto} />
          <h1>Logomarca</h1>
        </div>

        <form className={style.loginForm} onSubmit={handleSubmit}>

          <LoginInput name={'usuario'} id={'user'} placeholder={"Insira seu usuário"} label={'Usuário:'}></LoginInput>
          <LoginInput type={'password'} name={'senha'} id={'password'} placeholder={'Insira sua senha'} label={'Senha:'}></LoginInput>

          <div className={style.formOptions}>
            <div className={style.checkboxDiv} style={styles.checkboxDiv}>
              <Checkbox id={'checkbox'}></Checkbox>
              <Label htmlFor={'Checkbox'} style={styles.checkboxLabel}>Lembrar de mim</Label>
            </div>
            <a href="#" className={style.forgotPassword} style={styles.esqueciMinhaSenhaLabel}>
              Esqueci minha senha &gt;
            </a>
          </div>

          <LoginButton></LoginButton>

        </form>
      </div>

    </div>
  );
}