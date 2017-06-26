<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>book details confirmation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<!-- Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:20%">
  <h3 class="w3-bar-item">Menu</h3>
  <a href="add_new_book/Add_new_book.jsp" class="w3-bar-item w3-button">Add book</a>
  <a href="View_book/Search_by_ID_home.jsp" class="w3-bar-item w3-button">Search book</a>
  <a href="#" class="w3-bar-item w3-button">Issue book</a>
    <a href="#" class="w3-bar-item w3-button">Return book</a>
</div>
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system (LMS v1.0)</h1>
</div>


<div class="w3-container">
<center>
<h1 style="color:green;">User added successfully</h1>
<br>

<table>
<tr>
<td>
Generated user ID: 
</td>
<td>
<%=request.getAttribute("user_ID") %><br>
</td>
</tr>
<tr>
<td>
Name
</td>
<td>
<%=request.getAttribute("user_name") %><br>
</td>
</tr>
<tr>
<td>
Address
</td>
<td>
 <%=request.getAttribute("Address") %><br>
</td>
</tr>

</table>
<br>
<br>
</center>
</div>
</div>
</body>
</html>