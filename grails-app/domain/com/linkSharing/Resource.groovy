package com.linkSharing


abstract class Resource {
    String description
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic:Topic,createdBy:User]

    static hasMany = [readItems:ReadingItem, resourceRatings:ResourceRating]
    static constraints = {
        description size: 0..1024
        description type:'text'
    }


}
