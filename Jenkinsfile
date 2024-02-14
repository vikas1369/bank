pipeline {

    agent any
    parameters{
         choice(name : 'env',description: 'Select Deployment target:',choices: ['dev','test'])
    }

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
                script{
                //Use the input to determine deployment target
                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                                          credentialsId   : 'PF_CF_ID',
                                                          usernameVariable: 'USERNAME',
                                                          passwordVariable: 'PASSWORD']]) {

                                            bat "cf login -a https://api.cf.us10-001.hana.ondemand.com -u $USERNAME -p $PASSWORD -o fe81f8a9trial  -s ${params.env}"
                                            bat "cf push"
                                        }

                }
            }
        }
    }
}