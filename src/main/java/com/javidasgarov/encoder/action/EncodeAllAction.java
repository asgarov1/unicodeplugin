package com.javidasgarov.encoder.action;

import static com.javidasgarov.encoder.util.StringUtil.replaceAll;

public class EncodeAllAction extends EncodingAction {

    @Override
    public String processSelectedText(String text) {
        return replaceAll(text);
    }
}
