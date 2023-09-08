
let catchElem = (e) => document.querySelector(e);

let createElem = (e) => document.createElement(e);

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
            console.log(res);
            if (res.status == 200) {
                openModal();
                return res.json();
            }
            console.log(res.status);
        })
        .then(data => {
            console.log(data);
        })

    catchElem('#uName').value = '';
    catchElem('#uEmail').value = '';
    catchElem('#uPass').value = '';
    catchElem('#uRole').value = '';

});

let modal = catchElem(".modal");

let openModal = () => {

    modal.innerHTML = '';
    modal.style.display = "block";

    let modalContent = createElem("div");
    modalContent.setAttribute("class", "modal-content");

    let modalHeader = createElem("div");
    modalHeader.setAttribute("class", "modal-header");

    let modal_p = createElem("p");
    modal_p.textContent = "Registration Successful! Please login.";

    modalHeader.append(modal_p);

    let modalFooter = createElem("div");
    modalFooter.setAttribute("class", "modal-footer");

    let modalYes = createElem("button");
    modalYes.setAttribute("class", "modal-yes");
    modalYes.textContent = "Login";
    modalYes.addEventListener("click", () => {
        window.location.href = 'login.html';
        modal.style.display = "none";
    });


    modalFooter.append(modalYes);

    modalContent.append(modalHeader, modalFooter);

    modal.append(modalContent);

};
