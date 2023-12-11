Feature: search  user
 Scenario: search a Guide
  Given that the admin is logged inssv
  And Guide enter her id  2984754
  And  The guide IDs  exists in the Museum
  When the admin try to search that guide
  Then search sucssed
  

 Scenario: search  a Guide fail
  Given that the admin is logged inssv
  And Guide enter her id 10110
  And  The guide IDs  exists in the Museum
  When the admin try to search that guide
  Then search Guide fail
  
  
  