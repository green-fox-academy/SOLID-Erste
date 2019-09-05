pipeline {

  agent any

  environment {
    registry = "greisz/erste"
    registryCredential = 'greisz-dockerhub'
  }

  stages {
    stage('Build') {
      steps {
        sh './gradlew build --rerun tasks'
      }
    }

    stage('Docker deploy') {
      when{
          branch 'dev'
      }
      steps {
        script {
          dockerImage = docker.build registry + ":dev-latest"
        }
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
          }
        }
      }
    }
  }
}
