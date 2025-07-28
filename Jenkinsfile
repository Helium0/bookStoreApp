pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Hello from build stage'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests from TestRunner'
                bat 'mvn test -Dtest=runners.TestRunner'
            }
        }
    }
    post {
        always {
            junit 'target\\surefire-reports\\junitreports\\TEST-runners.TestRunner.xml'
            allure includeProperties:
                                 false,
                                 jdk: '',
                                 results: [[path: 'allure-results']]
        }
    }
}
