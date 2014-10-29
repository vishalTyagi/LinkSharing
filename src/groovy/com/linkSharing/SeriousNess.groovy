package com.linkSharing

public enum SeriousNess {
    SERIOUS('Serious'),
    VERYSERIOUS('Very-Serious'),
    CASUAL('Casual')

    String displayName

    SeriousNess(String displayName){
       this.displayName=displayName
    }
}