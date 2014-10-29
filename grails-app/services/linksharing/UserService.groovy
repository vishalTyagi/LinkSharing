package linksharing

import com.linkSharing.User
import com.linkSharing.UserCO
import grails.transaction.Transactional
///media/intelligrape/Data1/BootCamp/projects/LinkSharing/src/groovy/com.linkSharing.UserCO.groovy
@Transactional
class UserService {

    def asynchronousMailService
    def serviceMethod() {

    }

    void sendMail(String email,String topics){
        asynchronousMailService.sendMail{
            to email
            subject "Invitation to subscribe ${topics}"
            body "Hi, I have invited you to subscribe related topic."
        }
    }

    def registerUser(UserCO userCO){
        if(!userCO.imagePath)
            userCO.imagePath = "../images/blankuser.png"
        User user1 = new User()
        if(userCO.validate()){
            user1.properties = userCO.properties;
            user1.save(flush: true)
            return user1
        }else{
            return user1.errors;
        }
        return user1
    }
}
