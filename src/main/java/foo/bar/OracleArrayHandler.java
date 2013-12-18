package foo.bar;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
    // Этот медот отработает тогда когда будет проводиться биндовка входных параметров в блоке pl/sql
    // v_in := #{map.in, jdbcType=ARRAY, javaType=OBJECT, jdbcTypeName="T_FOR_TEST_MYBATIS", typeHandler=foo.bar.OracleArrayHandler, mode=IN};
    // Это стандартное преобразование типов Java в типы оракла
    Connection conn = preparedStatement.getConnection();
    /* Это наименование типа в оракле!
     Обычная коллекция: create or replace type t_for_test_mybatis force is table of varchar2(4000)
     Важно! Нельзя использовать типы из пакетов!
    */
    ArrayDescriptor desc = ArrayDescriptor.createDescriptor("T_FOR_TEST_MYBATIS", conn);
    String[] stringArray = new String[0];
    if (strings != null && strings.size() > 0) {
      // Поддерживаются только простые типы и массивы, никаких списков!
      stringArray = new String[strings.size()];
      for (int idx = 0; idx < strings.size(); idx++) {
        stringArray[idx] = strings.get(idx);
      }
    }
    ARRAY oracleArray = new ARRAY(desc, conn, stringArray);
    preparedStatement.setArray(i, oracleArray);
  }

  @Override
  public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
    // В случае когда используется хэндлер для коллекци этот метод не используется.
    return null;
  }

  @Override
  public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
    // В случае когда используется хэндлер для коллекци этот метод не используется.
    return null;
  }

  @Override
  public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
    // Этот медот отработает тогда когда будет проводиться биндовка выходных параметров в блоке pl/sql
    // #{map.out, jdbcType=ARRAY, javaType=OBJECT, jdbcTypeName="T_FOR_TEST_MYBATIS", typeHandler=foo.bar.OracleArrayHandler, mode=OUT} :=  v_out;
    // Мы знаем что будет массив, поэтому отрабатываем так, хотя в общем случае можно сделать и универсальное решение.
    String[] x = (String[]) ((ARRAY) callableStatement.getObject(i)).getArray();
    List<String> result = new ArrayList<String>(x != null ? x.length : 0);
    if (x != null) {
      Collections.addAll(result, x);
    }
    return result;
  }
}
