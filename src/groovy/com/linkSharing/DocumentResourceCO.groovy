package com.linkSharing

import grails.validation.Validateable
import org.springframework.web.multipart.commons.CommonsMultipartFile

/**
 * Created by intelligrape on 30/10/14.
 */
@Validateable
class DocumentResourceCO {
    CommonsMultipartFile myFile
    String description
    static constraints = {
        description size: 0..1024
        description type:'text'
    }
}
