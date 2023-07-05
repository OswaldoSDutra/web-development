package com.swd.domain.model;

public class Task extends BaseModel {

    private String id;
    private String title;
    private boolean complete;

    public Task() {
    }

    public Task(String id, String title, boolean complete) {
        this.id = id;
        this.title = title;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public ValidationResult isValid() {

        ValidationResult validationResult = new ValidationResult();
        validationResult.success = false;

        if (this.title == null || this.title.isEmpty()) {
            validationResult.errors.add(new ModelError("E01-F01-A02-M01", "Title cannot be blank ou empty."));
        } else if (this.title.length() > 50)
            validationResult.errors.add(new ModelError("E01-F01-A02-M02", "Title cannot be longer than 50 characters."));

        if(validationResult.errors.isEmpty())
            validationResult.success = true;

        return validationResult;
    }

}
