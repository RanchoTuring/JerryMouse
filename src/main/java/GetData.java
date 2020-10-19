import core.Entity.ForTask;
import core.Impl.Catcher;
import core.Impl.Parser;
import org.jsoup.nodes.Element;

public class GetData {
    static Catcher catcher = new Catcher();
    static Parser parser = new Parser();
    static String prefix = "https://news8.cumtb.edu.cn/";

    public static void main(String[] args) {

        //要抓取的总页数
        int n = 1;
        //要抓取的url，先初始化为新闻网首页
        String url = "https://news8.cumtb.edu.cn/zhyw.htm";
        String pageHtml;

        for (int pageNumber = 1; pageNumber <= n; pageNumber++) {

          //  System.out.printf("开始抓取第%d页的新闻\n",pageNumber);

            pageHtml = catcher.get(url).catchContent();

            // 获取该页的新闻
            parser.doc(pageHtml)
                    .getNodes("li[id^=line_u8_]")
                    .forEach((node) -> {
                                String newsPageUrl = node.select("a").first().attr("href");
                                //只抓取来源新闻官网的网页
                                if (newsPageUrl.matches("info/.*") || newsPageUrl.matches("../info/.*")) {

                                    newsPageUrl = convertInfoUrl(newsPageUrl);
                                    //依次抓取该条新闻的标题、信息、正文
                                    String[] datas = parser.doc(catcher.get(newsPageUrl).catchContent())
                                            .getNode("form[name=_newscontent_fromname] > div ")
                                           // .getTexts(".main_main_hd > h3", ".main_main_hd > p","#vsb_content_2 > div.v_news_content");
                                            .getTexts(".main_main_hd > p");


                                    for (String item : datas) {
                                       // System.out.print(item + "   ");
                                        System.out.print("\""+item + "\",");
                                    }
                                  //  System.out.println();

                                }
                            }
                    );
         //   System.out.printf("抓取完毕，用时%d毫秒\n",);

            //获取下一页面在服务器上的相对路径
            url = parser.doc(pageHtml).getNode("a.Next").getAttr("href");

            //转换为下一页面的url
            url = convertNextUrl(url);
        }

    }

    /**
     * 将下一页面在服务器上的相对路径转换为url
     *
     * @param url
     * @return
     */
    static String convertNextUrl(String url) {
        if (url.matches("zhyw/.*")) {
            url = prefix + url;
        } else {
            url = prefix + "zhyw/" + url;
        }
        return url;
    }

    /**
     * 转换新闻页面的Url
     *
     * @param url
     * @return
     */
    static String convertInfoUrl(String url) {
        if (url.startsWith("../")) {
            url = url.substring(3);
        }

        return prefix + url;
    }


    static void process(){
        String[] str={"发布时间：2020-10-19 17:37:50 作者： 来源： 点击：","发布时间：2020-10-16 17:32:35 作者： 来源：机电与信息工程学院 点击：","发布时间：2020-10-16 11:00:26 作者：文/校工会 图/王丽晔 郑亚飞 来源：校工会 点击：","发布时间：2020-10-15 17:07:25 作者：文/解士军 图/于晓东 来源：党委巡察办 点击：","发布时间：2020-10-15 17:00:06 作者： 来源：校团委 点击：","发布时间：2020-10-15 16:30:44 作者： 来源：总务处 点击：","发布时间：2020-10-15 09:27:37 作者： 来源：学生工作处 点击：","发布时间：2020-10-14 17:16:50 作者： 来源：党委组织部 点击：","发布时间：2020-10-13 17:18:52 作者：文/王丽晔 图/于晓东 王丽晔 姜振 来源：党委宣传部 点击：","发布时间：2020-10-13 16:48:28 作者：文/继续教育学院 图/于晓东 来源：继续教育学院 点击：","发布时间：2020-10-13 10:07:29 作者：乔志勇 来源：校团委 点击：","发布时间：2020-10-12 15:52:17 作者： 来源： 点击：","发布时间：2020-10-12 14:05:17 作者： 来源：国际合作与交流处 点击：","发布时间：2020-10-08 14:44:16 作者： 来源：应急管理与安全工程学院 点击：","发布时间：2020-10-07 15:24:35 作者：文/党委武装部 图/于晓东 来源：党委武装部 点击：","发布时间：2020-10-06 10:55:45 作者：美丽开木·罗合曼 来源：学生工作处 点击：","发布时间：2020-10-02 15:14:25 作者：曾丽君 来源：体育教研部 点击：","发布时间：2020-10-02 14:54:45 作者：张玉琪 来源：党委武装部 点击：","发布时间：2020-10-02 11:01:26 作者：文/邹殿龙 图/于晓东 来源：党委巡察办 点击：","发布时间：2020-10-01 18:01:10 作者：文/人事处 图/王丽晔 来源：人事处 点击：","发布时间：2020-10-01 17:16:06 作者：文/姚利梅 图/于晓东 来源：党委宣传部 点击：","发布时间：2020-09-30 18:27:26 作者：文/科学技术研究院 图/于晓东 来源：科学技术研究院 点击：","发布时间：2020-09-30 18:15:27 作者： 来源：党政办公室 点击："};



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
