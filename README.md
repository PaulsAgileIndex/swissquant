## NumberDistance Assignment

###

After an very unprofessional feedback form the local software house which gave me this 
task I made some changes to obscure their involvement to this.

I wrote my own input file and made some changes to the given problem. I also changed the 
package structure and names to wipe out them.

By the way - one (especially professional developers) could and they should be able to easily follow the whole development process by following the commit 
messages provided by GitHub. To say that this is not written by me is just unprofessional 
and ignorant. 

I've overachieved the assignment tasks to show my abilities e.g. 
- A call to the function (closest/furthest) shouldn't be more than 10 seconds (10000 ms - stated in the assignment). My average duration was 200 milliseconds for a call.
- I implemented a cache for the point universe. Key of the cache is the hash value of the Points coordinate -> reduce duplicates in the point universe
- I provided easy expandability of the application (factory for the algorithm used. The algorithm could be chosen by the client)
- I provided a REST API for easy testablility (integration tests with POSTMAN)
- I have implemented the application flexible in regards to that I'm not bound to static input points - which means give me the closest/furthest points to any point inside and outside the point universe.
- My result size is flexible and could also be parameterized from outside
- ...
- After the delivery of the assignment I added a writer for 16 bit encoded integer 
coordinates for Points to create a point universe.

### Prerequisite

  1. Add project Lombok to your IDE ([https://projectlombok.org/](https://projectlombok.org/) - 
  the class ``com.swissquant.assignment.numbersdistance.model.Point`` is using it).  
  **ADVANTAGE:**  
  One does not have to write ``getter/setter/hashCode/equals`` methods anymore.   
  For **Eclipse**:  
  Amend ``eclipse.ini`` and add ``lombok.jar`` to ``ECLIPSE_HOME`` (same 
  place where ``eclipse.ini`` could be found).
  
  **Important changes in ``eclipse.ini``**
  ```
   -vmargs
   -javaagent:lombok.jar
   -Xbootclasspath/a:lombok.jar
  ```  

  Sources also could be found in ``${project.basedir}/prerequisite/eclipse``

  1. For easy integration testing use POSTMAN [https://www.getpostman.com/](https://www.getpostman.com/)
  

### Run the Application from Eclipse

  1. Add Lombok to Eclipse as described above
  2. Navigate to ``com.swissquant.assignment.numbersdistance.SwissQuantApp``
  3. Context menu: **``Run As``** -> **``Java Application``**


### Run the Application from CLI

  1. Navigate to ${project.basedir}
  2. Execute **``mvn spring-boot:run``**


### Unit Test
  1. Invoked automatically during **``mvn clean install``** execution.
  2. Due to the more integration test like character of some unit tests one could also dismiss test execution for faster build cycles with **``mvn clean install-DskipTests``**


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

    