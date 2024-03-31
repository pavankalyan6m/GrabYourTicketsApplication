function adminHomePageContent() {
    return `
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Admin Home</title>
            <style>
                body {
                    margin: 0;
                    padding: 0;
                    font-family: Arial, sans-serif;
                    background-color: #f0f0f0;
                    /* Set background image */
                    background-image: url("/admin/images/admin-home_image.avif");
                    background-size: cover; /* Cover the entire container */
                    background-position: center; /* Center the background image */
                }
                .container {
                    width: 100%;
                    height: 100vh;
                    display: flex;
                    flex-direction: column; /* Align items vertically */
                    justify-content: center; /* Center items vertically */
                    align-items: center; /* Center items horizontally */
                    animation: fadeIn 1s ease-out; /* Add fade-in animation */
                }
                h1, h2 {
                    color: #ccc; /* Greyish white color */
                }
                h1 {
                    margin-bottom: 40px;
                    margin-top: 10px/* Add margin to the top of h1 */
                }
                .admin-options {
                    text-align: center;
                    margin-top: 50px; /* Add more space between h1 and h2 */
                }
                .admin-options h2 {
                    margin-bottom: 40px; /* Add more space below h2 */
                }
                .admin-options a {
                    display: inline-block;
                    margin: 10px;
                    padding: 10px;
                    background-color: #4169e1; /* Daisy blue color */
                    color: #fff;
                    text-decoration: none;
                    border-radius: 10px;
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                    transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transition effect */
                    animation: fadeInButton 1s ease-out; /* Button fade-in animation */
                }
                .admin-options a:hover {
                    background-color: #1e90ff; /* Lighter blue on hover */
                    transform: scale(1.1); /* Scale up the button on hover */
                }
                @keyframes fadeIn {
                    from { opacity: 0; }
                    to { opacity: 1; }
                }
                @keyframes fadeInButton {
                    from { opacity: 0; transform: translateY(20px); }
                    to { opacity: 1; transform: translateY(0); }
                }
            </style>
        </head>
        <body>
        <div class="container">
            <h1>Welcome home, Admin!</h1>
            <div class="admin-options">
                <h2>Please Select your option</h2>
                <a href="/admin/admin-create.html">Create New Member</a>
                <a href="/admin/admin-login.html">Login with Existing Account</a>
            </div>
        </div>
        </body>
        </html>
    `;
}

// Insert the generated HTML content into the document
document.body.innerHTML = adminHomePageContent();
