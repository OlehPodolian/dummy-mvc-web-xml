pipeline {
    agent any
    stages {
         stage('Build') {
            steps {
                echo 'mvn -version'
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving ....'
                    archiveArtifacts artifacts: '**/target/*.war'
                 }
             }
         }
    }
}
