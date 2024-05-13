

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/anish-kapuskar/cloud_webapp.git'
                bat 'cd BookStoreApp && dir && mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                bat 'copy /Y "C:\\WINDOWS\\system32\\config\\systemprofile\\.m2\\repository\\com\\mycompany\\BookStoreApp\\1.0-SNAPSHOT\\BookStoreApp-1.0-SNAPSHOT.war" "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps"'
            }
        }
    }
}
