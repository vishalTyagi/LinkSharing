package com.linkSharing

import grails.validation.Validateable
import org.codehaus.groovy.grails.validation.EmailConstraint
import groovy.*

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional


class UserController {
    def userService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
    }

    def create() {
        respond new User(params)
    }
//---------------------------------------------------------------------------------------------------------------------
    def loginHandler(){
        session.user = params.user
        redirect controller: 'home', action: 'dashBoard'
    }

    def register(UserCO user){
        userService.regidterUser(user)
    }

    def showUser(){
        render view: 'user'
    }
    def editProfile(){
        render view: 'editProfile'
    }
    //-------------------------------------------------------

    def sendMail(String email,String topics){
        userService.sendMail(email,topics);
    }

//-------------------------------------------------------------------------------------------------------------------
    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    def edit(User userInstance) {
        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
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
        password validator: { val, obj ->
            if(val?.equals(obj.confirmPassword)) {
            }
            else
                return false
        }
    }
}
