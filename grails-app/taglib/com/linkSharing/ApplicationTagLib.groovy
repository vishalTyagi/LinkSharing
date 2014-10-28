package com.linkSharing

class ApplicationTagLib {
    static defaultEncodeAs = [taglib: 'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def showInbox = { attrs ->
        attrs.lsit.each {
            println "hello"
            out << g.render(template: "userTemplate")
        }

     }

    def recentShares = {attrs ->
        List topicList = Topic.list(sort:'lastUpdated')
        topicList.each{ topic ->
            out << g.render(template: "/user/userTemplate", model: [topic: topic])
        }
    }
    def topPosts = {attrs ->
        List list = ResourceRating.list();
        list.each{
            out << g.render(template: "/user/userTemplate", model:[rate:it])
        }

    }
    def header = {attrs ->
        out << g.render(template: "/login/headerTemplate")
    }

    def image = {attrs ->

        out << g.link([action:'showUser',controller:'user'],'<img src="../images/blankuser.png" heigth="100" width="100">')
    }
}