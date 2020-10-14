package patches.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a vcsRoot with id = 'HttpsGithubComUygarSenocakkTeamcityExampleGit'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, GitVcsRoot({
    id("HttpsGithubComUygarSenocakkTeamcityExampleGit")
    name = "https://github.com/UygarSenocakk/TeamcityExample.git#refs/heads/release"
    url = "https://github.com/UygarSenocakk/TeamcityExample.git"
    branch = "refs/heads/main"
}))

