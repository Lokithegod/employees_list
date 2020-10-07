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
   steps {
    script {
     sh ''' mvn clean package '''
    }
   }
  }
 }
}
