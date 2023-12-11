Feature: Registration user

  
Scenario: admin not logged in try to add user 
    Given that admin  not logged in
    
    And there is a user with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/1960" ,visitsount 0 , visitorflag 0,discount 0.50 ,enterindate "00/00/0000" , hour 0 and minute 00
     And his age is more than 50 
    When the user is added to the system
    Then  the error message "Admin login is required" is displayed

Scenario: admin login register user succsed 
	  Given that admin logged in
	  
	  And there is a user with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/1960" ,visitsount 0 , visitorflag 0,discount 0.50 ,enterindate "00/00/0000" , hour 0 and minute 00
      And his age is more than 50
       
	  When the user is added to the system
	  Then  the user added successfully to the system
	  And the message add user appears "User added successfully to the system"

 Scenario: logged in admin trying to add exist user 
		Given that the admin is logged in
		
	 And there is a user with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/1960" ,visitsount 0 , visitorflag 0,discount 0.50 ,enterindate "00/00/0000" , hour 0 and minute 00 
	  And his age is more than 50
	  When the user is added to the system
	  
		Then the already exist message  " This  user is already registered" is displayed
	  
	  
	  
	  
	  
	  
	  
	  
	
	
	  Scenario: admin not logged in try to add regularvisitor 
    Given that admin  not logged in for regular visitor
   
    And there is a regular visitos with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/2020" ,visitsount 0 , visitorflag 1 ,enterindate "00/00/0000" , hour 0 and minute 00
       And his age is less than 50
    When the regular visitor is added to the system
    Then  the error message "Admin login is required" is displayed for regular visitor

Scenario: admin login register user succsed 
	  Given that admin logged in regular visitos 
	  
	  And there is a regular visitos with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/2020" ,visitsount 0 , visitorflag 1 ,enterindate "00/00/0000" , hour 0 and minute 00
      And his age is less than 50
       
	  When the regular visitor is added to the system
	  Then  the regular visitos  added successfully to the system
	  And the message add regular visitos  appears "User added successfully to the system"
	  

 Scenario: logged in admin trying to add exist user 
		Given that the admin is logged in regular visitos 
		
	 And there is a regular visitos with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,Address "Nablus street" , postal code "H3H1T5" , dob "12/11/2020" ,visitsount 0 , visitorflag 1 ,enterindate "00/00/0000" , hour 0 and minute 00
        And his age is less than 50
	   When the regular visitor is added to the system
		Then the already exist message  " This  user is already registered" is displayed regular visitos 
	  
	  
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	
	
	
	
	
	
	
	
	
	

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  Scenario: admin not logged in try to add Guide
    Given that admin  not logged in for guide
    And there is a Guide with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,dob "12/10/2012" ,Address "Nablus street" , toursperday 6, postal code "H3H1T5" , hiredate "12/10/2012"  and
     | day1        | day2        | day3       | day4       |  day5     |
     | Saturday    | Sunday      | Monday     | Tuesday    |  Wednesday| 
     |lang1        |  lang2      | lang3      | lang4      |   lang5   |
     |ARABIC       | ENGLISH     |  FRENCH    |  Espanish  |    Others |
    
    
    
     When  the Guide is added to the system
     
       
    Then  the error message "Admin login is required" is displayed for guide

Scenario: admin login register Guide succsed 
	  Given that admin logged in for guide
	  And there is a Guide with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,dob "12/10/2012" ,Address "Nablus street" , toursperday 6, postal code "H3H1T5" , hiredate "12/10/2012" and
	  | day1        | day2        | day3       | day4       |  day5     |
     | Saturday    | Sunday      | Monday     | Tuesday    |  Wednesday| 
     |lang1        |  lang2      | lang3      | lang4      |   lang5   |
     |ARABIC       | ENGLISH     |  FRENCH    |  Espanish  |    Others |
    
      When the Guide is added to the system
	  Then  the Guide added successfully to the system
	  And the message add Guide appears "Guide added successfully to the system" for guide


Scenario: admin login register Guide succsed 
	  Given that admin logged in for guide
	  And there is a Guide with ID 111, name "Ahmad Ali", email "ahm@gmail.com" ,dob "12/10/2012" ,Address "Nablus street" , toursperday 6, postal code "H3H1T5" , hiredate "12/10/2012" and
	  | day1        | day2        | day3       | day4       |  day5     |
     | Saturday    | Sunday      | Monday     | Tuesday    |  Wednesday| 
     |lang1        |  lang2      | lang3      | lang4      |   lang5   |
     |ARABIC       | ENGLISH     |  FRENCH    |  Espanish  |    Others |
    
      When the Guide is added to the system
	  Then  the Guide added successfully to the system
	  And the message add Guide appears "Guide added successfully to the system" for guide


