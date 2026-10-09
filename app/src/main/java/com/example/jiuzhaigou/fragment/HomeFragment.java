package com.example.jiuzhaigou.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.example.jiuzhaigou.R;
import com.example.jiuzhaigou.activity.NoticeListActivity;
import com.example.jiuzhaigou.adapter.NoticeAdapter;
import com.example.jiuzhaigou.entity.Notice;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ViewPager2 viewPagerBanner;
    private RecyclerView rvNotice;
    private View btnAbout, btnTip, btnGuide, btnRoute, btnHotel;

    private int[] bannerImages = {R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private int currentPage = 0;

    // 公告数据
    private List<Notice> allNoticeList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPagerBanner = view.findViewById(R.id.viewPager_banner);
        rvNotice = view.findViewById(R.id.rv_notice);
        btnAbout = view.findViewById(R.id.btn_about);
        btnTip = view.findViewById(R.id.btn_tip);
        btnGuide = view.findViewById(R.id.btn_guide);
        btnRoute = view.findViewById(R.id.btn_route);
        btnHotel = view.findViewById(R.id.btn_hotel);

        // 初始化轮播图
        initBanner();
        startAutoScroll();

        // 初始化公告数据
        initData();

        // 按钮点击跳转
        initClick();

        // ================== 【更多】按钮点击（正确位置）==================
        TextView tvMoreNotice = view.findViewById(R.id.tv_more_notice);
        tvMoreNotice.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NoticeListActivity.class);
            NoticeListActivity.noticeAllList = allNoticeList;
            startActivity(intent);
        });

        return view;
    }

    // 五个按钮跳转
    // 五个按钮跳转（已修好）
    private void initClick() {
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.jiuzhaigou.activity.AboutActivity.class);
            startActivity(intent);
        });
        btnTip.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.jiuzhaigou.activity.TipActivity.class);
            startActivity(intent);
        });
        btnGuide.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.jiuzhaigou.activity.GuideActivity.class);
            startActivity(intent);
        });
        btnRoute.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.jiuzhaigou.activity.RouteActivity.class);
            startActivity(intent);
        });
        btnHotel.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), com.example.jiuzhaigou.activity.HotelActivity.class);
            startActivity(intent);
        });
    }

    // 轮播图
    private void initBanner() {
        BannerAdapter adapter = new BannerAdapter(bannerImages);
        viewPagerBanner.setAdapter(adapter);
    }

    private void startAutoScroll() {
        runnable = () -> {
            currentPage = (currentPage + 1) % bannerImages.length;
            viewPagerBanner.setCurrentItem(currentPage, true);
            handler.postDelayed(runnable, 3000);
        };
        handler.postDelayed(runnable, 3000);
    }

    // ================== 公告数据（纯文本，无图片）==================
    private void initData() {
        allNoticeList = new ArrayList<>();

        allNoticeList.add(new Notice(
                "九寨沟景区2026年5月3日门票预订已达最大承载量",
                "截截至5月2日16:00，九寨沟景区2026年5月3日门票预订4.1万张，已达到最大承载量。未预订到门票的游客朋友可选择购买其它日期门票，或选择到九寨沟县神仙池、甲勿海·熊猫园、金猴谷、九寨华美胜地等周边景区游玩。 为了您有一个愉快的旅程，出行前请密切关注九寨沟景区官网、微信、微博获取最新公告信息。门票预约请关注微信小程序“九寨沟旅游官方平台”，票务咨询电话：0837-7769999。\n" +
                        "\n" +
                        "       温馨提示：\n" +
                        "\n" +
                        "       1.九寨沟景区旺季（4月1日-11月15日）最大游客承载量为41000人次/天，售罄即止。景区将在“九寨沟旅游官方平台”微信小程序启动候补预订机制，如有退订，系统将按先后顺序为您分配门票，若未能候补成功，候补款将原路返回。\n" +
                        "\n" +
                        "       2.非预约，不出行，请按照九寨沟景区“限量、预约、错峰”的相关规定，结合自身实际，合理安排出行时间。\n" +
                        "\n" +
                        "       3.五一期间景区入园时间：8:00-14:00（14:00之后景区停止接待游客入园），闭园时间：18:00。",
                "2026年5月02日",
                "九寨沟管理局",
                "旅游公告"
        ));
        allNoticeList.add(new Notice(
                "九寨沟景区对劳动模范实行“五一”假期免门票通告",
                "   致敬每一份耕耘，不负每一份热爱。\n" +
                        "\n" +
                        "       为庆祝“五一”国际劳动节，营造尊敬劳模、向劳模学习的良好社会氛围，九寨沟景区拟于2026年5月1日至5月5日对劳动模范实行免门票活动。（免票仅限九寨沟景区门票，不含观光车票）\n" +
                        "\n" +
                        "一、免门票时间\n" +
                        "\n" +
                        "       2026年5月1日—2026年5月5日\n" +
                        "\n" +
                        "二、免门票对象\n" +
                        "\n" +
                        "       持有地市州及以上人民政府颁发的“劳动模范”证书、政府部门颁布的文件和“五一劳动奖章”等人员。\n" +
                        "\n" +
                        "三、订票流程\n" +
                        "\n" +
                        "       免门票对象微信小程序搜索“九寨沟旅游官方平台”或关注微信公众号：九寨沟。实名预约景区门票并上传相关证件。预订成功后，免门票对象持本人身份证及相关证件原件到景区检票口检票入园。\n" +
                        "\n" +
                        "       本通告最终解释权归九寨沟风景名胜区管理局。\n" +
                        "\n" +
                        "       票务咨询电话：0837-7769999\n" +
                        "\n" +
                        "       旅游咨询电话：0837-7739753\n" +
                        "\n" +
                        "       景区投诉电话：0837-7739309\n" +
                        "\n" +
                        "       景区救护电话：0837-7738818\n" +
                        "\n" +
                        "       景区观光车服务电话：0837-7766016",
                "2026年4月25日",
                "九寨沟管理局",
                "旅游公告"
        ));
        allNoticeList.add(new Notice(
                "“五一”节假日出行温馨提示",
                "尊敬的游客朋友们及广大旅行社：\n" +
                        "\n" +
                        "       劳动节假期将至，初夏时节的九寨沟草木葱郁、海子澄澈，正值游览好时节。为确保您的旅途安全、顺畅、舒心，特此送上这份温馨提示：\n" +
                        "\n" +
                        "一、票务预约\n" +
                        "\n" +
                        "       1.实名预约：按照“限量、预约、错峰”的相关规定，景区实行实名制预约购票，建议提前7-14天预约，“非预约，不出行”，未预约将无法入园。未预约到景区门票的游客建议前往九寨沟县神仙池、甲勿海·熊猫园、九寨华美胜地旅游度假区等景区游览。\n" +
                        "\n" +
                        "       2.预约渠道：微信小程序搜索“九寨沟旅游官方平台”（票务咨询电话：0837-7769999）实名预约。\n" +
                        "\n" +
                        "       3.限量政策：景区严格执行游客最大承载量管理规定，旺季（4月1日-11月15日）最大承载量为41000人次/天，门票限量预约、售罄即止，倡导错峰出行。\n" +
                        "\n" +
                        "       4.候补登记：如您已抵达景区附近，当日门票预订已达最大承载量，可通过官方小程序尝试“候补预约”，一旦有退订，系统将按先后顺序为您分配门票，若未能候补成功，候补款将原路返回。\n" +
                        "\n" +
                        "       5.开放时间：景区入园时间为8:00-14:00，闭园时间为18:00。为了您开心愉快的游览体验，请合理安排游玩时间。\n" +
                        "\n" +
                        "二、安全出行\n" +
                        "\n" +
                        "       1.严格遵守防火规定，景区属森林草原防灭火重点区域，初夏植被繁茂、天干物燥，为防止山火发生，请严格遵守防火相关要求，请勿携带易燃易爆物品入园，请勿在景区内吸烟，严禁野外用火，共同守护生态安全。\n" +
                        "\n" +
                        "       2.注意游览安全，在景区游玩期间，请勿离开栈道，请勿在栈道追逐打闹；初夏栈道可能因雨后略显湿滑，行走时请放慢脚步、注意防滑，以防发生意外。\n" +
                        "\n" +
                        "       3.加强未成年人管护，未成年人须在家长监护下游览，请勿单独活动；注意春夏蚊虫开始增多，可提前准备驱蚊用品，避免蚊虫叮咬。\n" +
                        "\n" +
                        "       4.为了您的健康，游览海拔较高的景点时，请勿大量饮水，不做剧烈运动；正午高温时段可适当休息，避免中暑，随身携带饮用水补充水分。\n" +
                        "\n" +
                        "       5.高原天气多变，九寨沟昼夜温差较大，清晨稍凉，正午日照充足，偶有阵雨突袭，游玩期间请密切关注天气变化。\n" +
                        "\n" +
                        "       6.注意防范次生地质灾害，如有意外情况发生，请配合、服从工作人员统一指挥，以维护您和他人的合法权益，保障游览安全。\n" +
                        "\n" +
                        "三、文明游览\n" +
                        "\n" +
                        "       1.入园、游览及乘坐观光车时，请在规定站点依次有序排队，听从工作人员安排、不拥挤、不插队、相互礼让，共同营造安全、有序、文明的游览环境。景区处于山区环境，弯道较多，乘车时请抓好扶手，避免发生意外。\n" +
                        "\n" +
                        "       2.严禁在景区内留宿，景区实行“沟内游，沟外住”政策，请各位游客到景区外住宿。\n" +
                        "\n" +
                        "       3.请勿下滩踩水嬉戏、严禁游泳；请勿随地吐痰、乱丢垃圾，保护九寨沟生态环境。\n" +
                        "\n" +
                        "       4.请勿投食喂鱼、喂鸭等，投喂野生动物可能会改变它们的饮食习惯和习性，对它们的健康造成危害；初夏是野生动物活动频繁期，请保持安全距离，切勿惊扰。\n" +
                        "\n" +
                        "       5.请勿大声喧哗，保护野生动物的生存环境，也给其他游客营造安静的游览氛围。\n" +
                        "\n" +
                        "       6.请勿攀爬或翻越栏杆，不攀树折枝，不乱刻乱画；初夏植被长势旺盛，请勿随意攀折枝叶、采摘花草，守护景区自然风貌。\n" +
                        "\n" +
                        "       7.为了保障游客安全和景区秩序，未经允许，景区内禁止使用无人机等飞行器。\n" +
                        "\n" +
                        "       8.请勿携带宠物入园，以保护景区自然山水的完整性。\n" +
                        "\n" +
                        "       9.严禁在景区内私自携带、放生、遗弃任何动植物（包括宠物），以及任何其他未经许可的生物活体。\n" +
                        "\n" +
                        "四、咨询服务\n" +
                        "\n" +
                        "       景区游客中心有免费宣传资料发放、志愿者提供咨询服务，景区外重要交通路口和游客集散中心设有志愿者服务台。\n" +
                        "\n" +
                        "       若有其他咨询，请拨打以下电话：\n" +
                        "\n" +
                        "       票务咨询电话：0837-7769999\n" +
                        "\n" +
                        "       旅游咨询电话：0837-7739753\n" +
                        "\n" +
                        "       景区投诉电话：0837-7739309\n" +
                        "\n" +
                        "       景区救护电话：0837-7738818\n" +
                        "\n" +
                        "       景区观光车服务电话：0837-7766016\n" +
                        "\n" +
                        "       天下九寨沟，大美阿坝州。初夏的九寨，翠海叠瀑相映成趣，清风拂面沁人心脾。为守护九寨沟的自然灵秀，保障每一位游客的游览安全与舒心体验，请大家自觉遵守景区管理规定，做好防晒防雨措施、爱护生态环境、文明有序游览。让我们携手共护这片童话秘境，愿您在九寨沟度过一个惬意美好的劳动节假期！\n" +
                        "\n",
                "2026年4月25日",
                "九寨沟管理局",
                "旅游公告"
        ));
        allNoticeList.add(new Notice(
                "九寨沟景区今日共接待14180人次",
                "2026年5月14日，九寨沟景区今日共接待游客14180人次。",
                "2026年5月14日",
                "九寨沟管理局",
                "每日进沟人数"
        ));
        allNoticeList.add(new Notice(
                "九寨沟景区今日共接待15904人次",
                "2026年5月13日，九寨沟景区今日共接待游客15904人次。",
                "2026年5月13日",
                "九寨沟管理局",
                "每日进沟人数"
        ));
        allNoticeList.add(new Notice(
                "九寨沟景区今日共接待16689人次",
                "2026年5月12日，九寨沟景区今日共接待游客16689人次。",
                "2026年5月12日",
                "九寨沟管理局",
                "每日进沟人数"
        ));

        // 首页只显示3条
        List<Notice> homeList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            homeList.add(allNoticeList.get(i));
        }

        NoticeAdapter adapter = new NoticeAdapter(getActivity(), homeList);
        rvNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNotice.setAdapter(adapter);
    }

    // 轮播图适配器
    private class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerHolder> {
        private int[] images;
        public BannerAdapter(int[] images) { this.images = images; }

        @NonNull
        @Override
        public BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new BannerHolder(imageView);
        }

        @Override
        public void onBindViewHolder(@NonNull BannerHolder holder, int position) {
            ((ImageView) holder.itemView).setImageResource(images[position]);
        }

        @Override
        public int getItemCount() { return images.length; }

        class BannerHolder extends RecyclerView.ViewHolder {
            public BannerHolder(@NonNull View itemView) { super(itemView); }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (runnable != null) {
            handler.postDelayed(runnable, 3000);
        }
    }
}