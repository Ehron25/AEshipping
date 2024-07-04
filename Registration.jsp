
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/Registration.css" />
<title>Text Box Page</title>
</head>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: #FFC1C2;
}

.navbar {
	background: black;
	padding: 20px 20px;
	color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.navbar a {
	color: white;
	text-decoration: none;
	margin: 0 10px;
}

.container {
	background: white;
	padding: 40px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	width: 80%;
	max-width: 800px;
	margin: 40px auto;
	box-sizing: border-box;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 10px;
	margin-top: 10px;
}

.form-group input[type="text"], .form-group input[type="email"], .form-group input[type="password"], .form-group select {
	width: calc(100% - 20px);
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form-group input[type="date"] {
	width: calc(50% - 10px); /* Adjust the width as needed */
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form-row {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}

.form-row > div {
	flex: 1 1 calc(30% - 10px); /* Adjust the width as needed */
	margin-bottom: 20px;
}

.form-group button {
	padding: 10px 20px;
	background: black;
	border: none;
	border-radius: 4px;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: background 0.3s;
}

.button-container {
	display: flex;
	justify-content: space-between;
}

.button-container button {
    font-family: arial;
    background-color: #63B8EE;
    background: linear-gradient(to top, #63B8EE, #468CCF);
    color: #14396A;
    padding: 10px 20px;
    margin: 10px 0;
    border: none;
    cursor: pointer;
    width: 48%;
    border-radius: 5px;
    transition: background 0.3s;
    position: relative;
    overflow: hidden;
}

.button-container {
    display: flex;
    justify-content: space-between;
}

.button-container button:hover {
    color: white;
    background: #7AA2E3;
    background: linear-gradient(to top, #468CCF, #63B8EE);
}

.login-container .register-link {
	display: block;
	text-align: center;
	margin-top: 10px;
	color: #555;
}
</style>
<body>

	<div class="container">
	<form>
		<center><h1>Registration Form</h1></center>
			<div class="form-group form-row">
				<div>
					<label for="email_address">Email Address:</label>
					<input type="email" id="email" name="email" required>
				</div>
				<div>
					<label for="password">Password:</label>
					<input type="password" id="password" name="password" required>
					<input type="checkbox" id="togglePassword"> Show Password
				</div>
			</div>

			<div class="form-group form-row">
				<div>
					<label for="first_name">First Name:</label>
					<input type="text" id="firstName" name="firstName" required>
				</div>
				<div>
					<label for="middle_name">Middle Name:</label>
					<input type="text" id="middleName" name="middleName">
				</div>
				<div>
					<label for="last_name">Last Name:</label>
					<input type="text" id="lastName" name="lastName" required>
				</div>
			</div>

			<div class="form-group">
				<label for="birthday">Birthday:</label>
				<input type="date" id="birthday" name="birthday" required>

				<label for="sex">Sex:</label>
				<select id="sex" name="sex">
					<option value="MALE">Male</option>
					<option value="FEMALE">Female</option>
				</select>

				<label for="age">Age:</label>
				<input type="text" id="age" name="age" required>

				<label for="address">Address:</label>
				<input type="text" id="address" name="address" required>

				<label for="phone_number">Phone Number:</label>
				<input type="text" id="phoneNumber" name="phoneNumber" required>

				<label for="nationality">Nationality:</label>
				<input type="text" id="nationality" name="nationality" required>
			</div>

			<div class="button-container">
				<button class="submit" type="button" onclick="location.href='LogIn.jsp'">Back</button>
				<button class="submit" type="button" onclick="location.href='home.jsp'">Create</button>
			</div>
		</form>
	</div>

	<script>
		document.getElementById('togglePassword').addEventListener('change', function () {
			const passwordField = document.getElementById('password');
			if (this.checked) {
				passwordField.type = 'text';
			} else {
				passwordField.type = 'password';
			}
		});
	</script>
</body>
</html>
