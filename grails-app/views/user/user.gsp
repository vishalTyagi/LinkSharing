
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>
    <title>User Profile</title>

</head>

<body>
<div class="container container-unit">
    <div class="float-left">
        <div id="name" class="content-unit" style="border-radius: 17px">
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
        <div class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Topics</label>
            </div>
            <div style="height: 100px"> Grails  SUbscription posts</div>
            <div style="border-top: 1px solid grey;height: 100px"> helo</div>
        </div>
    </div>
    <div class="float-right">
        <div id="inbox" class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Posts</label>
            </div><br>

            <div>
                POsts
            </div>
        </div>
    </div>
</div>

</body>
</html>