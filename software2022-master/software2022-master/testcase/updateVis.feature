Feature: Update Visitor
 Scenario: Update  a Visitor
  Given that the Admin is logged invs
  And   Visitor enter her dobb "12/11/1960"
  And   Visitor enter her idss 2984754
   And The Visitor dobb Exist in the Museuam
  And  The Visitor IDs  Exists in the Museum
   And update Senior Visitor name  to "Kareem Ali"
  When the admin try to Updatee that Visitor
  Then Update Sucssedd
  

  
 Scenario: Update  a Visitor
  Given that the Admin is logged invs
  And   Visitor enter her dobb "12/11/2020"
  And   Visitor enter her idss 2984754
   And The Visitor dobb Exist in the Museuam
  And  The Visitor IDs  Exists in the Museum
   And update Regular Visitor names to "Mohammad Mahmood"
  When the admin try to Updatee that Visitor
  Then Update Sucssedd
  
 
 Scenario: Update  a Visitor fail
  Given that the Admin is logged invs
  And Visitor enter her dobb "13/5/2001"
  And Visitor enter her idss 101100
  And The Visitor dobb Exist in the Museuam
  And  The Visitor IDs  Exists in the Museum
  When the admin try to Updatee that Visitor
  Then Updatee Visitor faild
  
