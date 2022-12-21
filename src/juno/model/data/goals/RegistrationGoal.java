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

import juno.controller.log_out.Restorable;
import juno.model.util.AbstractObservable;
import juno.model.util.Observable;

public class RegistrationGoal
        extends AbstractObservable
        implements InterfaceGoal, Observable, Restorable {

    private boolean unlock;

    private static RegistrationGoal instance;

    private RegistrationGoal() {
        unlock = false;
    }

    public static RegistrationGoal getInstance() {
        if(instance == null) instance = new RegistrationGoal();
        return instance;
    }

    @Override
    public void unlock() {
        if(unlock) throw new IllegalArgumentException(
                "Registration goal is already unlocked.");
        unlock = true;
        updateAll();
    }

    @Override
    public String name() {
        return "REGISTRATION_GOAL";
    }

    @Override
    public boolean isReached() {
        return unlock;
    }

    @Override
    public void restore() {
        unlock = false;
        updateAll();
    }

}