<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Navbar.jsp"></jsp:include>
    <% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="form-container">
        <Form action="./Add" method="post">
            <h2>Employee Management</h2>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>

            <label for="contact">Contact:</label>
            <input type="text" id="contact" name="contact" required>

            <label for="Designation">Designation:</label>
            <input type="text" id="designation" name="designation" required>

            <label for="Salary">Salary:</label>
            <input type="text" id="salary" name="salary" required>

            <button type="submit">Submit</button>
        </form>
    </div>
    <% if(msg!=null){ %>
    <h1><%=msg %></h1>
    <%} %>
</body>
</html>
