## Requirements

  - Java 1.8+
  - Maven 3.6+
  
  
## Installation

Install the dependencies, compile and run the application.
Run this command from root directory of the project.

```sh
$ mvn clean install exec:java -Dexec.mainClass=App
```


## Run Configuration

  - The application has default config but you could change it.
  - Change src/main/resources/config.properties to set your own properties.
  - Avaliable properties:
    - inputFileName (put file inside src/main/resources/ directory)
    - merchant
    - fromDate
    - toDate



