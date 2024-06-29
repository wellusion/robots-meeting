This is one of the ways to solve the task about robot's meetings.
Most solutions are focused on implementation of the meeting robots logic. This version of the solution first of all are 
focused on emulating the task's conditions.

There is:
The discrete line that knows the robots locations and their parachutes;  
The robots themselves, each of which has the meeting program;
And of course the program, which runs when the robots are landed.

To solve the task are used kotlin.sequences functions, that emulate the relatively simultaneous execution of each 
robot's program. Every program's step, the conditions of parachute presence and meeting robot are checked.
Sequences functions are a kotlin feature. A more general way to implement the task conditions is to directly use multithreading.

Thus, both robots are executing their programs independently and searching for each other on the line.

Task conditions:
There are 2 robots. They are being landing by parachutes onto a discrete, infinite straight line. Initially, it is 
unclear what the distance between the robots and who is on the left and who is on the right.

Task:
Write a program for the robots that will guarantee their meeting. The program is the same for both robots. Communications 
between the robots are absent.

Depending on the version of the task, robots may not have memory. We will stick to this version.

Allowable operations:
moveLeft - One step to the left
moveRight - Obe step to the right
goto - Go to the specified line of the program
startPoint - Checking the presence of a parachute under the feet


