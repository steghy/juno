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

package juno.view.pages.new_game.single_player.match.panels.center.circle;

import juno.model.requester.PathProviderAssembler;
import juno.init.ProgramDirectory;
import juno.model.subjects.shift.Inverter;
import juno.view.img_initializer.ImageComponentInitializer;
import juno.view.util.ImageLabel;
import juno.view.util.ImageResizer;

/**
 * @author Simone Gentili
 */
public class CirclePanelConfigurator {

    // Builds a CirclePanelConfigurator object.
    private CirclePanelConfigurator() {}

    /** Configures the CirclePanel instance. */
    public static void configure() {
        // The Circle panel.
        CirclePanel circlePanel = CirclePanel.getInstance();

        // Images initialization.
        ImageResizer resizer = ImageResizer.getInstance();
        ImageLabel circle = new ImageLabel(resizer);
        ImageLabel invertedCircle = new ImageLabel(resizer);
        ImageComponentInitializer initializer = ImageComponentInitializer.getInstance();
        initializer.initialize(circle, PathProviderAssembler.getInstance().assemble(ProgramDirectory.BUTTONS, "CIRCLE.png"), null);
        initializer.initialize(invertedCircle, PathProviderAssembler.getInstance().assemble(ProgramDirectory.BUTTONS, "INVERTED_CIRCLE.png"), null);

        // Image Resizing.
        resizer.resize(circle, 6.0);
        resizer.resize(invertedCircle, 6.0);

        // Settings.
        circlePanel.setFirstComponent(circle);
        circlePanel.setSecondComponent(invertedCircle);

        // Observer / Observable.
        Inverter.getInstance().addObserver(circlePanel);

        // Circle panel initialization.
        circlePanel.init();
    }

}