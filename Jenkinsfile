pipeline {

    agent any

    stages {

        stage ('Build') {
            steps {
                withMaven(maven: 'maven_3_9_6') {
                    bat 'mvn clean package'
                }
            }
        }

        stage ('Deploy') {
            steps {

                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                  credentialsId   : 'PF_CF_ID',
                                  usernameVariable: 'USERNAME',
                                  passwordVariable: 'PASSWORD']]) {

                    bat "cf login -a https://api.cf.us10-001.hana.ondemand.com -u $CUSERNAME -p $CPASSWORD -o fe81f8a9trial  -s dev"
                    bat "cf push"
                }
            }

        }

    }

}