pipeline {
    environment {
        registry = "luisferreira1998/demo-spring-rest-api"
        registryCredential = 'esp53-dockerhub'
        dockerImage = ''
    }
    agent any
    stages {
        stage('Building Jar File') {
            agent {
                docker {
                    image { "maven:3.8.1-openjdk-11" }
                }
            }
            steps {
                sh "mvn package"
                stash includes: "**/target/*.jar", name: "app"
            }
        }
        stage('Building image') {
            steps {
                unstash "app"
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Publish image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
        stage("Deploy to Playground VM") {
            steps {
                sh "echo deploying"
            }
        }
    }
}