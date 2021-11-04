package com.javidasgarov.encoder.action;

import org.apache.commons.lang.StringEscapeUtils;

public class DecodeAction extends EncodingAction {
    @Override
    public String processSelectedText(String text) {
        return StringEscapeUtils.unescapeJava(text);
    }
}
