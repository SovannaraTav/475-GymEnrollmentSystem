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
      System.out.println("Enter a number between 0 and 34 inclusively:");
      displayOptions();
      int apiNumber = getIntInput();
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
          dealWithUnsuccessfulTransaction(
                  GymEnrollmentSystem.updateInstructorInClass(classNumber, newInstructorNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 2:
        {
          String classNumber = getInputtedClassNumber();
          dealWithUnsuccessfulTransaction(
                  GymEnrollmentSystem.removeInstructorFromClass(classNumber));
          // Causes the corresponding class record to move to the bottom
          break;
        }
        case 3:
        {
          String classNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(
                  GymEnrollmentSystem.addMemberToClass(classNumber, memberNumber));
          // Normal behavior
          break;
        }
        case 4:
        {
          String oldClassNumber = getInputtedClassNumber();
          String newClassNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(
                  GymEnrollmentSystem.updateMemberClassEnrollment(oldClassNumber, newClassNumber, memberNumber));
          // Causes the corresponding participant record to move to the bottom
          break;
        }
        case 5:
        {
          String classNumber = getInputtedClassNumber();
          String memberNumber = getInputtedMemberNumber();
          dealWithUnsuccessfulTransaction(
                  GymEnrollmentSystem.removeMemberFromClass(classNumber, memberNumber));
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
          break;
        }
        case 16:
        {
          break;
        }
        case 17:
        {
          break;
        }
        case 18:
        {
          break;
        }
        case 19:
        {
          break;
        }
        case 20:
        {
          break;
        }
        case 21:
        {
          break;
        }
        case 22:
        {
          break;
        }
        case 23:
        {
          break;
        }
        case 24:
        {
          break;
        }
        case 25:
        {
          break;
        }
        case 26:
        {
          break;
        }
      }
//    }finally {
//        continue;
//      }
      //deals with return of String as they throw SQLException
      try
      {
        switch (apiNumber)
        {
          case 27:
          {
            String classNumber = getInputtedClassNumber();
            System.out.println(GymEnrollmentSystem.getInstructorForClass(classNumber));
            break;
          }
          case 28:
          {
            String classNumber = getInputtedClassNumber();
            int numberOfRowsToReturn = getInputtedNumberOfRowsToReturn();
            System.out.println(GymEnrollmentSystem.getMembersInClass(classNumber, numberOfRowsToReturn));
            break;
          }
          case 29:
          {
            String memberNumber = getInputtedMemberNumber();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(memberNumber));
            break;
          }
          case 30:
          {
            String memberNumber = getInputtedMemberNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(memberNumber, date));
            break;
          }
          case 31:
          {
            String instructorNumber = getInputtedInstructorNumber();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(instructorNumber));
            break;
          }
          case 32: {
            String instructorNumber = getInputtedInstructorNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(instructorNumber, date));
            break;
          }
          case 33:
          {
            String classType = getInputtedClassType();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(classType));
            break;
          }
          case 34:
          {
            String classType = getInputtedClassType();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(classType, date));
            break;
          }
        }
      }
      catch (SQLException e)
      {
        System.out.println("ERRORRRRR");
        System.out.println(e.toString());
      }
    }
    System.out.println("Exiting System...");
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
//      System.out.println("Database connection established");
//           System.out.println(getMembersInClass("CLS001", 4));
      //PRINT OUT TEST QUERIES HERE:
    }
    catch (SQLException e)
    {
      System.err.println("Database connection error: " + e.getMessage());
    }
  }

  public static void displayOptions() {
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
    //
    System.out.println("27 - getInstructorForClass()");
    System.out.println("28 - getMembersInClass()");
    System.out.println("29 - getGymMemberClasses()");
    System.out.println("30 - getGymMemberClasses() on date");
    System.out.println("31 - getGymInstructorClasses()");
    System.out.println("32 - getGymInstructorClasses() on date");
    System.out.println("33 - getGymClassByClassType()");
    System.out.println("34 - getGymClassByClassType() on date");
  }

  //TODO: better work idk?
  public static void dealWithUnsuccessfulTransaction(boolean isSuccessful)
  {
    if (isSuccessful)
    {
      System.out.println("Success");
    }
    else
    {
      System.out.println("There was a problem");
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
      System.out.println("Ex. " + exampleText);
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

  public static int getIntInput()
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
    System.out.println("Type: " + typeOfParam);
    System.out.println("Ex. " + exampleText);
    if (!exampleText.isEmpty())
    {
      System.out.println(paramName + ": " + exampleText);
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

  //useable code, so probalby easier
  public static String getInputtedClassNumber()
  {
    return getStringInput("String", "classNumber", "");
  }

  public static String getInputtedInstructorNumber()
  {
    return getStringInput("String", "instructorNumber", "");
  }

  public static String getInputtedNewInstructorNumber()
  {
    return getStringInput("String", "newInstructorNumber", "");
  }

  public static String getInputtedMemberNumber()
  {
    return getStringInput("String", "memberNumber", "");
  }

  public static String getInputtedFirstName()
  {
    return getStringInput("String", "firstName", "");
  }

  public static String getInputtedLastName()
  {
    return getStringInput("String", "lastName", "");
  }

  public static String getInputtedEmail()
  {
    return getStringInput("String", "email", "");
  }

  public static String getInputtedPhoneNumber()
  {
    return getStringInput("String", "phoneNumber", "");
  }

  public static String getInputtedNewValue()
  {
    return getStringInput("String", "newValue", "");
  }

  public static String getInputtedStartTime()
  {
    return getStringInput("String", "startTime", "");
  }

  public static int getInputtedCapacity()
  {
    return getIntInput("int", "capacity", "");
  }

  public static int getInputtedNumberOfRowsToReturn()
  {
    return getIntInput("int", "numberOfRowsToReturn", "");
  }

  public static String getInputtedDate()
  {
    return getStringInput("Date", "Date", "");
  }

  public static String getInputtedClassType()
  {
    return getStringInput("String", "classType", "");
  }
}
