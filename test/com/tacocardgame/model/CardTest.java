package com.tacocardgame.model;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.tacocardgame.model.CardType.*;
import static org.junit.Assert.*;

public class CardTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void show_shouldShowTheReferencedFile() throws IOException {
        Card card = new Card(CHEESE);
        String image = Files.readString(Path.of("resources/images/"+ card.getType() + ".txt"));
        card.show(image);
    }

    @Test
    public void getType() {
    }
}