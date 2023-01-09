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

package juno.model.subjects.factory;

import juno.controller.util.InterfaceInitializer;
import juno.model.card.InterfaceCard;
import juno.model.card.colors.InterfaceColor;
import juno.model.subjects.ai.InterfaceDifficulty;
import juno.model.subjects.ai.examiner.card_examiner.CardExaminer;
import juno.model.subjects.ai.examiner.color_examiner.ColorExaminer;
import juno.model.subjects.ai.examiner.card_examiner.InterfaceCardExaminer;

/**
 * This class defines an initializer.
 * @author Simone Gentili
 */
public class Initializer
        implements InterfaceInitializer {

    // The Initializer instance.
    private static Initializer instance;

    // Builds the Initializer instance.
    private Initializer() {}

    /**
     * Returns the Initializer instance.
     * @return The Initializer instance
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void initialize() {
        AiFactory<InterfaceCard, InterfaceDifficulty> aiPlayerFactory =
                (AiFactory<InterfaceCard, InterfaceDifficulty>) AiFactory.getInstance();
        NameProvider nameFactory = NameProvider.getInstance();
        AiBuilder<InterfaceCard, InterfaceColor> aiBuilder =
                (AiBuilder<InterfaceCard, InterfaceColor>) AiBuilder.getInstance();
        aiPlayerFactory.setBuilder(aiBuilder);
        aiPlayerFactory.setRelativeProvider(nameFactory);
        aiBuilder.setCardExaminer((InterfaceCardExaminer<InterfaceCard>) CardExaminer.getInstance());
        aiBuilder.setColorExaminer(ColorExaminer.getInstance());
    }

}