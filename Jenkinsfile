pipeline {

    agent any
    //Use the input to determine deployment target
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

        //Added new stage to scan the repo
        stage('Scan') {
          steps {
            withSonarQubeEnv(installationName: 'sqserver') {//This is the name that is configured on jenkins system configuration
              bat './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
            }
          }
        }

        stage ('Deploy') {
            steps {
                script{
                withCredentials([[$class          : 'UsernamePasswordMultiBinding',
                                                          credentialsId   : 'PF_CF_ID',
                                                          usernameVariable: 'USERNAME',
                                                          passwordVariable: 'PASSWORD']]) {

                                            bat "cf login -a https://api.cf.us10-001.hana.ondemand.com -u $USERNAME -p $PASSWORD -o fe81f8a9trial  -s ${params.env}"
                                            bat "cf push -f manifest-${params.env}.yml"
                                        }

                }
            }
        }
    }
}