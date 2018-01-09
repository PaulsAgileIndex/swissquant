## SwissQuant Assignment

### Prerequisite

  1. Add project Lombok to your IDE [(https://projectlombok.org/] (https://projectlombok.org/) - 
  the class ``com.swissquant.assignment.numbersdistance.model.point.Point`` is using it).  
  **ADVANTAGE:**  
  One does not have write ``getter/setter/hashCode/equals`` methods anymore.   
  For **Eclipse**:  
  Amend ``eclipse.ini`` and add ``lombok.jar`` to ``ECLIPSE_HOME`` (same 
  place where ``eclipse.ini`` could be found).
  
  **Important changes in ``eclipse.ini``**
  ```
   -javaagent:lombok.jar
   -Xbootclasspath/a:lombok.jar
  ```  

  Sources also could be found in ``${project.basedir}/prerequisite/eclipse``

  1. For easy integration testing use POSTMAN [https://www.getpostman.com/](https://www.getpostman.com/)
  

### Run the Application from Eclipse

  1. Navigate to ``com.swissquant.assignment.numbersdistance.SwissQuantApp``
  2. Context menu: **``Run As``** -> **``Java Application``**


### Run the Application from CLI

  1. Navigate to ${project.basedir}
  2. Execute **``mvn spring-boot:run``**


### Unit Test
  1. Invoked automatically during ``mvn clean install`` execution.


### Integration Test with POSTMAN

 1. Run the Application (SpringBoot)
 2. Import to Postman ``${project.basedir}/postman/NumberDistance.postman_collection.json`` 
 3. Execute request ``findFurthestPointsTo`` or ``findClosestPointsTo`` 
 4. Check results

 **IMPORTANT**
 1. ResultSet size could be changed in request parameter e.g ``resultSetSize=20``
 2. Algorithm could be changed with e.g. ``algoName=bruteforce`` (brutefoce is currently 
 the only available algorithm)
 2. The given point (reference point for which the search in performed) could be changed in request body 
 
 ```JSON
  {
    "x": 1000,
    "y": 25
  }
 ```


### Room for Improvement

 1. Implement and add some algorithms to the Factory ``com.swissquant.assignment.numbersdistance.algorith.AlgoFactory``
 2. The given assignment does not require reading different input files. Could be changed in later iterations 
 => reading given (static) file "points" at application start time.


### Sources

**Input for decoding the binary file**
   1. [https://stackoverflow.com/questions/7157901/how-to-read-signed-int-from-bytes-in-java](https://stackoverflow.com/questions/7157901/how-to-read-signed-int-from-bytes-in-java)   
   2. [https://stackoverflow.com/questions/7619058/convert-a-byte-array-to-integer-in-java-and-vice-versa](https://stackoverflow.com/questions/7619058/convert-a-byte-array-to-integer-in-java-and-vice-versa) 


**Input for implementing the algorithm**
   1. [http://www.zrzahid.com/k-closest-points/](http://www.zrzahid.com/k-closest-points/)   
   2. [https://codereview.stackexchange.com/questions/9943/finding-points-with-the-shortest-distance](https://codereview.stackexchange.com/questions/9943/finding-points-with-the-shortest-distance)

    