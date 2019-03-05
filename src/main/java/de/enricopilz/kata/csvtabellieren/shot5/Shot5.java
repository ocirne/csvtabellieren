package de.enricopilz.kata.csvtabellieren.shot5;

import de.enricopilz.kata.csvtabellieren.CsvTabulator;

import java.util.List;

public class Shot5 implements CsvTabulator {

    @Override
    public List<String> tabelliere(List<String> csvZeilen) {
        Table table = new Table(csvZeilen);
        TableOutputer outputer = new TableOutputer(table);
        return outputer.createPlainOutput();
    }
}
