# Selenium automation tests for BuggyCarsRating website

## Prerequisite to run Selenium automation tests

### Download a ChromeDriver
Download a chrome driver that match the installed Chrome browser version on the local machine from
https://chromedriver.chromium.org/downloads.

### Set up a system variable "Path" 
1. In window key on the keyboard and type "variable".
2. Click on "Edit the system variable" icon, then the "System Properties" popup should be displayed.
3. In System Properties popup > Advanced tab, Click "Environment Variables".
4. In the section System Variables find the PATH environment variable and select it. Click Edit. 
If the PATH environment variable does not exist, click New. 
5. In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable with the location of the downloaded ChromeDriver from the previous step.
6. Click OK. Close all remaining windows by clicking OK.

<b>NOTE</b> 
Restarting window may be required if the system variable is new.

### Run Sanity tests
1. Open Java IDE of your choice and clone the repository. With IntelliJ, you can easily do it by go to menu File > New > "Project from Version control" .
Then paste the clone url.
2. Right click at the project and choose "Run all tests".
3. All tests should be executed successfully in Run window.
