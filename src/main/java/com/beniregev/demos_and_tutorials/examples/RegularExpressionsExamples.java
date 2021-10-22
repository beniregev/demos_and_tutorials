package com.beniregev.demos_and_tutorials.examples;

import java.util.Arrays;
import java.util.regex.Pattern;

public class RegularExpressionsExamples {

    //  Basic e-mail validation permitted by RFC 5322 -- TOO BASIC, NOT RECOMMENDED
    private final String REGEX_RFC5322 = "^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    //  Basic e-mail validation permitted by RFC 5322,
    //  restrict number of characters in top level domain (2 to 6)
    private final String REGEX_RFC5322_PLUS = "^[A-Za-z0-9+_.-]+@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    //  email validation permitted by RFC 5322,
    //  restrict leading, trailing, or consecutive dots,
    //  restrict number of characters in top level domain (2 to 6)
    private final String REGEX_FULL = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    //  email validation permitted by RFC 5322,
    //  restrict/exclude characters that can be used in SQL injection attacks (e.g. | ' _ ! = % etc),
    //  restrict leading, trailing, or consecutive dots,
    //  restrict number of characters in top level domain (2 to 6)
    private final String REGEX_SECURE = "^[\\w#$*+?{}^-]+(?:\\.[\\w#$*+?{}^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    private final String REGEX_COLUMN_AND_TAG0 = "([A-Za-z_-]+ {1})";
    private final String REGEX_COLUMN_AND_TAG1 = ".*([A-Za-z_-]+ {1}\u003c{1})";
    private final String REGEX_COLUMN_AND_TAG2 = ".*([A-Za-z_-]+ {1}\u003c{1}[A-Za-z]+).*";
    private final String REGEX_COLUMN_AND_TAG3 = ".*([A-Za-z_-]+ {1}\u003c{1}[A-Za-z]+\u003e{1})(.*|\\s*)";

    private final String REGEX_INITIAL = "^[a-zA-Z0-9]\\ )+[a-zA-Z]{2,6}$";

    public boolean isValidEmailAddressRFC5322Basic(String email) {
        return Pattern.compile(REGEX_RFC5322).matcher(email).matches();
    }

    public boolean isValidEmailAddressRFC5322Plus(String email) {
        return Pattern.compile(REGEX_RFC5322_PLUS).matcher(email).matches();
    }

    public boolean isValidEmailAddressRFC5322Full(String email) {
        return Pattern.compile(REGEX_FULL).matcher(email).matches();
    }

    public boolean isValidEmailAddressRFC5322Secure(String email) {
        return Pattern.compile(REGEX_SECURE).matcher(email).matches();
    }

    public boolean isValidColumnAndTagString0(String stringText) {
        return Pattern.compile(this.REGEX_COLUMN_AND_TAG0).matcher(stringText).matches();
    }

    public boolean isValidColumnAndTagString1(String stringText) {
        return Pattern.compile(this.REGEX_COLUMN_AND_TAG1).matcher(stringText).matches();
    }

    public boolean isValidColumnAndTagString2(String stringText) {
        return Pattern.compile(this.REGEX_COLUMN_AND_TAG2).matcher(stringText).matches();
    }

    public boolean isValidColumnAndTagString3(String stringText) {
        return Pattern.compile(this.REGEX_COLUMN_AND_TAG3).matcher(stringText).matches();
    }

