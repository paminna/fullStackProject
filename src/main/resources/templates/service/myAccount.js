// Получаем элементы, в которые будем выводить данные о пользователе
const nameEl = document.getElementById('name');
const emailEl = document.getElementById('email');
const ratingEl = document.getElementById('rating');

// Функция для получения данных о пользователе
function getUserData() {
    // Отправляем GET запрос на API сервера, который вернет информацию о пользователе
    fetch('https://example.com/api/user')
        .then(response => response.json())
        .then(data => {
            // Обновляем значения элементов на странице
            nameEl.textContent = data.name;
            emailEl.textContent = data.email;
            ratingEl.textContent = data.rating;
        })
        .catch(error => {
            console.error('Ошибка получения данных о пользователе', error);
        });
}

// Вызываем функцию для получения и вывода данных о пользователе при загрузке страницы
getUserData();
