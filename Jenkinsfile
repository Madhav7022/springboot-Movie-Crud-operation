pipeline {
  agent any
  parameters {
    string(name: 'IMAGE_TAG', defaultValue: 'latest', description: 'Docker image tag')
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
  }
  stages {
    stage('Clone') {
      steps {
        git url: 'https://github.com/Madhav7022/springboot-Movie-Crud-operation.git'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Docker Build & Push') {
      steps {
        script {
          docker.withRegistry('', 'dockerhub-creds') {
            def app = docker.build("madhav7022/movie-app:${params.IMAGE_TAG}")
            app.push()
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker-compose down'
        sh 'docker-compose up -d --build'
      }
    }
  }
}
