Feature: Update Guide
 Scenario: Update  a Guide
  Given that the Admin is logged insu
  And Guide enter herr id 2984754
  And  The guide IDu  exist in the Museum
   And update her name to "Anas Yasser"
  When the admin try to Update that guide
  Then Update Sucssed
  

 Scenario: Update  a Guide fail
  Given that the Admin is logged insu
  And Guide enter herr id 111
  And  The guide IDu  exist in the Museum
  When the admin try to Update that guide
  Then Updatee Guide faild
