package com.linkSharing

abstract class Resource {
    User createdBy
    String description
    Date dateCreated
    Date lastUpdated

    static belongsTo = [topic:Topic]

    static hasMany = [readItems:ReadingItem, resourceRating:ResourceRating]
    static constraints = {
        description size: 0..1024
    }


}
