package com.javidasgarov.encoder.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void testReplaceAll() {
        assertEquals("\\u0048\\u0065\\u006C\\u006C\\u006F", StringUtil.replaceAll("Hello"));
    }
}