function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    if (!username || !password) {
        alert('Please enter both username and password');
        return;
    }

    // Perform any additional client-side validation here

    // If validation passes, submit the form
    document.getElementById('loginForm').submit();
}
