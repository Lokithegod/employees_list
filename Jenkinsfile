pipeline {
 agent {
  label 'tomcat'
 }
// options {
//  disableConcurentBuild()
//  timestamp()
//  ansiColor('xterm')
// }
 stages {
  stage('Clean & Package') {
   steps {
    script {
     sh ''' mvn clean package '''
     sudo cd '''/$CATALINA_HOME/webapps'''
     sudo rm '''ROOT.war'''
     sudo man rmdir '''ROOT'''
    '''q'''
     sudo cp '''/jenkins/workspace/diploma_demo_project_master/target/ROOT.war /$CATALINA_HOME/webapps/ROOT.war'''
     sudo sh '''/$CATALINA_HOME/bin/shutdown.sh'''
     sudo sh '''/$CATALINA_HOME/bin/startap.sh'''
    }
   }
  }
 }
}
