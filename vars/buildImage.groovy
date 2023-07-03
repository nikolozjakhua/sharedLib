#!/usr/bin/env groovy

def call(String imageName) {
    echo 'building image'
    sh "docker build -t ${imageName} ."
}
