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
        <title>Create Address</title>
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
            <p><a href="/manage-agenda" style="cursor: pointer">Create customer </a></p>

        </div>
        <div class="container">
            <form method="post" action="create-address">

                <input type="text" id="addressId" name="addressId" value="" hidden>

                <div class="row">
                    <div class="col-25">
                        <label for="streetNumber">Street Number Name</label>
                    </div>
                    <div class="col-75">
                        <input type="number" id="streetNumber" name="streetNumber" value="${address.streetNumber}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="streetName">Street Name</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="streetName" name="streetName" value="${address.streetName}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="city">City</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="city" name="city" value="${address.city}" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="email">Postal Code</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="postalCode" name="postalCode" value="${address.postalCode}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="country">Country</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="country" name="country" value="${address.country}">
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
