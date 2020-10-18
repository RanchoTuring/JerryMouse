import core.Entity.ForTask;
import core.Impl.Catcher;
import core.Impl.Parser;
import org.jsoup.nodes.Element;

public class GetData {


    public static void main(String[] args) {
        Catcher catcher = new Catcher();
        Parser parser = new Parser();


        //抓取新闻网首页
        String home = catcher.get("https://news8.cumtb.edu.cn/zhyw.htm").catchContent();
        parser.doc(home)
                .getNodes("li[id^=line_u8_]")
                .forEach(new ForTask() {
                    @Override
                    public void forOneDo(Element node) {
                        String newsPage=node.select("a").first().attr("href");



                    if(newsPage.matches("info/.*")) {


                        String newsHtml = catcher.get("https://news8.cumtb.edu.cn/" + newsPage).catchContent();

                        System.out.print(parser.doc(newsHtml)
                                .getNode("form[name=_newscontent_fromname] > div >.main_main_hd > h3")
                                .getText() + "   ");

                        System.out.println(parser.doc(newsHtml)
                                .getNode("form[name=_newscontent_fromname] > div > .main_main_hd > p").getText());
                    }
                    }
                });




    }

    public static void pmain(String[] args) {
        Catcher catcher = new Catcher();
        Parser parser = new Parser();

        //首页
        String html = catcher.get("https://zj.zjol.com.cn/ds").catchContent();
        //解析首页，获取每一项
        parser.doc(html).getItsChildren("ul#news_list_cons")//forEachPrint("%s %s\n","a > p","a!href");
                //对每一项进行操作
                .forEach(new ForTask() {
                    @Override
                    public void forOneDo(Element node) {
                        String news = node.select("a").first().attr("href");
                        System.out.println("一条新闻" + news);

                        //拿新闻页面

                        //解析页面，提取数据


                    }
                });
        //解析翻页按钮


    }
}
