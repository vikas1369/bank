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
                script{
                //Prompt the user for input
                def userInput = input(
                    id : 'deployChoice',
                    message: 'Select Deployment target:',
                    parameters : [
                        choice(name: 'Deploy to Dev', value='dev'),
                        choice(name: 'Deploy to Test', value='test'),
                    ]
                )
                //Use the input to determine deployment target
                if(userInput=='dev'){
                    deployToCloudFoundry('dev')
                }else if(userInput=='test'){
                    deployToCloudFoundry('test')
                }else{
                    error('Invalid choice selected')
                }

                }
            }
        }
    }

    def deployToCloudFoundry(space){
        withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                          credentialsId   : 'PF_CF_ID',
                                          usernameVariable: 'USERNAME',
                                          passwordVariable: 'PASSWORD']]) {

                            bat "cf login -a https://api.cf.us10-001.hana.ondemand.com -u $USERNAME -p $PASSWORD -o fe81f8a9trial  -s $space"
                            bat "cf push"
                        }
    }
}