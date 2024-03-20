package org.omidmohebbise.axon.example1;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublisherService implements CommandLineRunner {


    @Qualifier("eventBus")
    private final EventBus eventBus;

    public void publishEvent(String id, String description) {
        ToDoCreatedEvent event = new ToDoCreatedEvent(id, description);
        eventBus.publish(GenericEventMessage.asEventMessage(event));
    }
    @Override
    public void run(String... args) throws Exception {
        publishEvent("1", "Complete task A");

    }
}