    public static void main(String[] args) {
        RegularExpressionsExamples examples = new RegularExpressionsExamples();

        String[] emails = {
                /* valid    */
                "user@domain.com", "user@domain.co.in", "user1@domain.com",
                "user.name@domain.com", "user#@domain.co.in", "user@domaincom",
                "user_name@domain.co.in", "user-name@domain.co.in", "user?name@domain.co.in",
                ".username@yahoo.com", "user!name@domain.co.in", "user#name@yahoo.com",
                "user$name@domain.co.in", "user%name@yahoo.com", "user*name@domain.co.in",
                "user&name@yahoo.com", "user^name@domain.co.in", "user+name@yahoo.com",
                "user/name@domain.co.in", "user=name@yahoo.com", "user{name@domain.co.in",
                "user}name@yahoo.com", "user|name@domain.co.in", "user~name@yahoo.com",
                "beni.regev@finastra.com", "beniregev@gmail.com", "user'name@domain.co.in",
                "support@gov.il", "moked@ramat-gan.muni.il", "support@htzone.co.il",
                /* invalid  */
                "user#domain.com", "support@htzone.co..il", "support@htzone..co.il", "username@yahoo..com",
                "@yahoo.com"
        };

        Arrays.stream(emails)
                .forEach(email -> {
                    String e_mail = (String) email;
                    System.out.println("\n\t******* " + e_mail + " *******");
                    System.out.println("Valid RFC 5322 Basic? " + examples.isValidEmailAddressRFC5322Basic(e_mail));
                    System.out.println("Valid RFC 5322 Plus? " + examples.isValidEmailAddressRFC5322Plus(e_mail));
                    System.out.println("Valid RFC 5322 Full? " + examples.isValidEmailAddressRFC5322Full(e_mail));
                    System.out.println("Valid RFC 5322 Full Secure? " + examples.isValidEmailAddressRFC5322Secure(e_mail));
                });
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println("******* isValidColumnAndTagString0 *******");
        String[] textLines0 = {
                "RequestedExecutionDate",
                "RequestedExecutionDate ",
                "RequestedExecutionDate  "
        };
        Arrays.stream(textLines0)
                .forEach(textLine -> System.out.println("Does \"" + textLine + "\" matches? " + examples.isValidColumnAndTagString0(textLine)));
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println("******* isValidColumnAndTagString1 *******");
        String[] textLines1 = {
                "RequestedExecutionDate <",
                "RequestedExecutionDate  <",
                "{Or Code <",
                "RequestedExecutionDate <\\n"
        };
        Arrays.stream(textLines1)
                .forEach(textLine -> System.out.println("Does \"" + textLine + "\" matches? " + examples.isValidColumnAndTagString1(textLine)));
        System.out.println("--------------------------------------------------------------------------------------------------");

        System.out.println("******* isValidColumnAndTagString2 *******");
        String[] textLines2 = {
                "RequestedExecutionDate <ReqdExctnDt>",
                "RequestedExecutionDate <ReqdExctnDt>\\n",
                "RequestedExecutionDate <ReqdExctnDt> [1..1] ± 30",
                "RequestedExecutionDate <ReqdExctnDt> [1..1] ± 30\\n",
                "Message root <Document> <CstmrCdtTrfInitn>",
                "Message root <Document> <CstmrCdtTrfInitn>\\n1",
                "Message root <Document> <CstmrCdtTrfInitn> [1..1] C31",
                "Message root <Document> <CstmrCdtTrfInitn> [1..1] C31\\n",
                "6.1.24.2.2  RegistrationIdentification <RegnId>",
                "6.1.24.2.2  RegistrationIdentification <RegnId>\\n",
                "Or MessageElement/BuildingBlock<XML Tag> Mult. Type Constr.",
                "Or MessageElement/BuildingBlock<XML Tag> Mult. Type Constr.\\n"
        };
        Arrays.stream(textLines2)
                .forEach(textLine -> System.out.println("Does \"" + textLine + "\" matches? " + examples.isValidColumnAndTagString2(textLine)));
        System.out.println("--------------------------------------------------------------------------------------------------");

        String[] textLines3 = {
                "The CustomerCreditTransferInitiation message must not be used by the debtor agent to execute the\\n",
                "credit transfer instruction(s). The FIToFICustomerCreditTransfer message must be used instead.\\n",
                "The CustomerCreditTransferInitiationV11 MessageDefinition is composed of 3 MessageBuildingBlocks:\\n",
                "A. GroupHeader\\n",
                "Set of characteristics shared by all individual transactions included in the message.\\n",
                "B. PaymentInformation\\n",
                "Set of characteristics that applies to the debit side of the payment transactions included in the\\n",
                "Approved by the Payments SEG on 11 January 2021 pain.001.001.11\\n",
                "6.1.24.2.2  RegistrationIdentification <RegnId>",
                "6.1.24.2.2  RegistrationIdentification <RegnId>\\n",
                "CustomerCreditTransferInitiationV11\\n",
                "Payments Initiation - Maintenance 2020 - 2021 4 February 2021\\n",
                "2.2 Structure\\n",
                "Or MessageElement/BuildingBlock<XML Tag> Mult. Type Constr.\\n",
                "Message root <Document> <CstmrCdtTrfInitn> [1..1] C31\\n",
                "GroupHeader <GrpHdr> [1..1] ± 16\\n",
                "PaymentInformation <PmtInf> [1..*] C4, C5\\n",
                "PaymentInformationIdentification <PmtInfId> [1..1] Text 27\\n",
                "CreditAdvice <CdtAdvc> [0..1] 28\\n",
                "{Or Code <Cd> [1..1] CodeSet 28\\n",
                "Or} Proprietary <Prtry> [1..1] Text 29\\n",
                "DebitAdvice <DbtAdvc> [0..1] 29\\n",
                "{Or Code <Cd> [1..1] CodeSet 29\\n",
                "Or} Proprietary <Prtry> [1..1] Text 29\\n",
                "BatchBooking <BtchBookg> [0..1] Indicator 29\\n",
                "Type <Tp> [0..1] ± 32\\n",
                "Currency <Ccy> [0..1] CodeSet C1 32\\n",
                "Approved by the Payments SEG on 11 January 2021 pain.001.001.11\\n",
                "CustomerCreditTransferInitiationV11\\n",
                "Payments Initiation - Maintenance 2020 - 2021 6 February 2021\\n",
                "Or MessageElement/BuildingBlock<XML Tag> Mult. Type Constr.\\n",
                "DebtorAgentAccount <DbtrAgtAcct> [0..1] C21,\\n",
                "PaymentTypeInformation <PmtTpInf> [0..1] ± 46\\n",
                "ExchangeRateInformation <XchgRateInf> [0..1] 47\\n",
                "UnitCurrency <UnitCcy> [0..1] CodeSet C1 48\\n",
                "ExchangeRate <XchgRate> [0..1] Rate 48\\n",
                "RateType <RateTp> [0..1] CodeSet 48\\n",
                "Approved by the Payments SEG on 11 January 2021 pain.001.001.11\\n",
                "CustomerCreditTransferInitiationV11\\n",
                "IntermediaryAgent1 <IntrmyAgt1> [0..1] ± 52\\n",
                "IntermediaryAgent1Account <IntrmyAgt1Acct> [0..1] C21,\\n" +
                "Identification <Id> [0..1] ± 53\\n",
                "Type <Tp> [0..1] ± 53\\n",
                "Currency <Ccy> [0..1] CodeSet C1 53\\n",
                "Name <Nm> [0..1] Text 54\\n",
                "Proxy <Prxy> [0..1] ± 54\\n",
                "Name <Nm> [0..1] Text 59\\n",
                "Proxy <Prxy> [0..1] ± 59\\n",
                "CreditorAgent <CdtrAgt> [0..1] ± 59\\n",
                "CreditorAgentAccount <CdtrAgtAcct> [0..1] C21\\n",
                "Approved by the Payments SEG on 11 January 2021 pain.001.001.11\\n",
                "Or MessageElement/BuildingBlock<XML Tag> Mult. Type Constr.\\n",
                "Currency <Ccy> [0..1] CodeSet C1 61\\n",
                "Name <Nm> [0..1] Text 61\\n",
                "Proxy <Prxy> [0..1] ± 61\\n",
                "Identification <Id> [0..1] ± 62\\n",
                "Type <Tp> [0..1] ± 63\\n",
                "Currency <Ccy> [0..1] CodeSet C1 63\\n",
                "Name <Nm> [0..1] Text 63\\n",
                "Proxy <Prxy> [0..1] ± 64\\n",
                "Code <Cd> [0..1] CodeSet 65\\n",
                "InstructionInformation <InstrInf> [0..1] Text 65\\n",
                "Purpose <Purp> [0..1] ± 65\\n",
                "RegulatoryReporting <RgltryRptg> [0..10] ± 65\\n",
                "Tax <Tax> [0..1] 66\\n",
                "Type <Tp> [0..1] Text 70\\n",
                "Category <Ctgy> [0..1] Text 70\\n",
                "CategoryDetails <CtgyDtls> [0..1] Text 71\\n",
                "Approved by the Payments SEG on 11 January 2021 pain.001.001.11\\n",
                "CustomerCreditTransferInitiationV11\\n",
                "Payments Initiation - Maintenance 2020 - 2021 9 February 2021\\n",
                "CodeOrProprietary <CdOrPrtry> [1..1] 89\\n",
                "{Or Code <Cd> [1..1] CodeSet 89\\n",
                "Or} Proprietary <Prtry> [1..1] Text 90\\n",
                "Issuer <Issr> [0..1] Text 90\\n",
                "Number <Nb> [0..1] Text 90\\n",
                "RelatedDate <RltdDt> [0..1] Date 90\\n",
                "Amount <Amt> [0..1] 90\\n",
                "Type <Tp> [0..1] 92\\n",
                "{Or Code <Cd> [1..1] CodeSet 92\\n",
                "Or} Proprietary <Prtry> [1..1] Text 92\\n",
                "Amount <Amt> [1..1] Amount C1, C18 92\\n",
                "TaxAmount <TaxAmt> [0..*] 93\\n",
                "Type <Tp> [0..1] 93\\n",
                "{Or Code <Cd> [1..1] CodeSet 94\\n",
                "Or} Proprietary <Prtry> [1..1] Text 94\\n",
                "Amount <Amt> [1..1] Amount C1, C18 94\\n",
                "Amount <Amt> [1..1] Amount C1, C18 110\\n",
                "2.3 Constraints\\n",
                "C1 ActiveOrHistoricCurrency\\n",
                "The Currency Code must be registered, or have already been registered. Valid active or historic\\n",
                "6.1.24.2.2  RegistrationIdentification <RegnId>",
                "6.1.24.2.2  RegistrationIdentification <RegnId>\\n",
                "currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)\\n",
                "contiguous letters, and may be or not be withdrawn on the day the message containing the\\n",
                "Currency is exchanged.\\n"
        };
        Arrays.stream(textLines3)
                .forEach(textLine -> System.out.println("Does \"" + textLine + "\" matches? " + examples.isValidColumnAndTagString3(textLine)));
        System.out.println("--------------------------------------------------------------------------------------------------");
    }
}
