def call(String BUILD_NAME) {
    node {
        sh "echo 'Performing Action - ${BUILD_TYPE}'"
		sh "chmod +x mvnw"
		sh "ls -ltr"
		sh "./mvnw ${BUILD_TYPE}"
    }
}