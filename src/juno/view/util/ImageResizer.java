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

package juno.view.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Simone Gentili
 */
public class ImageResizer {

    // Builds an ImageResizer object.
    private ImageResizer() {}

    public static Image resize(@NotNull Component component,
                               @NotNull String path) {
        ImageIcon image = new ImageIcon(path);
        return image.getImage().getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);
    }

    public static Image resize(@NotNull Component component,
                               @NotNull ImageIcon icon) {
        return  icon.getImage().getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);

    }

    public static Image resize(@NotNull Component component,
                               @NotNull Icon icon) {
        if(icon instanceof ImageIcon image)
            return image.getImage().getScaledInstance(
                    component.getWidth(),
                    component.getHeight(), 0);
        else throw new IllegalArgumentException(
                "Invalid object type: " + icon.getClass() +
                        ". ImageIcon type expected.");
    }

    public static Image resize(@NotNull Component component,
                               @NotNull Image image) {
        return  image.getScaledInstance(
                component.getWidth(),
                component.getHeight(), 0);
    }

    public static void resize(@NotNull AbstractButton button,
                              double divisor) {
        Icon icon = button.getIcon();
        button.setPreferredSize(new Dimension(
                (int) (icon.getIconWidth()  / divisor),
                (int) (icon.getIconHeight() / divisor)));
    }

}