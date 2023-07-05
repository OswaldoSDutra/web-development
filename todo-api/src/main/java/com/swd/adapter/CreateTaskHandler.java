package com.swd.adapter;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.swd.application.config.GuiceFactory;
import com.swd.domain.model.Task;
import com.swd.domain.model.ValidationResult;
import com.swd.domain.usecase.UseCaseResult;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class CreateTaskHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        JSONParser parser = new JSONParser();
        JSONObject responseJson = new JSONObject();
        JSONObject responseBody = new JSONObject();

        try {

            JSONObject event = (JSONObject) parser.parse(reader);

            if (event.get("body") != null) {

                Task task = GuiceFactory.getGson().fromJson((String) event.get("body"),Task.class);

                ValidationResult validationResult = task.isValid();

                if(validationResult.success) {
                    UseCaseResult<Task> result = GuiceFactory.getCreateTaskUseCase().create(task);
                    responseBody.put("message", result.getMessage());
                    responseJson.put("statusCode", 200);
                } else {
                    responseBody.put("message", validationResult.toString());
                    responseJson.put("statusCode", 400);
                }

            }

        }
        catch (Exception ex){
            responseBody.put("message", ex.getMessage());
            responseJson.put("statusCode: ", 500);
        }

        responseJson.put("body", responseBody.toString());

        writer.write(responseJson.toString());
        writer.close();

        reader.close();
    }


}
