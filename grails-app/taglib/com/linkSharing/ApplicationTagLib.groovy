package com.linkSharing

class ApplicationTagLib {
    static defaultEncodeAs = [taglib: 'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = "ls"

    def showInbox = { attrs ->
        User user = User.get(session.user)
        String name = "${user?.firstName} ${user?.lastName}"
        List<ReadingItem> items = ReadingItem.findAllByUserAndIsRead(user,false)
        items.each{
            Resource resource = it.resource
            out << g.render(template: '/readingItem/inboxTemplate',model: [resource:resource,name:name])
        }
     }
    def userInfo = {attrs ->
        User user = User.get(session.user)
        String name = "${user.firstName} ${user.lastName}"
        int subsSize = 0
        int topicSize = 0
        if(user.subscriptions){
            subsSize = user.subscriptions.size()
        }
        if(user.topics){
            topicSize = user.topics.size()
        }
        out << g.render(template: '/home/nameTemplate',model: [name: name,userName:user.userName,user:user,subscription:subsSize,topic:topicSize])
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