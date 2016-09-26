package com.musketeer.ten.Beans;

import com.musketeer.ten.http.HttpParser;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;
import org.xutils.http.annotation.HttpResponse;

/**
 * Created by Kevin on 2016/9/21.
 */
@HttpResponse(parser = HttpParser.class)
@Table(name = "CriticBeanBody")
public class CriticBeanBody {

    @Override
    public String toString() {
        return "CriticBeanBody{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", authorbrief='" + authorbrief + '\'' +
                ", times=" + times +
                ", text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", text3='" + text3 + '\'' +
                ", text4='" + text4 + '\'' +
                ", text5='" + text5 + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", image5='" + image5 + '\'' +
                ", imageforplay='" + imageforplay + '\'' +
                ", urlforplay='" + urlforplay + '\'' +
                ", titleforplay='" + titleforplay + '\'' +
                ", realtitle='" + realtitle + '\'' +
                ", publishtime=" + publishtime +
                ", status=" + status +
                ", errMsg=" + errMsg +
                '}';
    }

    /**
     * id : 100037
     * title : 《爱，不爱》你在我身后陪我们一起看电影 我怎能不力荐
     * author : 释澈鱼
     * authorbrief : 我有烟雾弹似的洁癖
     * times : 4716
     * text1 : 今晚推荐一部韩国电影《爱，不爱》，除了导演一直擅长的题材，另外的看点是帅哥玄彬，该片是玄彬入伍服役前的最后一部电影作品。估计不少少女喜欢。
     * <p/>
     * 玄彬很温柔隐忍，林秀晶情感戏信手拈来，得不到的永远在骚动被偏爱的有恃无恐。看着时会被内疚鞭笞，想起原来自己决绝离开的ex的温柔。但也从不后悔离开。爱情就像玄彬切的洋葱，总有一片让你流泪。
     * text2 : 剧情简介
     * <p/>
     * 本片改编自日本女作家井上荒野的短篇小说《不能回来的猫》，入围2011柏林电影节主竞赛单元，两位主演都是无酬劳出演该片。
     * <p/>
     * 一对夫妻在经过五年的厮守之后，终于濒临分手的边缘。突然有一天妻子（林秀晶 饰）告诉丈夫（玄彬 饰），她有了别人。丈夫是个貌似沉默宽容的男人，他平静地接受了妻子外遇的事实，仍一如既往深情相待。一面帮妻子整理离去的行李，一面为她准备了美味的咖啡。他一边收拾着行李，一边希望也许就在这个短促而有限的空间，他们可以拾回往昔的记忆。然而，妻子却被丈夫的体贴搞得有点不耐烦，情感出现了波动。丈夫为分别前的最后一餐特别预定了餐厅，而为避雨四处躲藏的小猫又成为他试图挽留妻子的契机……外面的雨一直下个不停……最后他们真的会分手吗？
     * text3 : 先得承认，我并不是所有文艺片的热衷者，柏林苍穹下看了两回都很二地睡着了。也必须承认，若没有二爷，这部片子或许不会给我如此深刻的感受。好吧，我就是外貌协会的，我就是觉得二爷很帅，林姑娘很迷人。
     * 但是在片子放完后，听着大家说无聊的时候，还是深深觉得，应该会有像我一样，沉浸于这残忍的一天的剧情，无法自拔的娃。哦？
     * <p/>
     * 影片开始在车上的背景铺叙确实是需要耐心的。林姑娘的那句：我要走了。来得唐突且残酷。于是这对小夫妻婚姻的裂痕就在这段车内的对话中渐渐展现出来，二爷明白男小三的存在，二爷明白身边的女人已经不属于自己。即使她还清楚地了解着自己的口味，喜好，但这已经不是能留下她的理由。
     * <p/>
     * 大雨。林姑娘的弃婚出走变得不那么顺利，本来打包离开，直接再见，恶劣的天气却让他们在结婚五年来最尴尬的氛围面临漫长的一天。这是一次很特殊的道别——二爷在新闻发布会上说。
     * <p/>
     * 于是让大家愈发觉得无聊的情节在这幢屋子里展开了……
     * <p/>
     * 故事好慢。屋顶有些漏水，他拿了一个盆在下头接水，煮咖啡，安静的等待时间的流逝。她在楼上收拾行李，很多回忆不知该怎么带走，不知该不该带走。盆里的水越积越多——过了很久——两人仍然没有实质性的对话。她下楼喝他煮的咖啡，谈话中当他说：“一切都会好的”时候，她终于按捺不住，她责怪他这么些年总是这么不温不火，即使到此时此刻，面对背叛自己的妻子，他还是如此沉默接受，她的自责，她的不满，她对于那么些年来共同生活，彼此间付出的感情的不舍，以及对现在自己找到的爱情的向往，她喝着黑咖啡，醇香的苦味。二爷帅气地把头发往后一捋，柔软的头发接着慢慢滑至额头，脸颊。“如果我不这么说，又能改变什么吗？”
     * text4 : ——古往今来，令人心疼的男子不过就是如此吧……
     * <p/>
     * 林姑娘在记者会上也说，在演戏时也想，如果能大喊大叫大哭大闹发泄出来该多好，但是这正是对演员的考验，当所有情绪都只能如此压抑，只能通过表情以及极少的台词来表达的时候。
     * <p/>
     * 看到地下室他曾为她制作的工艺品，她仍然十分的喜欢，她惋惜他不能从事自己喜欢的手工行业，虽然现在的工作令他有更高的收入。
     * ——喜欢动手的孩子，是不是常常都不善言辞呢？
     * <p/>
     * 猫咪的出现为剧情添加了俏皮的元素。（抱猫咪的动作性感无比！）只是猫咪淘气地把他手抓破了。当她小心翼翼为他擦拭被猫咪抓破的伤口，似乎能清晰感觉到这对曾经的爱人之间尚存的相怜之心。只是我分明可以感受到他那时克制住感情，告诉自己这只是习惯性的关心时，无法排遣并必须止于胸口的疼痛。对于帅哥的母性从来都是大爆发级别的……
     * <p/>
     * 猫咪不见踪影，躲在房子的某处。邻居夫妻是猫咪的主人，一起来找猫咪，处于准离婚状态的他们在甜蜜的邻居夫妻面前，该怎样掩饰尴尬，而这些掩饰，又是怎样地加重了伤痛。更悲催的是，他接到了男小三的电话，与晚秋里帅到令人发指的“you smile, you die”完全不同，他继续沉默地把电话递给她。他勉强地用平静的表情与邻居聊天，他有没有听清楚她在他身后与小三通话的内容呢？他可不可以没有听到呢？ Oh 可怜的孩子……
     * <p/>
     * 没有等到猫咪出现，邻居夫妇暂时回去了。
     * <p/>
     * 他们开始做晚餐，Pasta，他炒蔬菜，煮面，她来完成接下来的任务，让他帮忙切洋葱。
     * <p/>
     * ——最最让人揪心的切洋葱情节！——
     * <p/>
     * 他从冰箱里拿出罐子，打开，取出洋葱，开始仔细切起来（不是大家想象的那种切，是一刀一刀的切——秘密花园路过）。一会儿，他开始掉眼泪——果然切洋葱是技术活儿——长发遮住了他的眼睛（坐在第二排的我看不清他的表情），他试着把剩下的切完，但似乎没法继续，她让他先去洗洗脸。他把不需要的洋葱重新装进罐子里（好贴心）。站到镜子前，他用水洗脸，就像喝酒后微醉时，试图让自己清醒地那样洗脸。呼吸，再一次用手盛水，把脸埋在双手里。可是，为什么眼泪还是止不住地从眼眶里渗出来，明明已经小心地控制了一天的情愫，为什么此时此刻不能安静地继续躲在心里的角落。长发依然遮住了他的脸颊，他的表情仍然淡漠，但是作为旁观者的我已经心疼地难以自已。
     * <p/>
     * （真想飞奔到后面去抱住他……）
     * text5 : 猫咪闻到放在外面的鱼罐头，不知从哪儿跑了出来。她看着猫咪乖巧，安心地吃着鱼，像他一样缓缓地说道：一切都会好起来的……
     * <p/>
     * （电影结束了，男女猪脚耀眼登场……尖叫……）
     * <p/>
     * 背景音乐的问题在新闻发布会上也有提到，导演说，雨声是这部电影的音乐。其实细想来，如果音乐可以带动观众获得导演所安排的情绪，那么没有音乐或许也是一种技巧，令人赤果果地面临这惨白的一天，这令所有人都无所适从，所有就事论事的讨论都变得没有意义，所有情绪都无处安放的，难熬的，漫长的雨天。雨不停，他们继续困于这最后一天相处的时光，雨停，她将离开。怎样都是残忍。
     * <p/>
     * 众多观众都无心看下去此番无止尽的恼人的告别——他们又何尝想处在这样一种情况下？但是主人公不能弃场景而去，他们演绎着这些点点滴滴，他们无处逃避地面对着彼此，面对着自己。
     * <p/>
     * 絮絮叨叨那么久，抒发一下对这部被记者归为cult film的电影的感受。
     * <p/>
     * 二爷和林姑娘都演的很好，红毯也走得很好，我好喜欢呢:-)
     * <p/>
     * (完)
     * image1 : images/A5064BE7010D7145BF5ED2C446A4D6DF.jpg
     * image2 : images/CC9003D64DFE342EB81312CDB78CA117.jpg
     * image3 : images/67AA10C09534A2BA14A655AF33DC9F26.jpg
     * image4 : images/DED7955EE92FE64E87BCE7E82904A98F.jpg
     * image5 :
     * imageforplay : images/E7EE1274891CAA6F0FB60CDC74495117.jpg
     * urlforplay : http://v.qq.com/x/cover/khiyvzmzaw9tsrr.html
     * titleforplay : 《爱，不爱》完整版
     * realtitle : 你在我身后陪我们一起看电影 我怎能不力荐
     * publishtime : 636100128000000000
     * status : 0
     * errMsg : null
     */

