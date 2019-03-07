# factbook-web
Spring web application for Factbook project

Goal:  
Use the Java Spring Framework to create a REST web application that can return JSON (or XML) requests for country data.
 
Current Status:  
The application can retrieve country data from the database created in [FactbookProject](https://github.com/AStrizh/FactbookProject) 
and show that country's data.  

As of last update:  
All country sections can be examined. If a section is absent it will not show up in the country view.

Next Steps:  
Create the ability to compare statistics for two nations.

## Process

This project uses a database created from country data provided by the CIA in
[The World Factbook](https://www.cia.gov/library/publications/the-world-factbook/) 
to create a Spring web application.  
The data is in the public domain and free for public use.
[Download The World Factbook](https://www.cia.gov/library/publications/download/).  
  
To generate the appropriate database see my previous project 
[FactbookProject](https://github.com/AStrizh/FactbookProject). 

Currently the project is configured to work with a MySQL server and server details  
are in the application.properties file in the resources directory


## Build Tools

- Java 1.8
- SpringBoot 2.1.3 
- Intellij IDEA
- Gradle

---
## Author

Aleksandr Strizhevskiy, strizhevskiy@erudos.com