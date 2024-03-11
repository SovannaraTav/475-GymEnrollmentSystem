import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author Adam Chhor
 * helper methods
 */
public class Terminal
{
  static Scanner input = new Scanner(System.in);

  public static void runTerminal() throws SQLException
  {
    setUp();
    boolean isRunning = true;
    while (isRunning)
    {
      displayOptions();
      System.out.println("\nEnter a number between 0 and 33 inclusively:");
      int apiNumber = getUserInput();
      switch (apiNumber)
      {
        case 0:
        {
          isRunning = false;
          break;
        }
        case 1:
        {
          String classNumber = getInputtedClassNumber();
          String newInstructorNumber = getInputtedNewInstructorNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateInstructorInClass(
                  classNumber, newInstructorNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 2:
        {
          String classNumber = getInputtedClassNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeInstructorFromClass(
                  classNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 3:
        {
          String classNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addMemberToClass(
                  classNumber, memberNumber));
          // Normal behavior
          break;
        }
        case 4:
        {
          String oldClassNumber = getInputtedClassNumber();
          String newClassNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateMemberClassEnrollment(
                  oldClassNumber, newClassNumber, memberNumber));
          // Causes the corresponding participant record to move to the bottom
          break;
        }
        case 5:
        {
          String classNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeMemberFromClass(
                  classNumber, memberNumber));
          // Normal behavior
          break;
        }
        case 6:
        {
          String firstName = getInputtedFirstName();
          String lastName = getInputtedLastName();
          String email = getInputtedEmail();
          String phoneNumber = getInputtedPhoneNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addMember(
                  firstName, lastName, email, phoneNumber, memberNumber));
          // Normal behavior
          break;
        }
        case 7:
        {
          String memberNumber = getInputtedMemberNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateMemberEmail(
                  memberNumber, newValue));
          // Causes the corresponding member record to move to the bottom
          break;
        }
        case 8:
        {
          String memberNumber = getInputtedMemberNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateMemberPhoneNumber(
                  memberNumber, newValue));
          // Causes the corresponding member record to move to the bottom
          break;
        }
        case 9:
        {
          String memberNumber = getInputtedMemberNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateMemberLastPayment(
                  memberNumber, newValue));
          // Causes the corresponding member record to move to the bottom
          break;
        }
        case 10:
        {
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeMember(
                  memberNumber));
          // Normal behavior
          break;
        }
        case 11:
        {
          String firstName = getInputtedFirstName();
          String lastName = getInputtedLastName();
          String email = getInputtedEmail();
          String phoneNumber = getInputtedPhoneNumber();
          String instructorNumber = getInputtedInstructorNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addInstructor(
                  firstName, lastName, email, phoneNumber, instructorNumber));
          // Normal behavior
          break;
        }
        case 12:
        {
          String instructorNumber = getInputtedInstructorNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateInstructorEmail(
                  instructorNumber, newValue));
          // Causes the corresponding member record to move to the bottom
          break;
        }
        case 13:
        {
          String instructorNumber = getInputtedInstructorNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateInstructorPhoneNumber(
                  instructorNumber, newValue));
          // Causes the corresponding member record to move to the bottom
          break;
        }
        case 14:
        {
          String instructorNumber = getInputtedInstructorNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeInstructor(
                  instructorNumber));
          /*
          Normal behavior when removing an instructor record. The corresponding class
          records are move to the bottom
           */
          break;
        }
        case 15:
        {
          String classTypeName = getInputtedClassType();
          String instructorNumber = getInputtedInstructorNumber();
          String roomNumber = getInputtedRoomNumber();
          String startTime = getInputtedStartTime();
          String duration = getInputtedDuration();
          String classNumber = getInputtedClassNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addClass(
                  classTypeName, instructorNumber, roomNumber, startTime,
                  duration, classNumber));
          // Normal behavior
          break;
        }
        case 16:
        {
          String classNumber = getInputtedClassNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateClassStartTime(
                  classNumber, newValue));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 17:
        {
          String classNumber = getInputtedClassNumber();
          String newValue = getInputtedNewValue();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateClassDuration(
                  classNumber, newValue));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 18:
        {
          String classNumber = getInputtedClassNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeClass(
                  classNumber));
          // Normal behavior
          break;
        }
        case 19:
        {
          String roomNumber = getInputtedRoomNumber();
          int capacity = getInputtedCapacity();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addRoom(
                  roomNumber, capacity));
          // Normal behavior
          break;
        }
        case 20:
        {
          String roomNumber = getInputtedRoomNumber();
          int newValue = getInputtedCapacity();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateRoomCapacity(
                  roomNumber, newValue));
          // Causes the corresponding room record to move to the bottom
          break;
        }
        case 21:
        {
          String roomNumber = getInputtedRoomNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeRoom(
                  roomNumber));
          /*
          Normal behavior when removing a room record. The corresponding class
          records are move to the bottom
           */
          break;
        }
        case 22:
        {
          String classNumber = getInputtedClassNumber();
          String newRoomNumber = getInputtedNewRoomNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.updateRoomInClass(
                  classNumber, newRoomNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 23:
        {
          String classNumber = getInputtedClassNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.removeRoomFromClass(
                  classNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 24:
        {
          String name = getInputtedClassType();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addClassType(
                  name));
          // Normal behavior
          break;
        }
        case 25:
        {
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(GymEnrollmentSystem.checkGymMembership(
                  memberNumber));
          break;
        }
      }

      // Deals with return of String as they throw SQLException
      try
      {
        switch (apiNumber)
        {
          case 26:
          {
            String classNumber = getInputtedClassNumber();
            System.out.println(GymEnrollmentSystem.getInstructorForClass(
                    classNumber));
            break;
          }
          case 27:
          {
            String classNumber = getInputtedClassNumber();
            int numberOfRowsToReturn = getInputtedNumberOfRowsToReturn();
            System.out.println(GymEnrollmentSystem.getMembersInClass(
                    classNumber, numberOfRowsToReturn));
            break;
          }
          case 28:
          {
            String memberNumber = getInputtedMemberNumber();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(
                    memberNumber));
            break;
          }
          case 29:
          {
            String memberNumber = getInputtedMemberNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(
                    memberNumber, date));
            break;
          }
          case 30:
          {
            String instructorNumber = getInputtedInstructorNumber();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(
                    instructorNumber));
            break;
          }
          case 31: {
            String instructorNumber = getInputtedInstructorNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(
                    instructorNumber, date));
            break;
          }
          case 32:
          {
            String classType = getInputtedClassType();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(
                    classType));
            break;
          }
          case 33:
          {
            String classType = getInputtedClassType();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(
                    classType, date));
            break;
          }
          case 34: {
            System.out.println(GymEnrollmentSystem.getAllClassType());
            break;
          }
          case 35: {
            System.out.println(GymEnrollmentSystem.getAllRoom());
            break;
          }
          case 36: {
            System.out.println(GymEnrollmentSystem.getAllMember());
            break;
          }
          case 37: {
            System.out.println(GymEnrollmentSystem.getAllInstructor());
            break;
          }
        }
      }
      catch (SQLException e)
      {
        System.out.println("Error");
      }
    }
    System.out.println("Exiting system. Database connection closed");
    GymEnrollmentSystem.conn.close();
  }

  public static void setUp()
  {
    // Retrieves the PostgreSQL database properties
    Properties properties = new Properties();
    String fileName = "DatabaseProperties.properties";
    try
    {
      FileInputStream inputFile = new FileInputStream(fileName);
      properties.load(inputFile);
      inputFile.close();
    }
    catch (IOException e)
    {
      System.err.println("Input file error: " + e.getMessage());
      return;
    }
    String url = properties.getProperty("database.url");
    String user = properties.getProperty("database.user");
    String password = properties.getProperty("database.password");

    // Establishes the connection between JDBC and PostgreSQL database
    try
    {
      GymEnrollmentSystem.conn = DriverManager.getConnection(url, user, password);
      System.out.println("Database connection established");
      // PRINT OUT TEST QUERIES HERE:
    }
    catch (SQLException e)
    {
      System.err.println("Database connection error: " + e.getMessage());
    }
  }

  public static void displayOptions()
  {
    System.out.println("0 - Exit");
    System.out.println("1 - updateInstructorInClass()");
    System.out.println("2 - removeInstructorFromClass()");
    System.out.println("3 - addMemberToClass()");
    System.out.println("4 - updateMemberClassEnrollment()");
    System.out.println("5 - removeMemberFromClass()");
    System.out.println("6 - addMember()");
    System.out.println("7 - updateMemberEmail()");
    System.out.println("8 - updateMemberPhoneNumber()");
    System.out.println("9 - updateMemberLastPayment()");
    System.out.println("10 - removeMember()");
    System.out.println("11 - addInstructor()");
    System.out.println("12 - updateInstructorEmail()");
    System.out.println("13 - updateInstructorPhoneNumber()");
    System.out.println("14 - removeInstructor()");
    System.out.println("15 - addClass()");
    System.out.println("16 - updateClassStartTime()");
    System.out.println("17 - updateClassDuration()");
    System.out.println("18 - removeClass()");
    System.out.println("19 - addRoom()");
    System.out.println("20 - updateRoomCapacity()");
    System.out.println("21 - removeRoom()");
    System.out.println("22 - updateRoomInClass()");
    System.out.println("23 - removeRoomFromClass()");
    System.out.println("24 - addClassType()");
    System.out.println("25 - checkGymMembership()");
    System.out.println("26 - getInstructorForClass()");
    System.out.println("27 - getMembersInClass()");
    System.out.println("28 - getGymMemberClasses()");
    System.out.println("29 - getGymMemberClasses() on a given day");
    System.out.println("30 - getGymInstructorClasses()");
    System.out.println("31 - getGymInstructorClasses() on a given day");
    System.out.println("32 - getGymClassByClassType()");
    System.out.println("34 - getAllClassType()");
    System.out.println("35 - getAllRoom()");
    System.out.println("36 - getAllMember()");
    System.out.println("37 - getAllInstructor()");
  }

  public static void dealWithUnsuccessfulTransaction(boolean isSuccessful)
  {
    if (isSuccessful)
    {
      System.out.println("Success in executing function\n");
    }
    else
    {
      System.out.println("Error in executing function\n");
    }
  }

  public static String getStringInput(
          String typeOfParam, String paramName, String exampleText)
  {
    System.out.println();
    System.out.println("Enter Value for " + paramName + ":");
    System.out.println("Type: " + typeOfParam);
    if (!exampleText.isEmpty())
    {
      System.out.println("Example format: " + exampleText);
    }
    boolean isValidInput = false;
    String inputString = "";
    while (!isValidInput)
    {
      try
      {
        inputString = input.nextLine();
        isValidInput = true;
      }
      catch (Exception e)
      {
        System.out.println("Invalid input, try again");
      }
    }
    return inputString;
  }

  public static int getUserInput()
  {
    boolean isValidInput = false;
    int inputInt = 0;
    while (!isValidInput)
    {
      try
      {
        inputInt = Integer.parseInt(input.nextLine());
        isValidInput = true;
      }
      catch (Exception e)
      {
        System.out.println("Invalid input, try again");
      }
    }
    return inputInt;
  }

  public static int getIntInput(
          String typeOfParam, String paramName, String exampleText)
  {
    System.out.println();
    System.out.println("Enter Value for " + paramName + ":");
    System.out.println("Type: " + typeOfParam);
    if (!exampleText.isEmpty())
    {
      System.out.println("Example format: " + exampleText);
    }
    boolean isValidInput = false;
    int inputInt = 0;
    while (!isValidInput)
    {
      try
      {
        inputInt = Integer.parseInt(input.nextLine());
        isValidInput = true;
      }
      catch (Exception e)
      {
        System.out.println("Invalid input, try again");
      }
    }
    return inputInt;
  }

  public static String getInputtedClassNumber()
  {
    return getStringInput(
            "String", "classNumber", "CLS021");
  }

  public static String getInputtedInstructorNumber()
  {
    return getStringInput(
            "String", "instructorNumber", "INS021");
  }

  public static String getInputtedNewInstructorNumber()
  {
    return getStringInput(
            "String", "newInstructorNumber", "INS021");
  }

  public static String getInputtedMemberNumber()
  {
    return getStringInput(
            "String", "memberNumber", "MEM021");
  }

  public static String getInputtedFirstName()
  {
    return getStringInput(
            "String", "firstName", "Bob");
  }

  public static String getInputtedLastName()
  {
    return getStringInput(
            "String", "lastName", "Smith");
  }

  public static String getInputtedEmail()
  {
    return getStringInput(
            "String", "email", "smith@email.com");
  }

  public static String getInputtedPhoneNumber()
  {
    return getStringInput(
            "String", "phoneNumber", "4253525000");
  }

  public static String getInputtedNewValue()
  {
    return getStringInput(
            "String", "newValue", "");
  }

  public static String getInputtedRoomNumber()
  {
    return getStringInput(
            "String", "roomNumber", "121");
  }

  public static String getInputtedNewRoomNumber()
  {
    return getStringInput(
            "String", "newRoomNumber", "121");
  }

  public static String getInputtedStartTime()
  {
    return getStringInput(
            "String", "startTime", "2024-03-11 08:45:00");
  }

  public static String getInputtedDuration()
  {
    return getStringInput(
            "String", "duration", "02:00:00");
  }

  public static int getInputtedCapacity()
  {
    return getIntInput(
            "int", "capacity", "100");
  }

  public static int getInputtedNumberOfRowsToReturn()
  {
    return getIntInput(
            "int", "numberOfRowsToReturn", "10");
  }

  public static String getInputtedDate()
  {
    return getStringInput(
            "Date", "Date", "2024-03-11");
  }

  public static String getInputtedClassType()
  {
    return getStringInput(
            "String", "classType", "Running");
  }
}
