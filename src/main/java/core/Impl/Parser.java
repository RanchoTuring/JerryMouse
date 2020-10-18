package core.Impl;

import core.Entity.ForTask;
import core.ParserIface;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    public ParserIface getNodes(String selector) {
        if (inNodes) {
            currentNodes = currentNodes.select(selector);
        } else {
            currentNodes = currentNode.select(selector);
        }
        inNodes = true;
        return this;
    }

    @Override
    public ParserIface getNode(String selector) {
        if (inNodes) {
            currentNode = currentNodes.select(selector).first();
        } else {
            currentNode = currentNode.select(selector).first();
        }
        inNodes = false;
        return this;
    }

    /**
     * 根据selector获取一个元素，然后获取该元素的子元素
     *
     * @param selector
     * @return
     */
    @Override
    public ParserIface getItsChildren(String selector) {
        getNode(selector);
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
    public String getText() {
        if (inNodes) {
            throw new RuntimeException("无法获取多个节点对象的children");
        } else {
            return currentNode.text();
        }
    }

    @Override
    public String parse() {
        //TODO finish
        return doc.text();
    }

    @Override
    public ParserIface forEachPrint(String patten, String... selector) {
        String[] strings;
        int i;
        if (inNodes) {
            for (Element node : currentNodes) {
                strings = new String[selector.length];
                i = 0;
                for (String str : selector) {
                    if (str.contains("!")) {
                        String[] para=str.split("!");
                        strings[i++] = node.select(para[0]).first().attr(para[1]);
                    } else {

                        strings[i++] = node.select(str).first().text();
                    }
                }
                System.out.printf(patten, strings);
            }
        } else {
            strings = new String[selector.length];
            i = 0;
            for (String str : selector) {
                strings[i++] = currentNode.select(str).first().text();
            }
            System.out.printf(patten, strings);
        }
        return this;
    }
}
