package com.linkSharing

import grails.validation.Validateable

@Validateable
class EmailCo {
    String email
    static constraints={
        email email:true
    }
}
