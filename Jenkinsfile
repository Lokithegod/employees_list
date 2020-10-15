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
    }
   }
  }
  stage ('Stutdown TomCat Server'){
   steps{
    script{
     sh '''$CATALINA_DIR/bin/shutdown.sh'''
    }
   }
  }
  stage ('Remove old application war'){
   steps{
    script{
     sudo rm '''$CATALINA_DIR webapps/ROOT.war'''
    }
   }
  }
  stage ('Remove old application dir'){
   steps{
    script{
     sudo man rmdir '''$CATALINA_DIR webapps/ROOT'''
    }
   }
  }
  stage ('Copy new war in to webapp dir'){
   steps{
    script{
     sudo cp '''/jenkins/workspace/diploma_demo_project_master/target/ROOT.war $CATALINA_HOME webapps/ROOT.war'''
    }
   }
  }
   stage ('Startup TomCat Server'){
   steps{
    script{
     sh '''CATALINA_DIR/bin/startup.sh'''
    }
   }
  }  
 }
}
