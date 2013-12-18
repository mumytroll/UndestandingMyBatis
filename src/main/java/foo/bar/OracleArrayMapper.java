package foo.bar;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Описание
 *
 * @author Sergey.Titkov
 * @version 001.00
 * @since 001.00
 */
public interface OracleArrayMapper {
  public void doArray(@Param("map") Map<String, Object> map);
}
