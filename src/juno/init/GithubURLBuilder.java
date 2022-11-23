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

package juno.init;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

public class GithubURLBuilder implements InterfaceGithubURLBuilder {

    public static final String PREFIX = "https://raw.githubusercontent.com";
    public static final String TOKEN = "?token=";

    public String prefix;
    public String repositoryName;
    public String adminName;
    public String branchName;
    public String token;

    private static GithubURLBuilder instance;

    private GithubURLBuilder() {}

    public static GithubURLBuilder getInstance() {
        if(instance == null) instance = new GithubURLBuilder();
        return instance;
    }

    @Override
    public URL getGithubURL(@NotNull String path) throws MalformedURLException {
        String div = "/";
        path = path.replace('\\', '/');
        String urlString = (prefix == null ? PREFIX : prefix) +
                (adminName == null ? "" : div.concat(adminName)) +
                (repositoryName == null ? "" : div.concat(repositoryName)) +
                (branchName == null ? "" : div.concat(branchName)) +
                (path.startsWith("/") ? path : div.concat(path)) +
                (token == null || token.length() == 0 ? "" : token.concat(token));
        return new URL(urlString);
    }
}