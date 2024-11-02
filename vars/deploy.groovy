def call(){
  echo "this is deploying the code"
  sh "docker compose up -d"
}
