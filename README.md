## **Training Assignment**

### High Level System Requirement

iSLOW Corporation Ltd (fictional) (i.e. the company) is going to setup an Electronic Book Store (i.e. the store), and you are assigned to develop this system. The store is targeted to Internet users (i.e. the Users), who usually read books from the Internet. Once they buy a book managed by Moderators, they can select and read the book from a given logical shelf by the store.

##### Moderators Functionality

The Moderators of the store are able to manage the stock of the store. They can add, modify, search and view books in the stock. The store also has some details about the book, such as the price, the publisher, the author, and the category associated with it. Hence, the Moderators have to specify a correct price, publisher and category before adding to the stock.

In addition, the Moderators can search, view and modify contracts created by the Users (see **Users Functionality** for payment workflow). If the Users pay fees by using cheque, the **Moderators** are required to approve the transacted cheque, and reflect the amount to Users’ cash accounts.

Meanwhile, the Moderators have the rights of approving account opening requests. They can also lock/unlock Users’ accounts and resetting their password, if Users fails to login successfully more than 5 times.

##### Users Functionality

The Users can view and search books managed by the store. If they would like to go further, such as accessing the content of books or buying the books, they have to login using their account, or register an account.

An account opening form in the store, allow the Users entering a unique username in the store, and a password. Once an account is created, the **Users** must have to wait the **Moderators’** approval in order to logging in the store. The Users receive an email notification, while their accounts are approved.

After the **Users** logged in, they can read books from their logical shelf, or buy books. They can buy books by cash account or cheque. Once the fees are paid successfully, the books will be added on their logical shelf. The payment is successful only, if their cash account has enough money, and their cheque is valid. The validity is verified by the **Moderators**.

Meanwhile, the **Users** can search and check the status of all previous payments (i.e. contracts or transactions). The store allows that the **Users** to void a pending contract. The logical shelves provided by the store, allows the **User** accessing the content of all the bought books, wherein the format is either PDF or TXT.

Lastly, every actions of the Users/Moderators have to be logged and for auditing purpose. 

##### Data Model

The database of the store must at least have the following information:

|                                                                                                    User                                                                                                    |                                            Author                                            |                                                               Publisher                                                               |                            Shelf                            |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------|
| Username<br> Password<br> Name<br> Email<br> Telephone<br> Mobile<br> Address<br> Status<br> Created date<br> Updated Date<br> Approved Date<br> Approved By<br> Number of Retries<br> Last Login Date<br> | Name<br> Email<br> Country                                                                   | Name<br> Email<br> Address<br> Email<br> Telephone<br> Fax                                                                            | Book<br> User<br> Last Access Date<br> Number Of Accesses   |

|                                                                                                    Book                                                                                                    |                                            Cheque                                            |                                                                Contract                                                               |                          Moderator                          |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------|
| Subject<br> Description<br> ISBN<br> Content<br> Content Type<br> Author<br> Publisher<br> Category<br> Created Date<br> Price                                                                             | User<br> Contract<br> Created Date<br> Amount<br> Status<br> Approved Date<br> Approved By   | Contract Number<br> User<br> Book<br> Created Date<br> Updated Date<br> Voided Date<br> Status<br> Approved By<br> Transaction Number | Username<br> Password<br> Enable<br> Last Login Date        |

|                                                                                          Cash Account Transaction                                                                                          |                                           Category                                           |                                                              Audit Trail                                                              |                                                             |
|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------|
| Transaction Number<br> User<br> Amount<br> Remarks<br> Created Date                                                                                                                                        | Name<br> Description                                                                         | User Id<br> Module<br> Action<br> Audit date                                                                                          |                                                             |


##### Technical Requirement

The application is going to be a web application build based on the following technical requirements.

##### System and Design Pattern

The system and design pattern is up to your creativity. 


##### Development Tools and Environment
- Intellij IDEA
- Java JDK v1.8

##### Framework & Technologies
- Spring Framework
- Hibernate (ORM)
- Angular 13
- Spring Security

##### Database
- Oracle DB – Please Setup your own DB

##### Project Build and Deployment Tools
- Gradle

##### Server
- The application has to be able to deploy locally by using Spring Boot Tomcat Server.


###### Note

In the above description there are most certainly some requirements that have not been specified or of which it may not even be aware, especially technology-related or system-level requirements. As the designers and implementers, you may propose other features or functionality for the system that you feel would be useful to have and that are in keeping with its intended use as described above.


###### Gitlab commit syntax?

    {{ commit message }}
    IssueID: ASSIGNMENT 

