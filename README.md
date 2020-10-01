# phone-number-producer



## Frontend UI (Angular) :: phone-number-UI
 
 

##### Update Angular dependencies using `npm install`
 
##### Visit below URL after running angular app using `npm start` or `ng serve`
> http://localhost:4200
 
Enter phone number in give text box and click on **`Get`** button. It will find alphanumeric phone numbers and list into the table below.




## Backend APIs (Spring Boot) :: phone-number-provider-api
 
##### For H2 Database console visit 
> http://localhost:8080/h2-console

with url `jdbc:h2:mem:sampledb` and password as `password`


##### To get Alphanumeric phone numbers from backend with below number hit below URL
> http://localhost:8080//number?number=12345678&page=1&size=20


##### Get phones numbers from H2 database for first page hit below URL

http://localhost:8080/phoneNumbers?page=1
