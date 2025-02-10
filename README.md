# Online Taxi Booking System

## 🚖 Overview
This is a **Spring Boot web application** that allows users to book taxis online and contact the admin via messages. The application also includes an **Admin Panel** where the admin can view total bookings and messages from users. To enhance security, the admin dashboard is protected using **Spring Security**, ensuring only authorized access.

## ✨ Features
- **User Module**
  - Book a taxi online.
  - Send messages to the admin for inquiries.
  
- **Admin Module**
  - Secure login using **Spring Security**.
  - View total bookings.
  - See the number of users trying to contact the admin.
  
- **Security & Validation**
  - Admin authentication and authorization using **Spring Security**.
  - Data validation with **Spring Validation**.
  
## 🛠️ Tech Stack
- **Backend:** Spring Boot, Spring MVC, Spring JPA
- **Frontend:** HTML, CSS, Bootstrap, Thymeleaf
- **Database:** MySQL
- **Security:** Spring Security
- **Validation:** Spring Validation

## 📌 Future Enhancements
- Adding more services to improve user experience.
- Implementing additional admin controls.
- Enhancing UI for better interaction.

## 🚀 How to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/SameerMohanty7846/TaxiBooking
   ```
2. Navigate to the project directory:
   ```bash
   cd TaxiBooking
   ```
3. Configure the database in `application.properties`:
   ```properties
spring.application.name=TaxiBooking
spring.datasource.url=jdbc:mysql://localhost:3306/taxibooking
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

   ```
4. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application:
   - User Booking Page: `http://localhost:8080`
   - Admin Panel: `http://localhost:8080/admin/dashboard`

## 📬 Contact
For any queries or suggestions, feel free to reach out!

---
📌 **Note:** The project is actively being improved with more features coming soon!

