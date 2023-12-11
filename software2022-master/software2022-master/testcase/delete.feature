Feature: Delete  user
 Scenario: Delete  a Guide
  Given that the admin is logged ins
  And Guide enter her id 2984666
  And  The guide ID  exist in the Museum
  When the admin try to Delete that guide
  Then Delete Failds
  

 Scenario: Delete  a Guide fail
  Given that the admin is logged ins
  And Guide enter her id 111
  And  The guide ID  exist in the Museum
  When the admin try to Delete that guide
  Then Delete Guide sucssed