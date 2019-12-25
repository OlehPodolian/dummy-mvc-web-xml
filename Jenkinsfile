pipeline {
    agent any
    stages {
         stage('Build') {
            steps {
                sh 'source ~/.bash_profile'
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
