// Function to fetch movies from backend API and display in the table
function fetchMovies() {
    fetch('/api/movies')
        .then(response => response.json())
        .then(movies => {
            const moviesBody = document.getElementById('moviesBody');
            moviesBody.innerHTML = '';

            movies.forEach(movie => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${movie.title}</td>
                    <td>${movie.description}</td>
                    <td>${movie.releaseDate}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.duration}</td>
                    <td>
                        <button onclick="editMovie(${movie.id})">Edit</button>
                        <button onclick="deleteMovie(${movie.id})">Delete</button>
                    </td>
                `;
                moviesBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching movies:', error));
}

// Function to add/create a new movie
function addMovie(event) {
    event.preventDefault();

    const formData = new FormData(document.getElementById('addMovieForm'));
    const movie = {};
    formData.forEach((value, key) => movie[key] = value);

    fetch('/api/movies', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(movie)
    })
    .then(response => {
        if (response.ok) {
            fetchMovies(); // Refresh the movies list after adding
            document.getElementById('addMovieForm').reset();
        } else {
            throw new Error('Failed to add movie');
        }
    })
    .catch(error => console.error('Error adding movie:', error));
}

// Function to edit a movie (redirect to a new page or modal)
function editMovie(id) {
    // Implementation for editing a movie
}

// Function to delete a movie
function deleteMovie(id) {
    fetch(`/api/movies/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            fetchMovies(); // Refresh the movies list after deleting
        } else {
            throw new Error('Failed to delete movie');
        }
    })
    .catch(error => console.error('Error deleting movie:', error));
}

// Initial fetch movies when the page loads
fetchMovies();

// Add event listener to the form submission
document.getElementById('addMovieForm').addEventListener('submit', addMovie);
