
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/static/css/style.css">
</head>

<body class="text-center">
    <form method="post" class="form-signin">
        <img class="mb-4" src="https://cdn.onlinewebfonts.com/svg/img_382078.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="psw" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button><br>
        ${message!''}
        <label><a href="/register">Don't you have an account? Click here to register.</a></label>
        <p class="mt-5 mb-3 text-muted">&copy; Tinder 2018</p>
    </form>
</body>
</html>