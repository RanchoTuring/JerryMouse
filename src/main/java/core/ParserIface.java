package core;

import core.Entity.ForTask;


public interface ParserIface {
    ParserIface doc(String html);

    ParserIface forEach(ForTask forTask);

    ParserIface forEachPrint(String patten,String... css);

    ParserIface getNodes(String css);

    ParserIface getNode(String css);

    ParserIface getItsChildren(String css);

    ParserIface getChildren();

    String getAttr(String key);

    String getText();

    String[] getTexts(String... selector);

    String parse();



}
