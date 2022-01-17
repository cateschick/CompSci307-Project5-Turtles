## Lab Discussion
### Team 18
### Cate Schick (cms168), Dania Fernandez (df122), Carter Stonesifer (cbs58)


### Issues in Current Code

#### LogoCommand subclasses
 * declarations should use java collection interfaces (as opposed to arrayLists in constructor) --> make into private variable and access using getters (still arrayList)(don't use in constructor)  
 * no redundant booleans

#### Parser class 
 * abstraction: make parser package and have a parser for each language 
 * add catch for exception (mistake in submitted code) with popup prompting user to check what they wrote/submitted  

#### Pen and Turtle class 
* remove Javafx imports 
* move into view 
* magic numbers

#### Model, ReadWrite, Display, Toolbar 
*  some public constructors 


### Refactoring Plan

 * What are the code's biggest issues?
 - Communication between each of our parts (I/O, backend, frontend)
 - need to reduce dependencies: reduce number of model systsems view has access to

 * Which issues are easy to fix and which are hard?
 - easy to fix issues: public instance vars (make into private and access using getters), remove magic numbers (store in variable)
 - hard to fix issues: abstracting Parser for other 2 languanges 

 * What are good ways to implement the changes "in place"?
 - absract to remove duplicate code 


### Refactoring Work

 * Issue chosen: declarations should use Java collection interfaces
 - Fix: switch arraylist to collection declaration of Parser and store arrayList as private var in Parser
 - Alternatives: directly use collection in parser methods 


 * Issue chosen: reduce dependencies
 - Fix: asbtract display class into package, move turtle and pen into view 
 - Alternatives: have just one display class, remove javafx imports from turtle and pen
