function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (!username || !password) {
        alert('Please enter both username and password');
        return;
    }

    if(username == "username" && password == "password")
    {
     window.location.href = '/admin-success.html';
    }
    else {
            // Display error message if login fails
            alert('Invalid credentials');
        }

 }
