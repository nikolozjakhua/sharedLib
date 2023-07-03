#!/usr/bin/env groovy

def call(String imageName, String branchName, int portNumber) {
    echo "running container"
    sh "docker run -d --expose ${portNumber} -p ${portNumber}:3000 --name node${branchName}${env.BUILD_NUMBER} ${imageName}"
}
