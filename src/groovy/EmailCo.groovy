import grails.validation.Validateable

/**
 * Created by intelligrape on 22/10/14.
 */
@Validateable
class EmailCo {
    String email
    static constraints={
        email email:true
    }
}
