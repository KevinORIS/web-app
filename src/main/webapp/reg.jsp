<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {font-family: Arial, Helvetica, sans-serif;}
    form {border: 3px solid #f1f1f1;}

    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
    }

    button {
      background-color: #04AA6D;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer;
      width: 100%;
    }

    button:hover {
      opacity: 0.8;
    }

    .cancelbtn {
      width: auto;
      padding: 10px 18px;
      background-color: #f44336;
    }

    .imgcontainer {
      text-align: center;
      margin: 24px 0 12px 0;
    }

    img.avatar {
      width: 40%;
      border-radius: 50%;
    }

    .container {
      padding: 16px;
    }

    span.psw {
      float: right;
      padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
      span.psw {
        display: block;
        float: none;
      }
      .cancelbtn {
        width: 100%;
      }
    }
  </style>
</head>
<body>

<h2>Registration</h2>
<h2 style="color: #c82333">${msg}</h2>

<c:if test="${cause != null}">
  <details>
    <summary>Error Details</summary>
      <c:out value="${cause}"/>
    <details>
      <summary>stack-trace</summary>
      <c:out value="${stack-trace}"/>
    </details>
  </details>
</c:if>


<form action="reg-user" method="post">

  <div class="container">
    <label for='email'><b>Email</b></label>
    <br>
    <input id ="email" type="email" placeholder="Enter your email" name="email" required>
    <br>
    <label for='name'><b>Name</b></label>
    <br>
    <input id ="name" type="text" placeholder="Enter your name" name="name" required>
    <br>
    <label for='psw'><b>Password</b></label>
    <input id="psw"type="password" placeholder="Enter your password" name="psw" required>

    <label for='psw2'><b>Repeat your password</b></label>
    <input id="psw2"type="password" placeholder="Repeat your password" name="psw2" required>

    <button type="submit">Register me</button>
    <!-- <label>
         <input type="checkbox" checked="checked" name="remember"> Remember me
     </label> -->
  </div>

  <!--<div class="container" style="background-color:#f1f1f1">
      <button type="button" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
  </div> -->
</form>

</body>
</html>