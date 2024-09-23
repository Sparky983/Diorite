package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

import java.io.IOException;

/**
 * A {@code Decoder} reads a sequence of bytes and converts it into an object.
 *
 * @param <T> the type of the object
 * @see Decoder.Boolean
 * @see Decoder.Short
 * @see Decoder.Int
 * @see Decoder.Long
 */
@FunctionalInterface
public interface Decoder<T extends @Nullable Object> {
  /**
   * Decodes the given stream of bytes into an object.
   *
   * @param reader the reader to read the bytes from
   * @return the decoded object
   * @throws DecodeException if data from the stream was invalid
   * @throws IOException if an I/O exception occurred while reading from the reader
   */
  T decode(ByteReader reader) throws DecodeException, IOException;

  /**
   * An {@link Decoder} for the {@code boolean} primitive type.
   */
  @FunctionalInterface
  interface Boolean {
    /**
     * @see Decoder#decode(ByteReader)
     */
    boolean decode(ByteReader reader) throws DecodeException, IOException;
  }

  /**
   * An {@link Decoder} for the {@code short} primitive type.
   */
  @FunctionalInterface
  interface Short {
    /**
     * @see Decoder#decode(ByteReader)
     */
    short decode(ByteReader reader) throws DecodeException, IOException;
  }

  /**
   * An {@link Decoder} for the {@code int} primitive type.
   */
  @FunctionalInterface
  interface Int {
    /**
     * @see Decoder#decode(ByteReader)
     */
    int decode(ByteReader reader) throws DecodeException, IOException;
  }

  /**
   * An {@link Decoder} for the {@code long} primitive type.
   */
  @FunctionalInterface
  interface Long {
    /**
     * @see Decoder#decode(ByteReader)
     */
    long decode(ByteReader reader) throws DecodeException, IOException;
  }
}
