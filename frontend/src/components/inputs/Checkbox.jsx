export default function Checkbox({name, id, className}) {
    const styles={
        // checkbox:{
        //     width:'.5rem',
        //     height:'1rem',
        // }
    }
    return (
        <input type="checkbox" name={name} id={id} className={className}/>
    )
}