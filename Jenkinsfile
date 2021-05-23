pipeline {
  agent {
    docker {
      image 'maven:3.8.1-openjdk-11'
    }

  }
  stages {
    stage('Initialize') {
      steps {
        sh '''echo PATH = ${PATH}
echo M2_HOME = ${M2_HOME}
mvn clean'''
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }

    stage('Report') {
      steps {
        junit 'target/surefire-reports/*.xml'
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}