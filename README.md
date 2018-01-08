## SwissQuant Assigment

### Prerequisite

 1. Add project Lombok to your IDE.   
 The class ``com.swissquant.assignment.numbersdistance.model.point.Point`` is using it.
  
 For **Eclipse** amend ``eclipse.ini`` and add ``lombok.jar`` to ``ECLIPSE_HOME``. 
 
 Sources could be found in ``/number-distance-spring-boot/prerequisite/eclipse``

  **Important changes in ``eclipse.ini``**
  ```
  -javaagent:lombok.jar
  -Xbootclasspath/a:lombok.jar
  ```

### Integration Test with POSTMAN

 1. Run com.swissquant.assignment.numbersdistance.SwissQuantApp (SpringBoot Application)
 2. Import /number-distance-spring-boot/postman/NumberDistance.postman_collection.json to Postman 
 3. Execute findFurthestPointsTo or findClosestPointsTo request
 4. Check results
    