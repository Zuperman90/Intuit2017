# Intuit2017 Challenge
______________________________
Author : Ajith Paul

How to run the program
----------
1. Compile IntuitChallenge .

	javac IntuitChallenge.java 

2. Run the executable using the below command

	java IntuitChallenge

3. Program will ask for the following inputs.

	Absolute Path to the folder containing the userdata files.
  
Implementation and Assumptions
----------------
The monthly expenses of the user is calculated by reading the transaction details and is compared with the monthly earnings. If the expenses exceed monthly earnings for a significant duration of the period of data given, it is assumed that the user follows poor finacial planning and the likelihood of breaking up is more.
The transactions data is also scanned for expenses related to movies, restaurants, wedding-related purchases etc. Different weightages are assigned to each and a score is assigned.
  
  Sample Output
-----------------------
Enter the abs path to the folder name (with slashes escaped)
C:\\Users\\Ajith\\Downloads\\rit-challenge-master\\rit-challenge-master\\transaction-data

File Name user-0.csv
=============User ID: 624 ================

Good likelihood of current relationship.

Reason: Good finacial planning!

Reason: Couple Earned good score in other parameters

Eg: Eating out, Movies, Wedding planner etc.

\==============================================

File Name user-1.csv
=============User ID: 63891 ================

Less likelihood of current relationship.

Reason: Poor finacial planning!

Monthly expenses exceeded income in more than half the duration given.

\==============================================

File Name user-10.csv
=============User ID: 7299 ================

Good likelihood of current relationship.

Reason: Good finacial planning!

Reason: Couple Earned good score in other parameters

Eg: Eating out, Movies, Wedding planner etc.

\==============================================

File Name user-11.csv
=============User ID: 56930 ================

Good likelihood of current relationship.

Reason: Good finacial planning!

Reason: Couple Earned good score in other parameters

Eg: Eating out, Movies, Wedding planner etc.

\==============================================

File Name user-12.csv
=============User ID: 15248 ================

Less likelihood of current relationship.

Reason: Poor finacial planning!

Monthly expenses exceeded income in more than half the duration given.

\==============================================
