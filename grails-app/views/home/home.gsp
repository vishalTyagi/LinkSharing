<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>

    <title>Link Sharing</title>

    %{--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">--}%
</head>

<body>
<ls:header/>
<div class="container container-unit">
    <div class="float-left">
        <div class="content-unit" style="height:40%">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Recent Shares</label>
            </div><br>

            <div style="overflow: auto">
                <ls:recentShares/>
            </div>
        </div>

        <div class="content-unit" style="height:40%">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Recent Posts</label>
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
                    <ul class="ul-class">
                        <li>Username :              <g:textField name="username"/></li><br>
                        <li>Password :              <g:passwordField name="password"/></li><br>
                        <li><g:link name="link" controller="login"
                                    action="forgotPassword">forgot password..</g:link><g:submitButton
                                class="btn-group-sm" name="submit" value="Login"/></li>
                    </ul>
                </g:form></div>
        </div>


    <div class="content-unit">
        <div class="div-header">
            <label style="margin-top: 4px;margin-left:10px;">Registration</label>
        </div><br>
        <g:form name="registerForm" controller="user" action="register">
            <div>
                <ul class="ul-class">
                    <li>First name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <g:textField
                            name="firstName"/></li><br>
                    <li>Last name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <g:textField
                            name="lastName"/></li><br>
                    <li>E-mail&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <g:textField
                            name="email"/></li><br>
                    <li>Username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <g:textField
                            name="userName"/></li><br>
                    <li>Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <g:textField
                            name="passWord"/></li><br>
                    <li>Confirm password: <g:textField name="confirmPassword"/></li><br>
                    <li><g:submitButton name="Register"/>
                </ul>
            </div>
        </g:form>
    </div>
</div>

</div>
<div class="clear-both"></div>
</div>
</body>
</html>