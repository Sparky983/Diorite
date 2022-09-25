/*
 * Copyright 2022 Sparky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.sparky983.diorite.net.packet.clientbound.play;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import io.github.sparky983.diorite.io.StreamIn;
import io.github.sparky983.diorite.io.StreamOut;
import io.github.sparky983.diorite.net.packet.clientbound.ClientBoundPacket;
import io.github.sparky983.diorite.net.packet.clientbound.ClientBoundPacketId;
import io.github.sparky983.diorite.util.Preconditions;
import io.github.sparky983.diorite.world.Position;

public class SpawnExperienceOrbPacket implements ClientBoundPacket {

    private final int entityId;
    private final Position location;
    private final short count;

    @Contract(pure = true)
    public SpawnExperienceOrbPacket(final int entityId,
                                    final @NotNull Position location,
                                    final short count) {

        Preconditions.requireNotNull(location, "location");

        this.entityId = entityId;
        this.location = location;
        this.count = count;
    }

    @Contract(mutates = "param")
    public SpawnExperienceOrbPacket(final @NotNull StreamIn inputStream) {

        Preconditions.requireNotNull(inputStream, "inputStream");

        this.entityId = inputStream.readVarInt();
        this.location = inputStream.readPosition();
        this.count = inputStream.readShort();
    }

    @Override
    public void write(final @NotNull StreamOut outputStream) {

        Preconditions.requireNotNull(outputStream, "outputStream");

        outputStream.writeVarInt(entityId)
                .writePosition(location)
                .writeShort(count);
    }

    @Override
    public int getId() {

        return ClientBoundPacketId.Play.SPAWN_EXPERIENCE_ORB;
    }

    @Contract(pure = true)
    public int getEntityId() {

        return entityId;
    }

    @Contract(pure = true)
    public @NotNull Position getLocation() {

        return location;
    }

    @Contract(pure = true)
    public short getCount() {

        return count;
    }
}
