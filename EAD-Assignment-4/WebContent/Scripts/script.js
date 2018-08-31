function checkValidation() {
	if (isFNameValid() && isLNameValid() && isEmailValid() && isPasswordValid()
			&& isConfirmPasswordValid() && isContactNumberValid() && isOrganizatioNameValid() && isDobValid()) {
		document.getElementById("form").submit();
		return true;
	} else {
		alert("Enter valid inputs.")
		return false;
	}
}

function isFNameValid() {
	var name = document.getElementById('fname').value;
	var regexpression = new RegExp("^([a-zA-Z][a-zA-Z ]{2,})$");
	if (regexpression.test(name)) {
		return true;
	} else {
		return false;
	}
}

function isLNameValid() {
	var name = document.getElementById('lname').value;
	var regexpression = new RegExp("^([a-zA-Z]{2,})$");
	if (regexpression.test(name)) {
		return true;
	} else {
		return false;
	}
}

function isEmailValid() {
	var email = document.getElementById("email").value;
	var regexpression = new RegExp(
			"^([a-zA-Z0-9_\.]{2,})@([a-zA-Z0-9_]{2,})\.([a-zA-Z]{2,5})$");
	if (regexpression.test(email)) {
		return true;
	} else {
		return false;
	}
}

function isPasswordValid() {
	var password = document.getElementById("pwd").value;
	var regexpression = new RegExp(
			"^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
	if (regexpression.test(password)) {
		return true;
	} else {
		return false;
	}
}

function isConfirmPasswordValid() {
	var password = document.getElementById("pwd").value;
	var cpassword = document.getElementById("cpwd").value;
	if (password == cpassword) {
		return true;
	} else {
		return false;
	}
}

function isDobValid() {
	  var isValid = false;
	  var today = new Date();
	  var lowestAcceptableDate = new Date("01/01/1918");
	  var passedDate = new Date(document.getElementById("dob").value);
	  if(passedDate >= lowestAcceptableDate && passedDate <= today ) {
      isValid = true;
      }
	  return isValid;
}

function isContactNumberValid() {
	var contactno = document.getElementById("cnumber").value;
	var regexpression = new RegExp("^([0-9]{8,})$");
	if (regexpression.test(contactno)) {
		return true;
	} else {
		return false;
	}
}

function isOrganizatioNameValid(){
	var name= document.getElementById("orgname").value;
	var errorname="";
	if(name==errorname)
	{
		return false;
	}
	else{
		return true;
	}
}

function fnamefocusout() {
	if (isFNameValid()) {
		document.getElementById("fnamespan").style.color = "#008000";
		document.getElementById('fnamespan').innerHTML = '\u2714';
		document.getElementById("fname").style.borderColor = "#008000";
	} else {
		document.getElementById("fnamespan").style.color = "#ff0000";
		document.getElementById('fnamespan').innerHTML = "X";
		document.getElementById("fname").style.borderColor = "#ff0000";
	}
}

function lnamefocusout() {
	if (isLNameValid()) {
		document.getElementById('lnamespan').style.color = "#008000";
		document.getElementById('lnamespan').innerHTML = '\u2714';
		document.getElementById("lname").style.borderColor = "#008000";
	} else {
		document.getElementById('lnamespan').style.color = "#ff0000";
		document.getElementById('lnamespan').innerHTML = "X";
		document.getElementById("lname").style.borderColor = "#ff0000";
	}
}

function emailfocusout() {
	if (isEmailValid()) {
		document.getElementById("emailspan").style.color = "#008000";
		document.getElementById('emailspan').innerHTML = '\u2714';
		document.getElementById("email").style.borderColor = "#008000";
	} else {
		document.getElementById("emailspan").style.color = "#ff0000";
		document.getElementById('emailspan').innerHTML = 'X';
		document.getElementById("email").style.borderColor = "#ff0000";
	}
}

function passwordfocusout() {
	if (isPasswordValid()) {
		document.getElementById("pwdspan").style.color = "#008000";
		document.getElementById('pwdspan').innerHTML = '\u2714';
		document.getElementById("pwd").style.borderColor = "#008000";
	} else {
		document.getElementById("pwdspan").style.color = "#ff0000";
		document.getElementById('pwdspan').innerHTML = 'X';
		document.getElementById("pwd").style.borderColor = "#ff0000";
	}
}
function cpasswordfocusout() {
	if (isConfirmPasswordValid()) {
		document.getElementById("cpwdspan").style.color = "#008000";
		document.getElementById('cpwdspan').innerHTML = '\u2714';
		document.getElementById("cpwd").style.borderColor = "#008000";
	} else {
		document.getElementById("cpwdspan").style.color = "#ff0000";
		document.getElementById('cpwdspan').innerHTML = 'X';
		document.getElementById("cpwd").style.borderColor = "#ff0000";
	}
}
function contactnofocusout() {
	if (isContactNumberValid()) {
		document.getElementById("cnumspan").style.color = "#008000";
		document.getElementById('cnumspan').innerHTML = '\u2714';
		document.getElementById("cnumber").style.borderColor = "#008000";
	} else {
		document.getElementById("cnumspan").style.color = "#ff0000";
		document.getElementById('cnumspan').innerHTML = 'X';
		document.getElementById("cnumber").style.borderColor = "#ff0000";
	}
}

function dobfocusout(){
	if(isDobValid()){
		document.getElementById("dobspan").style.color = "#008000";
		document.getElementById('dobspan').innerHTML = '\u2714';
	}
	else{
		document.getElementById("dobspan").style.color = "#ff0000";
		document.getElementById('dobspan').innerHTML = 'X';
	}
}