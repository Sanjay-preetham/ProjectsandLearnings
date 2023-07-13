<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <div class="container">
        <h1>Successfully Registered!!! Login and Explore</h1>
        <hr>
        <label for="emailId"><b>Email Id: </b></label>
        <input type="email" placeholder="Enter Email Id" id="emailId" autofocus required><br><br><br>

        <label for="password"><b>Password: </b></label>
        <input type="password" placeholder="Enter Password" id="password" autofocus required><br><br><br>

        <hr>
        <button type="submit" class="signinBtn" onclick="signInUser()">Signin</button>
    </div>

    <script>
        function signInUser() {
            const emailId = document.getElementById("emailId").value;
            const password = document.getElementById("password").value;
            console.log("printed");
            const jsonObject = {
                emailId: emailId,
                password: password
            };

            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                	console.log(xhr.responseText);
                    if (xhr.status === 201) {
                        console.log(xhr.responseText);
                        window.location.href ="/addcode";
                    } else {
                        console.log('Error:', xhr.status);
                    }
                }
            };

            xhr.open('POST','/auth/signin', true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify(jsonObject));
        }
    </script>
</body>
</html>
