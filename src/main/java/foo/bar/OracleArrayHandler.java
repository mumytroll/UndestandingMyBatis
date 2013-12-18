package foo.bar;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import sun.security.x509.AttributeNameEnumeration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Описание
 *
 * @author Sergey.Titkov
 * @version 001.00
 * @since 001.00
 */
public class OracleArrayHandler implements TypeHandler<List<String>> {
  @Override
  public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
    Connection conn = preparedStatement.getConnection();
    ArrayDescriptor desc = ArrayDescriptor.createDescriptor("T_FOR_TEST_MYBATIS", conn);
    String[] stringArray = new String[0];
    if  (strings != null && strings.size()>0){
      stringArray = new String[strings.size()];
      for(int idx = 0; idx < strings.size() ; idx++){
        stringArray[idx] = strings.get(idx);
      }
    }
    ARRAY oracleArray = new ARRAY(desc, conn, stringArray);
    preparedStatement.setArray(i, oracleArray);
  }

  @Override
  public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
    String[] x = (String[]) ((ARRAY) callableStatement.getObject(i)).getArray();
    List<String> result = new ArrayList<String>(x != null ? x.length : 0);
    for (String row: x){
      result.add(row);
    }
    return result;
  }
}
