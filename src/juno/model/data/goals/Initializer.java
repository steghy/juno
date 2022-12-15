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

package juno.model.data.goals;

import juno.model.data.awards.avatar.AvatarImage;
import juno.model.data.awards.frame.AvatarFrame;

/**
 * @author Simone Gentili
 */
public class Initializer {

    // Builds an Initializer object.
    private Initializer() {}

    /** Initialize the goals and they relative awards. */
    public static void initialize() {

        // First match won.
        Goals.FIRST_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_2);
        Goals.FIRST_MATCH_WON.addObserver(AvatarFrame.GREY_FRAME);

        // Ten match won.
        Goals.TEN_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_3);
        Goals.TEN_MATCH_WON.addObserver(AvatarFrame.GREY_FRAME);

        // First match lose.
        Goals.FIRST_MATCH_LOSE.addObserver(AvatarFrame.BLUE_FRAME);

        // One hundred match won.
        Goals.ONE_HUNDRED_MATCH_WON.addObserver(AvatarImage.AVATAR_IMAGE_9);
    }

}