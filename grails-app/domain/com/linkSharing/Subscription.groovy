package com.linkSharing

class Subscription {

    static belongsTo = [user:User, topic:Topic]
    SeriousNess seriousness
    java.util.Date dateCreated

    static constraints = {
    }
}
