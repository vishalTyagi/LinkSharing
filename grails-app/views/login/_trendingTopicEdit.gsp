<br>
<div class="row">
    <div class="col-md-2">
        <ls:image/>
    </div>
    <div class="col-md-9">
        <div style="margin-left: 18px">
            <g:form>
                <g:textField name="topic" value="topic" style="width:300px"/>
                <g:submitButton name="Save" style="width:90px"/>
            </g:form>
        </div>
        <div>
            <div class="float-left">
                <span style="margin-left: 19px">@vishal</span>
            </div>
            <div class="float-right">
                <div class="float-left">
                    <span >Subscription</span><br>20
                </div>
                <div class="float-right">
                    <span>Topics</span><br> 10
                </div>
                <div class="clear-both"> </div>
            </div><div class="clear-both"> </div>
        </div>
        <div>
            <div class="col-md-8">
                <g:select name="seriousness" from="${com.linkSharing.SeriousNess.values()}" value="${values}"/>&nbsp;
                <g:select name="visibility" from="${com.linkSharing.Visibility.values()}" value="${visibility}"/>
            </div>
            <div class="col-md-4">
                <div class="pull-right">
                    <g:link><span class="glyphicon glyphicon-envelope"></span> </g:link>&nbsp;
                    <g:link><span class="glyphicon glyphicon-edit"></span> </g:link>&nbsp;
                    <g:link><span class="glyphicon glyphicon-trash"></span> </g:link>
                </div>
            </div>
        </div>
    </div>
</div>