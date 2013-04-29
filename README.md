Assignment given by xgrid on Fri, Apr 26, 2013
==================================================

Public Repo Link
[https://github.com/bahmadkhan/xassignment.git](https://github.com/bahmadkhan/xassignment.git)


How to clone project
--------------------------------------

In order to clone project, you need to have git installed (I did it using IDE, Netbeans).
Install git (for windows [http://git-scm.com](http://git-scm.com/download/win )). Open command prompt and execute following command
```bash
git clone https://github.com/bahmadkhan/xassignment.git
```

How to run project
--------------------------------------

Project can be run using maven. But there are little more information to consider.

1.  Mysql as a database engine is used. One need to supply some properties
      . Create db in mysql with name 'xdb' (or any specified in property file)
      . Supply properties for db in [\src\main\resources\messages\database.properties](https://github.com/bahmadkhan/xassignment/blob/master/src/main/resources/messages/database.properties)
  
2.  Maven as a repository management tool is used, so it should be downloaded and installed. Installation details are given [here](http://maven.apache.org/download.cgi) 
3.  Go to project clone root folder in command prompt and execute `mvn install tomcat:run`. This will run project by executing Tests first. Tests will create a default user 'admin@admin.com' with password 'JTO33'. User can login as a 'ROLE_ADMIN' from this account.




### Lot of changes need to be done in this architecture (like comments and javadoc). But due to shortage of time, my main focus was on completing the assignment.
