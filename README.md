# HospitalProject
Useful resources: 
https://www.concretepage.com/spring-boot/spring-boot-crudrepository-example
https://www.javatpoint.com/steps-to-create-spring-application

Project requirements :

Flow 1 – doctor creation :
Doctor entity should receive the next fields from client upon creation fields :
firstName – String
lastName – String 
Function - String
Address – Object
Email – Object – make sure the email is valid 
PhoneNumber – Object – the phone number should be validated (criterias : only digits, length of 10, starts with 07)

If the doctor is successfully created, it should receive an email with an URL that returns its data.

Flow 2 – patient creation :
Patient entity should receive the next fields from client upon creation fields :
firstName - String
lastName – String 
age - int
Address – Object
Email – Object – make sure the email is valid 
PhoneNumber – Object – the phone number should be validated (criterias : only digits, length of 10, starts with 07)

Flow 3 – update doctor/patient entity :
Both entities should accept partial updates, for example if only the first name is sent from client side, only this should be updated. Suggestion – use data transfer objects. 
Flow 4 – Appointment creation :
Appointment entity should receive from the client side : 
doctorId – Long 
patientId – Long
startTime – Date 
endTime – Date
cause - String
Validations : 
make sure that the doctor with the given doctorId exists
make sure that the patient with the given patientId exists
make sure that startTime is before endTime
make sure that endTime is after startTime
make sure that the interval is not booked by another patient
On creation both doctor and patient should be notified through email notification.

For the appointment methods should be provided for the following functionalities : 
get appointments by doctor
get appointments by patient
get appointments by doctor which did not took place
get appointments in the future

Flow 5 – Appointment cancelation :
An endpoint should be exposed through which the appointment can be canceled. The data from the client side should be :
appointmentId - Long
canceled – Boolean
An appointment which already took place in the past can’t be canceled.
An appointment which will occur in the next hour can’t be canceled.

Flow 6 – Define a spring boot job that :
scans the database every 5 minutes and marks the appointments that already took place.

Flow 7 – Create and send a HTML email template with velocity 

What to keep in mind and what to read :
All the classes will have and ID field - http://www.java2s.com/Code/Java/JPA/UsingMappedSuperclass.htm
 For Doctor / Patient some fields are common – what can we do with them?
In REST service is common to use data transfer objects – how to we skip writing boiler plate code? http://mapstruct.org/documentation/installation/
Javax Validations : http://www.baeldung.com/javax-validation
Spring boot jobs  : https://spring.io/guides/gs/scheduling-tasks/
Hibernate mappings : https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html
Velocity templates in spring : http://websystique.com/spring/spring-4-email-using-velocity-freemaker-template-library/
