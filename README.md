Football Management APP⚽
This project is a Microservices-based Football Management System that allows users to:
✅ Track teams, players, and tournaments
✅ Track player statistics
✅ Process payments for team merchandise using PayPal
✅ Send email confirmations after successful transactions
✅ Secure authentication and authorization using Spring Security & JWT

Project Architecture 🏗️
The system consists of multiple microservices:

Service Name		                    Port	Description
Match Service		                    8082	Manages matches between teams and stores results.
Player Stats Service	              8083	Tracks player statistics (goals, assists, etc.).
Team Management Service	            8080	Manages football teams and players.
Item Service		                    8085	Stores and sells team-related merchandise.
Payment Service		                  8084	Handles payments using PayPal & sends email confirmations.


API Gateway (Planned)		          	8081	Central entry point for all services.
Eureka Service Discovery (Planned)	8761	Registers & discovers microservices dynamically.



Technologies Used 🚀
Spring Boot (Backend Framework)
Spring Cloud OpenFeign (Microservices Communication)
Spring Security + JWT (Authentication & Authorization)
Spring Boot Data JPA (Database Interaction)
MySQL/PostgreSQL (Database)
Feign Client (Service-to-Service Calls)
PayPal REST API SDK (Payment Processing)
Spring Mail (Email Confirmation)
Eureka Service Discovery (Planned)
API Gateway (Planned)


Next Steps 🚀
🔲 API Gateway for centralized access
🔲 Eureka Service Discovery for dynamic service registration
🔲 Database integration for all services
🔲 Admin dashboard for management


To Do List 📝
✅ Setup Spring Boot microservices
✅ Implement JWT Security
✅ Add PayPal Payments
✅ Send Email Confirmations
🔲 Store Transactions in Database
🔲 Enhance Logging & Error Handling
🔲 API Gateway & Eureka Service Discovery



This README will be updated as we complete more features.🎯
