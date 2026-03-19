pipeline {
    agent any
    tools {
        maven 'Maven3'   // Name in Jenkins for Maven (pointing to C:\Program Files\apache-maven-3.9.14)
        jdk 'JDK11'      // Name in Jenkins for JDK (pointing to C:\Program Files\Java\jdk-21.0.10)
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Joyce-0111/CI---Demo'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit '**\\target\\surefire-reports\\*.xml'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
            post {
                always {
                    jacoco execPattern: '**\\target\\jacoco.exec'
                }
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
    }
    post {
        success {
            echo 'Build, Test, Coverage, and Package completed successfully!'
        }
        failure {
            echo 'Something went wrong. Check the console output.'
        }
    }
}