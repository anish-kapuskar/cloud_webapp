#!/bin/bash

sudo su

echo "export DB_HOSTNAME=csye6225-su2020.cvshnzxutmoj.us-east-1.rds.amazonaws.com">>/etc/environment
echo "export DB_HOSTNAME=csye6225-su2020.cvshnzxutmoj.us-east-1.rds.amazonaws.com">>~/.bashrc

cd /var/lib
sudo chmod -R 777 tomcat9


