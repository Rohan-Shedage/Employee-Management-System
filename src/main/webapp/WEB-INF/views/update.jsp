<%@page import="springmvcpgm.POJO.Employee" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <jsp:include page="Navbar.jsp"/>
<%  String msg = (String) request.getAttribute("msg");

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 50%;
            margin: 0 auto;
        }
        form {
            margin-top: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
        }
        .form-group input {
            width: 300px;
            padding: 5px;
        }
         table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
    .error {
        font-size: 18px;
        color: red;
    }
    .slide-down {
        animation: slide-down 2s ease-in-out;
    }
    @keyframes slide-down {
        0% {
            opacity: 0;
            transform: translateY(-30%);
        }
        100% {
            opacity: 1;
            transform: translateY(0);
        }
    }
        .form-group button {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .msg {
            margin-top: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        
            <form action="./update" method="post">
            <div>
            <div class="form-group">
           <label for="id">Id:</label>
                <input type="text" name="id" >
                </div>
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text"  name="name">
                </div> 
               
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="designation">Contact:</label>
                    <input type="text" id="contact" name="contact">
                </div>
                <div class="form-group">
                    <label for="designation">Designation:</label>
                    <input type="text" id="designation" name="designation">
                </div>
                <button type="submit">Update</button>
            </form>
             
    
    <% if (msg != null) { %>
        <h1 class="<%= msg.contains("not") ? "error" : "message" %>"><%= msg %></h1>
    <% } %>
        
        </div>
</body>
</html>