package com.linkSharing

class Topic {
    String name
    Visibility visibility
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy:User]
    static hasMany = [resources:Resource, subscriptions:Subscription]

    static constraints = {
        name unique: true
    }
}

