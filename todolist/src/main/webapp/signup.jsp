<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
border:1px solid black;
background-size:900px;
}
input{
align-item:center;
}


</style>
</head>

<body>
<form action="" method="post" enctype="multipart/form-data">
id:<input type="text" name="id"><br>
name:<input type="text" name="name"><br>
email:<input type="email" name="email"><br>
contact:<input type="text" name="contact"><br>
password:<input type="text" name="password"><br>
image:<input type="file" name="image"><br>
<button>submit</button>
</form>
</body>
</html>