#!/usr/bin/env groovy

def call(String imageName, String branchName) {
    echo 'Pushing image'
    withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: "USER")]) {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker tag ${imageName} nikolozjakhua/cicd:${branchName}.v1"
        sh "docker push nikolozjakhua/cicd:${branchName}.v1"                    
    }
}
