#!/usr/bin/env groovy

def call(string imageName) {
    echo 'building image'
    sh "docker build -t ${imageName} ."
}
