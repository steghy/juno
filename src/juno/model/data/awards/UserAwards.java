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

package juno.model.data.awards;

import juno.model.data.io.input.configurable.Configurable;
import juno.model.data.io.output.Exportable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Simone Gentili
 */
public class UserAwards
        implements InterfaceUserAwards, Configurable, Exportable {

    private final List<InterfaceAward> awards;

    // The UserAwards instance.
    private static UserAwards instance;

    // Builds the UserAwards instance.
    private UserAwards() {
        awards = new ArrayList<>();
    }

    /**
     * Returns the UserAwards instance.
     * @return The UserAwards instance.
     */
    public static UserAwards getInstance() {
        if(instance == null) instance = new UserAwards();
        return instance;
    }

    @Override
    public List<InterfaceAward> awards() {
        return awards;
    }

    @Override
    public void configure(@NotNull Map<String, Object> map) {
        map.forEach((k, v) -> {
            List<InterfaceAward> result = awards.stream()
                    .filter(award -> award.name().equals(k)).toList();
            int size = result.size();
            if(size == 0) throw new IllegalArgumentException(
                    "Invalid award name found: " + k);
            else if(size == 1) {
                Class<?> klass = v.getClass();
                if(klass == Boolean.class) {
                    if ((boolean) v) result.get(0).unlock();
                } else throw new IllegalArgumentException(
                        "Invalid object type: " + klass +
                                ". Boolean type expected.");
            } else throw new IllegalArgumentException(
                    "Awards with the same name: " + result);
        });
    }

    @Override
    public Map<String, Object> exportData() {
        Map<String, Object> map = new HashMap<>();
        awards.forEach(award -> map.put(award.name(), award.isUnlock()));
        return map;
    }

}