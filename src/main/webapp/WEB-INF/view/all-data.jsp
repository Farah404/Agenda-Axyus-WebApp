<%-- 
    Document   : all-customers
    Created on : 17 janv. 2023, 15:55:18
    Author     : farah.gauduin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Data</title>
        <style>
            body {
                font-family: Arial;
                margin: 0;
            }
            * {
                box-sizing: border-box;
            }
            /* Header/Logo Title */
            .header {
                padding: 60px;
                text-align: center;
                background-image:url("https://plos.org/wp-content/uploads/2020/07/abstract-image_color-tone.jpg");
                color: white;
                font-size: 30px;
            }
            .container{
                padding: 5%;
                text-align: center;
            }
            a {
                all: unset;

            }
            table, th, td {
                border: 1px solid;
            }

            table {
                width: 100%;
            }
            form {
                width: 100%;
                height: 100%;
                border-radius: 5px;
                align-items: center;
                display: inline-block;
                margin-bottom: 2%;
            }
            input{
                width: 80%;
                font: 16px system-ui;
            }
            .search-button{
                background-color: #4CAF50; /* Green */
                color: white;
                padding: 5px 30px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                border-radius: 8px;
                height: 100%;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div class="header">
            <h1> <a href="/" style="cursor: pointer">Welcome to your digital Agenda </a></h1>
            <p><a href="/all-customers" style="cursor: pointer">Customers List</a></p>
        </div>
        <div class="container">
            <table>
                <tr>
                    <th>Customer Id</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Username</th>
                    <th>Phone number</th>
                    <th>Email</th>
                    <th>Address Id</th>
                    <th>Street Number</th>
                    <th>Street Name</th>
                    <th>City</th>
                    <th>Postal Code</th>
                    <th>Country</th>
                </tr>
                <c:forEach items="${allData}" var="allData">

                    <tr>
                        <td>
                            <p><c:out value="${allData.customerId}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.lastName}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.firstName}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.username}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.phoneNumber}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.email}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.addressId}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.streetNumber}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.streetName}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.city}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.postalCode}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${allData.address.country}"></c:out></p>
                            </td> 
                        </tr>

                </c:forEach>
            </table>
        </div>
    </body>
</html>
