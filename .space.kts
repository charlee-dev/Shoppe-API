job("deploy") {
    startOn {
        gitPush {
            branchFilter {
                +Regex("master")
            }
        }
    }

    requirements {
        workerPool = WorkerPools.SELF_HOSTED
    }

    container(displayName = "Build, Test and GCP deploy", image = "gradle:jdk11") {
        kotlinScript { api ->
                api.gradlew("build")
                api.gradlew("test")
                api.gradlew("appengineDeploy")
        }
    }
}
