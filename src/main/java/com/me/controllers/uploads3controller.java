package com.me.controllers;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class uploads3controller {

    @Autowired
    private AmazonS3 s3client;

    @Value("http://webapp.anish.kapuskar.s3-website-us-east-1.amazonaws.com")
    private String endpointUrl;

    @Value("webapp.anish.kapuskar")
    private String bucketName;

    @RequestMapping(value = "uploads3controller.htm", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile,
                             HttpServletRequest request, HttpServletResponse response)
    {
        String fileUrl = "";
        String  status = null;
        try {

            //converting multipart file to file
            File file = convertMultiPartToFile(multipartFile);

            //filename
            String fileName = multipartFile.getOriginalFilename();

            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

            status = uploadFileTos3bucket(fileName, file);

            file.delete();

        } catch (Exception e) {

            return "UploadController().uploadFile().Exception : " + e.getMessage();

        }

        return "SellBooks";
    }



  /* @PostMapping("addBooks.htm")
   public String uploadFile(@RequestPart(value = "file") MultipartFile multipartFile) {

      String fileUrl = "";
      String  status = null;
      try {

         //converting multipart file to file
         File file = convertMultiPartToFile(multipartFile);

         //filename
         String fileName = multipartFile.getOriginalFilename();

         fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

         status = uploadFileTos3bucket(fileName, file);

         file.delete();

      } catch (Exception e) {

         return "UploadController().uploadFile().Exception : " + e.getMessage();

      }

      return status + " " +  fileUrl;
   }*/

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    private String uploadFileTos3bucket(String fileName, File file) {
        try {
            s3client.putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
        }catch(AmazonServiceException e) {
            return "uploadFileTos3bucket().Uploading failed :" + e.getMessage();
        }
        return "SellBooks";
    }

    public void deleteFile(final String fileName) {

        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName, fileName);
        s3client.deleteObject(deleteObjectRequest);

    }

}
