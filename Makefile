run-dev:
	mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=development

run-sonar-dev:
	mvn sonar:sonar \                                                                                                                           hattori@hattori-mac-2
  	-Dsonar.organization=ehattori-github \
  	-Dsonar.host.url=https://sonarcloud.io \
  	-Dsonar.login=$(SONAR_TOKEN)