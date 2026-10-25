export default function MiniButtonType2({ type, className, id, onClick, children='Mini botão tipo 2', ...buttonProps }) {
    const styles = {
        style: {
            display:'flex',
            alignItems:'center',
            justifyContent:'center',
            gap:'.3rem',
            padding: '.6rem .9rem',
            border: '1px solid #a2a2a2',
            borderRadius: '.6rem',
            backgroundColor: '#ffffff',
            color: '#454545',
            fontSize: '70%',
            fontWeight: '500',
            cursor: 'pointer'
        },
    }
    return (
        <button type={type} className={className} id={id} onClick={onClick} style={styles.style} {...buttonProps}>
            {children}
        </button>
    );
}