<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
<div align="center">
<h1>Employee List</h1>
        <h3>
            <a href="newEmployee">New Employee</a>
        </h3>
        <table border="1">
 <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>
 </tr>
            <c:forEach var="employee" items="${listEmployee}">
             <%-- <c:if test="${!empty employee}">  --%>
            
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>${employee.telephone}</td>
                    <td>
                        <a href="editEmployee?id=${employee.id}">Edit</a>
                        <ahref="deleteEmployee?id=${employee.id}">Delete</a>
                    </td>
                </tr>
                 <%-- </c:if>  --%>
            </c:forEach>
            
        </table>

</div>

</body>
</html>