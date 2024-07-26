package com.template.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DefaultControllerTests {

    private Gson gson;

    private MockMvc mockMvc;

    @InjectMocks
    private DefaultController defaultController;

    @Value("${spring.application.title}")
    private String title;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.defaultController).build();
        gson = new GsonBuilder().serializeNulls().create();
    }

    private String mockDefaultResponse() {
        return title + "Hello! You have successfully set up your Java21 Maven SpringBoot:3.3 environment by using the Lazsa template. You're all set to start coding.";
    }

    @Test
    public void getDefault_Success() throws Exception {
        ReflectionTestUtils.setField(defaultController, "title", title);
        final MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertEquals(this.mockDefaultResponse(), response.getContentAsString());
    }

}