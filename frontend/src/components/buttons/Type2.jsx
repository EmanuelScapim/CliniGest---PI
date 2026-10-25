export default function Type2({ type, className, id, onClick }) {
    const styles = {
        btnType1: {
            width: '100%',
            padding: '15px',
            border: '1px solid #a2a2a2',
            borderRadius: '8px',
            backgroundColor: '#ffffff',
            color: '#454545',
            fontSize: '16px',
            fontWeight: '500',
            cursor: 'pointer'
        },
    }
    return (
        <button type={type} className={className} id={id} onClick={onClick} style={styles.btnType1}>
            Botão tipo 2
        </button>
    );
}