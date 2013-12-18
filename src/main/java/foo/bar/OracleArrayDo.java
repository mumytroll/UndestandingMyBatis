package foo.bar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Описание
 *
 * @author Sergey.Titkov
 * @version 001.00
 * @since 001.00
 */
@Component
public class OracleArrayDo {

  @Autowired
  private OracleArrayMapper oracleArrayMapper;

  public String sayHello() {
    Map<String, Object> parameters = new HashMap<String, Object>();
    oracleArrayMapper.doArray(parameters);
    return parameters.get("out").toString();
  }

}
