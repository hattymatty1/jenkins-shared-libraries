def call(String Project, String Image){
  withCredentials([usernamePassword(credentialsId:"DockerHubCred", usernameVariable:"dockerHubUser", passwordVariable:"dockerHubPass")]){
    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
    sh "docker image tag ${Project}:${Image} ${env.dockerHubUser}/${Project}:${Image}"
    sh "docker push ${env.dockerHubUser}/${Project}:${Image}"
    echo "docker push Successful"
  }
}
