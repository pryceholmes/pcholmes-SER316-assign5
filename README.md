This file serves as a README for assignment 5. 

As of assignment 5a, there is a clean Git repo and gradle is set up. 
Checkstyle and spotbugs are setup, along with jacoco reports. 
Github actions are setup to run for all branches (currently just master).
There is a test class setup that runs and passes when the program is built.
The test class currently just includes one dummy test that will always pass on build, 
but as the program is implemented actual test cases will be added. 

I plan to implement 3 design patterns from the Gang of Four. I plan for these design patterns to work
together to form one running program instead of implemented independently of each other. 
Here is an overview of what design patterns I plan to implement, this is subject to change. 

Design pattern 1: State Behavior pattern - this pattern could be used to simulate the game running in cycles: Q1, Q2, Q3, Q4. 
For instance when the state is set to Q1, physical attacks always deal X amount less damage. We can keep track of what cycle we
are in using the state pattern. 

Design pattern 2: Mediator pattern. As stated in the requirements, the simulation could be tick based (not a requirement). I think I want to
implement my game this way and use the mediator pattern for communication between the different components of the game. 

Design pattern 3: Factory pattern. To create the characters in different classes such as a fighter or mage or thief, I could use
the factory pattern to create the character like described in the lecture videos. This would allow us to create different types
of characters without a mess of conditionals and constructor calls. 
