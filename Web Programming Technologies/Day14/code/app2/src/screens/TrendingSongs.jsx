import SongRow from '../components/SongRow'

function TrendingSongs() {
  const songs = [
    {
      id: 1,
      title: 'Bhool Bhulaiyaa 3 - Title Track',
      artists:
        'Pitbull, Diljit Dosanjh, Neeraj Sridhar, Tanishk Bagchi, Pritam, Dhrruv Yogi, Sameer',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Born to Shine',
      artists: 'Diljit Dosanjh',
      duration: '03:34',
    },
    {
      id: 1,
      title: 'Bhool Bhulaiyaa 3 - Title Track',
      artists:
        'Pitbull, Diljit Dosanjh, Neeraj Sridhar, Tanishk Bagchi, Pritam, Dhrruv Yogi, Sameer',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Born to Shine',
      artists: 'Diljit Dosanjh',
      duration: '03:34',
    },
    {
      id: 1,
      title: 'Bhool Bhulaiyaa 3 - Title Track',
      artists:
        'Pitbull, Diljit Dosanjh, Neeraj Sridhar, Tanishk Bagchi, Pritam, Dhrruv Yogi, Sameer',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Born to Shine',
      artists: 'Diljit Dosanjh',
      duration: '03:34',
    },
    {
      id: 1,
      title: 'Bhool Bhulaiyaa 3 - Title Track',
      artists:
        'Pitbull, Diljit Dosanjh, Neeraj Sridhar, Tanishk Bagchi, Pritam, Dhrruv Yogi, Sameer',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Born to Shine',
      artists: 'Diljit Dosanjh',
      duration: '03:34',
    },
    {
      id: 1,
      title: 'Bhool Bhulaiyaa 3 - Title Track',
      artists:
        'Pitbull, Diljit Dosanjh, Neeraj Sridhar, Tanishk Bagchi, Pritam, Dhrruv Yogi, Sameer',
      duration: '03:50',
    },
    {
      id: 2,
      title: 'Born to Shine',
      artists: 'Diljit Dosanjh',
      duration: '03:34',
    },
  ]

  return (
    <div>
      <h3>Trending Songs</h3>
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

export default TrendingSongs
