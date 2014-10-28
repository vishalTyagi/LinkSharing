<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>
    <title></title>
</head>

<body>
<div class="container container-unit">
    <div class="float-left">
        <div id="name" class="content-unit">
            <div class="row">
                <div class="col-md-3">
                    <ls:image/>
                </div>

                <div class="col-md-8">
                    <div style="margin-top: 12px;"><strong>${session.user}Vishal Kumar</strong><br>
                        <span>@vishal</span>
                    </div>

                    <div style="margin-top: 14px;">
                        <div class="float-left">subscription <br>
                            20
                        </div>

                        <div class="float-right">TOpics<br> 50</div>

                        <div class="clear-both"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="content-unit" style="height: 100px">
            <div class="div-header">
                <div class="float-left">
                    <label style="margin-top: 10px;margin-left: 10px">Topics</label>
                </div>
                <div class="float-right">
                    <div class="pull-right">
                        <form class="navbar-search ">
                            <input id="srch" type="text" class="search-query" placeholder="Search">
                        </form>
                    </div>
                </div><div class="clear-both"> </div>
            </div>

            <div>design</div>
        </div>
    </div>

    <div class="float-right">
        <div class="content-unit">
            <div class="div-header">
                <label>Profile</label>
            </div><br>

            <div>
                <g:form>
                    <dl class="dl-horizontal">
                        <dt>First Name* :</dt> <dd><g:textField name="firstName"/></dd><br>
                        <dt>Last Name* :</dt> <dd><g:textField name="LastName"/></dd><br>
                        <dt>User Name* :</dt> <dd><g:textField name="userName"/></dd><br>
                        <dt>Photo* :</dt> <dd><input type="file" name="myFile"></dd><br>
                        <dt></dt> <dd><g:submitButton name="Update"/></dd>
                    </dl>
                </g:form>
            </div>
        </div>

        <div class="content-unit">
            <div class="div-header">
                <label>Change Password</label>
            </div><br>

            <div>
                <g:form>
                    <dl class="dl-horizontal">
                        <dt>Password* :</dt> <dd><g:textField name="password"/></dd><br>
                        <dt>Confirm Password* :</dt> <dd><g:textField name="confirmPassword"/></dd><br>
                        <dt></dt> <dd><g:submitButton name="Update"/></dd>
                    </dl>
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>