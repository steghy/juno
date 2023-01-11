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
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class defines an abstract requester.
 * @author Simone Gentili
 */
public abstract class AbstractRequester
        implements InterfaceRequester {

    /** Constructor. */
    public AbstractRequester() {}

    // The URL builder list.
    private final List<InterfaceURLBuilder> urlBuilderList = new ArrayList<>();

    // The internet connectivity checker.
    private InterfaceInternetConnectivityChecker connectivityChecker;

    // The downloader.
    private InterfaceDownloader downloader;

    /**
     * Returns the URL builder list of this object.
     * @return A List object.
     */
    public List<InterfaceURLBuilder> getUrlBuilderList() {
        return urlBuilderList;
    }

    /**
     * Sets the internet connectivity checker of this object.
     * @param connectivityChecker An InterfaceInternetConnectivityChecker object.
     */
    public void setConnectivityChecker(@NotNull InterfaceInternetConnectivityChecker connectivityChecker) {
        this.connectivityChecker = connectivityChecker;
    }

    /**
     * Sets the downloader of this object.
     * @param downloader An InterfaceDownloader object.
     */
    public void setDownloader(@NotNull InterfaceDownloader downloader) {
        this.downloader = downloader;
    }

    /**
     * Returns the internet connectivity checker of this object.
     * @return An InterfaceInternetConnectivityChecker object.
     */
    @Nullable
    public InterfaceInternetConnectivityChecker getConnectivityChecker() {
        return connectivityChecker;
    }

    /**
     * Returns the downloader of this object.
     * @return An InterfaceDownloader object.
     */
    @Nullable
    public InterfaceDownloader getDownloader() {
        return downloader;
    }

}