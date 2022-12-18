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

import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;
import juno.model.data.goals.Goal;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the juno.model.data.awards package. */
    public static void initialize() {
        // Registration.
        Goal.REGISTRATION.addObserver(AvatarImage.AVATAR_IMAGE_1);
        Goal.REGISTRATION.addObserver(AvatarFrame.GREY_FRAME);

        // First match won.
        Goal.FIRST_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_2);
        Goal.FIRST_MATCH_WON.addObserver(AvatarFrame.CYAN_GREEN_FRAME);

        // First match lose.
        Goal.FIRST_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_3);

        // Ten match won.
        Goal.TEN_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_4);
        Goal.TEN_MATCH_WON.addObserver(AvatarFrame.BLUE_FRAME);

        // Ten match lose.
        Goal.TEN_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_5);

        // Fifty match won.
        Goal.FIFTY_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_6);
        Goal.FIFTY_MATCH_WON.addObserver(AvatarFrame.BLACK_FRAME);

        // Fifty match lose.
        Goal.FIFTY_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_8);

        // One hundred match won.
        Goal.ONE_HUNDRED_MATCH_WON.addObserver(AvatarFrame.GOLD_FRAME);

        // One hundred match lose.
        Goal.ONE_HUNDRED_MATCH_LOSE.addObserver(AvatarImage.AVATAR_IMAGE_9);
    }

}