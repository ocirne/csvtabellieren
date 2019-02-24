package de.enricopilz.kata.csvtabellieren;

import de.enricopilz.kata.csvtabellieren.shot1.Shot1;
import de.enricopilz.kata.csvtabellieren.shot2.Shot2;
import de.enricopilz.kata.csvtabellieren.shot4.Shot4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ShotsTest {

    @Parameters
    public static Collection<Object[]> data() {
        return List.of(new Object[][] {
                { new Shot1() }, { new Shot2() }, { new Shot4() }
        });
    }

    @Parameter
    public CsvTabulator csvTabulator;

    private static final List<String> REFERENCE_INPUT = List.of(
            "Name;Strasse;Ort;Alter",
            "Peter Pan;Am Hang 5;12345 Einsam;42",
            "Maria Schmitz;Kölner Straße 45;50123 Köln;43",
            "Paul Meier;Münchener Weg 1;87654 München;65"
    );

    private static final List<String> EXPECTED_OUTPUT = List.of(
            "Name         |Strasse         |Ort          |Alter|",
            "-------------+----------------+-------------+-----+",
            "Peter Pan    |Am Hang 5       |12345 Einsam |42   |",
            "Maria Schmitz|Kölner Straße 45|50123 Köln   |43   |",
            "Paul Meier   |Münchener Weg 1 |87654 München|65   |"
    );

    @Test
    public void testTabelliere() {
        List<String> actualOutput = csvTabulator.tabelliere(REFERENCE_INPUT);
        assertThat(actualOutput).isEqualTo(EXPECTED_OUTPUT);
    }
}