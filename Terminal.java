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
public class Terminal {
  static Scanner input = new Scanner(System.in);

  public static void runTerminal() {
    setUp();
    boolean isRunning = true;
    while (isRunning) {
      System.out.println("Enter value 0-35");
      System.out.println("Will list it out but im lazy rn");
      int apiNumber = getIntInput();
      switch (apiNumber) {
        case 0: {
          isRunning = false;
          continue;
        }
        case 1: {
          String classNumber = getInputtedClassNumber();
          String instructorNumber = getInputtedInstructorNumber();
          // dealWithUnsuccessfulTransaction(GymEnrollmentSystem.addInstructorToClass(classNumber, instructorNumber));
        }
        case 2: {
          break;
        }
        case 3: {
          break;
        }
        case 4: {
          break;
        }
        case 5: {
          break;
        }
        case 6: {
          break;
        }
        case 7: {
          break;
        }
        case 8: {
          break;
        }
        case 9: {
          break;
        }
        case 10: {
          break;
        }
        case 11: {
          break;
        }
        case 12: {
          break;
        }
        case 13: {
          break;
        }
        case 14: {
          break;
        }
        case 15: {
          break;
        }
        case 16: {
          break;
        }
        case 17: {
          break;
        }
        case 18: {
          break;
        }
        case 19: {
          break;
        }
        case 20: {
          break;
        }
        case 21: {
          break;
        }
        case 22: {
          break;
        }
        case 23: {
          break;
        }
        case 24: {
          break;
        }
        case 25: {
          break;
        }
        case 26: {
          break;
        }
        case 27: {
          break;
        }
      }
//    }finally {
//        continue;
//      }
      //deals with return of String as they throw SQLException
      try {
        switch (apiNumber) {
          case 28: {
            String classNumber = getInputtedClassNumber();
            System.out.println(GymEnrollmentSystem.getInstructorForClass(classNumber));
            break;
          }
          case 29: {
            String classNumber = getInputtedClassNumber();
            int numberOfRowsToReturn = getInputtedNumberOfRowsToReturn();
            System.out.println(GymEnrollmentSystem.getMembersInClass(classNumber, numberOfRowsToReturn));
            break;
          }
          case 30: {
            String memberNumber = getInputtedMemberNumber();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(memberNumber));
            break;
          }
          case 31: {
            String memberNumber = getInputtedMemberNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymMemberClasses(memberNumber, date));
            break;
          }
          case 32: {
            String instructorNumber = getInputtedInstructorNumber();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(instructorNumber));
            break;
          }
          case 33: {
            String instructorNumber = getInputtedInstructorNumber();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymInstructorClasses(instructorNumber, date));
            break;
          }
          case 34: {
            String classType = getInputtedClassType();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(classType));
            break;
          }
          case 35: {
            String classType = getInputtedClassType();
            String date = getInputtedDate();
            System.out.println(GymEnrollmentSystem.getGymClassByClassType(classType, date));
            break;
          }
        }
      } catch (SQLException e) {
        System.out.println("ERRORRRRR");
        System.out.println(e.toString());
      }
    }
    System.out.println("Exiting System...");
//      conn.close();


  }

  public static void setUp() {
    // Retrieves the PostgreSQL database properties
    Properties properties = new Properties();
    String fileName = "DatabaseProperties.properties";
    try {
      FileInputStream inputFile = new FileInputStream(fileName);
      properties.load(inputFile);
      inputFile.close();
    } catch (IOException e) {
      System.err.println("Input file error: " + e.getMessage());
      return;
    }
    String url = properties.getProperty("database.url");
    String user = properties.getProperty("database.user");
    String password = properties.getProperty("database.password");

    // Establishes the connection between JDBC and PostgreSQL database
    try {
      GymEnrollmentSystem.conn = DriverManager.getConnection(url, user, password);
//      System.out.println("Database connection established");
//           System.out.println(getMembersInClass("CLS001", 4));
      //PRINT OUT TEST QUERIES HERE:
    } catch (SQLException e) {
      System.err.println("Database connection error: " + e.getMessage());
    }
  }

  //TODO: better work idk?
  public static void dealWithUnsuccessfulTransaction(boolean isSuccessful) {
    if (isSuccessful) {
      System.out.println("Success");
    } else {
      System.out.println("There was a problem");
    }

  }

  public static String getStringInput(String typeOfParam, String paramName, String exampleText) {
    System.out.println();
    System.out.println("Enter Value for " + paramName + ":");
    System.out.println("Type: " + typeOfParam);
    if (!exampleText.isEmpty()) {
      System.out.println("Ex. " + exampleText);
    }
    boolean isValidInput = false;
    String inputString = "";
    while (!isValidInput) {
      try {
        inputString = input.nextLine();
        isValidInput = true;
      } catch (Exception e) {
        System.out.println("Invalid input, try again");
      }
    }
    return inputString;
  }

  public static int getIntInput() {
    boolean isValidInput = false;
    int inputInt = 0;
    while (!isValidInput) {
      try {
        inputInt = Integer.parseInt(input.nextLine());
        isValidInput = true;
      } catch (Exception e) {
        System.out.println("Invalid input, try again");
      }
    }
    return inputInt;
  }

  public static int getIntInput(String typeOfParam, String paramName, String exampleText) {
    System.out.println("Type: " + typeOfParam);
    System.out.println("Ex. " + exampleText);
    if (!exampleText.isEmpty()) {
      System.out.println(paramName + ": " + exampleText);
    }
    boolean isValidInput = false;
    int inputInt = 0;
    while (!isValidInput) {
      try {
        inputInt = Integer.parseInt(input.nextLine());
        isValidInput = true;
      } catch (Exception e) {
        System.out.println("Invalid input, try again");
      }
    }
    return inputInt;
  }

  //useable code, so probalby easier
  public static String getInputtedClassNumber() {
    return getStringInput("String", "classNumber", "");
  }

  public static String getInputtedInstructorNumber() {
    return getStringInput("String", "instructorNumber", "");
  }

  public static String getInputtedNewInstructorNumber() {
    return getStringInput("String", "newInstructorNumber", "");
  }

  public static String getInputtedMemberNumber() {
    return getStringInput("String", "memberNumber", "");
  }

  public static String getInputtedFirstName() {
    return getStringInput("String", "firstName", "");
  }

  public static String getInputtedLastName() {
    return getStringInput("String", "lastName", "");
  }

  public static String getInputtedEmail() {
    return getStringInput("String", "email", "");
  }

  public static String getInputtedPhoneNumber() {
    return getStringInput("String", "phoneNumber", "");
  }

  public static String getInputtedNewValue() {
    return getStringInput("String", "newValue", "");
  }

  public static String getInputtedStartTime() {
    return getStringInput("String", "startTime", "");
  }

  public static int getInputtedCapacity() {
    return getIntInput("int", "capacity", "");
  }

  public static int getInputtedNumberOfRowsToReturn() {
    return getIntInput("int", "numberOfRowsToReturn", "");
  }

  public static String getInputtedDate() {
    return getStringInput("Date", "Date", "");
  }

  public static String getInputtedClassType() {
    return getStringInput("String", "classType", "");
  }
}
