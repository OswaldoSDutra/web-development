package com.swd.adapter.e2e;

import com.amazonaws.services.lambda.runtime.Context;
import com.swd.BaseTest;
import com.swd.adapter.CreateTaskHandler;
import com.swd.application.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTaskHandlerE2eTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        this.environmentVariablesRule.set("ENV_NAME", this.getEnvName());
        this.environmentVariablesRule.set("LOCALSTACK_HOSTNAME", this.getLocalstackHostname());
    }

    @Test
    public void should_return_success() throws IOException {

        Context contextMock = Mockito.mock(Context.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream inputStream = this.getClass().getResourceAsStream("/payload/save/validTaskPayload.json");

        new CreateTaskHandler().handleRequest(inputStream, outputStream, contextMock);

        String outputText = new String(outputStream.toByteArray());

        assertThat(outputText).contains("\"statusCode\":200");
    }
}
