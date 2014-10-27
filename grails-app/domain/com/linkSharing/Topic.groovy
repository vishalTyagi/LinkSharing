package com.linkSharing

import spock.util.mop.Use

class Topic {
    String name
    enum visibility{Public,Private}
    Date dateCreated
    Date lastUpdated

    static belongsTo = [createdBy:User]
    static hasMany = [resources:Resource, subscriptions:Subscription]

    static constraints = {
    }
}

