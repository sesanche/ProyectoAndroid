node {
    stage 'Checkout'
    checkout scm

    stage 'Compile'
    sh "./gradlew compileDebugJava"

    stage 'Build'
    sh "./gradlew build"



    stage 'Release'
    archiveArtifacts artifacts: '**/*.apk', fingerprint: true


}