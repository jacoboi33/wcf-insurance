# Data Exchange Engineering Project

This is a project that we use to evaluate the technical skills of potential team members.

## Instructions on how to run the project

The database is stored in a postgres.yml docker-compose file to run it run:
`docker-compose -f postgres.yml up -d`

There are no volumes setup in the docker-compose file so once you destroy the container everything is gone.
also the data gets delete from the database each time you reload the data.

###Startup the database first this is a web application using thymeleaf
Then start the spring boot application and go to `localhost:8080`
from there just upload a file and wait for the summary to show on the screen and the download will download to the project home.
#### The schema is built from the data-schema.sql on spring startup.
#### `summary.csv` gets created in the wcf-insurance project directory.

## Things I would do if I had more time
* csv download from the web browser
* create a nav bar, and a way to go to the summary and detail page also use pagination for the detail page 
* so not all 10000 rows load in the pages.
* I would also setup a complete docker-compose environment for the entire application to run in.
* I would also make the pages look better.
* I would also add a spinner showing that data was still being uploaded to the database.

## Tech stack I used for this project
* Java 11
* Spring Boot
* PostgreSQL
* thymeleaf

## Requirements

This repository contains a file called `balances.csv` with the following colummns:

* FIRST_NAME
* LAST_NAME
* ADDRESS
* CITY
* STATE
* ZIP
* PHONE
* BALANCE

Your application should read `balances.csv` and generate a file called `summary.csv` with the following columns:

* STATE
* MIN_BALANCE
* MAX_BALANCE
* MEAN_BALANCE
* TOTAL_BALANCE

Your output should contain one row for each state represented in the input, along with the minimum, maximum, mean (average), and total (sum) of the balances for accounts in that state.

You may use a database if you like, though it's not a requirement.  If you choose to use a database, please populate the database programatically from the input file in your application. 

## Tech Stack
The following are the tools our team favors.  They are preferred, but not required, for this project.

* Java 8+
* Spring Boot
* PostgreSQL or SQLite
* JUnit, TestNG

## Guidelines

Build your own public repo on github and call it whatever you like. Build your solution in your repo, including a README.md file that contains the detailed instructions for running your app. Email the URL for your github repo to your hiring manager once you begin the project so we can review your progress. Once your project is completed, please email your hiring manager.

One of the major goals in this project is to see how you fill in ambiguities in your own creative way. There is no such thing as a perfect project here, just interpretations of the instructions above, so be creative in your approach.

Thank you for your time. We are excited to review your project!
