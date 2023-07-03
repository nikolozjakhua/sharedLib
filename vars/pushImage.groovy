#!/usr/bin/env groovy

def call() {
    echo 'Pushing image'
    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: "USER")]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        if (env.BRANCH_NAME == 'main') {
            sh "docker tag ${DOCKER_IMAGE_MAIN} nikolozjakhua/cicd:main.v1"
            sh "docker push nikolozjakhua/cicd:main.v1"                    
        } else if (env.BRANCH_NAME == 'dev') {
            sh "docker tag ${DOCKER_IMAGE_DEV} nikolozjakhua/cicd:dev.v1"
            sh "docker push nikolozjakhua/cicd:dev.v1"
        }
    }
}