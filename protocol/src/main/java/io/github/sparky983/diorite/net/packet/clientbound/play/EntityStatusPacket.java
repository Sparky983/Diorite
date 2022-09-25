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

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import io.github.sparky983.diorite.io.StreamIn;
import io.github.sparky983.diorite.io.StreamOut;
import io.github.sparky983.diorite.net.packet.clientbound.ClientBoundPacket;
import io.github.sparky983.diorite.net.packet.clientbound.ClientBoundPacketId;
import io.github.sparky983.diorite.util.Preconditions;

@ApiStatus.Experimental
public class EntityStatusPacket implements ClientBoundPacket {

    private final int entityId;
    private final byte entityStatus; // Use entity statuses enum

    @Contract(pure = true)
    public EntityStatusPacket(final int entityId, final byte entityStatus) {

        this.entityId = entityId;
        this.entityStatus = entityStatus;
    }

    @Contract(mutates = "param")
    public EntityStatusPacket(final @NotNull StreamIn inputStream) {

        Preconditions.requireNotNull(inputStream, "inputStream");

        this.entityId = inputStream.readInt();
        this.entityStatus = inputStream.readByte();
    }

    @Override
    public void write(final @NotNull StreamOut outputStream) {

        Preconditions.requireNotNull(outputStream, "outputStream");

        outputStream.writeInt(entityId)
                .writeByte(entityStatus);
    }

    @Override
    public int getId() {

        return ClientBoundPacketId.Play.ENTITY_STATUS;
    }

    @Contract(pure = true)
    public int getEntityId() {

        return entityId;
    }

    @Contract(pure = true)
    public byte getEntityStatus() {

        return entityStatus;
    }
}
