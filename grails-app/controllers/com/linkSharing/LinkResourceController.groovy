package com.linkSharing

import grails.validation.Validateable

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class LinkResourceController {

    def linkResourceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    //=======================================================================================

    def createLinkResource(LinkResourceCO linkResourceCO,String topic){
        def obj = linkResourceService.createLinkResource(linkResourceCO,topic,session.user)
        render "Link created"
    }
    //==================================================================================

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond LinkResource.list(params), model:[linkResourceInstanceCount: LinkResource.count()]
    }

    def show(LinkResource linkResourceInstance) {
        respond linkResourceInstance
    }

    def create() {
        respond new LinkResource(params)
    }

    @Transactional
    def save(LinkResource linkResourceInstance) {
        if (linkResourceInstance == null) {
            notFound()
            return
        }

        if (linkResourceInstance.hasErrors()) {
            respond linkResourceInstance.errors, view:'create'
            return
        }

        linkResourceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'linkResource.label', default: 'LinkResource'), linkResourceInstance.id])
                redirect linkResourceInstance
            }
            '*' { respond linkResourceInstance, [status: CREATED] }
        }
    }

    def edit(LinkResource linkResourceInstance) {
        respond linkResourceInstance
    }

    @Transactional
    def update(LinkResource linkResourceInstance) {
        if (linkResourceInstance == null) {
            notFound()
            return
        }

        if (linkResourceInstance.hasErrors()) {
            respond linkResourceInstance.errors, view:'edit'
            return
        }

        linkResourceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'LinkResource.label', default: 'LinkResource'), linkResourceInstance.id])
                redirect linkResourceInstance
            }
            '*'{ respond linkResourceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(LinkResource linkResourceInstance) {

        if (linkResourceInstance == null) {
            notFound()
            return
        }

        linkResourceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'LinkResource.label', default: 'LinkResource'), linkResourceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'linkResource.label', default: 'LinkResource'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
@Validateable
class LinkResourceCO{
    String url
    static constraints = {
        url url: true, nullable: false
    }
}