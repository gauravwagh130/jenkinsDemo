pipeline {
    agent any

    tools {
        jdk 'JDK-21'          // must match Manage Jenkins → Tools
        maven 'Maven-3'
    }

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Stop Old App') {
            steps {
                bat '''
                echo Stopping old Spring Boot app if running...
                taskkill /F /IM java.exe || exit 0
                '''
            }
        }

        stage('Run App') {
            steps {
                bat '''
                echo Starting Spring Boot app...
                start "" java -jar target\\JenkinsDemo-0.0.1-SNAPSHOT.jar
                '''
            }
        }
    }
}
