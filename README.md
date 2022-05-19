# RestConsumerTicketmaster README

Here is the rest consumer assessment for this Ticketmaster.
I used Spring framework (Spring boot and Spring JPA) and Jackson.
Jackson and JPA for easily creating object classes to pull down json data into java objects for easy consumption.

After unzipping the project, open the project in IntelliJ.
Once opened in your editor 'mvn clean install' in terminal or with your IDE.
I have created 2 tests that should pass upon building the project.


If all is good, you can run the project like so...
<img width="951" alt="Screen Shot 2022-05-12 at 4 37 41 PM" src="https://user-images.githubusercontent.com/25803933/168184238-85dedc1d-5776-4dff-92ff-7ad7a1fcad2a.png">


Call `mvn spring-boot:run` in the project root directory.
![](../../Desktop/Screen Shot 2022-05-19 at 12.51.52 AM.png)


The rest endpoint will be at `http://localhost:8080/artist/`
Call if from terminal with curl
![](../../Desktop/screenShott.png)

OR

Call it in the browser.
![](../../Desktop/Screen Shot 2022-05-19 at 12.59.33 AM.png)


Choose an artist from the list and supply it as a variable `name`.
However, keep in mind that artist names with spaces need to have their spaces replaced with a `+`
For example
![](../../Desktop/screenshotty2.png)