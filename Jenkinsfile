pipeline {
    agent any
    tools {
        maven 'local MVN'
    }
    stages {
         stage('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving ....'
                    archiveArtifacts artifacts: '**/target/*.war'
                 }
             }
         }
         stage('Deploy to staging') {
            steps {
                build job: 'tomcat-deploy'
            }
         }
         stage('Deploy to production') {
            steps {
                timeout(time: 5, unit:'DAYS') {
                    input message: 'Approve production Deploy'
                }

                build job: 'deploy-to-prod'
            }
            post {
                success {
                    echo 'Code deployed to production.'
                }

                failure {
                    echo 'Deploy failure'
                }
            }
         }
    }
}
