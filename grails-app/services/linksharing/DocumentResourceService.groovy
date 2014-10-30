package linksharing

import com.linkSharing.*
import grails.transaction.Transactional

@Transactional
class DocumentResourceService {

    def linkResourceService
    String docDirPath = "./web-app/images/docDir"
    File dir = new File(docDirPath)
    DocumentResource createDocumentResource(DocumentResourceCO resourceCO,String topicName,Long userId){
        if(!dir.exists()){
            dir.mkdir()         // move to bootstrap
        }
        resourceCO.myFile.transferTo(new File(dir,resourceCO.myFile.getOriginalFilename()))
        String filePath = "${docDirPath}/${resourceCO.myFile.getOriginalFilename()}"
        User user = User.get(userId)
        Topic topic = Topic.findByName(topicName)
        DocumentResource resource = new DocumentResource()
        if(resourceCO.validate()){
            resource.filePath = filePath
            resource.description = resourceCO.description
            resource.createdBy = user
            resource.topic = topic
            resource.addToResourceRatings(linkResourceService.createResourceRating(0,user))
            resource.addToReadItems(linkResourceService.createReadingItem(false,user))
            return resource.save(flush: true,failOnError: true)
        }else{
            resourceCO.errors
        }
        return resource
    }
}
