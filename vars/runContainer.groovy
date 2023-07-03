#!/usr/bin/env groovy

def call() {
    echo "running container"
    if (env.BRANCH_NAME == 'main') {
        sh "docker run -d --expose 3000 -p 3000:3000 --name nodemain${env.BUILD_NUMBER} ${DOCKER_IMAGE_MAIN}"
    } else if (env.BRANCH_NAME == 'dev') {
        sh "docker run -d --expose 3001 -p 3001:3000 --name nodedev${env.BUILD_NUMBER} ${DOCKER_IMAGE_DEV}"
    }
}