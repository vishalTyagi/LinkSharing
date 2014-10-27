<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>
    <title>DashBoard</title>
    <style type="text/css">
    .send_invite {
        height: 175px;
    }

    #inbox {
        height: 150px;
    }

    .resource {
        height: 250px;
    }

    #name {
        height: 110px;
        border-radius: 10px;
    }
    </style>
</head>

<body>
<ls:header/>
<div class="container container-unit">
    <div class="float-left">
        <div id="name" class="content-unit">
            <div>
                <div class="col-md-4">
                    <a href="#"> <img src="../images/blankuser.png" heigth="100" width="100"></a>
                </div>
                <div class="col-md-8">
                    <span>${session.user}Vishal Kumar</span><br>
                    <span>subscription  topics</span>
                </div>
            </div>
        </div>

        <div class="content-unit send_invite">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">subscription</label>
            </div><br>

            <div style="overflow: auto">
                topic info. are shown
            </div>
        </div>

        <div class="content-unit resource">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Trending Topics</label>
            </div><br>

            <div style="overflow: auto">
                topic info. are shown
            </div>
        </div>

        <div id class="content-unit send_invite">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Send invitation</label>
            </div><br>

            <div style="overflow: auto">
                <g:form >
                    <ul class="ul-class">
                        <li>Email* : <g:textField name="email"/></li><br>
                        <li>Topic* : <g:select name="topics" from="topicList"/></li><br>
                        <li><g:submitButton name="Invite"/></li>
                    </ul>
                </g:form>
            </div>
        </div>

        <div class="content-unit send_invite">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Create Topics</label>
            </div><br>

            <div style="overflow: auto">
                <g:form >
                    <ul class="ul-class">
                        <li>Name* : <g:textField name="topicName"/></li><br>
                        <li>Visibility* : <g:select name="visibility" from="list"/></li><br>
                        <li><g:submitButton name="Save"/></li>
                    </ul>
                </g:form>
            </div>
        </div>
    </div>

    <div class="float-right">
        <div id="inbox" class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Inbox</label>
            </div><br>

            <div style="overflow: auto">
                topic info. are shown
            </div>
        </div>

        <div class="content-unit resource">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Share Link</label>
            </div><br>

            <div style="overflow: auto">
                <g:uploadForm action="upload" method="post">
                    <ul class="ul-class">
                        <li>Link* : <g:textField name="url"/></li><br>
                        <li>Description* : <g:textArea name="description"/></li><br>
                        <li>Topic : <g:select name="topics" from="topicList"/></li><br>
                        <li><g:submitButton name="Share"/></li>
                    </ul>
                </g:uploadForm>
            </div>
        </div>

        <div class="content-unit resource">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Share Document</label>
            </div><br>

            <div style="overflow: auto">
                <g:uploadForm action="upload" method="post">
                    <ul class="ul-class">
                        <li><input type="file" name="myFile" /></li><br>
                        <li>Description* : <g:textArea name="description"/></li><br>
                        <li>Topic : <g:select name="topics" from="topicList"/></li><br>
                        <li><g:submitButton name="Share"/></li>
                    </ul>
                </g:uploadForm>
            </div>
        </div>
    </div>
    <div class="clear-both"> </div>
</div>
</body>
</html>