
let catchElem = (e) => document.querySelector(e);

const url = `http://localhost:8880/user/save`;

let register = catchElem('#reg-btn');

register.addEventListener('click', () => {

    let data = {
        userName: catchElem('#uName').value,
        userEmail: catchElem('#uEmail').value,
        userPassword: catchElem('#uPass').value,
        userRole: catchElem('#uRole').value
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
        },
        body: JSON.stringify(data)
    })
        .then(res => {
            if (res.status == 200) {
                return res.json();
            }
            console.log(res.status);
        })
        .then(data => {
            console.log(data);
            if (data.status == 'success') {
                window.location.href = 'login.html';
            }
        })
});
