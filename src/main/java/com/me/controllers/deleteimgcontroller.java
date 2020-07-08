package com.me.controllers;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.me.DAO.BookDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Lord Aegon
 */
public class deleteimgcontroller extends AbstractController {

    @Autowired
    private AmazonS3 s3client;

    @Value("http://webapp.anish.kapuskar.s3-website-us-east-1.amazonaws.com")
    private String endpointUrl;

    @Value("webapp.anish.kapuskar")
    private String bucketName;

    public deleteimgcontroller() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;


        String image = request.getParameter("image");
            String imagename = request.getParameter("imagename");
            deleteFile(imagename);


            mv= new ModelAndView("deleteSuccess","message","Image Deleted!");
                mv.addObject(imagename);
                logger.info("Delete successful");


        return mv;
    }

    public void deleteFile(final String fileName) {

        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileName);
        s3client.deleteObject(deleteObjectRequest);

    }

}