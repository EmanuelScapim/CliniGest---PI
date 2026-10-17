export default function LoginButton() {
    const styles = {
        btnType1: {
            width: '100%',
            padding: '15px',
            border: 'none',
            borderRadius: '8px',
            backgroundColor: '#6c94e8',
            color: 'white',
            fontSize: '16px',
            fontWeight: '500',
            cursor: 'pointer'
        },
    }
    return (
        <button type="submit" className="btnType1" style={styles.btnType1}>
            Entrar &gt;
        </button>
    );
}