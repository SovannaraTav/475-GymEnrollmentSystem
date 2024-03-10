/*
PostgreSQL JDBC Driver Documentation - https://jdbc.postgresql.org/documentation/

Team 475 - Gym Enrollment System
1) Adam Chhor
2) Ian McNeal
3) Sandesh Rai
4) Sovannara Tav
 */
import java.sql.*; // Imports all packages tied to the PostgreSQL JDBC Driver
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class GymEnrollmentSystem
{
    public static Connection conn;
    public static void main(String[] args) throws SQLException
    {
        Terminal.runTerminal();
    }

    /** #1
     * @Author Sandesh Rai
     * @return returns true if updating a class' instructor in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateInstructorInClass(
            String classNumber, String newInstructorNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET instructorId = 
                    (SELECT id FROM Instructor WHERE instructorNumber = ?)
                WHERE classNumber = ?
                """
            );
            query.setString(1, newInstructorNumber);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated instructor in class. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #2
     * @Author Sandesh Rai
     * @return returns true if updating a class' instructor to NULL in the Class
     * table was successful and displays the number of rows updated. Otherwise,
     * returns false.
     */
    public static boolean removeInstructorFromClass(String classNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET instructorId = NULL
                WHERE classNumber = ?
                """
            );
            query.setString(1, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Remove instructor from class. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #3
     * @Author Sandesh Rai
     * @return returns true if adding a new participant to the Participants table
     * was successful and displays the number of rows inserted. Otherwise, returns
     * false.
     */
    public static boolean addMemberToClass(String classNumber, String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO Participants (classId, memberId)
                VALUES
                    (
                    (SELECT id FROM Class WHERE classNumber = ?),
                    (SELECT id FROM Member WHERE memberNumber = ?)
                    )
                """
            );
            query.setString(1, classNumber);
            query.setString(2, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println(
                    "Added member to class. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #4
     * @Author Sandesh Rai
     * @return returns true if updating a member's class enrollment in the
     * Participants table was successful and displays the number of rows updated.
     * Otherwise, returns false.
     */
    public static boolean updateMemberClassEnrollment(
            String oldClassNumber, String newClassNumber, String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Participants
                SET classId = (SELECT id FROM Class WHERE classNumber = ?)
                WHERE classId = (SELECT id FROM Class WHERE classNumber = ?) AND 
                    memberId = (SELECT id FROM Member WHERE memberNumber = ?)
                """
            );
            query.setString(1, newClassNumber);
            query.setString(2, oldClassNumber);
            query.setString(3, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated member's class enrollment. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #5
     * @Author Sandesh Rai
     * @return returns true if removing a participant from the Participants table
     * was successful and displays the number of rows deleted. Otherwise, returns
     * false.
     */
    public static boolean removeMemberFromClass(
            String classNumber, String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Participants
                WHERE classID = (SELECT id FROM Class WHERE classNumber = ?) AND 
                    memberID = (SELECT id FROM Member WHERE memberNumber = ?)
                """
            );
            query.setString(1, classNumber);
            query.setString(2, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = query.executeUpdate();
            System.out.println(
                    "Removed member from class. Rows deleted: " + rowsDeleted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #6
     * @Author Sandesh Rai
     * @return returns true if adding a new member to the Member table was successful
     * and displays the number of rows inserted. Otherwise, returns false.
     */
    public static boolean addMember(
            String firstName, String lastName, String email,
            String phoneNumber, String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO Member 
                    (firstName, lastName, email, phoneNumber, memberNumber)
                VALUES (?, ?, ?, ?, ?)
                """
            );
            query.setString(1, firstName);
            query.setString(2, lastName);
            query.setString(3, email);
            query.setString(4, phoneNumber);
            query.setString(5, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println(
                    "Added member. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #7
     * @Author Sandesh Rai
     * @return returns true if updating a member's email in the Member table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateMemberEmail(String memberNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Member
                SET email = ?
                WHERE memberNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated member's email. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #8
     * @Author Sandesh Rai
     * @return returns true if updating a member's phone number in the Member table
     * was successful and displays the number of rows updated. Otherwise, returns
     * false.
     */
    public static boolean updateMemberPhoneNumber(
            String memberNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Member
                SET phoneNumber = ?
                WHERE memberNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated member's phone number. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #9
     * @Author Sandesh Rai
     * @return returns true if updating a member's last payment in the Member table
     * was successful and displays the number of rows updated. Otherwise, returns
     * false.
     */
    public static boolean updateMemberLastPayment(
            String memberNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Member
                SET lastPayment = ?
                WHERE memberNumber = ?
                """
            );
            query.setDate(1, Date.valueOf(newValue));
            query.setString(2, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated member's last payment. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #10
     * @Author Sandesh Rai
     * @return returns true if removing a member from the Member table and their
     * class enrollments from the Participants table was successful and displays
     * the number of rows deleted from both tables. Otherwise, returns false.
     */
    public static boolean removeMember(String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Participants
                WHERE memberID = (SELECT id FROM Member WHERE memberNumber = ?)
                """
            );
            query.setString(1, memberNumber);

            PreparedStatement query2 = conn.prepareStatement("""
                DELETE FROM Member
                WHERE memberNumber = ?
                """
            );
            query2.setString(1, memberNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = (query.executeUpdate() + query2.executeUpdate());
            System.out.println(
                    "Removed member and their class enrollments. Rows deleted: "
                            + rowsDeleted);
            query.close();
            query2.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #11
     * @Author Sovannara Tav
     * @return returns true if adding a new instructor to the Instructor table was
     * successful and displays the number of rows inserted. Otherwise, returns false.
     */
    public static boolean addInstructor(
            String firstName, String lastName, String email, String phoneNumber,
            String instructorNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO Instructor 
                    (firstName, lastName, email, phoneNumber, instructorNumber)
                VALUES (?, ?, ?, ?, ?)
                """
            );
            query.setString(1, firstName);
            query.setString(2, lastName);
            query.setString(3, email);
            query.setString(4, phoneNumber);
            query.setString(5, instructorNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println(
                    "Added instructor. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #12
     * @Author Sovannara Tav
     * @return returns true if updating an instructor's email in the Instructor
     * table was successful and displays the number of rows updated. Otherwise,
     * returns false.
     */
    public static boolean updateInstructorEmail(
            String instructorNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Instructor
                SET email = ?
                WHERE instructorNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, instructorNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated instructor's email. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #13
     * @Author Sovannara Tav
     * @return returns true if updating an instructor's phone number in the
     * Instructor table was successful and displays the number of rows updated.
     * Otherwise, returns false.
     */
    public static boolean updateInstructorPhoneNumber(
            String instructorNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Instructor
                SET phoneNumber = ?
                WHERE instructorNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, instructorNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated instructor's phone number. Rows updated: "
                            + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #14
     * @Author Sovannara Tav
     * @return returns true if removing an instructor from the Instructor table and
     * updating their previously assigned classes to NULL from the Class table was
     * successful and displays the number of rows updated and deleted. Otherwise,
     * returns false.
     */
    public static boolean removeInstructor(String instructorNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET instructorId = NULL
                WHERE instructorId = 
                    (SELECT id FROM Instructor WHERE instructorNumber = ?)
                """
            );
            query.setString(1, instructorNumber);

            PreparedStatement query2 = conn.prepareStatement("""
                DELETE FROM Instructor
                WHERE instructorNumber = ?
                """
            );
            query2.setString(1, instructorNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            int rowsDeleted = query2.executeUpdate();
            System.out.println(
                    "Updated instructor's previously assigned classes. Rows updated: "
                            + rowsUpdated);
            System.out.println(
                    "Removed instructor. Rows deleted: " + rowsDeleted);
            query.close();
            query2.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #15
     * @Author Sovannara Tav
     * @return returns true if adding a new class to the Class table was successful
     * and displays the number of rows inserted. Otherwise, returns false.
     */
    public static boolean addClass(
            String classTypeName, String instructorNumber, String roomNumber,
            String startTime, String duration, String classNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO Class 
                    (typeId, instructorId, roomId, startTime, duration, classNumber)
                VALUES
                    (
                    (SELECT id FROM ClassType WHERE name = ?),
                    (SELECT id FROM Instructor WHERE instructorNumber = ?),
                    (SELECT id FROM Room WHERE roomNumber = ?),
                    ?::TIMESTAMP, ?::INTERVAL, ?
                    )
                """
            );
            query.setString(1, classTypeName);
            query.setString(2, instructorNumber);
            query.setString(3, roomNumber);
            query.setString(4, startTime);
            query.setString(5, duration);
            query.setString(6, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println(
                    "Added class. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #16
     * @Author Sovannara Tav
     * @return returns true if updating a class' start time in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateClassStartTime(String classNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET startTime = ?::TIMESTAMP
                WHERE classNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated class' start time. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #17
     * @Author Sovannara Tav
     * @return returns true if updating a class' duration in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateClassDuration(String classNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET duration = ?::INTERVAL
                WHERE classNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated class' duration. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #18
     * @Author Sovannara Tav
     * @return returns true if removing a class from the Class table and its
     * corresponding records from the Participants table was successful and displays
     * the number of rows deleted from both tables. Otherwise, returns false.
     */
    public static boolean removeClass(String classNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Participants
                WHERE classId = (SELECT id FROM Class WHERE classNumber = ?)
                """
            );
            query.setString(1, classNumber);

            PreparedStatement query2 = conn.prepareStatement("""
                DELETE FROM Class
                WHERE classNumber = ?
                """
            );
            query2.setString(1, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = (query.executeUpdate() + query2.executeUpdate());
            System.out.println(
                    "Removed class and their corresponding participants records. " +
                            "Rows deleted: " + rowsDeleted);
            query.close();
            query2.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #19
     * @Author Sovannara Tav
     * @return returns true if adding a new room to the Room table was successful
     * and displays the number of rows inserted. Otherwise, returns false.
     */
    public static boolean addRoom(String roomNumber, int capacity)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO Room (roomNumber, capacity)
                VALUES (?, ?)
                """
            );
            query.setString(1, roomNumber);
            query.setInt(2, capacity);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println("Added room. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #20
     * @Author Sovannara Tav
     * @return returns true if updating a room's capacity in the Room table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateRoomCapacity(String roomNumber, int newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Room
                SET capacity = ?
                WHERE roomNumber = ?
                """
            );
            query.setInt(1, newValue);
            query.setString(2, roomNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated room's capacity. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #21
     * @Author Sovannara Tav
     * @return returns true if removing a room from the Room table and updating
     * their previously assigned classes to NULL from the Class table was successful
     * and displays the number of rows updated and deleted. Otherwise, returns false.
     */
    public static boolean removeRoom(String roomNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET roomId = NULL
                WHERE roomId = (SELECT id FROM Room WHERE roomNumber = ?)
                """
            );
            query.setString(1, roomNumber);

            PreparedStatement query2 = conn.prepareStatement("""
                DELETE FROM Room
                WHERE roomNumber = ?
                """
            );
            query2.setString(1, roomNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            int rowsDeleted = query2.executeUpdate();
            System.out.println(
                    "Updated room's previously assigned classes. Rows updated: "
                            + rowsUpdated);
            System.out.println(
                    "Removed room. Rows deleted: " + rowsDeleted);
            query.close();
            query2.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #22
     * @Author Sovannara Tav
     * @return returns true if updating a class' room number in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false.
     */
    public static boolean updateRoomInClass(String classNumber, String newRoomNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET roomId = (SELECT id FROM Room WHERE roomNumber = ?)
                WHERE classNumber = ?
                """
            );
            query.setString(1, newRoomNumber);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Updated room in class. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #23
     * @Author Sovannara Tav
     * @return returns true if updating a class' room number to NULL in the Class
     * table was successful and displays the number of rows updated. Otherwise,
     * returns false.
     */
    public static boolean removeRoomFromClass(String classNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET roomId = NULL
                WHERE classNumber = ?
                """
            );
            query.setString(1, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println(
                    "Removed room from class. Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #24
     * @Author Sovannara Tav
     * @return returns true if adding a new class type to the ClassType table was
     * successful and displays the number of rows inserted. Otherwise, returns false.
     */
    public static boolean addClassType(String name)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                INSERT INTO ClassType (name)
                VALUES (?)
                """
            );
            query.setString(1, name);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println(
                    "Added class type. Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }

    /** #25
     * @Author Sovannara Tav
     * @return returns true if the last payment of a gym member from the Member table
     * is NULL or less than or equal to 30 days indicating their gym membership is
     * active. Otherwise, indicates their gym membership is not active, but still
     * returns true.
     */
    public static boolean checkGymMembership(String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                    SELECT
                        CASE
                            WHEN lastPayment IS NULL
                                THEN '1' 
                            WHEN (CURRENT_DATE - lastPayment) <= 30
                                THEN '1'
                            ELSE '0'
                        END AS membershipStatus
                    FROM Member
                    WHERE memberNumber = ?
                    """
            );
            query.setString(1, memberNumber);


            ResultSet result = query.executeQuery();
            if (result.next())
            {
                if (result.getString("membershipStatus").equals("0"))
                {
                    System.out.println("Gym membership is not active");
                }
                else
                {
                    System.out.println("Gym membership is active");
                }
            }
            result.close();
            query.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /** #26
     * @Author Ian McNeal
     * @return Formatted String of instructor information of a given class.
     */
    public static String getInstructorForClass(String classNumber) throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, 
                Instructor.lastname AS instructor_lastname, 
                Instructor.email, Instructor.phoneNumber
            FROM Class
                JOIN Instructor ON (Class.instructorId = Instructor.id)
            WHERE Class.classNumber = ?;
            """
        );
        query.setString(1, classNumber);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #27
     * @Author Adam Chhor
     * @return Formatted String Table of members' information of "classNumber" and
     * limits column by "numberOfRowsToReturn".
     */
    public static String getMembersInClass(
            String classNumber, int numberOfRowsToReturn) throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
                SELECT firstName, lastName, email, phoneNumber, startDate, memberNumber
                FROM Member M
                    JOIN Participants P ON P.memberId = M.id
                    JOIN Class C ON C.id = P.classId
                WHERE C.classNumber = ?
                LIMIT ?
                """
        );
        query.setString(1, classNumber);
        query.setInt(2, numberOfRowsToReturn);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #28
     * @Author Ian McNeal
     * @return Formatted String Table of all classes member is enrolled in.
     */
    public static String getGymMemberClasses(String memberNumber) throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, 
                Instructor.lastName AS instructor_lastname, 
                Room.roomNumber AS room_number, ClassType.name AS class_type, 
                Class.startTime AS start_time, Class.duration
            FROM Member
                JOIN Participants ON (Member.id = Participants.memberId)
                JOIN Class ON (Participants.classId = Class.id)
                JOIN Instructor ON (Class.instructorId = Instructor.id)
                JOIN ClassType ON (Class.typeId = ClassType.id)
                JOIN Room ON (Class.roomId = Room.id)
            WHERE Member.memberNumber = ?;
            """
        );
        query.setString(1, memberNumber);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #29
     * @Author Ian McNeal
     * @return Formatted String Table of all classes member is enrolled in on a
     * given day.
     */
    public static String getGymMemberClasses(String memberNumber, String date)
            throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstName AS instructor_firstname, 
                Instructor.lastName AS instructor_lastname, 
                Room.roomNumber AS room_number, ClassType.name AS class_type, 
                Class.startTime AS start_time, Class.duration
            FROM Member
                JOIN Participants ON (Member.id = Participants.memberId)
                JOIN Class ON (Participants.classId = Class.id)
                JOIN Instructor ON (Class.instructorId = Instructor.id)
                JOIN ClassType ON (Class.typeId = ClassType.id)
                JOIN Room ON (Class.roomId = Room.id)
            WHERE Member.memberNumber = ? AND Class.startTime::DATE = ?::DATE
            ORDER BY Class.startTime;
            """
        );
        query.setString(1, memberNumber);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #30
     * @Author Ian McNeal
     * @return Formatted String Table of all classes an instructor leads.
     */
    public static String getGymInstructorClasses(String instructorNumber)
            throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Room.roomNumber AS room_number, ClassType.name AS class_type, 
                Class.startTime AS start_time, Class.duration
            FROM Instructor
                JOIN Class ON (Instructor.id = Class.instructorId)
                JOIN ClassType ON (Class.typeId = ClassType.id)
                JOIN Room ON (Class.roomId = Room.id)
            WHERE Instructor.instructorNumber = ?
            ORDER BY Class.startTime;
            """
        );
        query.setString(1, instructorNumber);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #31
     * @Author Ian McNeal
     * @return Formatted String Table of all classes an instructor leads on a given
     * day.
     */
    public static String getGymInstructorClasses(String instructorNumber, String date)
            throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Room.roomNumber AS room_number, ClassType.name AS class_type, 
                Class.startTime AS start_time, Class.duration
            FROM Instructor
                JOIN Class ON (Instructor.id = Class.instructorId)
                JOIN ClassType ON (Class.typeId = ClassType.id)
                JOIN Room ON (Class.roomId = Room.id)
            WHERE Instructor.instructorNumber = ? AND Class.startTime::DATE = ?::DATE
            ORDER BY Class.startTime;
            """
        );
        query.setString(1, instructorNumber);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #32
     * @Author Ian McNeal
     * @return Formatted String Table of all classes of a given class type.
     */
    public static String getGymClassByClassType(String classType) throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, 
                Instructor.lastname AS instructor_lastname, 
                Room.roomNumber AS room_number, 
                Class.startTime AS start_time, Class.duration
            FROM Class
                JOIN Instructor ON (Class.instructorId = Instructor.id)
                JOIN Room ON (Class.roomId = Room.id)
                JOIN ClassType ON (Class.typeId = ClassType.id)
            WHERE ClassType.name = ?
            ORDER BY Class.startTime;
            """
        );
        query.setString(1, classType);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }

    /** #33
     * @Author Ian McNeal
     * @return Formatted String Table of all classes of a given class type on a given
     * day.
     */
    public static String getGymClassByClassType(String classType, String date)
            throws SQLException
    {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstName AS instructor_firstname, 
                Instructor.lastName AS instructor_lastname, 
                Room.roomNumber AS room_number, 
                Class.startTime AS start_time, Class.duration
            FROM Class
                JOIN Instructor ON (Class.instructorId = Instructor.id)
                JOIN Room ON (Class.roomId = Room.id)
                JOIN ClassType ON (Class.typeId = ClassType.id)
            WHERE ClassType.name = ? AND Class.startTime::DATE = ?::DATE
            ORDER BY Class.startTime;
            """
        );
        query.setString(1, classType);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        String output = Util.parseDataBase(result);
        result.close();
        query.close();
        return output;
    }
}