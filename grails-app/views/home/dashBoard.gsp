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
    .form-element{
        margin-left: 70px;
    }
    .form-element label {
        display: inline-block;
        width: 150px;
    }
    .form-element input{
        width:200px;
    }
    </style>
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

        <div class="content-unit send_invite">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">subscription</label>
                <label style="margin-top: 4px;margin-left: 435px"><a href="#">View All</a></label>
            </div><br>

            <div>
                <div>
                    <div class="col-md-2">
                        <a href="#"><img src="../images/blankuser.png" width="100px" height="80px"></a>
                    </div>

                    <div class="col-md-8">
                        <div>
                            <g:form name="create">
                                <g:textField style="width:250px" name="topicName"/>&nbsp;<g:submitButton name="Save"/>
                            </g:form>
                        </div>

                        <div>
                            @vishal SUbscripetion topics
                        </div>
                        <div>
                            <g:form name="subscription">
                                <dl class="dl-horizontal">
                                <dt><g:select name="seriousness" from="${com.linkSharing.Subscription.seriousness.values()}" value="${subscription}"/></dt>
                                <dd><g:select name="visiblity" from="${com.linkSharing.Topic.visibility.values()}" value="${topics}"/></dd>
                                <dt><i>m</i><i>E</i><i>del</i></dt>
                                </dl>
                            </g:form>
                        </div>
                    </div>
                </div>
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

            <div>
                <g:form name="sendInvitation" controller="user" action="sendMail" method="post">
                    <dl class="dl-horizontal">
                       <dt>Email* : </dt> <dd><g:textField name="email"/></dd><br>
                        <dt>Topic* : </dt> <dd><g:select name="topics" from="${com.linkSharing.Topic.list()?.name}" value="topics"/></dd><br>
                        <dt> </dt><dd><g:submitButton name="Invite"/></dd>
                    </dl>
                </g:form>
            </div>
        </div>

        <div class="content-unit send_invite">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Create Topics</label>
            </div><br>

            <div>
                <g:form>
                    <dl class="dl-horizontal">
                        <dt>Name*</dt>
                        <dd><g:textField name="topicName" /></dd><br/>
                        <dt>Visibility*</dt>
                        <dd><g:select name="visibility" from="${com.linkSharing.Topic.visibility.values()}" value="${topics}"/></dd><br/>
                        <dt></dt>
                        <dd><g:submitButton name="Save" /></dd>
                    </dl>
                </g:form>
            </div>
        </div>
    </div>

    <div class="float-right">
        <div id="inbox" class="content-unit">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Inbox</label>
            </div><br>

            <div>
                topic info. are shown
            </div>
        </div>

        <div class="content-unit resource">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Share Link</label>
            </div><br>

            <div>
                <g:uploadForm action="upload" method="post">
                    <dl class="dl-horizontal">
                        <dt>Link* : </dt> <dd><g:textField name="url"/></dd><br>
                        <dt>Description* : </dt> <dd><g:textArea name="description"/></dd><br>
                        <dt>Topic : </dt> <dd><g:select name="topics" from="${com.linkSharing.Topic.list()?.name}" value="${topics}"/></dd><br>
                        <dt> </dt> <dd><g:submitButton name="Share"/></dd>
                    </dl>
                </g:uploadForm>
            </div>
        </div>

        <div class="content-unit resource">
            <div class="div-header">
                <label style="margin-top: 4px;margin-left:10px;">Share Document</label>
            </div><br>

            <div style="overflow: auto">
                <g:uploadForm action="upload" method="post">
                    <dl class="dl-horizontal">
                        <dt>Document* : </dt> <dd><input type="file" name="myFile"/></dd><br>
                        <dt>Description* : </dt> <dd><g:textArea name="description"/></dd><br>
                        <dt>Topic : </dt> <dd><g:select name="topics" from="${com.linkSharing.Topic.list()?.name}" value="${topics}"/></dd><br>
                        <dt> </dt> <dd><g:submitButton name="Share"/></dd>
                    </dl>
                </g:uploadForm>
            </div>
        </div>
    </div>

    <div class="clear-both"></div>
</div>
</body>
</html>