pipeline {
    agent any
    environment {
        // Slack configuration
        SLACK_COLOR_DANGER  = '#E01563'
        SLACK_COLOR_INFO    = '#6ECADC'
        SLACK_COLOR_WARNING = '#FFC300'
        SLACK_COLOR_GOOD    = '#3EB991'
    } // environment
    stages {
      stage('Install') {
            steps {
                echo 'Install'
                wrap([$class: 'BuildUser']) {
                  slackSend (color: "${env.SLACK_COLOR_WARNING}",
                                      channel: "#devops",
                                      message: "*Deploy Started:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${env.BUILD_USER}\n More info at: ${env.BUILD_URL}")
                }
                // sh "npm install"
            }
        }
        stage('Compile') {
            steps {
                echo 'build mvn to war and Docker image'
                sh "./gradlew build -x test --refresh-dependencies"
                sh "`aws ecr get-login --no-include-email`"
                // sh "docker build -t ahmego/backend ."
                // sh "docker tag ahmego/backend:latest 666351657248.dkr.ecr.ap-northeast-2.amazonaws.com/ahmego/backend:latest"
                // sh "docker push 666351657248.dkr.ecr.ap-northeast-2.amazonaws.com/ahmego/backend:latest"
            }
        }docker
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                // sh "mvn dockerfile:push"
                // sh "aws ecs update-service --cluster ahmego-prod-cluster --service ahmego-prod-api --task-definition ahmego-api --desired-count 1 --force-new-deployment"

            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            wrap([$class: 'BuildUser']) {
                echo "${BUILD_USER}"
                sh "git push origin HEAD:deploy/ahmego-backend-prod-cluster"
                sh 'printenv'
                echo 'This will run only if successful'
                slackSend (color: "${env.SLACK_COLOR_GOOD}",
                    channel: "#devops",
                    message: "*SUCCESS:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}")
            }
        }
        failure {
            echo 'This will run only if failed'
            slackSend (color: "${env.SLACK_COLOR_GOOD}",
                channel: "#devops",
                message: "*Failure:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${env.BUILD_USER_ID}\n More info at: ${env.BUILD_URL}")
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
