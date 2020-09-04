package core.Impl;

import core.Entity.ForTask;
import core.ParserIface;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;


public class Parser implements ParserIface {

    private Document doc;
    private Elements currentNodes;
    private Element currentNode;
    private boolean inNodes;

    @Override
    public ParserIface doc(String html) {
        doc = Jsoup.parse(html);
        inNodes = true;
        currentNodes = doc.children();
        return this;
    }

    @Override
    public ParserIface forEach(ForTask forTask) {
        //TODO finish
        for (Element node : currentNodes) {
            forTask.forOneDo(node);
        }
        return this;
    }

    @Override
    public ParserIface getNodes(String css) {
        if (inNodes) {
            currentNodes = currentNodes.select(css);
        } else {
            currentNodes = currentNode.select(css);
        }
        inNodes = true;
        return this;
    }

    @Override
    public ParserIface getNode(String css) {
        if (inNodes) {
            currentNode = currentNodes.select(css).first();
        } else {
            currentNode = currentNode.select(css).first();
        }
        inNodes = false;
        return this;
    }

    @Override
    public ParserIface getItsChildren(String css) {
        getNode(css);
        currentNodes = currentNode.children();
        inNodes = true;
        return this;
    }

    @Override
    public ParserIface getChildren() {
        if (inNodes) {
            throw new RuntimeException("无法获取多个节点对象的children");
        } else {
            currentNodes = currentNode.children();
        }
        inNodes = true;
        return this;
    }

    @Override
    public String parse() {
        //TODO finish
        return doc.text();
    }

    @Override
    public ParserIface forEachPrint(String patten, String... css) {
        String[] strings;
        int i;
        if (inNodes) {
            for (Element node : currentNodes) {
                strings = new String[css.length];
                i = 0;
                for (String str : css) {
                    strings[i++] = node.select(str).first().text();
                }
                System.out.printf(patten, strings);
            }
        } else {
            strings = new String[css.length];
            i = 0;
            for (String str : css) {
                strings[i++] = currentNode.select(str).first().text();
            }
            System.out.printf(patten, strings);
        }
        return this;
    }
}
