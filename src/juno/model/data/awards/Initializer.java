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

import juno.controller.util.InterfaceInitializer;
import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.goals.Objective;
import juno.model.data.goals.RegistrationObjective;

/**
 * this class defines an initializer.
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
     * @return The Initializer instance.
     */
    public static Initializer getInstance() {
        if(instance == null) instance = new Initializer();
        return instance;
    }

    @Override
    public void initialize() {
        // Registration.
        RegistrationObjective.getInstance().addObserver(AvatarImage.AVATAR_IMAGE_1);

        // First match won.
        Objective.FIRST_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_2);

        // First match lose.
        Objective.FIRST_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_3);

        // Ten match won.
        Objective.TEN_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_4);

        // Ten match lose.
        Objective.TEN_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_5);

        // Fifty match won.
        Objective.FIFTY_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_6);

        // Fifty match lose.
        Objective.FIFTY_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_7);

        // One hundred match won.
        Objective.ONE_HUNDRED_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_8);

        // One hundred match lose.
        Objective.ONE_HUNDRED_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_9);
    }

}