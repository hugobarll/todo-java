package com.hugobarll.todo_app.config;

import com.hugobarll.todo_app.entities.Task;
import com.hugobarll.todo_app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public void run(String... args) throws Exception {


        Task t1 = new Task(null, "Terminar esse projeto", false);
        Task t2 = new Task(null, "Comprar flores", false);
        Task t3 = new Task(null, "Comprar alianças", false);

        taskRepository.saveAll((Arrays.asList(t1,t2,t3)));
    }
}
