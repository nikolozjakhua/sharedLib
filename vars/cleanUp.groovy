#!/usr/bin/env groovy

def call() {
    echo 'Cleaning up'
    if (env.BRANCH_NAME == 'main') {
        def containerNames = sh(returnStdout: true, script: 'docker ps -a --format "{{.Names}}" --filter "name=nodemain*"').trim()
        if (containerNames.isEmpty()) {
            echo 'No previously deployed containers'
        } else {
            sh 'docker rm $(docker ps -a --format "{{.Names}}" --filter "name=nodemain*") -f'
        } 
    } else if (env.BRANCH_NAME == 'dev') {
        def containerNames = sh(returnStdout: true, script: 'docker ps -a --format "{{.Names}}" --filter "name=nodedev*"').trim()
        if (containerNames.isEmpty()) {
            echo 'No previously deployed containers'
        } else {
            sh 'docker rm $(docker ps -a --format "{{.Names}}" --filter "name=nodedev*") -f'
        }
    }   
}