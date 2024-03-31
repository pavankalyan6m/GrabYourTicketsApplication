// admin-create.js
document.getElementById("createAdminForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission

    const nameInput = document.getElementById("name");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");

    // Check if the name contains numbers
    if (/\d/.test(nameInput.value)) {
        alert("Name cannot contain numbers.");
        return; // Prevent further execution
    }

    fetch("http://localhost:8080/admin/create", {
        method: "POST",
        body: new FormData(this)
    })
    .then(response => {
        if (response.ok) {
            // Display success box
            const successBox = document.getElementById("successBox");
            successBox.style.display = "block";

            // Countdown timer
            let countdown = 5;
            const countdownSpan = document.getElementById("countdown");
            countdownSpan.textContent = countdown; // Initialize countdown value
            const timer = setInterval(() => {
                countdown--;
                countdownSpan.textContent = countdown; // Update countdown value
                if (countdown === 0) {
                    clearInterval(timer);
                    // Redirect to admin-login page after countdown
                    window.location.href = "admin-login.html";
                }
            }, 1000);

            // Show second message after a brief delay
            setTimeout(() => {
                document.getElementById("successMessage1").style.display = "none";
                document.getElementById("successMessage2").style.display = "block";
            }, 1000); // Change delay time if needed
        } else {
            throw new Error("Failed to create admin");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        // Handle error if needed
    });
});

// Password toggle functionality
const togglePassword = document.getElementById('togglePassword');
const password = document.getElementById('password');

togglePassword.addEventListener('click', function () {
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    this.classList.toggle('eye-icon');
});

