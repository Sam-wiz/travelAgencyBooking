package io.group17.travelagencybooking.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinationNotFoundException extends RuntimeException{
    private Long id;
    public DestinationNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }
}
