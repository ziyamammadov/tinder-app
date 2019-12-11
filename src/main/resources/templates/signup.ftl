<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        input[type=email],input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 20px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=email]:focus,input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        input[type=submit] {
            background-color: #007bff;
            border-radius: 5px;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        input[type=submit]:hover {
            opacity: 1;
        }

        .signupbtn {
            float: left;
            width: 100%;
        }

        .container {
            padding: 70px;
        }

        .modal {
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: white;
            padding-top: 30px;
            padding-right: 330px;
            padding-left: 330px;
        }

        .error {
            color: #D8000C;
            background-color: #FFBABA;
            width: 100%;
            padding: 15px;
            margin: 20px 0 22px 0;
            display: inline-block;
            border-radius: 5px;
        }

        .success{
            color: #4F8A10;
            background-color: #DFF2BF;
            width: 100%;
            padding: 15px;
            margin: 20px 0 22px 0;
            display: inline-block;
            border-radius: 5px;
        }

        .warning{
            color: #9F6000;
            background-color: #FEEFB3;
            width: 100%;
            padding: 15px;
            margin: 20px 0 22px 0;
            display: inline-block;
            border-radius: 5px;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }
    </style>
</head>
<body>
<div class="modal">
    <form method="post" class="modal-content">
        <div class="container">
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>
            <label><b>Email</b></label>
            <input type="email" placeholder="Enter Email" name="email" required>

            <label><b>Name</b></label>
            <input type="text" placeholder="Enter Name" name="name" required>

            <label><b>Surname</b></label>
            <input type="text" placeholder="Enter Surname" name="surname" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
            <div class="clearfix">
                <input type="submit" class="signupbtn" value="Sign Up"></input>
            </div>
            ${message!''}
            <a href="/login" style="text-decoration: none;color: #007bff">Back to login menu.</a>
        </div>
    </form>
</div>

</body>
</html>                                		                            