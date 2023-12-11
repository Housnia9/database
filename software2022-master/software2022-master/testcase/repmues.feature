Feature: Fall Report for muesuem
 Scenario: show all information in muesum
  Given that the admin is logged inss
  
  When show information in muesum 
  Then the informatin ba printed

 Scenario: notshow all information in muesum
  Given that the admin isnot logged ins
  
  When show information in muesum 
  Then the informatin ba printed faild