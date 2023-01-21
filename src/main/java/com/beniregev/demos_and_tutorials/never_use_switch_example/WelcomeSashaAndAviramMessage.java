package com.beniregev.demos_and_tutorials.never_use_switch_example;

import org.springframework.stereotype.Component;

@Component
public class WelcomeSashaAndAviramMessage implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "Welcome To Morphisec Sasha and Aviram";
    }

    @Override
    public int getMyCode() {
        return 5;
    }
}
