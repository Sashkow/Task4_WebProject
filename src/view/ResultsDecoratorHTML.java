/*
 * Copyright (c) Ian F. Darwin, http://www.darwinsys.com/, 1996-2002.
 * All rights reserved. Software written by Ian F. Darwin and others.
 * $Id: LICENSE,v 1.8 2004/02/09 03:33:38 ian Exp $
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * Java, the Duke mascot, and all variants of Sun's Java "steaming coffee
 * cup" logo are trademarks of Sun Microsystems. Sun's, and James Gosling's,
 * pioneering role in inventing and promulgating (and standardizing) the Java 
 * language and environment is gratefully acknowledged.
 * 
 * The pioneering role of Dennis Ritchie and Bjarne Stroustrup, of AT&T, for
 * inventing predecessor languages C and C++ is also gratefully acknowledged.
 */
package view;

import model.Table;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/** Print ResultSet in HTML
 */
public class ResultsDecoratorHTML extends ResultsDecorator {

    public ResultsDecoratorHTML() {
        super();
    }

    public String write(Table table) throws SQLException {


        int count = table.getColumnLabels().size();
        println("<table border=1>");
        print("<tr>");
        for (String label:table.getColumnLabels()) {
            print("<th>");
            print(label);

        }
        println("</tr>");
        for (List<String> row:table.getRows()){
            print("<tr>");
            for (String elem:row) {
                print("<td>");
                print(elem);
            }
            println("</tr>");
        }
        println("</table>");

        return this.getHtmlString();
    }

    /* (non-Javadoc)
     * @see ResultSetDecorator#write(int)
     */
    void write(int updateCount) {
        println("<p>RowCount: updateCount = <b>" +
                updateCount + "</p>");
    }

    /** Return a printable name for this decorator
     * @see ResultsDecorator#getName()
     */
    String getName() {
        return "HTML";
    }
}
/**
 * Base class for a series of ResultSet printers.
 *
 * @version $Id: ResultsDecorator.java,v 1.2 2004/03/26 02:39:33 ian Exp $
 */

abstract class ResultsDecorator {

    StringBuilder  htmlString;

    ResultsDecorator() {
        htmlString=new StringBuilder();

    }

    /** Print the name of this Decorator's output format */
    abstract String getName();

    /** Print the contents of a ResultSet */
    abstract String write(Table table) throws SQLException;

    /** Print the results of an operation as a Count */
    abstract void write(int rowCount);

    void println(String line){
        htmlString.append(line);
        htmlString.append('\n');

        //parent.println(line);
    }

    void println() {
        htmlString.append('\n');
        //parent.println();
    }

    void print(String lineSeg) {
        htmlString.append(lineSeg);
        //parent.print(lineSeg);
    }

    public String getHtmlString() {
        return htmlString.toString();
    }


}

/**
 * Callback so that ResultsDecorator can call invoker to handle redirections
 * etc.
 *
 * @version $Id: ResultsDecoratorPrinter.java,v 1.1 2004/03/26 02:39:33 ian Exp $
 */

interface ResultsDecoratorPrinter {

    void print(String line);

    void println(String line);

    void println();


}


           
         
