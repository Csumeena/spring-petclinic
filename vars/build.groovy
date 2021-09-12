def call(String BUILD_TYPE) {
    node {
        sh "echo 'Performing Action - ${BUILD_TYPE}'"
        sh "pwd"
        sh "ls -ltr"
		sh "chmod +x ../mvnw"
		sh "ls -ltr"
		sh "../mvnw ${BUILD_TYPE}"
    }
}