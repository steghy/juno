package juno.model.data.io.output;

import java.util.Map;

@FunctionalInterface
public interface Exportable{

    Map<String, Object> exportData();

}
