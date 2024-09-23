package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

/**
 * Thrown by an {@link Decoder} to indicate that that incoming data was invalid.
 */
public final class DecodeException extends Exception {
    public DecodeException() {
    }

    public DecodeException(@Nullable String message) {
        super(message);
    }

    @Override
    public Throwable fillInStackTrace() {
        // A server may want to make this method a no-op as this operation is relatively expensive
        // and can be triggered by a client very easily and in rapid succession
        return super.fillInStackTrace();
    }
}
