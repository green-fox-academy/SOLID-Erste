pipeline {

  agent any

  environment {
    registry = "greisz/erste"
    registryCredential = 'greisz-dockerhub'
    dockerImage = ''
  }

  stages {
    stage('Build') {
      steps {
        sh './gradlew build'
      }
    }

    stage('Docker deploy') {
      when{
          branch 'Docker'
      }
      steps {
        script {
          dockerImage = docker.build registry + ":dev-latest"
        }
        script {
          docker.withRegistry('', registryCredential ) {
            dockerImage.push('latest')
          }
        }
      }
    }
  }
}
