def call(String BUILD_TYPE, String PWD) {
    node {
        sh "echo 'Performing Action - ${BUILD_TYPE}'"
        sh "pwd"
        sh "ls -ltr"
        sh "ls -ltr ${PWD}"
		sh "chmod +x ${PWD}/mvnw"
		sh "ls -ltr"
        sh "ls -ltr ${PWD}"
		sh "${PWD}/mvnw ${BUILD_TYPE}"
    }
}