package linksharing

import com.linkSharing.*
import com.linkSharing.TopicCo
import grails.transaction.Transactional

@Transactional
class TopicService {

    def createTopic(TopicCo topicCo,Long id){
        User user = User.get(id)
        Topic topic = new Topic()
        if(topicCo.validate()) {
            topic.properties = topicCo.properties
            topic.createdBy = user
            createSubscription(user, topic, getSeriousNessForSelfCreatedTopic())
            return  topic.save(flush: true)
        }else{
             println topicCo.errors
        }
        return topic
    }

    Subscription createSubscription(User user,Topic topic,SeriousNess seriousness){
        Subscription subscription = new Subscription(topic: topic,user: user,seriousness:seriousness)
        return subscription
    }

    SeriousNess getSeriousNessForSelfCreatedTopic(){
        SeriousNess.SERIOUS
    }
    Visibility getVisibility(){
        Visibility.PUBLIC
    }
}
