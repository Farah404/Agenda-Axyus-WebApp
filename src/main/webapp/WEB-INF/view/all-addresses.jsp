<%-- 
    Document   : all-addresses
    Created on : 17 janv. 2023, 15:55:26
    Author     : farah.gauduin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addresses List</title>
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
            <p>Adrresses List</p>
        </div>

        <div class="container">
            <form id="form" role="search">
                <input  type="search" id="query" name="q"
                        placeholder="Search..."
                        aria-label="Search through site content">
                <button class="search-button">Submit</button>
            </form>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Street Number</th>
                    <th>Street Name</th>
                    <th>City</th>
                    <th>Postal Code</th>
                    <th>Country</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${addressesList}" var="address">

                    <tr>
                        <td>
                            <p><c:out value="${address.addressId}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${address.streetNumber}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${address.streetName}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${address.city}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${address.postalCode}"></c:out></p>
                            </td> 
                            <td>
                                <p><c:out value="${address.country}"></c:out></p>
                            </td> 
                            <td>
                                <a href="/all-addresses?dispatchMethod=showUpdateForm&addressId=<c:out value='${address.addressId}' />" style="cursor: pointer; color: blue">Update</a>
                            &nbsp;&nbsp;&nbsp;&nbsp; 
                             <a href="/all-addresses?dispatchMethod=deleteAddress&addressId=<c:out value='${address.addressId}' />" style="cursor: pointer; color: blue">Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
    </body>
</html>
