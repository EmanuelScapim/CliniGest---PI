import '../screens/css/Login.css'

export default function Login() {
  return (
    <>
      <div className="top-left-logo">
        <img src="../img/saco-logo.svg" alt="" />
      </div>

      <main className="login-container">
        <div className="login-card">
          <div className="logo-area">
            <img
              src="../img/login-logo.svg"
              alt=""
              className="css-logo-placeholder"
            />
            <h1>Logomarca</h1>
          </div>

          <form className="login-form">
            <div className="form-group">
              <label htmlFor="username">Usuário</label>
              <input
                type="text"
                id="username"
                name="username"
                placeholder="Insira seu usuário"
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="password">Senha</label>
              <input
                type="password"
                id="password"
                name="password"
                placeholder="Insira sua senha"
                required
              />
            </div>

            <div className="form-options">
              <label className="checkbox-container">
                <input type="checkbox" name="remember" />
                <span className="checkmark"></span>
                Lembre-se de mim
              </label>
              <a href="#" className="forgot-password">
                Esqueci minha senha &gt;
              </a>
            </div>

            <button type="submit" className="btn-primary">
              Entrar &gt;
            </button>
          </form>
        </div>
      </main>
    </>
  );
}