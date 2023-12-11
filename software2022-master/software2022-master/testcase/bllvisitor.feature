Feature: biiling for visitor

Scenario: the visitor want to add
  Given that the admin is logged inscc
  And the visitor enter "yes" ,the name of service "eating" ,visitorid 2984754 ,dop "12/11/2020"
  And the visitor is exist
  When add the service to visitor
  Then service added to visitor

 Scenario: the visitor want to add
  Given that the admin is logged inscc
  And the visitor enter "yes" ,the name of service "eating" ,visitorid 2984754 ,dop "12/11/1960"
  And the visitor is exist
  When add the service to visitor
  Then service added to visitor

 Scenario: the visitor dont want to add
  Given that the admin is logged inscc
  And the visitor enter "No" ,the name of service "eating" ,visitorid 2984754 ,dop "12/11/1960"
  
  And the visitor is exist
  When add the service to visitor
  Then service not added to visitor

 Scenario: the visitor want to add
  Given that the admin is logged insss
  And the visitor enter "yes" ,the name of service "eating" ,visitorid 3333 ,dop "12/11/1960"
  And the visitor is exist
 When add the service to visitor
  Then service not added to visitor
  Scenario: the visitor want to add
  Given that the admin is logged inscc
  And the visitor enter "yes" ,the name of service "eating" ,visitorid 3333 ,dop "12/11/2020"
  And the visitor is exist
  When add the service to visitor
  Then service not added to visitor
 
































 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "daily" and dob "12/11/1960"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed


 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "monthly" and dob "12/11/1960"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "yearly" and dob "12/11/1960"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

  Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "daily" and dob "12/11/2020"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "one" and dob "12/11/2020"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed
Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "one" and dob "12/11/1960"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "monthly" and dob "12/11/2020"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 2984754 and type "yearly" and dob "12/11/2020"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed

 Scenario: billing for types to ticket
  Given that the admin is logged inss
  And enter visitor id 777 and type "yepo" and dob "12/11/2020"
  And the visitor is exist and this type exist for this visitor
  When bbiling 
  Then the billing ba printed failed