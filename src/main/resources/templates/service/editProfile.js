// Получаем элементы формы, которые нужно отправить на сервер
const nameInput = document.getElementById('name');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const saveButton = document.getElementById('save-button');

// Функция для отправки данных на сервер
function saveUserData() {
    // Получаем значения из полей формы
    const name = nameInput.value;
    const email = emailInput.value;
    const password = passwordInput.value;

    // Отправляем POST запрос на API сервера для сохранения данных
    fetch('https://example.com/api/user', {
        method: 'POST',
        body: JSON.stringify({ name, email, password }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            console.log('Данные успешно сохранены', data);
        })
        .catch(error => {
            console.error('Ошибка сохранения данных', error);
        });
}

// Добавляем обработчик события на кнопку сохранения данных
saveButton.addEventListener('click', saveUserData);
