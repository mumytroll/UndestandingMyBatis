package foo.bar;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class OracleArrayDoTests {
    @Autowired
    private OracleArrayDo oracleArrayDo;

    @Test
    public void testSayHello() {
        Assert.assertEquals("[Строка один Это русский текст., Строка два Это русский текст., Строка три Это русский текст., Эта новая строка]", oracleArrayDo.returnArrayToString());
    }
}
