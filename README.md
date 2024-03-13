# School Grading Application

Welcome to our School Grading Application project repository. This application is the culmination of our team's efforts in the Human Computer Interaction subject. Our goal was to create a robust, user-friendly application that serves the educational sector, specifically tailored for middle schools and high schools. This document provides an overview of the project, technical details, requirements, and setup instructions.

## Overview

The School Grading Application is designed to facilitate the management of academic records within educational institutions. It is a comprehensive platform that supports three distinct types of users, each with tailored privileges:

- **Admins**: Possess full privileges, including managing users, classes, subjects, grades, municipalities, and countries.
- **Professors**: Have the ability to manage classes, subjects, and grades but with restricted access compared to admins.
- **Students**: Can view their grades and class information, with no editing privileges.

The application features dedicated dashboards for each user type, enhancing the user experience by providing relevant information and functionality directly aligned with their roles.

Entities managed within the application include:

- Classes
- Subjects
- Students
- Professors
- Grades
- Municipalities
- Countries

Each entity comes with extensive information fields, ensuring a detailed and comprehensive educational management system. Additionally, the application supports multi-language functionality, offering interfaces in both English and Albanian, and includes thorough data validation to ensure data integrity.

## Features

- Full CRUD (Create, Read, Update, Delete) operations
- Extensive data filtering options
- Multi-language support (English and Albanian)
- Comprehensive data validation

## Development

The application was developed using JavaFX for the frontend, with SceneBuilder employed to design the UI. The backend database utilizes MySQL, providing a robust and reliable data storage solution.

### Technical Architecture

Our project adheres to the Model-View-Controller (MVC) pattern:

- **Models** and Data Transfer Objects (DTOs) are used for data representation and transfer.
- **Views** are crafted in FXML, facilitating a clean separation from the application logic.
- A **Repository** layer contains SQL statements and database interaction logic, promoting code reusability.
- The **Services** layer utilizes repository methods, adding a level of abstraction.
- **Controllers** handle user interactions, relying on services for data manipulation.

The application incorporates Object-Oriented Programming (OOP) principles throughout its design, enhancing code readability, reusability, and scalability.

### Database Management

We have implemented database migration strategies, allowing for smooth updates and modifications to the database schema. The SQL model is available in the migrations folder for review, ensuring transparency and ease of understanding of the underlying data structure.

## Requirements and Setup

To run the application, you'll need an IDE capable of running JavaFX applications. Additionally, the application depends on two external libraries:

- FontAwesome for JavaFX icons
- JFoenix for modern UI components

Please ensure these dependencies are correctly included in your project setup.

### Running the Application

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE that supports JavaFX.
3. Ensure that FontAwesome and JFoenix libraries are added to your project's dependencies.
4. Run the main application file.

## Contributors

- [Florian Saqipi](https://github.com/floriansaqipi/)
- [Gentrit Kryeziu](https://github.com/Gentrit851)
- [Fjolla Ajeti](https://github.com/fjolla-ajeti)
- [Erza Merovci](https://github.com/erzamerovci)
- [Erza Bërbatovci](https://github.com/erza-b)

## Acknowledgments

We would like to express our deepest appreciation to our professors and mentors in the Human Computer Interaction subject for their guidance and support throughout this project. Their insights and feedback were invaluable in shaping this application.
