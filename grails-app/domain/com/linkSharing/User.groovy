package com.linkSharing

import org.apache.tools.ant.types.resources.comparators.Date

class User {
    String email
    String firstName
    String userName
    String LastName
    boolean active
    boolean admin
    java.util.Date dateCreated
    java.util.Date lastUpdated
    static hasMany = [subscription:Subscription,topic:Topic,resourceRating:ResourceRating,resourceItems:ReadingItem]


    static constraints = {
        email email: true,blank: false,unique: true,nullable: false

    }

    static mapping = {
        table('people')
    }
}
