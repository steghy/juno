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

package juno.view.button;

/**
 * This class contains all the graphic button.
 * @author Simone Gentili
 */
public enum Button
        implements InterfaceButton {

    /** Juno logo */
    JUNO(true),

    // PRE ACCESS PANEL //
    /** Welcome */
    WELCOME(true),
    /** Welcome back */
    WELCOME_BACK(true),
    /** Registration */
    REGISTRATION(true),
    /** Create an account */
    CREATE_AN_ACCOUNT(true),
    /** Continue without an account */
    CONTINUE_WITHOUT_AN_ACCOUNT(true),
    /** Log in */
    LOG_IN(true),
    /** Confirm */
    CONFIRM(true),
    /** Profile button */
    PROFILE_BUTTON(true),

    // MAIN MENU SECTION //
    /** New game */
    NEW_GAME(true),
    /** Score */
    SCORE(true),
    /** Options */
    OPTIONS(true),
    /** Exit */
    EXIT(true),
    /** Log out */
    LOG_OUT(true),

    // OPTIONS //
    /** Settings */
    SETTINGS(true),
    /** Audio toggle music */
    AUDIO_TOGGLE_MUSIC(false),
    /** Audio toggle effects */
    AUDIO_TOGGLE_EFFECTS(false),
    /** Fullscreen toggle */
    FULLSCREEN_TOGGLE(false),
    /** Back */
    BACK(true),

    // NEW GAME MENU //
    /** Difficulty */
    DIFFICULTY(true),
    /** Single player */
    SINGLE_PLAYER(true),
    /** Multiplayer */
    MULTIPLAYER(true),

    // SINGLE_PLAYER //
    /** Two players */
    TWO_PLAYERS(true),
    /** Three players */
    THREE_PLAYERS(true),
    /** Four players */
    FOUR_PLAYERS(true),
    /** Players */
    PLAYERS(true),
    /** Start */
    START(true),
    /** Restart */
    RESTART(true),
    /** Winner */
    WINNER(true),

    // MODE //
    /** Mode */
    MODE(true),
    /** Classic */
    CLASSIC(true),
    /** Classic artwork */
    CLASSIC_ARTWORK(true),

    // MATCH //
    /** Cover */
    COVER(true),
    /** Circle */
    CIRCLE(true),
    /** Inverted circle */
    INVERTED_CIRCLE(true),

    // MULTIPLAYER //
    /** Unavailable service */
    UNAVAILABLE_SERVICE(true),

    // DIFFICULTY //
    /** Easy */
    EASY(true),
    /** Medium */
    MEDIUM(true),
    /** Hard */
    HARD(true);

    // Simple button boolean value.
    private final boolean isSimple;

    // Toggle button boolean value.
    private final boolean isToggle;

    /**
     * Create a Button instance with
     * the specified boolean value.
     * @param isSimple A boolean value.
     */
    Button(boolean isSimple) {
        this.isSimple = isSimple;
        this.isToggle = !isSimple;
    }

    @Override
    public boolean isSimpleButton() {
        return isSimple;
    }

    @Override
    public boolean isToggleButton() {
        return isToggle;
    }

}