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

package juno.view.pages.new_game.single_player.match.panels.south;

import juno.model.card.InterfaceCard;
import juno.model.deck.AbstractCompatibilityCheckerUser;
import juno.model.util.Setter;
import juno.view.gobject.GObjectButton;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * This class defines a compatible graphic card enabler.
 * @author Simone Gentili
 */
public class CompatibleGCardEnabler
        extends AbstractCompatibilityCheckerUser<InterfaceCard>
        implements Setter<List<GObjectButton<InterfaceCard>>> {

    // The CompatibleGCardEnabler.
    private static CompatibleGCardEnabler instance;

    // Builds the CompatibleGCardEnabler.
    private CompatibleGCardEnabler() {}

    /**
     * Returns the CompatibleGCardEnabler instance.
     * @return The CompatibleGCardEnabler instance.
     */
    public static CompatibleGCardEnabler getInstance() {
        if(instance == null) instance = new CompatibleGCardEnabler();
        return instance;
    }

    @Override
    public void set(@NotNull List<GObjectButton<InterfaceCard>> object) {
        object.forEach(gCard ->
            gCard.setEnabled(Objects.requireNonNull(getCompatibilityChecker())
                    .isCompatible(gCard.object())));
    }

}