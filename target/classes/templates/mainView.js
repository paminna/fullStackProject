// получить ссылку на блок book-list
const bookList = document.getElementById('book-list');

// // получить список книг с сервера
// fetch('http://localhost:8080/bookList')
//     .then(response => response.json())
//     .then(data => {
//         // перебираем каждый элемент массива данных и создаем элементы для добавления на страницу
//         data.forEach(book => {
//             const bookTitle = document.createElement("h2");
//             bookTitle.textContent = book.title;
//             const bookAuthor = document.createElement("p");
//             bookAuthor.textContent = book.author;
//             const bookDescription = document.createElement("p");
//             bookDescription.textContent = book.description;
//
//             // создаем контейнер для каждой книги и добавляем в него созданные элементы
//             const bookContainer = document.createElement("div");
//             bookContainer.appendChild(bookTitle);
//             bookContainer.appendChild(bookAuthor);
//             bookContainer.appendChild(bookDescription);
//
//             // добавляем контейнер с книгой на страницу
//             bookList.appendChild(bookContainer);
//         });
//     })
//     .catch(error => console.log(error));

fetch('http://localhost:8080/bookList')
    .then(response => response.json())
    .then(books => {
        const numPages = Math.ceil(books.length / 6); // Calculate number of pages
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
    const startIndex = (pageNum - 1) * 6;
    const endIndex = pageNum * 6;

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

        const bookAuthor = document.createElement('p');
        bookAuthor.classList.add('book-author');
        bookAuthor.textContent = book.author;
        bookItem.appendChild(bookAuthor);

        const bookDescription = document.createElement('p');
        bookDescription.classList.add('book-description');
        bookDescription.textContent = book.description;
        bookItem.appendChild(bookDescription);

        const bookImage = document.createElement('img');
        bookImage.classList.add('book-image');
        bookImage.src = book.imageUrl;
        bookItem.appendChild(bookImage);
        // const bookImage = document.createElement('img');
        // bookImage.src = 'обложка.webp';
        // bookItem.appendChild(bookImage);

        bookList.appendChild(bookItem);
    }

    // Update active class for pagination buttons
    const activeButton = pagination.querySelector('.active');
    if (activeButton) {
        activeButton.classList.remove('active');
    }
    pagination.children[pageNum - 1].classList.add('active');
}
