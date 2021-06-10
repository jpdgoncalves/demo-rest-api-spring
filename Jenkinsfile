pipeline {
    environment {
        registry = "luisferreira1998/demo-spring-rest-api"
        registryCredential = 'esp53-dockerhub'
        dockerImage = ''
        containerName = 'esp53-spring-demo-api'
        sshCommandPrefix = 'ssh -o StrictHostKeyChecking=no esp53@192.168.160.87'
    }
    agent any
    stages {
        stage('Building Jar File') {
            agent {
                docker {
                    image "maven:3.8.1-openjdk-11"
                }
            }
            steps {
                sh "mvn package"
                stash includes: "**/target/*.jar", name: "app"
            }
        }
        stage('Testing Jar File') {
            agent {
                docker {
                    image "maven:3.8.1-openjdk-11"
                }
            }
            steps {
                sh "mvn test"
                junit "target/surefire-reports/*.xml"
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
                sshagent(credentials: ["esp53_ssh_key"]) {
                    sh "$sshCommandPrefix docker stop $containerName || echo Container $containerName isnt running"
                    sh "$sshCommandPrefix docker rm $containerName || echo Container $containerName doesnt exist"
                    sh "$sshCommandPrefix docker rmi $registry || echo image $registry doesnt exist"
                    sh "$sshCommandPrefix docker pull $registry:$BUILD_NUMBER"
                    sh "$sshCommandPrefix docker create -p 53999:8080 --name $containerName $registry:$BUILD_NUMBER"
                    sh "$sshCommandPrefix docker start $containerName"
                }
            }
        }
    }
}