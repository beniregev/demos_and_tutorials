package com.beniregev.demos_and_tutorials.never_use_switch_example;

/**
 * @author Binyamin Regev
 * @since 1.8
 */
public interface MailGenerator {
    String generateHtml(MailInfo mailInfo);
    int getMyCode();
}
