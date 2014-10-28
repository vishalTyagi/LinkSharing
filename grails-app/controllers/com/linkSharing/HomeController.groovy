package com.linkSharing

import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile

class HomeController {

    def index() {
        if(!session.user){
            render view: 'home'
        }else{
            dashBoard()
        }

    }

    def dashBoard(){
        render view: 'dashBoard'
    }

    def upload(){
        if(request instanceof MultipartHttpServletRequest)
        {
            MultipartHttpServletRequest mpr = (MultipartHttpServletRequest)request;
            CommonsMultipartFile f = (CommonsMultipartFile) mpr.getFile("myFile");
            if(!f.empty) {
                f.transferTo(new File("./web-app/images/doc4.txt"))
                render "${f.inputStream.text}"
                // flash.message = 'success'
            }
            else
                flash.message = 'file cannot be empty'
        }
        else
            flash.message = 'request is not of type MultipartHttpServletRequest'
    }
}
