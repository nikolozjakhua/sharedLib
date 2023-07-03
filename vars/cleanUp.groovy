#!/usr/bin/env groovy

def call(String branchName) {
    echo 'Cleaning up'
    def containerNames = sh(returnStdout: true, script: 'docker ps -a --format "{{.Names}}" --filter "name=node${branchName}*"').trim()
    if (containerNames.isEmpty()) {
        echo 'No previously deployed containers'
    } else {
        sh 'docker rm $(docker ps -a --format "{{.Names}}" --filter "name=node${branchName}*") -f'
    } 
}
