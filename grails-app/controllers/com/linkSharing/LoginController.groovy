package com.linkSharing

class LoginController {

    def index() {
        println '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<'
        println params.userName
        println params.passWord
        println '>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
        render "User login successfully..."
    }
    def checkLogin(){
        User user = User.findByUserName(params.username)
        if(user){
            if (user.passWord.equals(params.password)) {
                redirect controller: 'user', action: 'loginHandler',params: [user: user.id]
            }else{
                render "Wrong Password !!!"
            }
        }
        else
            render "Wrong Username !!!"
    }

    def logout(){
        session.invalidate()
        redirect controller: 'home', action: 'index'
    }
    def forgotPassword(){
        render view: '/topic/topic'
    }

}