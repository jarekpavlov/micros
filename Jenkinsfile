
pipeline {

    agent any

    stages {

        stage("build") {

            steps {
                echo 'building the application with maven'
                withMaven {
                    batch "mvn clean install"
                }
            }

        }
        stage("test") {

            steps {
                echo 'testing the application'
            }

        }
        stage("deploy") {

            steps {
                echo 'deploying the application'
            }

        }

    }

}
