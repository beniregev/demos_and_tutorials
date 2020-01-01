package com.beniregev.demos_and_tutorials.never_use_switch_example;

import org.springframework.stereotype.Component;

/**
 * @author Binyamin Regev e-mail: beniregev@gmail.com
 * @since 1.8
 */
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        //50 lines of code
        return "<html> don't call us we call you </html>";
    }

    @Override
    public int getMyCode() {
        return 2;
    }
}
