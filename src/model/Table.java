package model;

import java.util.List;

/**
 * Created by root on 10.02.14.
 */
public class Table {
    List<String> columnLabels;
    List<List<String>> rows;

    public List<String> getColumnLabels() {
        return columnLabels;
    }

    public void setColumnLabels(List<String> columnLabels) {
        this.columnLabels = columnLabels;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public Table() {


    }
}
