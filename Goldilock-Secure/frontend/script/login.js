
let catchElem = (e) => document.querySelector(e);

let createElem = (e) => document.createElement(e);

const url = `http://localhost:8880/user/signIn`;

let log_btn = catchElem('#log-btn');

let login = () => {
    const userName = catchElem('#uEmail').value;
    const userPassword = catchElem('#uPass').value;
    const credentials = `${userName}:${userPassword}`;
    const encodedCredentials = btoa(credentials);

    fetch(url, {
        method: 'GET',
        headers: {
            'Authorization': `Basic ${encodedCredentials}`
        }
    })
        .then(res => {
            if (res.status == 200) {
                console.log(res);
                return res.json();
            }
            else {
                openModal();
                throw new Error('Invalid Credentials');
            }
        })
        .then(data => {
            console.log(data);
            localStorage.setItem('user', JSON.stringify(data));
            window.location.href = 'home.html';
        })
        .catch(err => {
            openModal();
            console.log(err);
        })
}

log_btn.addEventListener('click', login);

let modal = catchElem(".modal");

let openModal = () => {

    modal.innerHTML = '';
    modal.style.display = "block";

    let modalContent = createElem("div");
    modalContent.setAttribute("class", "modal-content");

    let modalHeader = createElem("div");
    modalHeader.setAttribute("class", "modal-header");

    let modal_p = createElem("p");
    modal_p.textContent = "Invalid Credentials! Please try again.";

    modalHeader.append(modal_p);

    let modalFooter = createElem("div");
    modalFooter.setAttribute("class", "modal-footer");

    let modalYes = createElem("button");
    modalYes.setAttribute("class", "modal-yes");
    modalYes.textContent = "Try Again";
    modalYes.addEventListener("click", () => {
        modal.style.display = "none";
    });


    modalFooter.append(modalYes);

    modalContent.append(modalHeader, modalFooter);

    modal.append(modalContent);

};
