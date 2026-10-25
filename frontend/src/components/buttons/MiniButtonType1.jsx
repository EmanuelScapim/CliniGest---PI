export default function MiniButtonType1({ type, className, id, onClick, children='Mini botão tipo 1' }) {
    const styles = {
        style: {
            display:'flex',
            alignItems:'center',
            justifyContent:'center',
            gap:'.3rem',
            padding: '.6rem .9rem',
            border: '1px solid #6c94e8',
            borderRadius: '.6rem',
            backgroundColor: '#6c94e8',
            color: '#ffff',
            fontSize: '70%',
            fontWeight: '500',
            cursor: 'pointer'
        },
    }
    return (
        <button type={type} className={className} id={id} onClick={onClick} style={styles.style}>
            {children}
        </button>
    );
}