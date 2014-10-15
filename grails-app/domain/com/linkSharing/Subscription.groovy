package com.linkSharing

import org.apache.tools.ant.types.resources.comparators.Date

class Subscription {

    static belongsTo = [user:User, topic:Topic]
    enum seriousness{Serious,VerySerious,Casual}
    java.util.Date dateCreated

    static constraints = {
    }
}
