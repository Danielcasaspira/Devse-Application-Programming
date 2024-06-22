package com.devsu.financial.model;

import com.devsu.financial.model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testClientGettersAndSetters() {

        Client client = new Client();
        client.setId(1L);
        client.setName("Jose Lema");
        client.setGender("Masculino");
        client.setAge(30);
        client.setIdentification("1234567890");
        client.setAddress("Otavalo sn y principal");
        client.setPhone("098254785");
        client.setPassword("1234");
        client.setStatus(true);

        assertEquals(1L, client.getId());
        assertEquals("Jose Lema", client.getName());
        assertEquals("Masculino", client.getGender());
        assertEquals(30, client.getAge());
        assertEquals("1234567890", client.getIdentification());
        assertEquals("Otavalo sn y principal", client.getAddress());
        assertEquals("098254785", client.getPhone());
        assertEquals("1234", client.getPassword());
        assertTrue(client.isStatus());
    }

}
