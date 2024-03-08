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
    public static void main(String[] args)
    {
        Terminal.runTerminal();
    }

    /** #1
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean addInstructorToClass(String classNumber, String instructorNumber) {
        try {
        PreparedStatement query = conn.prepareStatement("""
                
                """
        );
        ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #2
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean updateInstructorInClass(String classNumber, String newInstructorNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #3
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean removeInstructorFromClass(String classNumber, String instructorNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #4
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean addMemberToClass(String classNumber, String memberNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #5
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean updateMemberClassEnrollment(String oldClassNumber, String newClassNumber, String memberNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #6
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean removeMemberFromClass(String classNumber, String memberNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #7
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean addMember(String firstName, String lastName, String email, String phoneNumber, String memberNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #8
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean updateMemberEmail(String memberNumber, String newValue) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #9
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean updateMemberPhoneNumber(String memberNumber, String newValue) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #10
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean updateMemberLastPayment(String memberNumber, String newValue) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #11
     * @Author Sandesh Rai
     * @return returns true if
     */
    public static boolean removeMember(String memberNumber) {
        try {
            PreparedStatement query = conn.prepareStatement("""
                
                """
            );
            ResultSet result = query.executeQuery();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #12
     * @Author Sovannara Tav
     * @return returns true if adding a new instructor to the Instructor table was
     * successful and displays the number of rows inserted. Otherwise, returns false
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
            System.out.println("Rows inserted: " + rowsInserted);
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
     * @return returns true if updating an instructor's email in the Instructor
     * table was successful and displays the number of rows updated. Otherwise,
     * returns false
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
            System.out.println("Rows updated: " + rowsUpdated);
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
     * @return returns true if updating an instructor's phone number in the
     * Instructor table was successful and displays the number of rows updated.
     * Otherwise, returns false
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
            System.out.println("Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #15
     * @Author Sovannara Tav
     * @return returns true if removing an instructor from the Instructor table was
     * successful and displays the number of rows deleted. Otherwise, returns false
     */
    public static boolean removeInstructor(String instructorNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Instructor
                WHERE instructorNumber = ?
                """
            );
            query.setString(1, instructorNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = query.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
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
     * @return returns true if adding a new class to the Class table was successful
     * and displays the number of rows updated. Otherwise, returns false
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
                    ?, ?, ?
                    )
                """
            );
            query.setString(1, classTypeName);
            query.setString(2, instructorNumber);
            query.setString(3, roomNumber);
            query.setTimestamp(4, Timestamp.valueOf(startTime));
            query.setString(5, duration);
            query.setString(6, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsInserted = query.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
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
     * @return returns true if updating a class' start time in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false
     */
    public static boolean updateClassStartTime(String classNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET startTime = ?
                WHERE classNumber = ?
                """
            );
            query.setTimestamp(1, Timestamp.valueOf(newValue));
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
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
     * @return returns true if updating a class' duration in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false
     */
    public static boolean updateClassDuration(String classNumber, String newValue)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET duration = ?
                WHERE classNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #19
     * @Author Sovannara Tav
     * @return returns true if updating a class' room number in the Class table was
     * successful and displays the number of rows updated. Otherwise, returns false
     */
    public static boolean updateClassRoomNumber(String classNumber, String roomNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Class
                SET roomId = (SELECT id FROM Room WHERE roomNumber = ?)
                WHERE classNumber = ?
                """
            );
            query.setString(1, roomNumber);
            query.setString(2, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
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
     * @return returns true if removing a class from the Class table was successful
     * and displays the number of rows deleted. Otherwise, returns false
     */
    public static boolean removeClass(String classNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Class
                WHERE classNumber = ?
                """
            );
            query.setString(1, classNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = query.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
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
     * @return returns true if adding a new room to the Room table was successful
     * and displays the number of rows inserted. Otherwise, returns false
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
            System.out.println("Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #22
     * @Author Sovannara Tav
     * @return returns true if updating the room number of a room in the Room table
     * was successful and displays the number of rows updated. Otherwise, returns
     * false
     */
    public static boolean updateRoomNumber(String roomNumber, String newValue)
    {
        try {
            PreparedStatement query = conn.prepareStatement("""
                UPDATE Room
                SET roomNumber = ?
                WHERE roomNumber = ?
                """
            );
            query.setString(1, newValue);
            query.setString(2, roomNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsUpdated = query.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            query.close();
        } catch(SQLException e) {
            return false;
        }
        return true;
    }
    /** #23
     * @Author Sovannara Tav
     * @return returns true if updating a room's capacity in the Room table was
     * successful and displays the number of rows updated. Otherwise, returns false
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
            System.out.println("Rows updated: " + rowsUpdated);
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
     * @return returns true if removing a room from the Room table was successful
     * and displays the number of rows deleted. Otherwise, returns false
     */
    public static boolean removeRoom(String roomNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM Room
                WHERE roomNumber = ?
                """
            );
            query.setString(1, roomNumber);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = query.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
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
     * @return returns true if adding a new class type to the ClassType table was
     * successful and displays the number of rows inserted. Otherwise, returns false
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
            System.out.println("Rows inserted: " + rowsInserted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #26
     * @Author Sovannara Tav
     * @return returns true if removing a class type from the ClassType table was
     * successful and displays the number of rows deleted. Otherwise, returns false
     */
    public static boolean removeClassType(String name)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                DELETE FROM ClassType
                WHERE name = ?
                """
            );
            query.setString(1, name);

            // Need to use .executeUpdate() instead of .executeQuery() for CRUD
            int rowsDeleted = query.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
            query.close();
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #27
     * @Author Sovannara Tav
     * @return returns true if the membership of a gym member from the Member table
     * is active. Otherwise, returns false
     */
    public static boolean checkGymMembership(String memberNumber)
    {
        try
        {
            PreparedStatement query = conn.prepareStatement("""
                    SELECT lastPayment
                    FROM Member
                    WHERE memberNumber = ?
                    """);
            query.setDate(1, Date.valueOf(memberNumber));

            /*
            If lastPayment is an empty string, thus indicating that it is NULL, then
            the membership of a gym member is not active
             */
            ResultSet result = query.executeQuery();
            if (result.getString(1).isEmpty()) {
                return false;
            }
        }
        catch(SQLException e)
        {
            return false;
        }
        return true;
    }
    /** #28
     * @Author Ian McNeal
     * @return Formatted String of instructor information of a given class.
     */
    public static String getInstructorForClass(String classNumber) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, Instructor.lastname AS instructor_lastname, 
                Instructor.email, Instructor.phonenumber
            FROM Class
                JOIN Instructor ON (Class.instructorid = Instructor.id)
            WHERE Class.classnumber = ?;
                """
        );
        query.setString(1, classNumber);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }
    /** #29
     * @Author Adam Chhor
     * @return Formatted String Table of members' information of "classNumber" and limits column by "numberOfRowsToReturn"
     */
    public static String getMembersInClass(String classNumber, int numberOfRowsToReturn) throws SQLException {
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
        return Util.parseDataBase(result);
    }

    /** #30
     * @Author Ian McNeal
     * @return Formatted String Table of all classes member is enrolled in.
     */
    public static String getGymMemberClasses(String memberNumber) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, Instructor.lastname AS instructor_lastname, 
                Room.roomnumber AS room_number, ClassType.name AS class_type, 
                Class.starttime AS start_time, Class.duration
            FROM Member
                JOIN Participants ON (Member.id = Participants.memberid)
                JOIN Class ON (Participants.classid = Class.id)
                JOIN Instructor ON (Class.instructorid = Instructor.id)
                JOIN ClassType ON (Class.typeid = ClassType.id)
                JOIN Room ON (Class.roomid = Room.id)
            WHERE Member.membernumber = ?;
                """
        );
        query.setString(1, memberNumber);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }

    /** #31
     * @Author Ian McNeal
     * @return Formatted String Table of all classes member is enrolled in on a given day.
     */
    public static String getGymMemberClasses(String memberNumber, String date) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, Instructor.lastname AS instructor_lastname, 
                Room.roomnumber AS room_number, ClassType.name AS class_type, 
                Class.starttime AS start_time, Class.duration
            FROM Member
                JOIN Participants ON (Member.id = Participants.memberid)
                JOIN Class ON (Participants.classid = Class.id)
                JOIN Instructor ON (Class.instructorid = Instructor.id)
                JOIN ClassType ON (Class.typeid = ClassType.id)
                JOIN Room ON (Class.roomid = Room.id)
            WHERE Member.membernumber = ? AND Class.starttime::date = ?::date
            ORDER BY Class.starttime;
                """
        );
        query.setString(1, memberNumber);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }

    /** #32
     * @Author Ian McNeal
     * @return Formatted String Table of all classes an instructor leads.
     */
    public static String getGymInstructorClasses(String instructorNumber) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Room.roomnumber AS room_number, ClassType.name AS class_type, 
                Class.starttime AS start_time, Class.duration
            FROM Instructor
                JOIN Class ON (Instructor.id = Class.instructorid)
                JOIN ClassType ON (Class.typeid = ClassType.id)
                JOIN Room ON (Class.roomid = Room.id)
            WHERE Instructor.instructornumber = ?
            ORDER BY Class.starttime;
                """
        );
        query.setString(1, instructorNumber);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }

    /** #33
     * @Author Ian McNeal
     * @return Formatted String Table of all classes an instructor leads on a given day.
     */
    public static String getGymInstructorClasses(String instructorNumber, String date) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Room.roomnumber AS room_number, ClassType.name AS class_type, 
                Class.starttime AS start_time, Class.duration
            FROM Instructor
                JOIN Class ON (Instructor.id = Class.instructorid)
                JOIN ClassType ON (Class.typeid = ClassType.id)
                JOIN Room ON (Class.roomid = Room.id)
            WHERE Instructor.instructornumber = ? AND Class.starttime::date = ?::date
            ORDER BY Class.starttime;
                """
        );
        query.setString(1, instructorNumber);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }

    /** #34
     * @Author Ian McNeal
     * @return Formatted String Table of all classes of a given class type.
     */
    public static String getGymClassByClassType(String classType) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, Instructor.lastname AS instructor_lastname, 
                Room.roomnumber AS room_number, Class.starttime AS start_time, Class.duration
            FROM Class
                JOIN Instructor ON (Class.instructorid = Instructor.id)
                JOIN Room ON (Class.roomid = Room.id)
                JOIN ClassType ON (Class.typeid = ClassType.id)
            WHERE ClassType.name = ?
            ORDER BY Class.starttime;
                """
        );
        query.setString(1, classType);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }

    /** #35
     * @Author Ian McNeal
     * @return Formatted String Table of all classes of a given class type on a given day.
     */
    public static String getGymClassByClassType(String classType, String date) throws SQLException {
        PreparedStatement query = conn.prepareStatement("""
            SELECT Instructor.firstname AS instructor_firstname, Instructor.lastname AS instructor_lastname, 
                Room.roomnumber AS room_number, Class.starttime AS start_time, Class.duration
            FROM Class
                JOIN Instructor ON (Class.instructorid = Instructor.id)
                JOIN Room ON (Class.roomid = Room.id)
                JOIN ClassType ON (Class.typeid = ClassType.id)
            WHERE ClassType.name = ? AND Class.starttime::date = ?::date
            ORDER BY Class.starttime;
                """
        );
        query.setString(1, classType);
        query.setString(2, date);
        ResultSet result = query.executeQuery();
        return Util.parseDataBase(result);
    }
}