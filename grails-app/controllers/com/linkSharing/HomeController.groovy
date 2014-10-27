package com.linkSharing

class HomeController {

    def index() {
        if(!session.user){
            render view: 'home'
        }else{
            dashBoard()
        }

    }

    def dashBoard(){
        render view: 'dashBoard'
    }
}
