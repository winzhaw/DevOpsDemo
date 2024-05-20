Pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/winzhaw/DevOpsDemo.git']])
            }
        }

        stage('Test') {
            steps {
                sh 'echo test'
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo deploy'
            }
        }

    }

}
