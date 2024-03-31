// admin-login.js

let attempts = 0;

document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission
    // Get form data
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    attempts++;

    if (attempts === 3) {
        document.getElementById("errorMessage").innerText = "Too many attempts. Please try again later.";
        document.getElementById("errorMessage").style.display = "block";
        setTimeout(() => {
            window.location.href = "/admin/admin-home.html";
        }, 3000); // Redirect after 3 seconds
        return;
    }

    // Perform authentication
    // Here you should make an AJAX request to your backend to authenticate the user
    // Example:
    fetch("http://localhost:8080/admin/authenticate", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username: username, password: password })
    })
    .then(response => {
        if (response.ok) {
            // Redirect to dashboard or another page upon successful authentication
            window.location.href = "/admin/admin-success.html";
        } else {
            document.getElementById("errorMessage").style.display = "block";
            setTimeout(() => {
                document.getElementById("errorMessage").style.display = "none";
            }, 3000); // Hide error message after 3 seconds
        }
    })
    .catch(error => {
        console.error("Error:", error);
        // Handle authentication error here
    });
});

document.getElementById("togglePassword").addEventListener("click", function() {
    const passwordField = document.getElementById("password");
    const type = passwordField.getAttribute("type") === "password" ? "text" : "password";
    passwordField.setAttribute("type", type);
    this.innerHTML = type === "password" ? "&#128065;" : "&#128064;";
});
