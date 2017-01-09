<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="/frame/bootstrap-3.3.7-dist/css/bootstrap.css">
  <link rel="stylesheet" href="/frame/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/boss/perm/form-elements.css">
  <link rel="stylesheet" href="/css/boss/perm/style.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
  <!-- Favicon and touch icons -->
  <link rel="shortcut icon" href="/image/boss/perm/ico/favicon.png">
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/image/boss/perm/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/image/boss/perm/ico/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/image/boss/perm/ico/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="/image/boss/perm/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
  <div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>业务运营支撑系统</strong></h1>
                    <div class="description">
                      <p>
                        登录boss系统
                      </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                  <div class="form-top">
                    <div class="form-top-left">
                      <h3>请登录boss系统</h3>
                    </div>
                    <div class="form-top-right">
                      <i class="fa fa-key"></i>
                    </div>
                    </div>
                    <div class="form-bottom">
                  <form class="login-form" role="form">
                    <div class="form-group">
                      <label class="sr-only" for="form-username">Username</label>
                        <input type="text" name="userAccount" placeholder="用户名..." class="form-username form-control" id="form-username">
                      </div>
                      <div class="form-group">
                        <label class="sr-only" for="form-password">Password</label>
                        <input type="password" name="userPwd" placeholder="密码..." class="form-password form-control" id="form-password">
                      </div>
                      <div class="form-group">
                        <label class="sr-only" for="form-password">vCode</label>
                        <input type="text" name="vCode" placeholder="验证码..." class="form-password form-control" id="form-vCode">
                      </div>
                      <button class="btn" id="login" type="button">登录</button>
                  </form>
                </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                  <h3>第三方账号登陆:</h3>
                  <div class="social-login-buttons">
                    <a class="btn btn-link-1 btn-link-1-facebook" href="#">
                      <i class="fa fa-facebook"></i> Facebook
                    </a>
                    <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                      <i class="fa fa-twitter"></i> Twitter
                    </a>
                    <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                      <i class="fa fa-google-plus"></i> Google Plus
                    </a>
                  </div>
                </div>
            </div>
        </div>
    </div>

  </div>

  <script src="/js/jquery/jquery-2.2.4.js"></script>
  <script src="/js/jquery/jquery.md5.js"></script>
  <script src="/frame/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <script src="/js/backstretch/jquery.backstretch.min.js"></script>
  <script src="/js/boss/perm/login/scripts.js"></script>
 <!--[if lt IE 10]>
      <script src="assets/js/placeholder.js"></script>
  <![endif]-->

</body>
</html>
