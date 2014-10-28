<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>

    <title>Link Sharing</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <style>
    .form-element {
        margin-left: 70px;
    }

    .form-element label {
        display: inline-block;
        width: 150px;
    }

    .form-element input {
    / / width : 200 px;
    }
    </style>
</head>

<body>
<div class="container container-unit">
    <div class="float-left">
        <div class="content-unit" style="height:43%">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Recent Shares</label>
            </div>

            <div style="max-height: 90%;overflow-y: auto;overflow-x:hidden">
                <ls:recentShares/>
            </div>
        </div>

        <div class="content-unit" style="height:43%">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Recent Posts</label>
                <g:select style="margin-top: 4px;margin-right: 10px" class="pull-right" name="drop"
                          from="['Today', '1 Week', '1 Month', '1 Year']"/>
            </div><br>

            <div>
                <ls:topPosts/>
            </div>
        </div>
    </div>

    <div class="float-right">
        <div class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Login</label>
            </div><br>

            <div>
                <g:form name="loginForm" controller="login" action="checkLogin">
                    <dl class="dl-horizontal">
                        <dt>Username :</dt> <dd><g:textField name="username"/></dd><br><br>
                        <dt>Password :</dt> <dd><g:passwordField name="password"/></dd><br>
                        <dt></dt> <dd><g:link name="link" controller="login"
                                              action="forgotPassword">forgot password </g:link> <g:submitButton
                            class="btn-group-sm" name="submit" value="Login"/></dd>
                    </dl>
                </g:form></div>
        </div>


        <div class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Registration</label>
            </div><br>
            <g:form name="registerForm" controller="user" action="register">
                <div>
                    <dl class="dl-horizontal">
                    <dt>First name :</dt> <dd><g:textField name="firstName"/></dd><br>
                    <dt>Last name :</dt> <dd><g:textField name="lastName"/></dd><br>
                    <dt>E-mail :</dt> <dd><g:textField name="email"/></dd><br>
                    <dt>Username :</dt> <dd><g:textField name="userName"/></dd><br>
                    <dt>Password :</dt> <dd><g:textField name="password"/></dd><br>
                    <dt>Confirm password:</dt> <dd><g:textField name="confirmPassword"/></dd><br>
                    <dt>Photo :</dt> <dd><input type="file" name="myFile"/></dd><br>
                    <dt></dt> <dd><g:submitButton name="Register"/></dd>
                </dl>

            </g:form>
        </div>
    </div>

</div>

<div class="clear-both"></div>
</div>
</body>
</html>