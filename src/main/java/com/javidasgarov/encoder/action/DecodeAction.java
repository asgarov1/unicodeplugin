package com.javidasgarov.encoder.action;

import org.apache.commons.text.StringEscapeUtils;


public class DecodeAction extends EncodingAction {
    @Override
    public String processSelectedText(String text) {
        return StringEscapeUtils.unescapeJava(text);
    }
}
