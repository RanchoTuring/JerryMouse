package core;

import core.Entity.ForTask;

import javax.swing.text.Document;

public interface ParserIface {
    ParserIface doc(String html);

    ParserIface forEach(ForTask forTask);

    ParserIface forEachPrint(String patten,String... css);

    ParserIface getNodes(String css);

    ParserIface getNode(String css);

    ParserIface getItsChildren(String css);

    ParserIface getChildren();

    String getText();

    String parse();



}
