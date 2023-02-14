package com.beniregev.demos_and_tutorials.demos.apache_poi.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class InputResources {


    public static final String EXCEL_FILE_PATH = "./data/";
    private final String[] columns = { "First Name", "Last Name", "Email", "Date of Birth" };
    private final List<Contact> contacts = new ArrayList<>();

    public static final InputResources INSTANCE = InputResources.getInstance();

    private InputResources() {
        generateContactsList();
    }

    public static InputResources getInstance() {
        return new InputResources();
    }

    private void generateContactsList() {
        contacts.add(new Contact("Avraham", "Avinu", "avraham.avinu@genesis.com", "04/02/1974"));
        contacts.add(new Contact("Itsik", "Avinu", "itsik.avinu@genesis.com", "02/02/1975"));
        contacts.add(new Contact("Jakob", "Avinu", "jakob.avinu@genesis.com", "04/04/1976"));
        contacts.add(new Contact("Sarah", "Imenu", "sarah.imenu@genesis.com", "05/05/1987"));
        contacts.add(new Contact("Rivka", "Imenu", "rivka.imenu@genesis.com", "04/04/1987"));
        contacts.add(new Contact("Lea", "Imenu", "lea.imenu@genesis.com", "16/12/1980"));
        contacts.add(new Contact("Rachel", "Imenu", "rachel.imenu@genesis.com", "19/01/1990"));
    }
}
