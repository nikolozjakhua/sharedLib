#!/usr/bin/env groovy

def call() {
    echo 'Linting Dockerfile'
    sh 'docker run --rm -i hadolint/hadolint < Dockerfile'
}