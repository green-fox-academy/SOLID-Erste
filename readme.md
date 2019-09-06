Credit Card Registry Application
Prepared by:
- Iaroslav Miller
- Ksenia Kulikova
- Anna Sabransky 
- Gabor Reisz

Execution Extractions:
1. Git repository should be cloned from github.
2. MySQL database is used for persistance, the script only works if the database is created in advance, for instance using Workbench.
3. Prior to building the application the Environmnental Variables used in the project to connect to the database  should be created in the system. 

| Number | Env Var           | Example String                                 | 
| -----  | ----------------- | ---------------------------------------------- | 
| 1      | HACKDB_URL        | jdbc:mysql://localhost:3306/{insert_db_name}   | 
| 2      | HACKDB_PASSWORD   | {mysql_server_password}                        | 
| 3      | HACKDB_USERNAME   | {mysql_server_username}                        | 

4. After cloning the project it can be build from command line using command: ./gradlew build.


