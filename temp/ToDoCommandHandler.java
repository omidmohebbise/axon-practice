package org.omidmohebbise.axon.example1;


import lombok.extern.log4j.Log4j2;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ToDoCommandHandler {
    @CommandHandler
    public void handle(CreateToDoCommand command) {
        log.info("** command: ", command.getId());
        ToDoCreatedEvent event = new ToDoCreatedEvent(command.getId(), command.getDescription());
        log.info("** event: ", event.getId());
    }
}
