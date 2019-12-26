pipeline {
    agent any

    parameters {
        string(name: 'tomcat_dev', defaultValue: '3.136.161.118', description: 'Staging server')
        string(name: 'tomcat_prod', defaultValue: '18.222.112.249', description: 'Production server')
    }
    triggers {
        pollSCM('* * * * *')
    }
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
                    echo 'Now Archiving ...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('Deployments') {
            parallel {
                stage('Deploy to staging') {
                    steps {
                        sh 'scp -i /Users/olegpodolian/IdeaProjects/study/jenkins-study/jenkins-udemy-course/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_dev}:var/lib/tomcat8/webapps'
                    }
                }
                stage('Deploy to production') {
                    steps {
                        sh 'scp -i /Users/olegpodolian/IdeaProjects/study/jenkins-study/jenkins-udemy-course/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_prod}:var/lib/tomcat8/webapps'
                    }
                }
             }
        }
    }
}
