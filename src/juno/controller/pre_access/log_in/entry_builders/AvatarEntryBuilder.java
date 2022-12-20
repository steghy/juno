/*
 *
 * MIT License
 *
 * Copyright (c) 2022 Simone Gentili
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package juno.controller.pre_access.log_in.entry_builders;

import juno.model.data.avatar.InterfaceConfigurationMapDecorator;
import juno.model.data.io.input.configurable.Configurable;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AvatarEntryBuilder
        extends AbstractEntryBuilder {

    // The map decorator.
    private InterfaceConfigurationMapDecorator decorator;

    // The AvatarEntryBuilder instance.
    private static AvatarEntryBuilder instance;

    // Builds the AvatarEntryBuilder instance.
    private AvatarEntryBuilder() {}

    /**
     * Returns the AvatarEntryBuilder instance.
     * @return The AvatarEntryBuilder instance.
     */
    public static AvatarEntryBuilder getInstance() {
        if(instance == null) instance = new AvatarEntryBuilder();
        return instance;
    }

    /**
     * Sets the configuration map decorator of this object.
     * @param decorator An InterfaceConfigurationMapDecorator object.
     */
    public void setDecorator(@NotNull InterfaceConfigurationMapDecorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public Map.Entry<Configurable, Map<String, Object>> create(@NotNull String name) {
        try {
            return Map.entry(
                    Objects.requireNonNull(getConfigurable()),
                    decorator.decorate(Objects.requireNonNull(getImporter())
                            .importData(Objects.requireNonNull(getBuilder()).build(name))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}