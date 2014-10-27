
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application"/>
    <title>Topic</title>
    <style>
        #topic{
            height:200px;
        }
        #user{
            height:200px;
        }
        #posts{
            height:500px;
        }
    </style>
</head>

<body>
<ls:header/>
<div class="container container-unit">
<div class="float-left">
    <div id="topic" class="content-unit">
        <div class="div-header">
            <label style="margin-top: 4px;margin-left:10px;">Topic : {TopicName}</label>
        </div><br>
        <div style="overflow: auto">
            topic info. are shown
        </div>
    </div>
    <div id="user" class="content-unit">
        <div class="div-header">
            <label style="margin-top: 4px;margin-left:10px;">Users : {TopicName}</label>
        </div><br>
        <div style="overflow: auto">
            info of user on that topic
        </div>
    </div>
</div>
<div class="float-right">
    <div id="posts" class="content-unit">
        <div class="div-header">
            <label style="margin-top: 4px;margin-left:10px;">Posts : {TopicName}</label>
        </div><br>
        <div style="overflow: auto">
            Post related to topic by users
        </div>
    </div>
</div>
<div class="clear-both"></div>
</div>
</body>
</html>