const form = document.querySelector('#login-form');

form.addEventListener('submit', (event) => {
    event.preventDefault();
    const data = new FormData(form);
    localStorage.setItem(data.get("username"), data.get("passwprd"));
    fetch('http://localhost:8080/login', {
        method: 'POST',
        body: data
    }).then(response => handleResponse(response))
        .catch(error => {
            console.error(error);
        });
});

function handleResponse(response) {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }

    response.text().then(fileName => {
        window.location.href = fileName
    });
}

