job("deploy") {
    startOn {
        gitPush {
            branchFilter {
                +Regex("master")
            }
        }
    }

    container(displayName = "Gradle build", image = "gradle:jdk11") {
        kotlinScript { api ->
                api.gradlew("build")
                api.gradlew("appengineDeploy")
        }
    }
}
