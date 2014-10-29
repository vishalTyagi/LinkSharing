import com.linkSharing.DocumentResource
import com.linkSharing.LinkResource
import com.linkSharing.ReadingItem
import com.linkSharing.Resource
import com.linkSharing.Subscription
import com.linkSharing.Topic
import com.linkSharing.User

class BootStrap {
    def topicService
    def init = { servletContext ->
        User user = createUser("vishal","kumar","v@abc.com",true,true)
        int i = 1
        5.times{
            Topic topic = createTopic("Grails"+i,"public")
            Subscription subscription = subscription(topicService.getSeriousNessForSelfCreatedTopic())
            topic.addToSubscriptions(subscription)
            Resource resource1 = createResource(null,"./home/user","Hello this is not a correct resource it is a demo.",user)
            Resource resource2 = createResource("https://www.facebook.com",null,"this is the link resource demo",user)
            topic.addToResources(resource1)
            topic.addToResources(resource2)
            ReadingItem item = createReadingItems(user)
            ReadingItem item1 = createReadingItems(user)
            resource1.addToReadItems(item)
            resource2.addToReadItems(item1)
            user.addToTopics(topic)
            user.addToSubscriptions(subscription)
            i++
        }
        user.save()
    }
    def destroy = {
    }

    def createUser(firstName,lastName,email,active,admin){
        User user = new User(email:email,firstName: firstName,lastName: lastName,userName: firstName,password: lastName,active: active,admin: admin)
        user
    }
    def createTopic(name,visibility){
        Topic topic = new Topic(name:name,visibility:visibility)
        topic
    }
    def subscription(seriousness){
        Subscription subscription = new Subscription(seriousness:seriousness)
        subscription
    }
    def createResource(String url,String path,String description,User user){
        Resource resource = null
        if(url){
                resource = new LinkResource(description: description, url: url,createdBy: user)
        }
        if(path){
                resource = new DocumentResource(description: description, filePath: path, createdBy: user)
        }
        return resource
    }
    def createReadingItems(User user){
        ReadingItem item = new ReadingItem(isRead: false,user: user)
        return item
    }
}
