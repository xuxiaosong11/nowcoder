package com.example.nowcoder.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author admin
 * @ClassName CoummuntiyUtil.java
 * @Description 生成随机字符串
 * @createTime 2020年04月25日 18:58:00
 */

public class CoummuntiyUtil {

    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String md5(String key) {
        if (StringUtils.isBlank(key) ) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
