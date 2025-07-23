pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests from TestRunner'
                bat 'ls src/test/java/runners/TestRunner.class'
                bat 'mvn test -Dtest=runners.TestRunner'
            }
        }
    }
}
