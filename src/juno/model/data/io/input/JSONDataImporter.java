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

package juno.model.data.io.input;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * This class defines a JSON file importer.
 * In particular, this importer allows you
 * to convert the content of a JSON file into
 * a Map object.
 * @author Simone Gentili
 */
public class JSONDataImporter
        implements InterfaceDataImporter {

    // The JSONDataImporter instance.
    private static JSONDataImporter instance;

    // Builds the JSONDataImporter instance.
    private JSONDataImporter() {}

    /**
     * Returns the JSONDataImporter instance.
     * @return The JSONDataImporter instance.
     */
    public static JSONDataImporter getInstance() {
        if(instance == null) instance = new JSONDataImporter();
        return instance;
    }

    @Override
    public Map<String, Object> importData(@NotNull String path) throws IOException {
        String source = new String(Files.readAllBytes(Paths.get(path)));
        JSONObject jsonObject = new JSONObject(source);
        return jsonObject.toMap();
    }

}