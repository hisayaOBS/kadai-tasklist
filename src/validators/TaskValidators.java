package validators;

import java.util.ArrayList;
import java.util.List;

import models.Task;

public class TaskValidators {

    public static List<String> taskValidate(Task task) {
        List<String> errors = new ArrayList<String>();
        String content_error = contentValidate(task.getContent());

        if (!content_error.equals("")) {
            errors.add(content_error);
        }
        return errors;

    }

    private static String contentValidate(String content) {
        if (content == null || content.equals("")) {
            return "タスクを入力してください。";
        } else {
            return "";
        }
    }
}
