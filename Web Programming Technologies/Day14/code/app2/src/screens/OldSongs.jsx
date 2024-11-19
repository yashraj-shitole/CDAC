import SongRow from '../components/SongRow'

function OldSongs() {
  const songs = [
    {
      id: 1,
      title: 'Bheegi Bheegi Raaton Mein',
      artists: 'Kishore Kumar, Lata Mangeshkar',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Aap Ki Ankhon Mein Kuch',
      artists: 'Kishore Kumar, Lata Mangeshkar',
      duration: '03:54',
    },
    {
      id: 3,
      title: 'Tum Aa Gaye Ho Noor Aa Gaya',
      artists: 'Kishore Kumar, Lata Mangeshkar',
      duration: '03:20',
    },
    {
      id: 4,
      title: 'Hamen Tumse Pyar Kitna',
      artists: 'Kishore Kumar, Lata Mangeshkar',
      duration: '03:04',
    },
    {
      id: 5,
      title: 'Dheere Dheere Se Meri Zindagi Mein Aana',
      artists: 'Kishore Kumar, Lata Mangeshkar',
      duration: '03:14',
    },
  ]

  return (
    <div>
      <h3>Old Songs</h3>
      <table className='table  table-hover'>
        <thead>
          <tr>
            <th>Id</th>
            <th>Track Title</th>
            <th>Artists</th>
            <th>Duration</th>
          </tr>
        </thead>
        <tbody>
          {songs.map((song) => {
            return (
              <SongRow
                id={song.id}
                title={song.title}
                artists={song.artists}
                duration={song.duration}
              />
            )
          })}
        </tbody>
      </table>
    </div>
  )
}

export default OldSongs
