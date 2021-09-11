pipeline {
    agent any
    stages {
		stage('GIT Pull') {
			steps {
				git branch: 'main', url: 'https://github.com/Csumeena/spring-petclinic.git'
			}
		}	
		stage('Build') {
            steps {
                sh "./mvnw -DskipTests=true package"
            }
			post {
				success {
					// junit 'target/surefire-reports/*.xml'
					archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
				}
				failure {
					sh "echo 'build failed'"
				}
			}
        }
		stage('Tests') {
            steps {
                sh "./mvnw test"
            }
			post {
				success {
					junit 'target/surefire-reports/*.xml'
					// archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
				}
				failure {
					junit 'target/surefire-reports/*.xml'
					sh "echo 'test failed'"
				}
			}
        }		
    }
	post {
		always {
			emailext body: 'Build Summary for Jenkins build - ${BUILD_URL}', 
				recipientProviders: [upstreamDevelopers()], 
				subject: 'Build Summary for ${JOB_NAME}', 
				to: 'sufa.0726@gmail.com'
			}
		success {
			sh "java -Dserver.port=8081 -jar target/spring-petclinic-2.5.0-SNAPSHOT.jar"
			
		}
	}			
}