package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class ByteReader extends InputStream implements Closeable {
    private final InputStream stream;
    private final byte[] readBuffer = new byte[8];

    public ByteReader(InputStream stream) {
        this.stream = Objects.requireNonNull(stream, "stream");
    }

    /**
     * Reads a single byte.
     *
     * @return the byte that was read as an unsigned integer
     * @throws IOException if there was an I/O exception
     */
    @Override
    public int read() throws IOException {
        return stream.read();
    }

    /**
     * Reads into the given buffer.
     *
     * @param buffer the buffer to read into
     * @return the number of bytes that were actually read
     * @throws IOException if there was an I/O exception
     */
    @Override
    public int read(byte[] buffer) throws IOException {
        return stream.read(buffer);
    }

    byte[] read(int bytes) throws IOException {
        assert bytes <= this.readBuffer.length;

        var offset = 0;
        while (offset < bytes) {
            var length = this.readBuffer.length - offset;
            var singleRead = stream.read(this.readBuffer, offset, length);
            offset += singleRead;
        }
        return this.readBuffer;
    }

    public <T extends @Nullable Object> T read(Decoder<T> decoder) throws IOException, DecodeException {
        return decoder.decode(this);
    }

    public boolean read(Decoder.Boolean decoder) throws IOException, DecodeException {
        return decoder.decode(this);
    }

    public short read(Decoder.Short decoder) throws IOException, DecodeException {
        return decoder.decode(this);
    }

    public int read(Decoder.Int decoder) throws IOException, DecodeException {
        return decoder.decode(this);
    }

    public long read(Decoder.Long decoder) throws IOException, DecodeException {
        return decoder.decode(this);
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
