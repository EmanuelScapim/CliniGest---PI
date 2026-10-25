import { BiSearch } from 'react-icons/bi';
import css from './Searchbar.module.css';

export default function Searchbar({ id, className }) {
    const styles = {
        style: {
            width: '100%',
            padding: '.7rem .9rem .7rem 2.2rem',
            border: '1px solid #a2a2a2',
            borderRadius: '.6rem',
            backgroundColor: '#ffff',
            color: '#454545',
            fontSize: '70%',
            fontWeight: '500',
        }
    }
    return (
        <div className={`${css.container} searchbar-container`}>
            <BiSearch className={css.icon} aria-hidden="true" />
            <input
                type="text"
                placeholder="Buscar pacientes..."
                id={id}
                aria-label="Buscar pacientes"
                style={styles.style}
                className={className}
            />
        </div>
    )
}