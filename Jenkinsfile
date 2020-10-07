pipeline {
 agent {
  label 'build_agent'
 }
 options {
//  disableConcurentBuild()
//  timestamp()
//  ansiColor('xterm')
 }
 stages {
  stage('Clean & Package') {
   script {
    script {
     sh ''' mvn clean package '''
    }
   }
  }
 }
}
