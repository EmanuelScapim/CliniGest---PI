export default function Input({ type, id, name, placeholder, label, className }) {
    const styles = {
        label: {
            display: 'block',
            fontWeight: 'bold',
            color: '#333',
            margin: '1rem 0 .5rem'
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
                className={className}
            />
        </div>
    )
}