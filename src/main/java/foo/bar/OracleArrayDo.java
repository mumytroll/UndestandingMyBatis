package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Описание
 *
 * @author Sergey.Titkov
 * @version 001.00
 * @since 001.00
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Component
public class OracleArrayDo {

  // Это бин отработает MyBatis
  @Autowired
  private OracleArrayMapper oracleArrayMapper;

  public String returnArrayToString() {
    // Только для map можно получить out параметры!
    Map<String, Object> parameters = new HashMap<String, Object>();
    // Это входной список строк, который будет обработна в PL/SQL кодею
    List<String> strings = new ArrayList<String>();
    strings.add("Строка один");
    strings.add("Строка два");
    strings.add("Строка три");
    parameters.put("in", strings);
    //Вызываем.
    oracleArrayMapper.doArray(parameters);
    //И преобразуем в строку!
    return parameters.get("out").toString();
  }

}
