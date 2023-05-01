##  UI автотесты для Android приложения Wikipedia

## :computer: Использованный стек технологий

<p align="center">
<img width="6%" title="Java" src="src/test/resources/img/logo/Java.svg">
<img width="6%" title="Allure Report" src="src/test/resources/img/logo/Allure_Report.svg">
<img width="6%" title="Allure TestOps" src="src/test/resources/img/logo/AllureTestOps.svg">
<img width="6%" title="IntelliJ IDEA" src="src/test/resources/img/logo/Intelij_IDEA.svg">
<img width="6%" title="Selenide" src="src/test/resources/img/logo/Selenide.svg">
<img width="6%" title="Gradle" src="src/test/resources/img/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="src/test/resources/img/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="src/test/resources/img/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="src/test/resources/img/logo/Telegram.svg">
<img width="6%" title="Appium" src="src/test/resources/img/logo/Appium.png">
<img width="6%" title="Browserstack" src="src/test/resources/img/logo/Browserstack.png">
</p>

## :running_woman: Варианты запуска тестов из терминала

### Для удаленного запуска с Browserstack:
```
./gradlew clean test -DdeviceHost=browserstack
```
### Для запуска на эмуляторе Android Studio:
```
./gradlew clean test -DdeviceHost=local
```
### Для запуска на локальном устройстве Android:
```
./gradlew clean test -DdeviceHost=real
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="src/test/resources/img/logo/Jenkins.svg"> Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/mobile_browserstack/">*Jenkins job*</a>

<p align="center">
<img title="Jenkins Build" src="src/test/resources/img/screenshots/jenkinsBuild.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="src/test/resources/img/logo/Allure_Report.svg"> Allure-отчет
### <a target="_blank" href="https://jenkins.autotests.cloud/job/mobile_browserstack/3/allure/#suites/64fbf7b5c40e21e96b63c268953d5ea5/6fedd44f40eb8f95/">*Overview*</a>

<p align="center">
<img title="Allure Overview" src="src/test/resources/img/screenshots/allureReportMain.png">
</p>

## <img width="4%" style="vertical-align:middle" title="TestOps" src="src/test/resources/img/logo/AllureTestOps.svg"> Интеграция с Allure TestOps
### *Allure TestOps* <a target="_blank" href="https://allure.autotests.cloud/project/2198/dashboards">*Dashboard*</a>

<p align="center">  
<img title="Allure TestOps Dashboard" src="src/test/resources/img/screenshots/allureTestOpsDashboard.png">  
</p> 

## <img width="4%" style="vertical-align:middle" title="Telegram" src="src/test/resources/img/logo/Telegram.svg"> Уведомление в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически отправляет сообщение с отчетом прохождения тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="src/test/resources/img/screenshots/notificationTelegram.png">
</p>

Для каждого теста выполняется запись видео. Ниже представлен пример видео прохождения теста.
<p align="center">
  <img title="Selenoid Video" src="src/test/resources/img/screenshots/video.gif">
</p>