Scenario: logged in admin trying to add exist Guide
		Given that the admin is logged in for guide
	  And there is a Guide with ID 2984754, name "Ahmad Ali", email "ahm@gmail.com" ,dob "12/10/2012" ,Address "Nablus street" , toursperday 6, postal code "H3H1T5" , hiredate "12/10/2012"  and 
	| day1        | day2        | day3       | day4       |  day5     |
     | Saturday    | Sunday      | Monday     | Tuesday    |  Wednesday| 
     |lang1        |  lang2      | lang3      | lang4      |   lang5   |
     |ARABIC       | ENGLISH     |  FRENCH    |  Espanish  |    Others |
    
   When the Guide is added to the system
 Then the already exist message  " This  guide is already registered" is displayedf
	  
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		 Scenario: admin not logged in try to add onetime ticket to system
    Given that admin  not logged in for add one ticket
    And there is a Ticket with ID 2984754, idvisitor 2984754,duedate "12/10/2022" and price 2984754
    
    
    
     When  the Ticket is added to the system
     
       
    Then  the error message "Admin login is required" is displayed for Ticket

Scenario: admin login register Ticket succsed 
	  Given that admin logged in for oneticket
	 
	  And there is a Ticket with ID 2984754, idvisitor 2984754,duedate "12/10/2022" and price 2984754
    
    
    
     When  the Ticket is added to the system
     
    
      
	  Then  the ticket added successfully to the system
	  And the message addoneticket appears "oneTicket added successfully to the system" for Ticket

Scenario: logged in admin trying to add exist oneTicket
		Given that the admin is logged in for oneticket
	  And there is a Ticket with ID 2984754, idvisitor 2984754,duedate "12/10/2022" and price 2984754
    
    
   When the Ticket is added to the system
 Then the already exist message  " This  oneticket is already exist" is diplayed oneticket
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	 Scenario: admin not logged in try to add multytime ticket to system
    Given that admin  not logged in for add multy ticket
    And there is a Ticket with ID 2984754, idvisitor 2984754,duedate "12/10/2020" , price 2984754 and discount 0.50
     |typ1|
    |yearly|
    
    
    
    
     When  the multyTicket is added to the system
     
       
    Then  the error message "Admin login is required" is displayed for multyTicket

Scenario: admin login register Ticket succsed 
	  Given that admin logged in for multyticket
	 
	 
     And there is a Ticket with ID 2984754, idvisitor 2984754 ,duedate "12/10/2020" , price 2984754 and discount 0.50
    |typ2|
    |MONTHLY|
    
    
    
     When  the multyTicket is added to the system
     
    
      
	  Then  the multyticket added successfully to the system
	  And the message addmultyticket appears "multyTicket added successfully to the system" for Ticket
Scenario: admin login register Ticket succsed 
	  Given that admin logged in for multyticket
	 
	 
     And there is a Ticket with ID 55, idvisitor 2984754 ,duedate "12/10/2020" , price 2984754 and discount 0.50
    |typ2|
    |yearly|
    
    
    
     When  the multyTicket is added to the system
     
    
      
	  Then  the multyticket added successfully to the system
	  And the message addmultyticket appears "multyTicket added successfully to the system" for Ticket
	  
	  
	  Scenario: admin login register Ticket succsed 
	  Given that admin logged in for multyticket
	 
	 
     And there is a Ticket with ID 59, idvisitor 2984754 ,duedate "12/10/2020" , price 2984754 and discount 0.50
    |typ2|
    |daily|
    
    
    
     When  the multyTicket is added to the system
     
    
      
	  Then  the multyticket added successfully to the system
	  And the message addmultyticket appears "multyTicket added successfully to the system" for Ticket
	  
	  
	  
	  
	  Scenario: admin login register Ticket succsed 
	  Given that admin logged in for multyticket
	 
	 
     And there is a Ticket with ID 44, idvisitor 2984754 ,duedate "12/10/2020" , price 2984754 and discount 0.50
    |typ2|
    |daily|
    
    
    
     When  the multyTicket is added to the system
     
    
      
	  Then  the multyticket added successfully to the system
	  And the message addmultyticket appears "multyTicket added successfully to the system" for Ticket
Scenario: logged in admin trying to add exist multyTicket
		Given that the admin is logged in for multyticket
	 And there is a Ticket with ID 2984754, idvisitor 2984754,duedate "12/10/2020" , price 2984754 and discount 0.50
     |typ2|
    |MONTHLY|
    
    
   When the multyTicket is added to the system
 Then the already exist message  " This  multyticket is already exist" is diplayed multyticket
		
		
		
		
		
	  
	  