Spring Boot - Managing Parking Lot Project

	Tecnology Stack
	
	-	Maven
	-	Swagger UI
	-	Lombok
	-	H2 - JPA
	
Paths / Username&Password
		
	- Swagger UI path : /swagger-ui/ 
	- H2 Database Console path : /h2-console/
	- H2 Database Console username: sa
	- H2 Database Console password: 

Overview of Service Statuses:
		
	CheckInOutRecordController
		-CheckIn() // On Air
		-CheckOut() // Calculation & Query Broken
		
	ParkingAreaController
		-GetParkingAreaByName() // On Air
		-CreateParkingArea() // On Air
		-DeleteParkingArea() // On Air
		-UpdateParkingArea() // On Air
		-GetDailyIncomeOfParkingArea() // Query Broken
		
	VehicleController
		-GetParkingDetailByLicencePlate() // On Air


Status of Project

	Done:
			-Creation of database & tables
			-Defening Entites
			-Defening DTOs & Converters
			-Rest controller service definitions
	Partially Done:
			-Unit Tests
			-Exception Handling
			-DAO Layer
			-Swagger UI configuration
			-SonarLint Static Check Issues
	To Be Done:
			-Log
			-WebSecurityLayer
			-Validation of Requests

			