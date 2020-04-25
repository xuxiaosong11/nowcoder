package com.example.nowcoder;

import com.example.nowcoder.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 * @ClassName MailTest.java
 * @Description TODO
 * @createTime 2020年04月25日 16:25:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NowcoderApplication.class)
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Test
    public void testmail() {
        mailClient.sendMail("2457476273@qq.com","test","welcome");
    }
}
