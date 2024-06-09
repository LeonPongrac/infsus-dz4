package hr.infsus.controller;

import hr.infsus.service.BoothApplicationService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/admin")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("admin").initializeFormKeys().list();

        List<Map<String, Object>> taskDetails = tasks.stream()
                .map(task -> {
                    Map<String, Object> details = new HashMap<>();
                    details.put("id", task.getId());
                    details.put("name", task.getName());
                    details.put("description", task.getDescription());
                    details.put("assignee", task.getAssignee());
                    details.put("createTime", task.getCreateTime());
                    details.put("dueDate", task.getDueDate());
                    details.put("formKey", task.getFormKey());
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
        return "tasks-admin";
    }

    @GetMapping("/task/admin/approve/{id}")
    public String approveTask(@PathVariable("id") String taskId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approved", true);
        taskService.complete(taskId, variables);
        return "redirect:/tasks/admin";
    }

    @GetMapping("/task/admin/reject/{id}")
    public String rejectTask(@PathVariable("id") String taskId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("approved", false);
        taskService.complete(taskId, variables);
        return "redirect:/tasks/admin";
    }
}
