package linksharing

import com.linkSharing.User
import com.linkSharing.UserCO
import grails.transaction.Transactional

@Transactional
class UserService {

    def asynchronousMailService
    def serviceMethod() {

    }

    def sendMail(String email,String topics){
        asynchronousMailService.sendMail{
            to email
            subject "Invitation to subscribe ${topics}"
            body "Hi, I have invited you to subscribe related topic."
            // html g.render(template: "/login/headerTemplate")
        }
        render 'Mail sent'
    }

    def regidterUser(UserCO userCO){
        User user1 = new User()
        if(userCO.validate()){
            user1.properties = userCO.properties;
            user1.save(flush: true)
        }else{
            render user1.errors;
        }
        render view: 'home/dashBoard'
    }
}
