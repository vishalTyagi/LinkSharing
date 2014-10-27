import com.linkSharing.DocumentResource
import com.linkSharing.LinkResource
import com.linkSharing.Resource
import com.linkSharing.Subscription
import com.linkSharing.Topic
import com.linkSharing.User

class BootStrap {

    def init = { servletContext ->
        User user = createUser("vishal","kumar","v@abc.com",true,true)
        int i = 1
        5.times{
            Topic topic = createTopic("Grails"+i,"public")
            Subscription subscription = subscription("Serious")
            topic.addToSubscriptions(subscription)
            createResource("http://www.google.com",null, "demo link doc",user,topic)
            createResource(null,"/media/intelligrape/Data1","demo doc Resource",user,topic)
            user.addToTopics(topic)
            user.addToSubscriptions(subscription)
            i++
        }
        user.save()
    }
    def destroy = {
    }

    def createUser(firstName,lastName,email,active,admin){
        User user = new User(email:email,firstName: firstName,lastName: lastName,userName: firstName,passWord: lastName,active: active,admin: admin)
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
    void createResource(url,path,description,user,topic){
        Resource resource = null
        if(url){
            5.times {
                resource = new LinkResource(description: description, url: url,createdBy: user,topic: topic)
            }
        }
        if(path){
            5.times {
                resource = new DocumentResource(description: description, filePath: path, createdBy: user,topic: topic)
            }
        }
    }
}
