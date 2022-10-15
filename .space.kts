/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Build and run tests") {
    startOn {
        gitPush {
            branchFilter {
                +Regex("main")
            }
        }
    }
    
    container(displayName = "Gradle build", image = gradle:jdk11) {
        kotlinScript { api ->
            if (api.gitBranch() == "refs/heads/master"){
                println("Running in master branch")
            }
            api.gradlew("clean")
            api.gradlew("build")
            api.gradlew("test")
        }
    }
}
