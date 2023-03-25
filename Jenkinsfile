pipeline {
    agent any

    tools {
        maven "maven3.8.7"
    //    sonar "sonar_scanner4.8.0.2856"
   //sonar_token squ_80a9d90b556bf1107ab4d5b26cb73ffc4fbf9a79
    }

    stages {
         stage('Test') {
            steps {
                echo ' -- Testing project --'
                bat 'mvn sonar:sonar -Dsonar.login=squ_80a9d90b556bf1107ab4d5b26cb73ffc4fbf9a79'
            }
        }
         stage('Compile') {
            steps {
                echo ' -- Compile project --'
                bat 'mvn clean compile'
            }
        }
        stage('Deploy') {
            steps {
                echo ' -- Deploying project --'
                bat "docker build -t img_mediatech:1.${env.BUILD_NUMBER} ."
                bat "docker tag img_mediatech:1.${env.BUILD_NUMBER} img_mediatech:1.${env.BUILD_NUMBER}"
            }
        }
         stage('Run Container') {
            steps {
                echo ' -- Deploying project --'
                bat "docker run -d -p 8080:8080 --name c_mediatech img_mediatech:1.${env.BUILD_NUMBER}"
            }
        }
    }
}