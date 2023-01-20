<%-- 
    Document   : index
    Created on : 17 janv. 2023, 15:51:14
    Author     : farah.gauduin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Agenda Web App</title>
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
                max-width: 300px;
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
                text-decoration: none;
                font-size: 22px;
                color: white;
            }

            button:hover, a:hover {
                opacity: 0.7;
            }

        </style>
    </head>
    <body>
        <div class="header">
            <h1>Welcome to your digital Agenda</h1>
            <p>Explore all your options below !</p>
        </div>
        <div class="row container">
            <div class="column">

                <div class="card">
                    <img src="https://standardbeagle.com/wp-content/uploads/2016/06/client-meeting.jpg" style="width:100%">
                    <h1>Resgistered Customers</h1>
                    <p class="title">View, update and delete</p>
                    <div style="margin: 24px 0;">
                    </div>
                    <p><button><a href="/all-customers">Check Customers</a></button></p>
                </div>

            </div>
            <div class="column">

                <div class="card">
                    <img src="https://static.vecteezy.com/system/resources/previews/001/977/224/original/gps-map-with-pin-illustration-free-vector.jpg"  style="width:100%">
                    <h1>Registered Addresses</h1>
                    <p class="title">View and search data</p>
                    <div style="margin: 24px 0;">
                    </div>
                    <p><button><a href="/all-addresses">Check Addresses</a></button></p>
                </div>

            </div>
            <div class="column">

                <div class="card">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8RSaCMCTAXNasW_pKiOxboRvqjZmPCmbcsNc-cQw1SYgb2hPERANwLeotZEfMqV4oSxM&usqp=CAU" style="width:100%">
                    <h1>Manage your Agenda</h1>
                    <p class="title">Add data</p>
                    <div style="margin: 24px 0;">
                    </div>
                    <p><button><a href="/manage-agenda">Manage Agenda</a></button></p>
                </div>

            </div>
        </div> 

    </body>
</html>
