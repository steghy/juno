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

package juno.model.requester;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Simone Gentili
 */
public class Requester
        extends AbstractRequester {

    // The Requester instance.
    private static Requester instance;

    // Builds the Requester instance.
    private Requester() {}

    /**
     * Returns the Requester instance.
     * @return The Requester instance.
     */
    public static Requester getInstance() {
        if(instance == null) instance = new Requester();
        return instance;
    }

    @Override
    public void solve(@NotNull InterfacePathProvider pathProvider) throws IOException {
        if(Objects.requireNonNull(getConnectivityChecker()).isConnected()) {
            Objects.requireNonNull(getUrlBuilderList());
            Objects.requireNonNull(getDownloader());
            Map<String, String> errors = new HashMap<>();
            for(InterfaceURLBuilder urlBuilder : getUrlBuilderList()) {
                try {
                    URL url = urlBuilder.getURL(pathProvider.canonicalPath());
                    getDownloader().download(url, pathProvider.absolutePath());
                    return;
                } catch (IOException e) { errors.put(urlBuilder.toString(), e.getMessage()); }
            } throw new IOException("The request failed due to the following problems:" + errors);
        } else throw new IllegalArgumentException(
                "Cannot resolve the request because the " +
                        "internet connection is not available.");
    }

}