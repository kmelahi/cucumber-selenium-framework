pipeline {
  agent any

  options {
    timestamps()
    disableConcurrentBuilds()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        bat 'mvn -U -DskipTests clean package'
      }
    }

    stage('Test') {
      steps {
        bat 'mvn -U test -Dheadless=true -Dbrowser=chrome'
      }
    }

    stage('Publish Reports') {
      steps {
        junit 'target/surefire-reports/*.xml'
        archiveArtifacts artifacts: 'target/cucumber-reports/**', allowEmptyArchive: true
      }
    }
  }

  post {
    always {
      echo "Done."
    }
  }
}
