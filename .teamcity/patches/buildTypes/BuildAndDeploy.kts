package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'BuildAndDeploy'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("BuildAndDeploy")) {
    expectSteps {
        maven {
            goals = "clean install"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        script {
            scriptContent = "echo 'Hello world!'"
        }
    }
    steps {
        update<ScriptBuildStep>(1) {
            clearConditions()
            scriptContent = """
                echo 'Hello world!'
                ls
            """.trimIndent()
        }
        insert(2) {
            step {
                name = "SSH Upload"
                type = "ssh-deploy-runner"
                param("jetbrains.buildServer.deployer.username", "h50rzxa@beeone.lan")
                param("jetbrains.buildServer.deployer.sourcePath", "target/*.jar")
                param("jetbrains.buildServer.deployer.targetUrl", "10.8.241.51:/home/beeone.lan/h50rzxa/test")
                param("secure:jetbrains.buildServer.deployer.password", "credentialsJSON:f9f9575b-b121-4d2c-9132-2eb2af23baf4")
                param("jetbrains.buildServer.sshexec.authMethod", "PWD")
                param("jetbrains.buildServer.deployer.ssh.transport", "jetbrains.buildServer.deployer.ssh.transport.scp")
            }
        }
    }

    triggers {
        add {
            vcs {
                branchFilter = ""
            }
        }
    }
}