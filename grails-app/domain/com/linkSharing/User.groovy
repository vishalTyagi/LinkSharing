package com.linkSharing

import org.apache.tools.ant.types.resources.comparators.Date

class User {
    String email
    String firstName
    String userName
    String lastName
    String password
    boolean active
    boolean admin

    java.util.Date dateCreated
    java.util.Date lastUpdated
    static hasMany = [subscriptions:Subscription,topics:Topic,resourceRatings:ResourceRating,resourceItems:ReadingItem]


    static constraints = {
        email email: true,blank: false,unique: true,nullable: false
        userName blank: false, unique: true
        password blank: false
    }

    static mapping = {
        table('people')
    }

    static void validateAndSave(User user){
        user.validate()
        if(user.hasErrors()){
            println user.errors
        }else{
            user.save(flush: true)
        }
    }
}
