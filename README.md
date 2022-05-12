# RestConsumerTicketmaster

Here is the rest consumer for this Ticketmaster assessment.
I used Spring frame work (Spring boot and Spring JPA) and Jackson.
Jackson and JPA for easily creating object classes to pull down json data from ticketmaster's website.
While I used Spring Boot, I ultimately didn't use the RestController because I wanted to have this application run in the terminal.
You will see that the application will pull down a list of all the Artists avaiable and give you a choice to query one for upcoming events in the consol.

After unzipping the project, open the project in IntelliJ.
Once opened in your editor 'mvn clean install' in terminal or with your IDE.
I have created a 2 tests that should pass upon building the project.

If all is good, you can run the project like so...
<img width="951" alt="Screen Shot 2022-05-12 at 4 37 41 PM" src="https://user-images.githubusercontent.com/25803933/168184238-85dedc1d-5776-4dff-92ff-7ad7a1fcad2a.png">

The program should run like this.
<img width="812" alt="Screen Shot 2022-05-12 at 4 44 11 PM" src="https://user-images.githubusercontent.com/25803933/168185115-99a66a86-6d4c-4852-9048-398c790d24a8.png">

Then input artist name of your choice

<img width="591" alt="Screen Shot 2022-05-12 at 4 46 41 PM" src="https://user-images.githubusercontent.com/25803933/168185151-7195de65-e2c6-483f-8d89-6f7f1c933497.png">

After you should see a list in json format of upcoming events and their venues
<img width="853" alt="Screen Shot 2022-05-12 at 4 47 37 PM" src="https://user-images.githubusercontent.com/25803933/168185187-bcd54bfb-b4d3-48ca-ae21-9c0f5a77fd44.png">
