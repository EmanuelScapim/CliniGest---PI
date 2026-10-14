export default function Label({ htmlFor, children, style }) {
  return (
    <label htmlFor={htmlFor} style={style}>
      {children}
    </label>
  );
}