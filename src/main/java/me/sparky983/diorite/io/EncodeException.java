package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

/**
 * Thrown by an {@link Encoder} to indicate that that outgoing data was invalid.
 */
public final class EncodeException extends RuntimeException {
    public EncodeException() {
    }

    public EncodeException(@Nullable String message) {
        super(message);
    }
}
