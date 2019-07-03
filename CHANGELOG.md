## CHANGE LOG

<b>[ 19.07.04 ]</b> Dockerfile 추가 및 Gradle build 후 Docker image 생성되도록 작업
- 참고 링크 : <https://spring.io/guides/gs/spring-boot-docker/>
- 사용법
    - ./gradlew clean
    - ./gradlew -xTest build docker
- 이슈사항 
    - 아래와 같은 에러 발생
    - 해당 이슈에 대해서 절대경로를 적용하면 된다고 하는 글이 대다수여서 절대경로로 적용하였으나 여전히 에러가 발생
    - 해결법을 더 찾아볼 것 
```
> Task :docker FAILED
COPY failed: stat /var/lib/docker/tmp/docker-builder704843379/build/libs/backend-0.0.1-SNAPSHOT.jar: no such file or directory
```
- 다음 예정 작업
    1. gradle build후 생성한 docker image를 AWS ECR에 Push하는 작업
    2. AWS ECR에 Push한 docker image로 AWS ECS를 통해 배포하는 작업
    3. Jenkinsfile을 작성하여 Jenkins를 통한 CI/CD 구축
        - 브랜치 구성 전략 Git Flow 참고 : https://datasift.github.io/gitflow/IntroducingGitFlow.html

---
