#!/usr/bin/env groovy

def call() {
    echo 'building image'
    if (env.BRANCH_NAME == 'main') {
        sh 'docker build -t ${DOCKER_IMAGE_MAIN} .'
    } else if (env.BRANCH_NAME == 'dev') {
        sh 'docker build -t ${DOCKER_IMAGE_DEV} .'
    }
}