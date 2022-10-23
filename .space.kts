//job("deploy") {
//    startOn {
//        gitPush {
//            branchFilter {
//                +Regex("master")
//            }
//        }
//    }
//
//    requirements {
//        workerPool = WorkerPools.SELF_HOSTED
//    }
//
//    container(displayName = "Build", image = "gradle:jdk11") {
//        kotlinScript { api ->
//            api.gradle("build")
//        }
//    }
//
//    host(displayName = "GCP deploy") {
//        shellScript {
//            content = """
//                gcloud components install app-engine-java
//                ./gradlew appengineDeploy
//            """
//        }
//    }
//
//    failOn {
//        testFailed { enabled = false }
//        nonZeroExitCode { enabled = false }
//        outOfMemory { enabled = false }
//    }
//}
