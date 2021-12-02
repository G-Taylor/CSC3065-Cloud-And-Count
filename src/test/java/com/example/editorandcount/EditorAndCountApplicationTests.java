package com.example.editorandcount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EditorAndCountApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String address = "http://andcount.40234272.qpc.hal.davecutting.uk/";

    @Test
    void contextLoads() {
    }

    @Test
    public void noParametersEntered() {
        assertThat(this.restTemplate.getForObject(address, String.class)).contains("Incorrect Parameters");
    }

    @Test
    public void incorrectParametersEntered() {
        String parameter = "test";
        assertThat(this.restTemplate.getForObject(address + parameter, String.class)).contains("Incorrect Parameters");
    }

    @Test
    public void noTextEntered() {
        String parameter = "?text=";
        assertThat(this.restTemplate.getForObject(address + parameter, String.class)).contains("No Text Entered");
    }

    @Test
    public void correctResultOne() {
        String parameter = "?text=and";
        assertThat(this.restTemplate.getForObject(address + parameter, String.class)).contains("\"answer\":1");
    }

    @Test
    public void correctResultTen() {
        String parameter = "?text=and and and and and and and and and and";
        assertThat(this.restTemplate.getForObject(address + parameter, String.class)).contains("\"answer\":10");
    }

    @Test
    public void correctResultFourWithNumbers() {
        String parameter = "?text=and2 8and 789 an7d an3d";
        assertThat(this.restTemplate.getForObject(address + parameter, String.class)).contains("\"answer\":4");
    }
}
