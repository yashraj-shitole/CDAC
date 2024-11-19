function SongRow({ id, title, artists, duration }) {
  return (
    <tr>
      <td>{id}</td>
      <td>{title}</td>
      <td>{artists}</td>
      <td>{duration}</td>
    </tr>
  )
}

export default SongRow
