pipeline {

  agent any

  environment {
    registry = "greisz/erste"
    registryCredential = 'cb0e70eb-6db0-450b-99b5-aece738902b7'
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
