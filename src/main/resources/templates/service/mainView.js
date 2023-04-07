// получить ссылку на блок book-list
const bookList = document.getElementById('book-list');

fetch('http://localhost:8080/bookList')
    .then(response => response.json())
    .then(books => {
        const numPages = Math.ceil(books.length / 4); // Calculate number of pages
        const pagination = document.querySelector('.pagination');

        // Create pagination buttons and add event listeners
        for (let i = 1; i <= numPages; i++) {
            const button = document.createElement('button');
            button.textContent = i;
            pagination.appendChild(button);
            button.addEventListener('click', () => showPage(i, books));
        }

        showPage(1, books); // Show first page of book list by default
    })
    .catch(error => console.log(error));

function showPage(pageNum, books) {
    const startIndex = (pageNum - 1) * 4;
    const endIndex = startIndex + 4;

    const bookList = document.getElementById('book-list');
    bookList.innerHTML = ''; // Clear book list

    for (let i = startIndex; i < endIndex && i < books.length; i++) {
        const book = books[i];
        const bookItem = document.createElement('div');
        bookItem.classList.add('book-item');

        const bookTitle = document.createElement('h2');
        bookTitle.classList.add('book-title');
        bookTitle.textContent = book.title;
        bookItem.appendChild(bookTitle);

        const bookAuthor = document.createElement('h2');
        bookAuthor.classList.add('book-author');
        bookAuthor.textContent = book.author;
        bookItem.appendChild(bookAuthor);

        const bookDescription = document.createElement('p');
        bookDescription.classList.add('book-description');
        bookDescription.textContent = book.description;
        bookItem.appendChild(bookDescription);

        // const bookImage = document.createElement('img');
        // bookImage.classList.add('book-image');
        // bookImage.src = book.imageUrl;
        // bookItem.appendChild(bookImage);
        const bookImage = document.createElement('img');
        bookImage.src = '../image/обложка.webp';
        bookImage.height = 300;
        bookImage.width = 200;
        bookItem.appendChild(bookImage);

        const wishlistButton = document.createElement('button');
        wishlistButton.classList.add('wishlist-button');
        wishlistButton.innerHTML = '<i class="fa fa-heart"></i>';
        wishlistButton.addEventListener('click', function() {
            //написать функцию
            addToWishlist(book);
        });

        bookList.appendChild(bookItem);
    }

    // Update active class for pagination buttons
    const activeButton = pagination.querySelector('.active');
    if (activeButton) {
        activeButton.classList.remove('active');
    }
    pagination.children[pageNum - 1].classList.add('active');
}

// Получаем ссылку на форму и на поле ввода
const searchForm = document.querySelector('form');
const searchInput = document.querySelector('input[type="text"]');

// Обработчик события отправки формы
searchForm.addEventListener('submit', (event) => {
    // Отменяем стандартное поведение браузера
    event.preventDefault();

    // Получаем значение поля ввода
    const searchTerm = searchInput.value;

    // Отправляем запрос на сервер
    const xhr = new XMLHttpRequest();
    xhr.open('GET', `http://localhost:8080/books?search=${searchTerm}`);
    xhr.onload = () => {
        // Парсим полученный ответ
        const books = JSON.parse(xhr.responseText);

        // Отображаем список книг
        const bookList = document.getElementById('book-list');
        bookList.innerHTML = '';
        books.forEach((book) => {
            const bookItem = document.createElement('div');
            bookItem.classList.add('book-item');

            const bookTitle = document.createElement('h2');
            bookTitle.classList.add('book-title');
            bookTitle.textContent = book.title;
            bookItem.appendChild(bookTitle);

            const bookAuthor = document.createElement('h2');
            bookAuthor.classList.add('book-author');
            bookAuthor.textContent = book.author;
            bookItem.appendChild(bookAuthor);

            const bookDescription = document.createElement('p');
            bookDescription.classList.add('book-description');
            bookDescription.textContent = book.description;
            bookItem.appendChild(bookDescription);

            // const bookImage = document.createElement('img');
            // bookImage.classList.add('book-image');
            // bookImage.src = book.imageUrl;
            // bookItem.appendChild(bookImage);
            const bookImage = document.createElement('img');
            bookImage.src = '../image/обложка.webp';
            bookImage.height = 300;
            bookImage.width = 200;
            bookItem.appendChild(bookImage);

            bookList.appendChild(bookItem);
        });
    };
    xhr.send();
});
