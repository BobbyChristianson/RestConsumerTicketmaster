# RestConsumerTicketmaster README

Here is the rest consumer assessment for this Ticketmaster.
I used Spring framework (Spring boot and Spring JPA) and Jackson.
Jackson and JPA for easily creating object classes to pull down json data into java objects for easy consumption.

After unzipping the project, open the project in IntelliJ.
I have created 2 tests that should pass upon building the project.       
Run `mvn clean install` to build the project. 


Call `mvn spring-boot:run` in the project root directory.      
<img width="551" alt="Screen Shot 2022-05-19 at 12 51 52 AM" src="https://user-images.githubusercontent.com/25803933/169246833-bc58dc2c-d3ee-47d7-891e-c542aa9205b1.png">



The rest endpoint will be at `http://localhost:8080/artist/`
Call if from terminal with curl
<img width="418" alt="screenShott" src="https://user-images.githubusercontent.com/25803933/169246798-de147a8b-426b-49d5-a20d-8ad0a0adaefc.png">

OR

Call it in the browser.
<img width="935" alt="Screen Shot 2022-05-19 at 12 59 33 AM" src="https://user-images.githubusercontent.com/25803933/169246778-6be37829-040b-4300-b72b-1061b03ec4e4.png">



Choose an artist from the list and supply it as a variable `name`.
However, keep in mind that artist names with spaces need to have their spaces replaced with a  
For example

<img width="623" alt="screenshotty2" src="https://user-images.githubusercontent.com/25803933/169246650-c87f63bb-db82-427f-ac88-3548a3b17bd2.png">
