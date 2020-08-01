#!/bin/bash

sudo su

cd /var/lib/tomcat9/webapps
sudo cp -r amazon-cloudwatch-agent.json /opt/aws/amazon-cloudwatch-agent/etc/
sudo /opt/aws/amazon-cloudwatch-agent/bin/amazon-cloudwatch-agent-ctl \
    -a fetch-config \
    -m ec2 \
    -c file:/opt/aws/amazon-cloudwatch-agent/etc/amazon-cloudwatch-agent.json \
    -s
sudo systemctl restart amazon-cloudwatch-agent


