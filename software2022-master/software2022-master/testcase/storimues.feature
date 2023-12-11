Feature: informatin for muesuem
 Scenario: show all servises and stories in muesum
  Given that the admin is logged insss
  
  When show servises in muesum 
  Then the servises ba printed

  Scenario: not show all servises and stories in muesum
  Given that the admin is not logged insss
  
  When show servises in muesum 
  Then the servises printed faild