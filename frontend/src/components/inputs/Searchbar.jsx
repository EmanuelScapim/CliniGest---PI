export default function Searchbar() {
    const styles = {
        style: {
            width:'max-content',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            gap: '.3rem',
            padding: '.7rem .9rem',
            border: '1px solid #a2a2a2',
            borderRadius: '.6rem',
            backgroundColor: '#ffff',
            color: '#454545',
            fontSize: '70%',
            fontWeight: '500',
        }
    }
    return (
        <input
            type="text"
            placeholder="🔎 Buscar pacientes...  "
            id="searchbar"
            style={styles.style}
        />
    )
}