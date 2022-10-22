import circlet.pipelines.script.SpaceApi

/**
 * JetBrains Space Automation
 * This Kotlin-script file lets you automate build activities
 * For more info, see https://www.jetbrains.com/help/space/automation.html
 */

job("Build and run tests") {
    startOn {
        gitPush {
            branchFilter {
                +Regex("master")
            }
        }
    }
//
//    container(displayName = "Gradle build", image = "gradle:jdk11") {
//        kotlinScript { api ->
//            api.space().doSafely("Build failed") {
//                api.gradlew("clean")
//                api.gradlew("build")
//            }
//            api.space().doSafely("Build failed") {
//                api.gradlew("test")
//            }
//        }
//    }

    host("Build artifacts and a Docker image") {
        // assign project secrets to environment variables
        env["HUB_USER"] = Secrets("dockerhub_user")
        env["HUB_TOKEN"] = Secrets("dockerhub_token")

        shellScript {
            content = """
                docker login --username ${'$'}HUB_USER --password "${'$'}HUB_TOKEN"
            """
        }

        dockerBuildPush {
            labels["vendor"] = "mycompany"
            tags {
                +"shoppe-api/release:1.0.${"$"}JB_SPACE_EXECUTION_NUMBER"
            }
        }
    }
}


suspend fun SpaceApi.doSafely(messageIfFailed: String, block: () -> Unit) {
    try {
        block()
    } catch (ex: Exception) {
        val recipient = ChannelIdentifier.Profile(ProfileIdentifier.Id("adrianwitaszak"))
        val content = ChatMessage.Text(messageIfFailed)
        chats.messages.sendMessage(recipient, content)
    }
}
