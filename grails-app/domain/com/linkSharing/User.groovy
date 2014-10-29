package com.linkSharing

class User {
    String email
    String firstName
    String userName
    String lastName
    String password
    boolean active
    boolean admin
    String imagePath

    java.util.Date dateCreated
    java.util.Date lastUpdated
    static hasMany = [subscriptions:Subscription,topics:Topic,resourceRatings:ResourceRating,resourceItems:ReadingItem]


    static constraints = {
        email email: true,blank: false,unique: true,nullable: false
        userName blank: false, unique: true
        password blank: false
        imagePath nullable: true
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
