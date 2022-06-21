
pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage("build") {

            steps {
                echo 'building the application with maven'
                    sh "mvn clean install"
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
