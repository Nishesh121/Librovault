const API_URL = 'http://localhost:8080/api/books';

document.addEventListener('DOMContentLoaded', function () {
    fetchBooks();
    fetchAuthorsAndGenres();

    document.getElementById('addBookForm').addEventListener('submit', function (e) {
        e.preventDefault();
        addBook();
    });

    document.getElementById('searchForm').addEventListener('submit', function (e) {
        e.preventDefault();
        searchBooks();
    });
});

function fetchBooks() {
    fetch(API_URL)
        .then(response => response.json())
        .then(books => renderBooks(books))
        .catch(error => console.error('Error fetching books:', error));
}

function renderBooks(books) {
    const tableBody = document.getElementById('bookTableBody');
    tableBody.innerHTML = '';
    books.forEach(book => {
        const row = `<tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.price}</td>
        </tr>`;
        tableBody.innerHTML += row;
    });
}

function addBook() {
    const book = {
        title: document.getElementById('title').value,
        author: document.getElementById('authorInput').value,
        genre: document.getElementById('genreInput').value,
        price: parseFloat(document.getElementById('price').value)
    };

    fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(book)
    })
    .then(response => response.json())
    .then(newBook => {
        fetchBooks(); // Refresh list after adding
        document.getElementById('addBookForm').reset();
    })
    .catch(error => console.error('Error adding book:', error));
}

function fetchAuthorsAndGenres() {
    fetch(`${API_URL}`)
        .then(response => response.json())
        .then(books => {
            const authors = [...new Set(books.map(book => book.author))];   //new set le array list ma duplicate allow gardaiana
            const genres = [...new Set(books.map(book => book.genre))];

            const authorSelect = document.getElementById('authorSelect');
            const genreSelect = document.getElementById('genreSelect');

            authors.forEach(author => {
                const option = document.createElement('option');
                option.value = author;
                option.text = author;
                authorSelect.add(option);
            });

            genres.forEach(genre => {
                const option = document.createElement('option');
                option.value = genre;
                option.text = genre;
                genreSelect.add(option);
            });
        });
}

function searchBooks() {
    const selectedAuthor = document.getElementById('authorSelect').value;
    const selectedGenre = document.getElementById('genreSelect').value;
    const minPrice = document.getElementById('minPrice').value;
    const maxPrice = document.getElementById('maxPrice').value;

    let url = API_URL;

    if (selectedAuthor) {
        url += `/author?name=${encodeURIComponent(selectedAuthor)}`;
    } else if (selectedGenre) {
        url += `/genre?name=${encodeURIComponent(selectedGenre)}`;
    } else if (minPrice && maxPrice) {
        url += `/price?min=${minPrice}&max=${maxPrice}`;
    }

    fetch(url)
        .then(response => response.json())
        .then(books => renderBooks(books))
        .catch(error => console.error('Error searching books:', error));
}
