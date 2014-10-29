<style>
#name {
    height: 110px;
    border-radius: 10px;
}
</style>
<div id="name" class="content-unit">
    <div class="row">
        <div class="col-md-2">
            <ls:image/>
        </div>

        <div class="col-md-9">
            <div style="margin-top: 12px;"><strong>${name}</strong><br>
                <span>@${userName}</span>
            </div>

            <div style="margin-top: 14px;">
                <div class="float-left">subscription<br>
                    ${subscription}
                </div>

                <div class="float-right">Topics<br> ${topic}</div>

                <div class="clear-both"></div>
            </div>
        </div>
    </div>
</div>