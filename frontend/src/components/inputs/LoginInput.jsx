import '../css/General.css'

export default function LoginInput({ type, id, name, placeholder, label }) {
    const styles = {
        label: {
            display: 'block',
            fontWeight: 'bold',
            color: '#333',
            margin: '1rem 0 .5rem'
        },
        input: {
            width: '100%',
            padding: '.8rem',
            border: '1px solid #a2a2a2',
            borderRadius: '8px',
            backgroundColor: '#f2f2f2',
            color: '#555',
            transition: 'border-color 0.2s'
        }
    };
    return (
        <div>
            <label htmlFor={name} style={styles.label}>{label}</label>
            <input
                type={type}
                id={id}
                name={name}
                placeholder={placeholder}
                required
                style={styles.input}
            />
        </div>
    )
}