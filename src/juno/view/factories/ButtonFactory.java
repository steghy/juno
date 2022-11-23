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

package juno.view.factories;

import juno.init.Directories;
import juno.init.InterfaceDirectories;
import juno.view.util.Constant;
import juno.view.util.ImageButton;
import juno.view.util.ImageComponentInitializer;
import juno.view.util.ImageToggleButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("ALL")
public class ButtonFactory {

    private static String extension = ".png";
    private static String rollover = "_ROLLOVER";
    private static String selected = "_SELECTED";

    private static InterfaceDirectories directories = Directories.BUTTONS;

    private static boolean download = false;

    private static Constant bothMissing = Constant.THROW_EXCEPTION;
    private static Constant bothSelectedMissing = Constant.THROW_EXCEPTION;
    private static Constant allMissing = Constant.THROW_EXCEPTION;

    private static Constant imageMissing = Constant.KEEP_ROLLOVER_IMAGE;
    private static Constant rolloverImageMissing = Constant.KEEP_IMAGE;

    private static Constant selectedImageMissing = Constant.KEEP_ROLLOVER_SELECTED_IMAGE;
    private static Constant rolloverSelectedImageMissing = Constant.KEEP_SELECTED_IMAGE;

    private static Dimension dimension = null;

    private ButtonFactory() {}

    public static AbstractButton createButton(@NotNull ButtonLibrary BUTTON) {
        AbstractButton button;
        if(BUTTON.name().endsWith("TOGGLE")) {
            button = new ImageToggleButton();
            ImageComponentInitializer.initialize(
                    button,
                    directories,
                    download,
                    BUTTON.name(),
                    BUTTON.name() + extension,
                    BUTTON.name() + rollover + extension,
                    BUTTON.name() + selected + extension,
                    BUTTON.name() + selected + rollover + extension,
                    dimension,
                    bothMissing,
                    bothSelectedMissing,
                    allMissing,
                    imageMissing,
                    rolloverImageMissing,
                    selectedImageMissing,
                    rolloverSelectedImageMissing
            );
        } else {
            button = new ImageButton();
            ImageComponentInitializer.initialize(
                    button,
                    directories,
                    download,
                    BUTTON.name(),
                    BUTTON.name() + extension,
                    BUTTON.name() + rollover + extension,
                    dimension,
                    bothMissing,
                    imageMissing,
                    rolloverImageMissing
            );
        }

        return button;
    }
}