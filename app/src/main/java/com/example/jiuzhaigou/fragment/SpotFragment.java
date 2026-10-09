package com.example.jiuzhaigou.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.adapter.SpotAdapter;
import com.example.jiuzhaigou.entity.Comment;
import com.example.jiuzhaigou.entity.Spot;
import com.example.jiuzhaigou.entity.SubSpot;
import java.util.ArrayList;
import java.util.List;

public class SpotFragment extends Fragment {
    private RecyclerView rvSpots;

    @Nullable
    // 在 SpotFragment 里初始化数据时，直接给每个 SubSpot 加上 5 条评论
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spot, container, false);
        rvSpots = view.findViewById(R.id.rv_spots);

        // ========== 留言数据 ==========
        // 树正寨留言
        List<Comment> commentsShuzhengzhai = new ArrayList<>();
        commentsShuzhengzhai.add(new Comment("游客A", "藏寨氛围超棒，拍出来的照片很有感觉！", "2026-04-10"));
        commentsShuzhengzhai.add(new Comment("游客B", "寨子很安静，当地人也很热情，值得一逛。", "2026-04-15"));
        commentsShuzhengzhai.add(new Comment("游客C", "晚上的灯光超美，星空也很清晰。", "2026-04-20"));
        commentsShuzhengzhai.add(new Comment("游客D", "藏餐味道不错，价格也很实惠。", "2026-04-22"));
        commentsShuzhengzhai.add(new Comment("游客E", "适合慢慢逛，感受当地文化。", "2026-04-25"));

        // 树正群海留言
        List<Comment> commentsShuzhengqunhai = new ArrayList<>();
        commentsShuzhengqunhai.add(new Comment("游客F", "水色真的绝了，一层一层的超治愈！", "2026-05-01"));
        commentsShuzhengqunhai.add(new Comment("游客G", "倒影超美，晴天去拍效果最好。", "2026-05-02"));
        commentsShuzhengqunhai.add(new Comment("游客H", "沿着栈道慢慢走，风景一步一换。", "2026-05-03"));
        commentsShuzhengqunhai.add(new Comment("游客I", "夏天来水很足，冬天来有不一样的静谧感。", "2026-05-04"));
        commentsShuzhengqunhai.add(new Comment("游客J", "九寨沟的精华景点之一，一定要来！", "2026-05-05"));

        // 诺日朗瀑布留言
        List<Comment> commentsNuoriliang = new ArrayList<>();
        commentsNuoriliang.add(new Comment("游客K", "宽宽的瀑布超壮观，水声轰鸣很震撼。", "2026-05-06"));
        commentsNuoriliang.add(new Comment("游客L", "瀑布前的栈道可以近距离感受水雾。", "2026-05-07"));
        commentsNuoriliang.add(new Comment("游客M", "上午光线好，拍出来的照片自带滤镜。", "2026-05-08"));
        commentsNuoriliang.add(new Comment("游客N", "瀑布后面的水帘洞也很有意思。", "2026-05-09"));
        commentsNuoriliang.add(new Comment("游客O", "不愧是标志性景点，人多但值得。", "2026-05-10"));

        // 镜海留言
        List<Comment> commentsJinghai = new ArrayList<>();
        commentsJinghai.add(new Comment("游客P", "风平浪静的时候，水面像镜子一样！", "2026-05-11"));
        commentsJinghai.add(new Comment("游客Q", "倒映着雪山和树林，分不清哪里是天哪里是水。", "2026-05-12"));
        commentsJinghai.add(new Comment("游客R", "早上来几乎没人，独享这份宁静。", "2026-05-13"));
        commentsJinghai.add(new Comment("游客S", "秋天的时候，周围的树叶变黄，倒影超美。", "2026-05-14"));
        commentsJinghai.add(new Comment("游客T", "一定要无风的天气来，不然看不到效果。", "2026-05-15"));

        // 长海留言
        List<Comment> commentsChanghai = new ArrayList<>();
        commentsChanghai.add(new Comment("游客U", "九寨沟最大的海子，视野超开阔！", "2026-05-16"));
        commentsChanghai.add(new Comment("游客V", "远处的雪山和海子搭配起来超绝。", "2026-05-17"));
        commentsChanghai.add(new Comment("游客W", "海拔高一点，温度会低一点，记得多穿点。", "2026-05-18"));
        commentsChanghai.add(new Comment("游客X", "栈道上有很多观景点，每个角度都不一样。", "2026-05-19"));
        commentsChanghai.add(new Comment("游客Y", "人少景美，很适合拍全景照。", "2026-05-20"));

        // 五彩池留言
        List<Comment> commentsWuhua = new ArrayList<>();
        commentsWuhua.add(new Comment("游客Z", "真的是五彩的！水色随着光线变化超神奇。", "2026-05-21"));
        commentsWuhua.add(new Comment("游客AA", "小小的池子，颜色却有好几种，超漂亮。", "2026-05-22"));
        commentsWuhua.add(new Comment("游客BB", "一定要晴天来，阳光照下来才好看。", "2026-05-23"));
        commentsWuhua.add(new Comment("游客CC", "景区的保护做得很好，一定要爱护环境。", "2026-05-24"));
        commentsWuhua.add(new Comment("游客DD", "虽然不大，但却是九寨沟的灵魂景点。", "2026-05-25"));

        // 扎依扎嘎神山留言
        List<Comment> commentsShengshan = new ArrayList<>();
        commentsShengshan.add(new Comment("游客EE", "藏民心中的神山，氛围很神圣。", "2026-05-26"));
        commentsShengshan.add(new Comment("游客FF", "山壁的纹理很特别，拍照很有感觉。", "2026-05-27"));
        commentsShengshan.add(new Comment("游客GG", "可以在山下祈福，感受当地文化。", "2026-05-28"));
        commentsShengshan.add(new Comment("游客HH", "周围的树林也很茂密，空气很清新。", "2026-05-29"));
        commentsShengshan.add(new Comment("游客II", "人不多，很安静，适合放空。", "2026-05-30"));

        // 扎如寺留言
        List<Comment> commentsZharusi = new ArrayList<>();
        commentsZharusi.add(new Comment("游客JJ", "藏式寺庙建筑超有特色，很出片。", "2026-06-01"));
        commentsZharusi.add(new Comment("游客KK", "里面很安静，香火也很旺。", "2026-06-02"));
        commentsZharusi.add(new Comment("游客LL", "可以请个讲解，了解寺庙的历史。", "2026-06-03"));
        commentsZharusi.add(new Comment("游客MM", "门口的转经筒一定要转一圈，感受一下。", "2026-06-04"));
        commentsZharusi.add(new Comment("游客NN", "周边的环境也很清幽，适合散步。", "2026-06-05"));

        // ========== 子景点数据 ==========
        List<SubSpot> treeSubs = new ArrayList<>();
        treeSubs.add(new SubSpot("树正寨", "树正寨是坐落在树正沟内的藏羌村落，村寨后有一座海拔4200米的达戈男神山，面对树正群海。寨内建有九宝莲花菩提塔，它们代表九个藏族村寨团结、祥和、幸福。这里曾建设民族文化村，可以观赏九寨沟藏式的建筑风格、彩绘及藏民的服饰，体验藏民的日常生活，感受藏民的衣、食、住、行。\n" +
                "\n" +
                " \n" +
                "\n" +
                "       树正寨里张灯结彩着，藏家传统的装饰墙里一格一格镶嵌着华丽的工艺品和生活器具，桌上摆满了美酒菜肴。着藏族服饰的年轻小伙和美丽女子，勇敢、直率、大方，热情的介绍他们的民族和生活习性，青稞酒飘香、酥油茶着色，这就是可以触手可及的幸福。\n" +
                "\n" +
                "\n" +
                "\n" +
                "       树正寨里还有一个民俗文化村，在那里大家可以观赏九寨沟藏式的建筑风格、门窗上的彩绘及藏民的服饰，体验藏民的日常生活，感受藏民的衣、食、住、行。在九宝莲花菩提塔的下方是马致远笔下的“枯藤老树昏鸦，小桥流水人家”。古老的水磨房、栈道，依然向你倾诉着藏民昨日的历史。沿着那条栈道漫步，在栈道的两旁可以见到很多高山柳都长出了长长的红色须根，那是这些高山柳在这特殊的水环境中为了生存，长出的帮助吸收养分、氧气的触须。走到对岸是蟠龙坪，奇怪的是那里-每一株树的树根都紧紧的抱着一块巨石，石块上却无一粒泥土，有如专门洗过一样，干干净净。可抱着这些石头生长的树木却拔地而起，冲天而上，异常的高大。", R.drawable.shuzhengzhai, commentsShuzhengzhai));
        treeSubs.add(new SubSpot("树正群海", "树正群海海拔2187-2280 米。其地形是在河谷迭加泥石流堆积物基础上，再经钙华沉积，形成大小19 个湖泊，顺着沟谷层层迭迭。这里森林、湖泊、小瀑布相错相连，呈现“树在水中生，水在林间流，人在画中游”的奇特景观。\n" +
                "\n" +
                " \n" +
                "\n" +
                "       树正群海沟全长13.8公里，共有各种湖泊（海子）40余个，约占九寨沟景区全部湖泊的40%。上部海子的水翻越湖堤，从树丛中溢出，激起白色的水花，在青翠中跳跳蹦蹦，穿梭奔窜。水流顺堤跌宕，形成幅幅水帘，婀娜多姿，婉约变幻。整个群海，层次分明，那绿中套蓝的色彩，童话般的天真自然。\n" +
                "\n" +
                "\n" +
                "\n" +
                "       40多个湖泊，犹如40多面晶莹的宝镜，顺沟叠延五、六公里。水光潋滟，碧波荡漾，鸟雀鸣唱，芦苇摇曵。盆景海、芦苇海、火花海、卧龙海、树正瀑布、老虎海。一路惊奇，一路美景，一路碧水，一路瑶池。", R.drawable.shuzhengqunhai, commentsShuzhengqunhai));

        List<SubSpot> rizeSubs = new ArrayList<>();
        rizeSubs.add(new SubSpot("诺日朗瀑布", "诺日朗海拔2343 米，高24.5 米、宽320 米，是中国最宽的高山钙华瀑布。滔滔流水自诺日朗群海而来，从瀑顶树丛中倾泻而下，像数条洁白的哈达，水势浩大，声震山谷。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　诺日朗瀑布是迄今为止在我国发现的最宽的钙华瀑布。“诺日朗”藏语中意指男神，也有伟岸高大的意思。滔滔水流自诺日朗群海而来，从瀑顶树丛中越堤而下，如银河飞泻，水势浩大，声震山谷。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　在公路旁的山崖上，建有一座观景台，站在台上，瀑布全景尽收眼底，不管是畅快淋漓的“银河”飞溅，还是凝冰而成的冰晶世界，都足以震撼每一位前往九寨游客的心灵。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　清晨，阳光照耀，瀑面上常可看见一道道彩虹横挂山谷，为瀑布更添一份迷人丰姿。寒冬时节，瀑布就成了一幅巨大的冰幔，无数的冰柱悬挂在陡崖之上，成为一个罕见的冰晶世界，造型各异的冰雕迎光透着幽幽的蓝色魅惑，这也是九寨沟六绝之一：蓝冰。\n" +
                "\n", R.drawable.nuorilang, commentsNuoriliang));
        rizeSubs.add(new SubSpot("镜海", "水面如镜，倒映雪山", R.drawable.jinghai, commentsJinghai));

        List<SubSpot> zechaSubs = new ArrayList<>();
        zechaSubs.add(new SubSpot("长海", "长海，海拔3101 米，总长约4350 米，宽300 米，深90 米，库容4500万立方米。平面呈「S」型，属冰川堰塞湖、淡水湖，是九寨沟海拔最高、湖水最深，面积和库容最大的海子。长海旁边的山峰终年积雪，四周森林珠翠，站在长海观台上看去，蓝天白云，皑皑峰雪尽收眼底，感觉山和天互相连接在一起，没有距离，这也是长海的一大景观。诗赋：映日雪山苍云横，接天古树碧波开。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　长海是九寨沟海拔最高、湖面最宽的海子，海子水面呈墨蓝色，水源来自于高山融雪，令人奇怪的是，长海四周都没有出水口，但夏秋雨季水不溢堤，冬春久旱也不干涸，因此九寨沟当地人称之为装不满，漏不干的宝葫芦。湖深处达百余米，呈S行展布，海子四周森林碧翠，山峰终年积雪。隆冬时节，长海冰层厚达60厘米，是冰上运动的理想场所。", R.drawable.changhai, commentsChanghai));
        zechaSubs.add(new SubSpot("五彩池", "从长海下行1公里即为五彩池，五彩池海拔3010 米地区，长约100 米，宽60 米，深6.6 米，深藏于公路下边的深谷中。五彩池虽在九寨沟众海中最小巧玲珑，然而它的色彩却是最为斑斓，与五花海不相上下。五彩池异常清澈，透过池水，可见到池底岩面的石纹，由于池底沉淀物的色差以及池畔植物色彩的不同，原本湛蓝色的湖面变得五彩斑斓。是九寨沟湖泊中的精粹，也是最精致的海子，被人称为九寨之眼。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　五彩池向来以秀美多彩，纯洁透明闻名于天下，寒冬地冻三尺之时，池水却依然清波荡漾，四季雨旱交替，而池水似无增减。这是因为池水是由位于高处的长海经地下补给，地下四季常温不冻，补给水量全年大体稳定之故。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　五彩池池底砾石棱角，岩面纹理，一一分明，池水蔚蓝宝绿，明澈透亮。湖里生长着水绵、轮藻、小蕨等水生植物群落，同时还生长芦苇、节节草、水灯芯等草本植物。这些水生群落所含叶绿素深浅不同，在富含碳酸钙质的湖水里，能呈现不同的颜色。同一湖泊里，有的水域蔚蓝，有的湾汊浅绿，有的水色绛黄，有的流泉粉蓝……变化无穷，煞是好看!\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　在日头当顶，山风吹拂或以石击水时，还能溅开一圈圈金红、金黄和雪青的涟漪，分外妖艳。", R.drawable.wuhua, commentsWuhua));

        List<SubSpot> zaruSubs = new ArrayList<>();
        zaruSubs.add(new SubSpot("扎依扎嘎神山", " 来过九寨沟的99.99%以上的游客，都不曾见过九寨沟深处，当地村民心中最为神圣的“扎依扎嘎圣山”。沟内扎依扎嘎神山为最高峰——山峰海拔4400米，山顶海拔4528米，据说这座神山是万山之主，是当地居民的圣地。\n" +
                "\n" +
                "\n" +
                "\n" +
                "       这座特别的神山，坐落于在九寨沟东侧扎如沟的深处，矗立在扎如马道的尽头，属于九寨沟自然保护区的核心区范围，只有生态户外旅行的探访者、当地虔诚的村民、以及巡山队或科考队，才有机会看到这片九寨沟中，最为纯洁的净土。九寨沟山区里的独特地质构造和气候系统，让这座圣山平时终日隐藏在云雾之中，非常难以得见全貌，如果一次转山就可能看到圣山的全貌，那是相当的幸运和福气。", R.drawable.shengshan, commentsShengshan));
        zaruSubs.add(new SubSpot("扎如寺", "   海拔2026 米，藏语称为“然悟贡巴”，始建于明朝末年，历经2 次的翻修，是九寨沟景区内唯一的宗教寺庙，也是苯教信仰者的圣地。苍山环绕，面临宝镜崖，金顶红檐，五色经幡祈祷于风中，展现出浓厚苯教文化氛围。这里每年会举行四次大型宗教活动，其中以农历四月十五日举办的「嘛智节」最为盛大。\n" +
                "\n" +
                "\n" +
                "\n" +
                "       扎如寺背依一脉苍山，面临宝镜崖，金顶红檐，五色经幡切切祈祷于风中。既有肃穆的禅味，又有原始苯波教的遗风。寺院总占地面积为100余亩，建筑面积为20000多平方米，其中，寺院标志性建筑有“雍仲拉泽佛塔”。共5层，第一层为博物馆，第二层为显宗殿，第三层为密宗殿，第四层为心宗殿，第五层供有佛祖舍利宝塔和大藏经\"甘珠尓\"108套。\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "       这里具有浓烈的宗教文化气息，是以藏族原始宗教苯教为基础，藏传佛教为辅的宗教寺庙，是九寨沟内唯一的宗教活动场所，每年都会举办庙会。其中最大的一次是每年的“麻智会”。麻智会是扎如寺最重要的宗教盛典，也是九寨沟最隆重的节日。比起“麻智会”，一年中最热闹的庙会则是正月十五日，九寨沟各寨的男女老少、穿上节日盛装，带上酒和食物，步行围绕“万山之祖”扎依扎嘎山逆时针方向转圈，半山和山脚有神水瀑布，可洗手、洗脸或洗澡，有的请和尚在头上洒水，可洗掉污浊，带来吉祥。\n" +
                "\n", R.drawable.zharusi, commentsZharusi));

        // ========== 大景点数据 ==========
        List<Spot> spotList = new ArrayList<>();
        spotList.add(new Spot("树正沟", "\"Y\"字形主干，必经之路，景点集中", R.drawable.shuzheng, treeSubs));
        spotList.add(new Spot("日则沟", "\"Y\"字形右上，精华密集区域", R.drawable.nuorilang, rizeSubs));
        spotList.add(new Spot("则查洼沟", "\"Y\"字形左上，海拔最高", R.drawable.changhai, zechaSubs));
        spotList.add(new Spot("扎如沟", "东北部，适合徒步与宗教体验", R.drawable.zharusi, zaruSubs));

        // 设置适配器
        rvSpots.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSpots.setAdapter(new SpotAdapter(getActivity(), spotList));

        return view;
    }
}