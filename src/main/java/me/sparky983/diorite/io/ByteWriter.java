package me.sparky983.diorite.io;

import org.jspecify.annotations.Nullable;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public final class ByteWriter extends OutputStream implements Closeable {
    private final OutputStream stream;

    public ByteWriter(OutputStream stream) {
        this.stream = Objects.requireNonNull(stream, "stream");
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] buffer) throws IOException {
        stream.write(buffer);
    }

    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        stream.write(buffer, offset, length);
    }

    public <T extends @Nullable Object> void write(Encoder<T> codec, T data) throws IOException {
        codec.encode(this, data);
    }

    public void write(Encoder.Boolean encoding, boolean data) throws IOException {
        encoding.encode(this, data);
    }

    public void write(Encoder.Short encoding, short data) throws IOException {
        encoding.encode(this, data);
    }

    public void write(Encoder.Int encoding, int data) throws IOException {
        encoding.encode(this, data);
    }

    public void write(Encoder.Long encoding, long data) throws IOException {
        encoding.encode(this, data);
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
