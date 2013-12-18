package foo.bar;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    //To change body of implemented methods use File | Settings | File Templates.
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
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
