def call(String PWD, String FILENAME) {
    node {
        sh "ls -ltr ${PWD}"
		sh "chmod +x ${PWD}/${FILENAME}"		
        sh "ls -ltr ${PWD}"
		
    }
}