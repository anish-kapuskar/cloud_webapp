package com.me.controllers;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SNSUtil {

    @Value("")
    private String snsTopicARN;

    @Value("")
    private String awsAccessKey;

    @Value("")
    private String awsSecretKey;

    @Value("us-east-1")
    private String awsRegion;

    private AmazonSNS amazonSNS;


    @PostConstruct
    private void postConstructor() {

    AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
                new BasicAWSCredentials(awsAccessKey, awsSecretKey)
        );

        this.amazonSNS = AmazonSNSClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion)
                .build();
    }

    public void publishSNSMessage(String message) {

        PublishResult result = this.amazonSNS.publish(this.snsTopicARN, message);

    }
}
