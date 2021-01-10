package com.beniregev.demos_and_tutorials.never_use_switch_example;

/**
 * <div>
 *     <p>This is the interface that all mails will have to implement. </p>
 *     <ul>Each implementing class will:
 *     <li>Return a different value in method {@code getMyCode()}. </li>
 *     <li>Return the message to send in method {@code generateHtml(MailInfo)}. </li>
 *     </ul>
 *
 * </div>
 * @author Binyamin Regev
 * @since 1.8
 */
public interface MailGenerator {
    String generateHtml(MailInfo mailInfo);
    int getMyCode();
}
