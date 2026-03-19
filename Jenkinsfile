pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "myapp:latest"
        CONTAINER_NAME = "myapp-container"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Building Maven project..."
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running tests..."
                    bat 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    echo "Packaging JAR..."
                    bat 'mvn package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image..."
                    bat 'docker build -t %DOCKER_IMAGE% .'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                script {
                    echo "Deploying container..."
                    bat '''
                        docker rm -f %CONTAINER_NAME% || echo "No existing container"
                        docker run -d -p 9090:8080 --name %CONTAINER_NAME% %DOCKER_IMAGE%
                    '''
                }
            }
        }
    }

    post {
        always {
            echo "Pipeline finished."
        }
    }
}