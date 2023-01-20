<%-- 
    Document   : manage-agenda
    Created on : 18 janv. 2023, 10:37:59
    Author     : farah.gauduin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
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

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            input[type=number], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
                float: left;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
                padding: 5%;
                text-align: center;
                margin: 2%;
            }

            .col-25 {
                float: left;
                width: 10%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 90%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
            }
        </style>
    </head>
    <body>
        <div class="header">
            <h1> <a href="/" style="cursor: pointer">Welcome to your digital Agenda </a></h1>
            <p><a href="/all-customers" style="cursor: pointer">Update customer </a></p>

        </div>
        <div class="container">
            <form method="post" action="update-customer">
                
                <input type="text" id="customerId" name="customerId" value="${existingCustomer.customerId}" hidden>

                <div class="row">
                    <div class="col-25">
                        <label for="lname">Last Name</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="lname" name="lastName" value="${existingCustomer.lastName}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="fname">First Name</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="fname" name="firstName" value="${existingCustomer.firstName}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="uname">Username</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="uname" name="username" value="${existingCustomer.username}" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="email">Email</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="email" name="email" value="${existingCustomer.email}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="email">Phone Number</label>
                    </div>
                    <div class="col-75">
                        <input type="number" id="phone" name="phoneNumber" value="${existingCustomer.phoneNumber}">
                    </div>
                </div>
                    <div class="row">
                    <div class="col-25">
                        <label for="email">Address Id</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="addressId" name="addressId" value="${existingCustomer.addressId}" readonly="readonly">
                    </div>
                </div>

                <br>
                <div class="row">
                    <input type="submit" value="Submit">
                </div>
            </form>
        </div>
    </body>
</html>
