// admin-create.js

document.getElementById("createAdminForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent default form submission

    fetch("http://localhost:8080/admin/create", {
        method: "POST",
        body: new FormData(this)
    })
    .then(response => {
        if (response.ok) {
            // Display success message
            document.getElementById("successMessage").style.display = "block";

            // Countdown timer
            let countdown = 3;
            const countdownSpan = document.getElementById("countdown");
            const timer = setInterval(() => {
                countdown--;
                countdownSpan.textContent = countdown;
                if (countdown === 0) {
                    clearInterval(timer);
                    window.location.href = "admin-login.html";
                }
            }, 1000);
        } else {
            throw new Error("Failed to create admin");
        }
    })
    .catch(error => {
        console.error("Error:", error);
        // Handle error if needed
    });
});
