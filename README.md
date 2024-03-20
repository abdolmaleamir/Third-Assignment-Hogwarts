The project is a simulation of a Hogwarts school management system, where users 
can manage teachers, students, and courses. The system is implemented using Java classes and methods, and it uses object-oriented programming principles to organize the code.

The main class is Main, which contains the main method that starts the program. The Main class creates instances of the Hogwarts and Assistant classes, and then displays a main menu to the user. The user can choose to manage teachers, students, or courses, or they can exit the program.

The Hogwarts class represents the Hogwarts school and contains lists of teachers, students, and courses. The Hogwarts class provides methods to add and remove teachers, students, and courses, and to view the lists of teachers, students, and courses.

The Assistant class represents the assistant who manages the Hogwarts school. The Assistant class contains lists of teachers and students who have requested to join the school. The Assistant class provides methods to handle teacher and student requests, and to view the lists of teacher and student requests.

The Teacher and Student classes represent teachers and students, respectively. The Teacher and Student classes contain fields for the teacher or student's name, password, and other relevant information. The Teacher and Student classes provide methods to change the teacher or student's name and password, and to view the teacher or student's profile.






Student Class Overview

The Student class extends the Account class and includes the following fields:

courses: an ArrayList of Strings representing the student's course names.
username: a String representing the student's username.
score: a double representing the student's score.
password: a String representing the student's encrypted password.
group: a String representing the student's Hogwarts group.
Constructors

The Student class has one constructor that initializes the username, password, group, and score fields. However, the courses field is not initialized in the constructor.

Methods

changeUsername(String newUsername): Overrides the changeUsername method from the Account class to update the username field.
changePassword(String newPassword): Overrides the changePassword method from the Account class to update the password field.
toString(): Overrides the toString method to provide a String representation of the Student object.
showProfile(): Displays the student's profile information, including their username, score, courses, and Hogwarts group.
getCourses(): Returns the courses ArrayList.
validatePassword(String enteredPassword): Validates the entered password against the stored encrypted password.





Teacher Class Overview

The Teacher class extends the Account class and includes the following fields:

lumos: an int representing the teacher's number of votes.
course: a String representing the teacher's course name.
score: a double representing the teacher's score.
username: a String representing the teacher's username.
password: a String representing the teacher's encrypted password.
Constructors

The Teacher class has one constructor that initializes the username, password, score, and course fields.

Methods

changePassword(String newPassword): Overrides the changePassword method from the Account class to update the password field.
toString(): Overrides the toString method to provide a String representation of the Teacher object.
validatePassword(String enteredPassword): Validates the entered password against the stored encrypted password.
setVote(int lumos): Sets the teacher's number of votes.
getVote(): Returns the teacher's number of votes.
showProfile(): Displays the teacher's profile information, including their username, score, course, and number of votes






Account Class Overview

The Account class includes the following fields:

accountID: a UUID representing the account's unique identifier.
username: a String representing the account's username.
password: a String representing the account's encrypted password.
The Student and Teacher classes extend the Account class and include additional fields specific to their respective roles.

Constructors

The Account class has a default constructor that initializes the accountID field with a new UUID.

The Student and Teacher classes have constructors that initialize the username, password, score, course, lumos, and courses fields.

Methods

changeUsername(String newUsername): Updates the username field.
changePassword(String newPassword): Updates the password field.
validatePassword(String enteredPassword): Validates the entered password against the stored encrypted password.





Hogwarts Class Overview

The Hogwarts class includes the following fields:

studentsList: an ArrayList of Strings representing the students' information.
coursesList: an ArrayList of Strings representing the courses' names.
teachersList: an ArrayList of Strings representing the teachers' information.
Constructors

The Hogwarts class has a default constructor that initializes the studentsList, coursesList, and teachersList fields as empty ArrayLists.

Methods

viewAllTeachers(): Displays the list of teachers' information.
viewAllStudents(): Displays the list of students' information.
teacherAppend(String enteredTeacher): Adds a teacher's information to the teachersList field.
studentsAppend(String enteredStudent): Adds a student's information to the studentsList field.
defaultCourses(): Adds the default courses to the coursesList field.
viewAllCourses(): Displays the list of courses






Assistant Class Overview

The Assistant class extends the Hogwarts class and includes the following fields:

wantingteachers: an ArrayList of Strings representing the teachers' requests.
wantingstudents: an ArrayList of Strings representing the students' requests.
username: a String representing the assistant's username.
password: a String representing the assistant's encrypted password.
Constructors

The Assistant class has a default constructor that initializes the wantingteachers and wantingstudents fields as empty ArrayLists, and sets the username and password fields to "harrypotter" and "76856734", respectively.

Methods

viewAllTeachers(): Displays the list of teachers' information.
viewAllStudents(): Displays the list of students' information.
viewAllCourses(): Displays the list of courses.
teacherAppend(String enteredTeacher): Adds a teacher's information to the teachersList field.
studentsAppend(String enteredStudent): Adds a student's information to the studentsList field.
adjustCourseList(): Allows the user to add or remove courses from the coursesList field.
adjustTeachersList(): Allows the user to remove teachers from the teachersList field.
adjustStudentList(): Allows the user to remove students from the studentsList field.
showRequestTeacher(): Displays the list of teachers' requests.
showRequestStudent(): Displays the list of students' requests.
validatePassword(String enteredPassword): Validates the entered password against the stored encrypted password.
validateUsername(String enteredUsername): Validates the enteredusername against the stored username.



+-----------------+
|       Main       |
+-----------------+
| - assistant: Assistant |
| - hogwarts: Hogwarts |
| + runMenu()         |
+-----------------+

+-----------------+
|     Assistant   |
+-----------------+
| - lumos: int     |
| - password: str  |
| - course: str    |
| - score: double  |
| - username: str  |
| + viewAllTeachers()|
| + viewAllStudents()|
| + viewAllCourses()|
| + teacherAppend(str) |
| + studentsAppend(str)|
| + defaultCourses()  |
+-----------------+

+-----------------+
|      Hogwarts   |
+-----------------+
| - studentsList: ArrayList<str> |
| - coursesList: ArrayList<str>   |
| - teachersList: ArrayList<str>  |
| + viewAllTeachers()|
| + viewAllStudents()|
| + viewAllCourses()|
| + teacherAppend(str) |
| + studentsAppend(str)|
+-----------------+

+-----------------+
|     Teacher     |
+-----------------+
| - password: str  |
| - course: str    |
| - score: double  |
| - username: str  |
| + changeUsername(str newUsername) |
| + changePassword(str newPassword) |
| + toString()     |
| + showProfile()  |
| + getCourses()   |
| + validatePassword(str enteredPassword) |
+-----------------+

+-----------------+
|    Student     |
+-----------------+
| - password: str  |
| - course: ArrayList<str> |
| - group: str    |
| - score: double  |
| - username: str  |
| + changeUsername(str newUsername) |
| + changePassword(str newPassword) |
| + toString()     |
| + showProfile()  |
| + getCourses()   |
| + validatePassword