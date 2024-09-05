<%@page import="springmvcpgm.POJO.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="Navbar.jsp"/>
    <% String msg=(String)request.getAttribute("msg");
    Employee emp=(Employee)request.getAttribute("emp");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
            margin: 0;
        }
        .search-container {
            position: relative;
            width: 400px;
        }
        .search-input {
            width: 100%;
            padding: 12px 20px;
            border: none;
            border-radius: 25px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            font-size: 16px;
            outline: none;
        }
        .search-input:focus {
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
        }
        .search-button {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            border: none;
            background-color: #007BFF;
            color: white;
            padding: 10px 15px;
            border-radius: 50%;
            cursor: pointer;
            outline: none;
        }
        .search-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="search-container">
     <Form action="./search" method="post">
        <input type="text" class="search-input" name="id" placeholder="Search...">
        <button class="search-button">&#128269;</button>
        </Form>
    </div>
      <% if(msg!=null){ %>
    <h1><%=msg %></h1>
    <%} %>
    <%if(emp!=null){ %>
     <h1>Id:<%= emp.getId() %></h1>
    <h1>NAME:<%= emp.getName() %></h1>
    <h1>Email:<%= emp.getEmail() %></h1>
    <h1>Contact:<%= emp.getContact() %></h1>
    <h1>Dessignation:<%= emp.getDesignation() %></h1>
    <h1>Salary:<%= emp.getSalary() %></h1>
    <%} %>
    
    
    
</body>
</html>
