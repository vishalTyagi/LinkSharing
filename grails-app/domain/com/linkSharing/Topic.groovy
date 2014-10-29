package com.linkSharing

class Topic {
    String name
    enum visibility{Public,Private}
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy:User]
    static hasMany = [resources:Resource, subscriptions:Subscription]

    static constraints = {
        name unique: true
    }
}

