# HA-TDD-Chess

## Building & Running
./mvnw test && ./mvnw spring-boot:run

This command will deploy a development server on http://localhost:8080

## Live-Reload
This project uses spring-boot-devtools enabling live reload of code changes if your editor is set up correctly.
For IntelliJ, activate Advanced Settings > Compiler > 'Allow auto-make to start even if developed application is currently running', and Build, Execution, Deployment > Compiler > Build project automatically.
Create a maven run-configuration with the command mvn spring-boot:run, and you can start refreshing the webpage to see your latest changes.
