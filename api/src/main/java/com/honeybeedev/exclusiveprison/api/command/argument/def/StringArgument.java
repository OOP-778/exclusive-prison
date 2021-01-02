package com.honeybeedev.exclusiveprison.api.command.argument.def;

import com.honeybeedev.exclusiveprison.api.command.argument.CommandArgument;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.function.Function;

@Accessors(fluent = true, chain = true)
public class StringArgument implements CommandArgument<String> {

    @Setter
    @Getter
    private String id;

    @Getter
    @Setter
    private boolean required = false;

    @Override
    public Function<String, String> parser() {
        return in -> in;
    }
}
