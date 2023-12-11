Feature: signin
	Description: The admin logs into the muesum 
	Actor: Admin
	
Scenario: Admin can login
	Given that the admin is not logged in
	And the password is "valid"
	Then the admin login succeeds
	And the admin is logged in
	
Scenario: Admin has the wrong password
	Given that the admin is not logged in
	And the password is "not valid"
	Then the admin login fails
	And the admin is not logged in

		Scenario: User can login
	Given that the User is not logged in
	And the user is already rigisterd
	And the username is "Ahmad Ali" ,password "H3H1T5" for user
	
	
	Then the user login succeeds
	And the user is logged in
	
Scenario: User has the wrong password or user name
	Given that the User is not logged in
	And the user is already rigisterd
	
	And the username is "Ahmad Alii" ,password "H3H1T55" for user
	

	Then the User login fails
	And the User is not logged in
	
	
	
	
		Scenario: visitor can login
	Given that the visitor is not logged in
	And the visitor is already rigisterd
	And the username is "Ahmad Ali" ,password "H3H1T5" for visitor
	
	
	Then the visitor login succeeds
	And the visitor is logged in
	
Scenario: visitor has the wrong password or user name
	Given that the visitor is not logged in
	And the visitor is already rigisterd
	
	And the username is "Ahmad Alii" ,password "H3H1T55" for visitor
	

	Then the visitor login fails
	And the visitor is not logged in
	
	
	
	
	
	