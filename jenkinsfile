node {
    def mvnHome
    stage('Get Latest Changes') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/mohamedelattar12/DEPI_FINAL.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Clean Old Builds') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean '
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean /)
            }
        }
    }
      stage('Run Tests') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean test -X '
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean test -X/)
            }
        }
    }
    stage('Results') {
      allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'target/allure-results']]
    }
}