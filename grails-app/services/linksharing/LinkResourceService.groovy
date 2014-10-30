package linksharing

import com.linkSharing.*
import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def serviceMethod() {

    }

    LinkResource createLinkResource(LinkResourceCO linkResourceCO,String topicName,Long userId){
        println topicName
        Topic topic = Topic.findByName(topicName)
        println "${topic}_______________________________________________"
        User user = User.get(userId)
        LinkResource linkResource = new LinkResource()
        if(linkResourceCO.validate()){
            linkResource.url = linkResourceCO.url
            linkResource.description = linkResourceCO.description
            linkResource.createdBy = user
            linkResource.topic = topic
            linkResource.addToReadItems(createReadingItem(false,user))
            linkResource.addToResourceRatings(createResourceRating(0,user))
            println "inside if >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
            return linkResource.save(flush: true,failOnError: true)
        }else{
            println linkResourceCO.errors
        }
        return linkResource
    }

    ResourceRating createResourceRating(int score,User user){
        ResourceRating rating = new ResourceRating(score: score,user: user)
        return rating
    }
    ReadingItem createReadingItem(boolean isRead, User user){
        ReadingItem item = new ReadingItem(isRead: isRead, user: user)
        return item
    }
}
