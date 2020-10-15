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
     sudo sh '''/$CATALINA_HOME/bin/shutdown.sh'''
     sudo rm '''/$CATALINA_HOME/webapps/ROOT.war'''
     sudo man rmdir '''/$CATALINA_HOME/webapps/ROOT'''
    '''q'''
     sudo cp '''/jenkins/workspace/diploma_demo_project_master/target/ROOT.war /$CATALINA_HOME/webapps/ROOT.war'''
     sudo sh '''/$CATALINA_HOME/bin/startap.sh'''
    }
   }
  }
 }
}
