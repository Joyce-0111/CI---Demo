pipeline {
    agent any
    tools {
        maven 'Maven'   // Name of Maven installation in Jenkins
        jdk 'Java'      // Name of JDK in Jenkins
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