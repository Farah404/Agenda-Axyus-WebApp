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
        <title>Agenda Management</title>
        <style>
            /* Style the body */
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
            .column {
                float: left;
                width: 33.33%;
                padding: 10px;
                height: 300px; /* Should be removed. Only for demonstration */
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                width: 400px;
                margin: auto;
                text-align: center;
                font-family: arial;
            }

            .title {
                color: grey;
                font-size: 18px;
            }

            button {
                border: none;
                outline: 0;
                display: inline-block;
                padding: 8px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 100%;
                font-size: 18px;
            }

            a {
                all: unset;

            }

            button:hover, a:hover {
                opacity: 0.7;
            }

        </style>
    </head>
    <body>
        <div class="header">
            <h1> <a href="/" style="cursor: pointer">Welcome to your digital Agenda </a></h1>
            <p>Agenda Management</p>
        </div>

        <div class="row container">
            <div class="column">

                <div class="card">
                    <img src="https://www.ae91.fr/wp-content/uploads/2021/06/action-emploi-illue-08.jpg" style="width:100%">
                    <p><button><a href="/create-customer">Create Customer</a></button></p>
                </div>

            </div>
            <div class="column">

                <div class="card">
                    <img src="https://www.ae91.fr/wp-content/uploads/2021/06/action-emploi-illue-09.jpg"  style="width:100%">
                    <p><button><a href="/create-address">Create Address</a></button></p>
                </div>

            </div>
            <div class="column">

                <div class="card">
                    <img src="https://www.ae91.fr/wp-content/uploads/2021/06/action-emploi-illue-07.jpg" style="width:100%">
                    <p><button><a href="/all-data">See all data</a></button></p>
                </div>

            </div>
        </div> 
    </body>
</html>
