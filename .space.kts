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

    container(displayName = "Gradle build", image = "gradle:jdk11") {
        kotlinScript { api ->
                api.gradlew("clean")
                api.gradlew("build")
//                api.gradlew("test")
                api.gradlew("appengineDeploy")
        }
    }
}
