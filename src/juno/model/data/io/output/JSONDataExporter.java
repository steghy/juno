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

package juno.model.data.io.output;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * This class defines a json data exporter.
 * @author Simone Gentili
 */
public class JSONDataExporter 
        implements InterfaceDataExporter {

    // The JSONDataExporter instance.
    private static JSONDataExporter instance;

    // Builds the JSONDataExporter instance.
    private JSONDataExporter() {}

    /**
     * Returns the JSONDataExporter instance.
     * @return The JSONDataExporter instance.hk
     */
    public static JSONDataExporter getInstance() {
        if(instance == null) {
            instance = new JSONDataExporter();
        } return instance;
    }

    @Override
    public void exportData(@NotNull String path, 
                           @NotNull Map<String, Object> map) throws IOException {
        JSONObject jsonObject = new JSONObject(map);
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(jsonObject.toString());
        fileWriter.close();
    }

}