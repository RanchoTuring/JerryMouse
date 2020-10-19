import core.Impl.Catcher;
import core.Impl.Parser;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Catcher catcher = new Catcher();
        Parser parser = new Parser();


//        List<String> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        System.out.println(list1.getClass() == list2.getClass());

        //  System.out.println(catcher.get("www.baidu.com"));  会报错
//        System.out.println(catcher.get("http://www.baidu.com"));

        //  System.out.println(catcher.post("http://127.0.0.1").catchContent());
        //System.out.println(catcher.get("http://127.0.0.1").addData("name=zhangsan").addData("age=18").catchContent());

//        String content=catcher.post("127.0.0.1")
//                .addHeader("rancho","test1")
//                .addHeader("rancho","test2")
//                .addData("I am a data")
//                .catchContent();
//
//        System.out.println(content);

        //    System.out.println(catcher.get("http://www.baidu.com").catchContent());


//                FileReader in=new FileReader("brank.html");
//        StringBuilder buf=new StringBuilder();
//        char[] chars=new char[1000];
//        int len=0;
//        while((len=in.read(chars))!=-1){
//            buf.append(chars);
//        }
//        String html=buf.toString();

//      parser.doc(html).forEach((x)->{
//            System.out.println(x);
//        });

//    System.out.println(Jsoup.parse(html));
//        System.out.println(Jsoup.parse(html).children());

//parser.doc(catcher.get("https://www.bilibili.com/ranking").addHeader("cookie","fts=1530024643; buvid3=E6C95B19-F5E8-4B0D-BC57-E9D49BD0785920709infoc; LIVE_BUVID=ff6c22b3ab1382183c1c1ad343dde773; LIVE_BUVID__ckMd5=111e50c585879c9b; im_notify_type_15220341=0; stardustvideo=1; CURRENT_FNVAL=16; OUTFOX_SEARCH_USER_ID_NCOO=281316136.6317302; rpdid=|(k|mJ|Ru~)u0J'ullY|u)m~m; sid=iu6czo4w; _uuid=08AD8FA9-9A9C-5A15-CC07-A3B2A6F6E31898051infoc; PHPSESSID=nqnj24j5sqq95ac87dfvrte4g5; route=; stardustpgcv=0606; INTVER=1; deviceFingerprint=70f1ba86656e0a342173deb351d699e3; CURRENT_QUALITY=80; Hm_lvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; Hm_lpvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; kfcFrom=sixin; from=sixin; msource=unc_626xk_message; kfcSource=unc_626xk_message; finger=1295565314; blackside_state=1; bp_t_offset_15220341=429633236547826429; bp_article_offset_15220341=428876583571787975; PVID=1; bp_video_offset_15220341=430424983705988519; bsource=search_baidu").catchContent()).getNode("ul.rank-list").getChildren().forEachPrint("%-3s：%s\n                    作者：%-10s播放量：%-15s评分：%s\n\n","div.num","a.title","div.detail > a >span","div.detail > span","div.pts >div");
        parser.doc(
                catcher.get("https://www.bilibili.com/v/popular/rank/all")
                        .addHeader("cookie", "fts=1530024643; buvid3=E6C95B19-F5E8-4B0D-BC57-E9D49BD0785920709infoc; LIVE_BUVID=ff6c22b3ab1382183c1c1ad343dde773; LIVE_BUVID__ckMd5=111e50c585879c9b; im_notify_type_15220341=0; stardustvideo=1; CURRENT_FNVAL=16; OUTFOX_SEARCH_USER_ID_NCOO=281316136.6317302; rpdid=|(k|mJ|Ru~)u0J'ullY|u)m~m; sid=iu6czo4w; _uuid=08AD8FA9-9A9C-5A15-CC07-A3B2A6F6E31898051infoc; PHPSESSID=nqnj24j5sqq95ac87dfvrte4g5; route=; stardustpgcv=0606; INTVER=1; deviceFingerprint=70f1ba86656e0a342173deb351d699e3; CURRENT_QUALITY=80; Hm_lvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; Hm_lpvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; kfcFrom=sixin; from=sixin; msource=unc_626xk_message; kfcSource=unc_626xk_message; finger=1295565314; blackside_state=1; bp_t_offset_15220341=429633236547826429; bp_article_offset_15220341=428876583571787975; PVID=1; bp_video_offset_15220341=430424983705988519; bsource=search_baidu")
                        .catchContent())
                .getItsChildren("ul.rank-list")
                .forEachPrint("%-3s：%s\n                    作者：%-10s播放量：%-15s评分：%s\n\n",
                        "div.num", "a.title", "div.detail > a >span", "div.detail > span", "div.pts >div");


//                .forEach((node)->{
//            System.out.printf("%-3s：%s\n                    作者：%-10s播放量：%-15s评分：%s\n\n",
//                    node.select("div.num").first().text(),
//                    node.select("a.title").first().text(),
//                    node.select("div.detail > a >span").first().text(),
//                    node.select("div.detail > span").first().text(),
//                    node.select("div.pts >div").first().text()
//            );
//
//        });


//        String html=catcher.get("https://www.bilibili.com/ranking")
//                .addHeader("cookie","fts=1530024643; buvid3=E6C95B19-F5E8-4B0D-BC57-E9D49BD0785920709infoc; LIVE_BUVID=ff6c22b3ab1382183c1c1ad343dde773; LIVE_BUVID__ckMd5=111e50c585879c9b; im_notify_type_15220341=0; stardustvideo=1; CURRENT_FNVAL=16; OUTFOX_SEARCH_USER_ID_NCOO=281316136.6317302; rpdid=|(k|mJ|Ru~)u0J'ullY|u)m~m; sid=iu6czo4w; _uuid=08AD8FA9-9A9C-5A15-CC07-A3B2A6F6E31898051infoc; PHPSESSID=nqnj24j5sqq95ac87dfvrte4g5; route=; stardustpgcv=0606; INTVER=1; deviceFingerprint=70f1ba86656e0a342173deb351d699e3; CURRENT_QUALITY=80; Hm_lvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; Hm_lpvt_8a6e55dbd2870f0f5bc9194cddf32a02=1588513634; kfcFrom=sixin; from=sixin; msource=unc_626xk_message; kfcSource=unc_626xk_message; finger=1295565314; blackside_state=1; bp_t_offset_15220341=429633236547826429; bp_article_offset_15220341=428876583571787975; PVID=1; bp_video_offset_15220341=430424983705988519; bsource=search_baidu")
//                .catchContent();
//
//        Elements rankItems=Jsoup.parse(html).select("ul.rank-list").first().children();
//
//        for(Element node:rankItems){
//            System.out.printf("%-3s：%s\n                    作者：%-10s播放量：%-15s评分：%s\n\n",
//                    node.select("div.num").first().text(),
//                    node.select("a.title").first().text(),
//                    node.select("div.detail > a >span").first().text(),
//                    node.select("div.detail > span").first().text(),
//                    node.select("div.pts >div").first().text()
//            );
//        }


    }


}
