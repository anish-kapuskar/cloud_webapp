#!/bin/bash

sudo systemctl stop tomcat.service
sudo systemctl stop amazon-cloudwatch-agent.service

sudo rm -rf /var/lib/tomcat9/webapps

sudo chown -R tomcat:tomcat /var/lib/tomcat9/webapps

sudo systemctl start tomcat.service

