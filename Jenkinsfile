pipeline {
    agent {
        label 'tomcat'
    }
    environment {
        APACHE = "/apache-tomcat-8.5.59"
    }
    stages {
         stage ('Shutdown TomCat Server'){
            steps{
                script{
                    catchError(buildResult: 'SUCCESS', stageResult: 'SUCCESS') {
                        sh '''sudo sh ${APACHE}/bin/shutdown.sh'''
                    }
                }
            }
        }
        stage('Clean & Package') {
            steps {
                script {
                    sh ''' mvn package '''
                }
            }
        }
        stage ('Remove old application war'){
            steps{
                script{
                    sh '''sudo rm -rf ${APACHE}/webapps/ROOT.war;exit 0'''
                }
            }
        }
        stage ('Copy new war in to webapp dir'){
            steps{
                script{
                    sh '''sudo cp ${WORKSPACE}/target/ROOT.war ${APACHE}/webapps/ROOT.war'''
                }
            }
        }
        stage ('Startup TomCat Server'){
            steps{
                script{
                    sh '''sudo sh ${APACHE}/bin/startup.sh'''
                }
            }
        }  
    }
    post {
        success {
            cleanWs()
        }
    }
}
