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
 }
}
