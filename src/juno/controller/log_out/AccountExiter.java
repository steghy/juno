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

package juno.controller.log_out;

import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class AccountExiter
        extends AbstractAccountExiter<String> {

    // The Account exiter.
    private static AccountExiter instance;

    // Builds the account exiter.
    private AccountExiter() {}

    /**
     * Returns the AccountExiter instance.
     * @return The AccountExiter instance.
     */
    public static AccountExiter getInstance() {
        if(instance == null) instance = new AccountExiter();
        return instance;
    }

    @Override
    public void logOut() {
        String object = Objects.requireNonNull(getProvider()).provide();
        Objects.requireNonNull(getExporterManager()).export(object);
        Objects.requireNonNull(getRestorableList()).forEach(Restorable::restore);
        Objects.requireNonNull(getGenerator()).generate();
    }

}