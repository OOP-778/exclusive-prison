package com.honeybeedev.exclusiveprison.api.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ParseResult<T> {

    private final String message;
    private T object;

}
