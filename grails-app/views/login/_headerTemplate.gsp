<div id ="header" class = "container">
    <div class="col-md-6">
        <div>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Link Sharing</span>
            </button>
            <a class="navbar-brand" href="#">Link Sharing</a>
        </div>
    </div>
    <div class="col-md-5 ">
        <div class="pull-right">
            <form class="navbar-search ">
                <input id="srch" type="text" class="search-query" placeholder="Search">
            </form>
        </div>
    </div>
    <div class="col-md-1" style="margin-top: 7px;">
        <ul id="drop-nav">
            <li><a href="#">User</a>
                <ul>
                    <li><a href="#">Profile</a></li>
                    <li><g:link name="signout" controller="login" action="logout">logout</g:link></li>
                </ul>
            </li>
        </ul>
    </div>
</div>