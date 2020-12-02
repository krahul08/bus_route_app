 # Bus Route App (Development Mode)
  
  ## Intro
  
  ### A simple Bus route showing app using Sample.json file that is in the Assets folder of the project, that have all the details of your Bus.
  
  
  ## Stack used
  
  1. Java
  2. Android studio
  3. Mutable Live Data
  
  ## Database Used
  1. Sqlite Room Database
  
  ## Resources used
  1. Room Library
  2. MVVM Design pattern used
  
  ## The App
  
  ## 1. Model
  
  - Defined model(Data class) based on the need of the project.
  - Have Common timmings data class.
  - Searialized data class.
  
  ## 2. Network
  
   - Used defined Json from assets folder as per the app needs.
   
   
   ## 3. Utils
   
   - Added Type converters for room db.
   - Have public static function for fetch/read Json from Assets folder.
   
   ## 4. DB
    
    - Have Bus Database
    - Have DAO
    - Entities.
    
  ## 5. View Model
  
   -  All the business logic
   -  Comparing given timing with current time.
   
   ## 6. View
   
     - OnClickListner
     - RecyclerView Adapters
     - And all the UI desings
  
  
 ## Problems and Assumptions the 
  - First of all i found issues with the Json that is in timings, because there are objects which are empty.
  - And for the timings we only have 4 timings objects which will be repetitive. So as per my knowledge and for the time being i hard coded only one object to check that list and their clicks.
  - Secondly i thought a approach to work like that attach that four objects with route position, for eg: position of horizontal list will show the 002's data and so on, and it will repeat again from 5 position of vertical list.
  - As per my knowledge adding list of routes is ok, but if it is about the timing, then we have to think alot over it , becaue if we do so, we  have to make particular table for particular timings like 002, 003 and so on, and then fetch data and then compare with current timings.
  - Till i added route data in db.
  - I tried my level best for Structuring my codes.
  
  
  ## Future things
  - Will add data binding.
  - will add timings data if i get the correct Json.
  - Obviously the ui things.
  - We can also add view pager along with tablayout if needs.
  
