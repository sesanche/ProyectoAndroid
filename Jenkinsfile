node {
    stage 'Checkout'
    checkout scm

    stage 'Compile'
    sh "./gradlew compileDebugSources"

    stage 'Test'
    sh "./gradlew test"

    stage 'Build'
    sh "./gradlew build"

    stage 'Release'
    archiveArtifacts artifacts: 'build/**/*.apk', fingerprint: true


}