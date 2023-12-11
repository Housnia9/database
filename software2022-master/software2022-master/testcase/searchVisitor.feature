Feature: Search visitor

Scenario: Search a Visitorsn

  Given That the Admin is logged inv
  And Visitor enter her dob "12/11/1960"
   And Visitor enter her idv 2984754
  And The Visitor dob Exist in the Museuam
   And  The Visitor IDv  Exists in the Museum
  When the admin try to Search that Visitor
  Then Searchss sucssed
  
  
  Given That the Admin is logged inv
  And Visitor enter her dob "12/11/2020"
   And Visitor enter her idv 2984754
  And The Visitor dob Exist in the Museuam
   And  The Visitor IDv  Exists in the Museum
  When the admin try to Search that Visitor
  Then Searchss sucssed
  
  Scenario: search  a Visitor fail
  Given That the Admin is logged inv
  And Visitor enter her dob "13/5/2001"
  And Visitor enter her idv 101100
  And The Visitor dob Exist in the Museuam
  And  The Visitor IDv  Exists in the Museum
  When the admin try to Search that Visitor
  Then Searchss Visitor faild