function checkValidationLogin(){
	
	var email = document.getElementById("email").value;
	var pwd = document.getElementById("pwd");
	if(isEmailValidLogin() && isPasswordValidLogin())
	{
		var emailstr="arjita101@gmail.com";
		var pwdstr="Arjita@1234";
		if(email == emailstr && pwd == pwdstr)
		{
			document.getElementById("form").submit();
			return true;
		}
		else{
			alert("Wrong email or password.")
			return false;
		}
	}
	else{
		alert("Invalid email or password")
		return false;
	}
}
function isEmailValidLogin() {
	var email = document.getElementById("email").value;
	var regexpression = new RegExp(
			"^([a-zA-Z0-9_]{2,})@([a-zA-Z0-9_]{2,})\.([a-zA-Z]{2,5})$");
	if (regexpression.test(email)) {
		return true;
	} else {
		return false;
	}
}

function isPasswordValidLogin() {
	var password = document.getElementById("pwd").value;
	var regexpression = new RegExp(
			"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
	if (regexpression.test(password)) {
		return true;
	} else {
		return false;
	}
}