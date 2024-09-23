package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

import java.io.IOException;

/**
 * An {@code Encoder} outputs some given data into a sequence of bytes.
 *
 * @param <T> the type of the data
 * @see Encoder.Boolean
 * @see Encoder.Short
 * @see Encoder.Int
 * @see Encoder.Long
 */
@FunctionalInterface
public interface Encoder<T extends @Nullable Object> {
  /**
   * Encodes the given data to the writer.
   *
   * @param writer the writer to output the data to
   * @param data the data to encode
   * @throws EncodeException if the data is invalid
   * @throws IOException if an I/O exception occurred while writing to the writer
   */
  void encode(ByteWriter writer, T data) throws IOException;

  /**
   * An {@link Encoder} for the {@code boolean} primitive type.
   */
  @FunctionalInterface
  interface Boolean {
    /**
     * @see Encoder#encode(ByteWriter, Object)
     */
    void encode(ByteWriter writer, boolean data) throws IOException;
  }

  /**
   * An {@link Encoder} for the {@code short} primitive type.
   */
  @FunctionalInterface
  interface Short {
    /**
     * @see Encoder#encode(ByteWriter, Object)
     */
    void encode(ByteWriter write, short data) throws IOException;
  }

  /**
   * An {@link Encoder} for the {@code int} primitive type.
   */
  @FunctionalInterface
  interface Int {
    /**
     * @see Encoder#encode(ByteWriter, Object)
     */
    void encode(ByteWriter writer, int data) throws IOException;
  }

  /**
   * An {@link Encoder} for the {@code long} primitive type.
   */
  @FunctionalInterface
  interface Long {
    /**
     * @see Encoder#encode(ByteWriter, Object)
     */
    void encode(ByteWriter writer, long data) throws IOException;
  }
}