    @Column(name = "id", isId = true, autoGen = false)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "authorbrief")
    private String authorbrief;
    @Column(name = "times")
    private int times;
    @Column(name = "text1")
    private String text1;
    @Column(name = "text2")
    private String text2;
    @Column(name = "text3")
    private String text3;
    @Column(name = "text4")
    private String text4;
    @Column(name = "text5")
    private String text5;
    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "image3")
    private String image3;
    @Column(name = "image4")
    private String image4;
    @Column(name = "image5")
    private String image5;
    @Column(name = "imageforplay")
    private String imageforplay;
    @Column(name = "urlforplay")
    private String urlforplay;
    @Column(name = "titleforplay")
    private String titleforplay;
    @Column(name = "realtitle")
    private String realtitle;
    @Column(name = "publishtime")
    private long publishtime;
    private int status;
    private Object errMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorbrief() {
        return authorbrief;
    }

    public void setAuthorbrief(String authorbrief) {
        this.authorbrief = authorbrief;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImageforplay() {
        return imageforplay;
    }

    public void setImageforplay(String imageforplay) {
        this.imageforplay = imageforplay;
    }

    public String getUrlforplay() {
        return urlforplay;
    }

    public void setUrlforplay(String urlforplay) {
        this.urlforplay = urlforplay;
    }

    public String getTitleforplay() {
        return titleforplay;
    }

    public void setTitleforplay(String titleforplay) {
        this.titleforplay = titleforplay;
    }

    public String getRealtitle() {
        return realtitle;
    }

    public void setRealtitle(String realtitle) {
        this.realtitle = realtitle;
    }

    public long getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(long publishtime) {
        this.publishtime = publishtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(Object errMsg) {
        this.errMsg = errMsg;
    }
}
