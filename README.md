# Team 'A' group Project - Aodh's Auto Parts
 

Project Description - Ben 

The Aodh’s Auto Part Database management system is a java application made to optimise stock management, customer information, company information and customer/Business orders for a car parts seller. The java application uses CRUD (Create, Read, Update, Delete) to create an optimised and intuitive system with Mysql database usage and extensive test coverage allowing for ease of use, exception handling and error checking.  

Main App Operation 

The Main App java class is an easy-to-use interface presenting the user with a clearly outline menu with number options leading into a switch statement that brings the user to their desired choice the main page is streamlined by contained the information for each menu operation in separate classes as to make the main page appear clear, ordered and uncluttered. 

 

The main app and other java classes revolve around 8 core database tables. These tables include Customer to house any necessary user information, Product for a list of stock for either for customer use finding out about desired stock or for business uses such as stock management. Product supporting tables such as Brand, Warehouse and Category are useful for business information and Order tables help track customer orders in volume, product and destination. The order destination information would be taken from our Address table, and the payments table handles order pricing.  

 

Database Connectivity 

Database interactions are handled through JDBC with MySQL. The TestConnection class tests database connectivity while the other classes handle testing operations such as the deleting and inserting of data into the database which is critical to ensuring the smooth operation of the java application. Our application ensures proper initialisation and closure of database connections and currently our connection details are hardcoded and for further optimisation our code could be easily extended with something like connection pooling 

Testing Framework 

We use JUnit testing to cover all our CRUD operations. Our testing goes a step beyond simple verification, and I will go into to detail on the intricacies of each of our test classes. 

TestReadData – This test validates numerous different operations such as data retrieval, data integrity and proper null handling. Each test follows a concise and similar layout firstly ensuring a database connection, then executing the operation and finally verifying the existence of the data as well as the correctness of said data. 

TestInsertData – For each test case in this class there is the inclusion of both success and failure scenarios. The failure tests check for proper handling of SQL integrity constraint violations.  

UpdateData – The test class verifies that update operations both succeed and that failures are properly reported if invalid data is encountered. Each affected row is verified to ensure the best testing standard. 

testDeleteData – Our final test class verifies successful deletion (if records exist) regarding our database as well as proper outcomes in the attempt of deleting information that doesn’t exist.  

 

4.  Conclusion 

Our application adheres to current industry standards and provides a streamlined service to easily record inventory, orders and customer information and the extensive testing shows a high level of quality assurance. Our application is aimed at not only the average customer but could also be a useful framework for other businesses or be a supplier for mechanics and auto parts shops. The system can be enhanced in the future to provide a web page for customers and better security features for data protection for bothe the customers information and business information. The interface provides a solid foundation for any future expansion and adaptation for whatever the business requires.  
