package com.swd.domain.model.unit;

import com.swd.domain.model.Task;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TaskUnitTest {

    @Test
    public void should_not_be_valid_due_to_empty_title() {
        Task task = new Task();
        assertThat(task.isValid().success).isFalse();
    }

    @Test
    public void should_display_empty_title_validation_message() {
        Task task = new Task();
        assertThat(task.isValid().toString()).contains("E01-F01-A02-M01-Title cannot be blank ou empty.");
    }

    @Test
    public void should_not_be_valid_due_to_long_title() {
        char[] title = new char[51];
        Arrays.fill(title,'A');

        Task task = new Task();
        task.setTitle(new String(title));

        assertThat(task.isValid().success).isFalse();
    }

    @Test
    public void should_display_long_title_validation_message() {

        char[] title = new char[51];
        Arrays.fill(title,'A');

        Task task = new Task();
        task.setTitle(new String(title));

        assertThat(task.isValid().toString()).contains("E01-F01-A02-M02-Title cannot be longer than 50 characters.");
    }
}