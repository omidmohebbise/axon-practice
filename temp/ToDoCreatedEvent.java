package org.omidmohebbise.axon.example1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ToDoCreatedEvent {
    private final String id;
    private final String description;
}
