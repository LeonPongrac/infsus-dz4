package hr.infsus.controller;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/user")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("user").initializeFormKeys().list();

        List<Map<String, Object>> taskDetails = tasks.stream()
                .map(task -> {
                    Map<String, Object> details = new HashMap<>();
                    details.put("id", task.getId());
                    details.put("name", task.getName());
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    StringBuilder formattedVariables = new StringBuilder();
                    for (Map.Entry<String, Object> entry : variables.entrySet()) {
                        formattedVariables.append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
                    }
                    details.put("variables", formattedVariables.toString());
                    return details;
                })
                .collect(Collectors.toList());

        model.addAttribute("tasks", taskDetails);
        return "tasks-user";
    }

    @GetMapping("/task/user/confirm/{id}")
    public String confirmTask(@PathVariable("id") String taskId) {
        taskService.complete(taskId);
        return "redirect:/tasks/user";
    }

}
