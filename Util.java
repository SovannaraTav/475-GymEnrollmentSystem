
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @Author Adam Chhor
 * helper methods
 */
public class Util {

  public static String parseDataBase(ResultSet rs) throws SQLException
  {
    StringBuilder formattedStringBuilder = new StringBuilder();
    ResultSetMetaData metaData = rs.getMetaData();
    for(int i = 1; i <= metaData.getColumnCount(); i++)
    {
      formattedStringBuilder.append(String.format("%-30s", metaData.getColumnName(i)));
    }
    formattedStringBuilder.append("\n");
    formattedStringBuilder.append("-".repeat(30* metaData.getColumnCount()));
    formattedStringBuilder.append("\n");
    while (rs.next())
    {
      for(int i = 1; i <= metaData.getColumnCount(); i++)
      {
        formattedStringBuilder.append(String.format("%-30s", rs.getString(i)));
      }
      formattedStringBuilder.append("\n");
    }
    return formattedStringBuilder.toString();
  }
}
