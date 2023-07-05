package com.swd.adapter.unit;

import com.amazonaws.services.lambda.runtime.Context;
import com.swd.BaseTest;
import com.swd.adapter.CreateTaskHandler;
import com.swd.application.config.GuiceFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTaskHandlerUnitTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        this.environmentVariablesRule.set("ENV_NAME", this.getEnvName());
    }

    @Test
    public void should_return_bad_request_due_to_empty_title() throws IOException {

        Context contextMock = Mockito.mock(Context.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = this.getClass().getResourceAsStream("/payload/save/taskEmptyTitlePayload.json");

        new CreateTaskHandler().handleRequest(inputStream, outputStream, contextMock);

        String outputText = new String(outputStream.toByteArray());

        assertThat(outputText).contains("\"statusCode\":400");
    }

    @Test
    public void should_return_bad_request_due_to_empty_body() throws IOException {

        Context contextMock = Mockito.mock(Context.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = this.getClass().getResourceAsStream("/payload/save/taskEmptyBodyPayload.json");

        new CreateTaskHandler().handleRequest(inputStream, outputStream, contextMock);

        String outputText = new String(outputStream.toByteArray());

        assertThat(outputText).contains("\"statusCode\":400");
    }

}