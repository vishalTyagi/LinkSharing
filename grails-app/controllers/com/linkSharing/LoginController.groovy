package com.linkSharing

class LoginController {

    def index() {
    }
    def checkLogin(){
        User user = User.findByUserName(params.username)
        if(user){
            if (user.password.equals(params.password)) {
                redirect controller: 'user', action: 'loginHandler',params: [userId: user.id]
            }else{
                render "Wrong Password !!!"
            }
        }
        else
            render "Wrong Username !!!"
    }

    def showHome(){
        if(session.user){
            render view: '/home/dashBoard'
        }else{
            render view: '/home/home'
        }
    }

    def logout(){
        session.invalidate()
        redirect controller: 'home', action: 'index'
    }
    def forgotPassword(){
        render view: '/topic/topic'
    }

}
