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

    container(displayName = "Build", image = "gradle:jdk11") {
        kotlinScript { api ->
            try {
                api.gradle("build")
            } catch (ex: Exception) {
                val recipient = ChannelIdentifier.Channel(ChatChannel.FromName("CI-channel"))
                val content = ChatMessage.Text("Build failed")
                api.space().chats.messages.sendMessage(recipient, content)
            }
        }
    }

    host(displayName = "GCP deploy") {
        shellScript {
            content = """
                ./gradlew appengineDeploy
            """
        }
    }

    failOn {
        testFailed { enabled = false }
        nonZeroExitCode { enabled = false }
        outOfMemory { enabled = false }
    }
}
