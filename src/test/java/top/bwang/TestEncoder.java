package top.bwang;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author bwang
 * @version 1.0
 * @Description TODO
 * @date 2021/4/5 20:59
 */
@SpringBootTest
public class TestEncoder {

    private Logger logger = LoggerFactory.getLogger(TestEncoder.class);

    @Test
    public void test01() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("bwang");
        logger.info("加密后的数据{}", encode);
        boolean matches = encoder.matches("bwang", encode);
        logger.info("数据对比结果{}", matches);
    }
}
