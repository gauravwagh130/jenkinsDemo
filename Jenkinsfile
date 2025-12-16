pipeline {
    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run App') {
            steps {
                bat '''
                echo Starting Spring Boot application...
                cd target
                java -jar JenkinsDemo-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }
}
