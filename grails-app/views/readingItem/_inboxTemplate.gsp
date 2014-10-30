<div class="row">
    <div class="col-md-2"><ls:image /></div>
    <div class="col-md-9" style="margin-top: 7px">
        <div class="float-left"> ${name} @${resource.createdBy.userName} </div>
        <div class="float-right"><div class="pull-right">
            <g:link action="showTopic" controller="topic" params="[topicId:resource.getTopic().id]">

                ${resource.getTopic().name}
            </g:link>
        </div></div>

        <div class="clear-both"></div>
        <div> ${resource.description} </div>
        <div class="float-left"><i>t</i><i>f</i><i>g</i> </div>
        <div class="float-right"><div class="pull-right"> <a href="#">view post</a></div> </div>
        <div class="clear-both"></div>
    </div>
</div>
