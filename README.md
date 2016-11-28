# Classroom-Voting
JSF App for voting free time hour

## Setup and deployment

1. Import project in your fauvorite IDE.
2. Add all jars from library folder to the Java Build Path of the project
3. Add all jars instead junit jar (not needed) to the Deployment Assembly of the project
4. Deploy project on a server (Tested with Tomcat 8.0.36)

## Usage

On Database class you can configure the free time options:

1. You can change the value of the options setting new value of this String:

  *private static final String hora1 = "12:30"* 

2. You can add as many options you need adding FreeTime class object to the votesList like this:

  *votesList.add(new FreeTime(hora1, 0));*
