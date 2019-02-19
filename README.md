# PlumFuseAssignment

## Prerequisites
- JSD 1.8 or later
- Maven

### Techstack
- Selenium
- Java
- TestNG framework

#### Description
Used Selenium Webdriver and TestNG framework to automate the application. It follows the Page Object model and maven dependencies are added for Selenium, Testng and pageFactory.
Gecko driver is used to run the test cases in Mozilla Firefox browser. 
geckodriver-v0.21.0: This mac version of Gecko driver is used. So, if you are using windows then please download the respective driver and replace it against the path "/src/main/resources/geckodriver".

Config file is used to get the url.
All the input parameters that are required for the test run are being passed from TestNG.xml file.


# How to run
- Clone this project into your local machine
- In case you are using windows, you would require to change the file path format in Base class under src/main/java/com.plivo.base 
- Right click on TestNG.xml file(it is present under src/main/resources folder) and then run it. Extent report would be generated once the test run is completed.
