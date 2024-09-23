package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

/**
 * A {@code Codec} is an object that acts as both an {@link Encoder} and {@link Decoder}.
 *
 * @param <T> the type of the data
 * @see Encoder
 * @see Decoder
 */
public interface Codec<T extends @Nullable Object> extends Encoder<T>, Decoder<T> {
  interface Boolean extends Encoder.Boolean, Decoder.Boolean {}

  interface Short extends Encoder.Short, Decoder.Short {}

  interface Int extends Encoder.Int, Decoder.Int {}

  interface Long extends Encoder.Long, Decoder.Long {}
}
