package com.linkSharing

class DocumentResource extends Resource{
    String filePath
    static constraints = {
        filePath nullable: false
    }
}
