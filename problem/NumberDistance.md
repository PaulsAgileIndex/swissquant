

## Number Distance

### Problem
--------------------

You're given a binary file called "myPointUniverse" containing 10'000'000 points (x,y). Each point is encoded
as two 16 bit signed integer values in series.

Develop and ship a Java program that computes, based on the point universe provided by the file "myPointsUniverse"

 - The 10 closest points to (-201, 301)
 - The 20 furthest points form (1001, 26)
 
 Use Maven or Gradle. All files and libraries necessary to run the solution should be shipped. 
 
### Acceptance Criteria
 --------------------
 
 - FR: Find the solution of 20 closest and 30 furthest points.
 - FR: Use the ordinary resp. Euclidean distance to evaluate how close two points are. 
 - NFR: The computation of each result should take no longer than 10000 ms (10 sec).
 - NFR: The solution should be packaged such that a <Name of the Company> developer can easily understand
   how to build it from source code and run it. <- I really have my doubt that they have such developers
   
   
### Attention
 -------------------- 
 
 - The first 3 points in the file are: (-715, 22165), (761, -23591), (-194, 6015)
 - Do a professional job in terms of implementation, validation and packaging
 - Please do not distribute this challenge or solution to it <- yes and please be fair to your candidates