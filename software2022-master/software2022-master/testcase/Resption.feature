Feature: isueeTicket
	Description: the visitor wont ticket and book tour
	Actor: visitor
	
Scenario: visitor can isuee ticket and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "one" ,visitorid 2984754 and subdate "12/10/2022" , dop "12/11/1960"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket succeeds
	
	
	Scenario: visitor can isuee ticket and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "one" ,visitorid 2984754 and subdate "12/10/2022" , dop "12/11/2020"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket succeeds
	
Scenario: visitor cant isuee ticket and have somthing wrong
	
	Given that the admin is logged inf
	
	And the visitor enter tickid 298475 ,ticktype "one" ,visitorid 298475 and subdate "21/10/2022" , dop "12/11/2020"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket fails for one
	Scenario: visitor can isuee ticket and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "one" ,visitorid 2984754 and subdate "12/10/2022" , dop "12/11/1960"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket succeeds
	Scenario: visitor can isuee ticket and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 298475 ,ticktype "one" ,visitorid 2984754 and subdate "12/10/2022" , dop "12/11/1960"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket succeeds
	
	
	Scenario: visitor can isuee ticket and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984753 ,ticktype "one" ,visitorid 2984754 and subdate "12/10/2022" , dop "12/11/2020"
	And the visitor is already rigistered
	
	When isueeticket for one
	Then the visitor isueeticket succeeds
	
	
	
	
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "yearly"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "monthly"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "daily"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 4 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "yearly"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 84754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "monthly"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 4754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "daily"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 44 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype "daily"
	
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 59 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/2020" and multytype  "daily"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
		
		Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 55 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "yearly"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
		Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 55 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "daily"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 298475 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "daily"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy	
		
		
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "monthly"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
	
	
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 555 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "yearly"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
		
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 29847566 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "daily"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy	
		
		
	Scenario: visitor can isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 298884754 ,ticktype "multy" ,visitorid 2984754 , subdate "12/10/2022" ,dop "12/11/1960" and multytype "monthly"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket succeeds for multy
		
			
		
		
		
		
		
		
		
		Scenario: visitor cant isuee ticket and the ticcket is multy
	Given that the admin is logged inf
	
	And the visitor enter tickid 298475 ,ticktype "multy" ,visitorid 298475 , subdate "21/10/2022" ,dop "12/11/2020" and multytype "daily"
	
    
	And the visitor is already rigistered for multy
	
		When isueeticket for multy and make discount
	Then the visitor isueeticket fails for multy
	
	
	
	
	Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "one" ,visitorid 2984754 and datewante "16/10/2022" , dop "12/11/1960" ,and langusge you want for guide "Espanish" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
	
	
	
	
	
		Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "18/10/2022" , dop "12/11/1960" ,and langusge you want for guide "Arabic" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
		Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "12/10/2022" , dop "12/11/1960" ,and langusge you want for guide "FRENCH" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
	Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "19/10/2022" , dop "12/11/1960" ,and langusge you want for guide "english" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
	Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "17/10/2022" , dop "12/11/1960" ,and langusge you want for guide "FRENCH" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
		Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "22/10/2022" , dop "12/11/1960" ,and langusge you want for guide "FRENCH" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
	
	
	Scenario: visitor can  booktour and the ticcket is one
	Given that the admin is logged inf
	
	And the visitor enter tickid 2984754 ,ticktype "multy" ,visitorid 2984754 and datewante "12/10/2022" , dop "12/11/2020" ,and langusge you want for guide "Arabic" ,and want guide "No" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour succeeds
	
		
	
	
	
	Scenario: visitor cant  booktour somthing wrong
	Given that the admin is logged inf
	
	And the visitor enter tickid 298 ,ticktype "multy" ,visitorid 29 and datewante "21/10/2022" , dop "12/11/1960" ,and langusge you want for guide "Arabi" ,and want guide "yes" ,hour 4 .minuite 30
	And the ticket is already exist for visitor 
	And have avaliable guide if want guide
	And the dat for to in muesum
	When booktour for visitor
	Then the visitor book tour fails
	
	
	
	
	
	
	
	Scenario: admin want to send massagage to visitor
	Given that the admin is logged inf
	
	And admin enter visitor id 2984754 ,dop "12/11/1960" ,massage "we have discounts"
	And the visitor is already exist 
	
	When admin send massage
	Then massage send sucssed
	
	
	
	Scenario: admin want to send massagage to visitor
	Given that the admin is logged inf
	
	And admin enter visitor id 2984754 ,dop "12/11/2020" ,massage "we have discounts"
	And the visitor is already exist 
	
	When admin send massage
	Then massage send sucssed
	
	
	
	
	
	
	Scenario: admin want to send massagage to visitor
	Given that the admin is logged inf
	
	And admin enter visitor id 2 ,dop "12/11/2020" ,massage "we have discounts"
	And the visitor is already exist 
	
	When admin send massage
	Then massage send fails
	
	Scenario: admin want to send massagage to visitor
	Given that the admin is logged inf
	
	And admin enter visitor id 2 ,dop "12/11/1960" ,massage "we have discounts"
	And the visitor is already exist 
	
	When admin send massage
	Then massage send fails
	
	
	
	
	
	
	Scenario: visitor want to addd notes  to visits
	
	
	And visitor enter the date of viisit "22/10/2022" ,dop "12/11/1960" mvisitorid 2984754 ,notes "this visit buitiful"
	And the visitor is already existn 
	And the visit is already exist for visitor
	When visitor add notes for visit
	Then visitor notes sucssed 
	
	
		Scenario: visitor want to addd notes  to visits
	
	
	And visitor enter the date of viisit "12/10/2022" ,dop "12/11/2020" mvisitorid 2984754 ,notes "this visit buitiful"
	And the visitor is already existn 
	And the visit is already exist for visitor
	When visitor add notes for visit
	Then visitor notes sucssed 
	

	
		
	Scenario: visitor want to addd notes  to visits
	
	
	And visitor enter the date of viisit "21/10/2022" ,dop "12/11/2020" mvisitorid 2984754 ,notes "this visit buitiful"
	And the visitor is already existn 
	And the visit is already exist for visitor
	When visitor add notes for visit
	Then visitor notes fails 
	
	Scenario: visitor want to addd notes  to visits
	
	
	And visitor enter the date of viisit "21/10/2022" ,dop "12/11/1960" mvisitorid 2984754 ,notes "this visit buitiful"
	And the visitor is already existn 
	And the visit is already exist for visitor
	When visitor add notes for visit
	Then visitor notes fails 
	
	
	Scenario: visitor want to addd notes  to visits
	
	
	And visitor enter the date of viisit "21/10/2022" ,dop "12/11/2020" mvisitorid 2 ,notes "this visit buitiful"
	And the visitor is already existn
	And the visit is already exist for visitor
	When visitor add notes for visit
	Then visitor notes fails