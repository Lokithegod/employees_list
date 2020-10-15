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
     sh '''sh /apache-tomcat-8.5.59/bin/shutdown.sh'''
    }
   }
  }
  stage ('Remove old application war'){
   steps{
    script{
     sh '''sudo rm /apache-tomcat-8.5.59/webapps/ROOT.war'''
    }
   }
  }
  stage ('Remove old application dir'){
   steps{
    script{
     sh '''sudo man rmdir /apache-tomcat-8.5.59/webapps/ROOT'''
    }
   }
  }
  stage ('Copy new war in to webapp dir'){
   steps{
    script{
    sh '''sudo cp /jenkins/workspace/diploma_demo_project_master/target/ROOT.war /apache-tomcat-8.5.59/webapps/ROOT.war'''
    }
   }
  }
   stage ('Startup TomCat Server'){
   steps{
    script{
     sh '''sh /apache-tomcat-8.5.59/bin/startup.sh'''
    }
   }
  }  
 }
}
