package com.swd.application.port;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.google.inject.Inject;
import com.swd.application.config.GuiceFactory;
import com.swd.domain.model.Task;
import com.swd.domain.port.TaskDataBasePort;
import com.swd.application.port.aws.IDynamoDbFactory;

import java.util.HashMap;
import java.util.Map;

public class DynamoDbTaskRepository implements TaskDataBasePort {

    private IDynamoDbFactory dynamoDbFactory;

    private String DYNAMODB_TABLE_NAME = "Task";

    @Inject
    public DynamoDbTaskRepository(IDynamoDbFactory iDynamoDbFactory) {
        this.dynamoDbFactory = iDynamoDbFactory;
    }

    @Override
    public void createTask(Task task) {

        this.dynamoDbFactory
                .getDynamoDBClient()
                .getTable(this.DYNAMODB_TABLE_NAME)
                .putItem(
                        this.mapFromTask(task)
                );

    }

    @Override
    public Task findTaksById(String id) {

        Map<String, AttributeValue> keyMap = new HashMap<>();
        keyMap.put("id",new AttributeValue(id));

        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setKey(keyMap);

        getItemRequest.setTableName(this.DYNAMODB_TABLE_NAME);

        Item result = this.dynamoDbFactory
                .getDynamoDBClient()
                .getTable(this.DYNAMODB_TABLE_NAME)
                .getItem("id", id);

        return this.mapToTask(result);
    }

    private Item mapFromTask(Task task){
        return
                new Item()
                        .withString("id", task.getId())
                        .withString("title", task.getTitle())
                        .withBoolean("complete", task.getComplete());
    }

    private Task mapToTask(Item itemTask){
        return GuiceFactory.getGson().fromJson(itemTask.toJSON(), Task.class);
    }

}
