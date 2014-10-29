package linksharing

import com.linkSharing.*
import grails.transaction.Transactional

@Transactional
class LinkResourceService {

    def serviceMethod() {

    }

    def createLinkResource(LinkResourceCO linkResourceCO,String topicName,String userId){
        Topic topic = Topic.findByName(topicName)
        User user = User.get(userId)
        Resource linkResource = new LinkResource()
        if(linkResourceCO.validate()){
            linkResource.properties = linkResourceCO.properties
            linkResource.createdBy = user
            linkResource.topic = topic
            linkResource.addToReadItems(createReadingItem(false,user))
            linkResource.addToResourceRatings(createResourceRating(0,user))
            println "inside if >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
            linkResource.save(flush: true)
        }else{
            println linkResourceCO.errors
        }
        return linkResource
    }

    def createResourceRating(int score,User user){
        ResourceRating rating = new ResourceRating(score: score,user: user)
        return rating
    }
    def createReadingItem(boolean isRead, User user){
        ReadingItem item = new ReadingItem(isRead: isRead, user: user)
        return item
    }
}
