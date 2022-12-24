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
 * @author Simone Gentili
 */
public enum Button
        implements InterfaceButton {

    // LOGO //
    JUNO(true),

    // PRE ACCESS PANEL //
    WELCOME(true),
    WELCOME_BACK(true),
    REGISTRATION(true),
    CREATE_AN_ACCOUNT(true),
    CONTINUE_WITHOUT_AN_ACCOUNT(true),
    LOG_IN(true),
    CONFIRM(true),
    PROFILE_BUTTON(true),

    // MAIN MENU SECTION //
    NEW_GAME(true),
    SCORE(true),
    OPTIONS(true),
    EXIT(true),
    LOG_OUT(true),

    // OPTIONS //
    SETTINGS(true),
    AUDIO_TOGGLE(false),
    FULLSCREEN_TOGGLE(false),
    BACK(true),

    // NEW GAME MENU //
    DIFFICULTY(true),
    SINGLE_PLAYER(true),
    MULTIPLAYER(true),

    // SINGLE_PLAYER //
    TWO_PLAYERS(true),
    THREE_PLAYERS(true),
    FOUR_PLAYERS(true),
    PLAYERS(true),
    START(true),

    // MODE //
    MODE(true),
    STACKING(true),

    // MATCH //
    COVER_TO_NORTH(true),
    COVER_TO_SOUTH(true),
    COVER_TO_EAST(true),
    COVER_TO_WEST(true),

    // MULTIPLAYER //
    UNAVAILABLE_SERVICE(true),

    // DIFFICULTY //
    EASY(true),
    MEDIUM(true),
    HARD(true);

    // Simple button boolean value.
    private final boolean isSimple;

    // Toggle button boolean value.
    private final boolean isToggle;

    // Builds a Button object with
    // the specified boolean value.
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