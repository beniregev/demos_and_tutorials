package com.beniregev.demos_and_tutorials.never_use_switch_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <div>
 *     <p>  This class method {@code sendMail(MailInfo)} &quot;sends&quot;
 *          the message by calling a private method. </p>
 *     <p>  Note: {@code Autpwored} property This class method {@code sendMail(MailInfo)} &quot;sends&quot;
 *
 * </div>
 * @author Binyamin Regev
 * @since 1.8
 * @see MainConfiguration
 */
@Service
public class MailSender {

    @Autowired
    private Map<Integer, MailGenerator> map;

    public void sendMail(MailInfo mailInfo) {

        int mailCode = mailInfo.getMailCode();
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new IllegalStateException(mailCode + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html);
    }

    public int getMapSize() {
        return map.size();
    }
    private void send(String html) {
        System.out.println(html + " was sent");
    }
}
