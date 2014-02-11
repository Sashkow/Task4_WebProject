package dao;

import model.Table;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10.02.14.
 */
/*
fills Table object from model with ResultSet data
 */
public class TableFiller {
    public static void fillTable(Table table, ResultSet resultSet){

        ResultSetMetaData md = null;
        try {
            List<String> columnLabelList=new ArrayList<String>();
            List<List<String>> rowsList= new ArrayList<List<String>>();


            md = resultSet.getMetaData();
            int count = md.getColumnCount();

            for (int i=1; i<=count; i++) {
                columnLabelList.add(md.getColumnLabel(i));
            }

            while (resultSet.next()) {
                List<String> row=new ArrayList();
                for (int i=1; i<=count; i++) {
                    row.add(resultSet.getString(i));
                }
                rowsList.add(row);
            }
            table.setColumnLabels(columnLabelList);
            table.setRows(rowsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


