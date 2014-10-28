import grails.validation.Validateable

@Validateable
class UserCO {
    String email
    String firstName
    String userName
    String lastName
    String password
    String confirmPassword

    static constraints = {
        email email: true,blank: false,unique: true,nullable: false
        userName blank: false, unique: true
        password(validator: { val, obj ->
            if(val?.equals(obj.confirmPassword)) {
            }
            else
                return false
        })
    }
}
