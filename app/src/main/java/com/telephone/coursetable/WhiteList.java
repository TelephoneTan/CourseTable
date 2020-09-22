package com.telephone.coursetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class WhiteList extends AppCompatActivity {
    ViewPager2 mviewPager2;

    public static String getBrand() {
        return android.os.Build.BRAND;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_list);

        String Brand =  getBrand();

        switch ( Brand.toLowerCase()){
            case "wiko":Wiko();break;
            case "oneplus":Oneplus();break;
            case "huawei": case "honor": Huawei();break;
            case "samsung":Samsung();break;
            case "xiaomi":Xiaomi();break;
            case "meizu":Meizu();break;
            case "asus":Asus();break;
            case "lenovo":Lenovo();break;
            case "oppo":Oppo();break;
            case "nokia":Nokia();break;
            case "sony":Sony();break;
            case "htc":HTC();break;
            default:common();break;
        }
    }

    public void Wiko() {
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　用户解决方案-----1\n" +
                "　　用户解决方案第三步骤详解-----2\n\n" +
                "　　***右滑进入下一页");

        list.add("用户解决方案");
        list.add("用户解决方案第三步骤详解");

        list2.add("◎转到电话助理>电池>关闭生态模式。\n" +
                "◎返回并转到手动模式\n" +
                "◎点击右上角的齿轮图标>后台应用白名单>现在选择您的应用程序");
        list2.add("1.启动电话辅助功能，点击按电源节省\n" +
                "2.关闭节能模式，并点击\"优化模式\"\n" +
                "3.禁用\"优化模式\"，或确保应用未优化\n" +
                "4.转到\"高级设置\"\n" +
                "5.进入后台进程白名单\n" +
                "6.确保你的应用在列表中\n\n" +
                "或者：\n" +
                "转到拨号器，输入代码，\n取消选中Lowram启用和后台启用。\n" +
                "注意：重新启动后需要再次完成。\n　　*#*#86569726#*#*");
       mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"wiko"));
    }

    public void Samsung(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　Galaxy S9 / S10-----1\n" +
                "　　Galaxy S8（j6ltedx）或以上-----2\n" +
                "　　其余三星手机-----3\n\n" +
                "　　***右滑进入下一页");

        list.add("Galaxy S9 / S10");
        list.add("Galaxy S8（j6ltedx）或以上");
        list.add("其余三星手机");
        list2.add("睡眠应用\n" +
                "　　“睡眠应用程序”菜单是三星应用程序终止策略的狙击手。\n" +
                "　　请仔细地按照说明进行操作，以防止应用被关闭。\n" +
                "清单：\n" +
                "◎禁用-将未使用的应用置于睡眠状态\n" +
                "◎禁用-自动禁用未使用的应用程序\n" +
                "◎从休眠的应用列表中删除您的应用\n" +
                "◎禁用-应用程序的背景限制\n" +
                "　　1.从手机设置启动设备护理\n" +
                "　　2.点击电池>三点菜单>设置，禁用所有切换（通知除外)\n" +
                "　　3.点击睡眠应用\n" +
                "　　4.使用垃圾桶图标唤醒所有应用");
        list2.add("◎打开设置>设备维护>电池，在底部看到最常用的应用列表。\n" +
                "◎选择应用，然后点“省电”按钮，在组中单独管理应用。\n" +
                "◎在最底端，您将找到不受监视的应用。" +
                "从“应用电源监控器”影响范围中排除您想要不受监视的应用（白名单）。\n" +
                "◎在“不受监视的应用”菜单中，点击三点菜单，可以从列表中添加或删除应用程序。\n" +
                "◎您可以关闭App电源监控器功能，因为它只会妨碍您Galaxy手机的正常运行。");
        list2.add("手机设置>应用程序>选择三点菜单>\n特殊访问>优化电池使用率>\n" +
                "在列表中找到您的应用，并确保未选中该应用程序。\n\n" +
                "注意：如果您为应用程序启用Edge Lighting，则该应用程序将无法唤醒屏幕。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"samsung"));

    }

    public void Xiaomi(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　电源管理-----1\n" +
                "　　应用程式省电模式-----2\n" +
                "　　自动启动-----3\n" +
                "　　应用固定-----4\n\n" +
                "　　***右滑进入下一页");

        list.add("电源管理");
        list.add("应用程式省电模式");
        list.add("自动启动");
        list.add("应用固定");

        list2.add("请启用：\n" +
                "◎设置>高级设置>电池管理器>电源计划-性能设置\n" +
                "◎设备设置>高级设置>电池管理器>受保护的应用 –您的应用需要受到保护\n" +
                "◎设备设置>应用程序>您的应用程序>电池>耗电量大的提示 -在屏幕关闭后保持运行\n" +
                "◎设置>其他设置>电池和性能>管理应用的电池使用量，如下：\n" +
                "　　1.将省电模式切换为关闭\n" +
                "　　2.选择以下选项：\n" +
                "后台节能>选择应用>选择您的应用>\n后台设置>无限制");
        list2.add("安全>电池>应用程序省电>\n您的应用程序>无限制");
        list2.add("打开安全性应用>权限>自动启动\n" +
                "为所需的应用程序启用“自动启动”。");
        list2.add("　　当您打开“最近使用的应用程序”托盘时，向下拖动您的应用程序-它会被锁定。" +
                "\n　　因此，即使您清除了最近使用的应用程序，也不会从后台清除它。再次向下拖动可从后台清除您的应用。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"xiaomi"));

    }

    public void Meizu(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　调整设备-----1\n\n" +
                "　　***右滑进入下一页");
        list.add("调整设置");
        list2.add("◎设备设置>高级设置>电量管理>性能模式.\n\n" +
                "◎设备设置>高级设置>电量管理>受保护的应用 – 将您的应用勾选为“受保护的”.\n\n" +
                "◎启用设备设置>应用>您的应用>电池>“高耗电提醒”与“在屏幕关闭后保持运行”。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"meizu"));

    }

    public void Asus(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　调整设备-----1\n\n" +
                "　　***右滑进入下一页");
        list.add("调整设置");
        list2.add("华硕上的恶意应用称为Power Master.为确保应用程序后台处理正常进行，请进行以下设置：\n\n" +
                "◎智能管家(Mobile Manager)> (PowerMaster)>设置(Settings) 或 省电选项(Battery-saving options)> 清除“暂停中断”(Clean up in suspend)\n\n" +
                "◎智能管家(Mobile Manager)> (PowerMaster)>设置(Settings) 或 省电选项(Battery-saving options)>“自动禁止自行启动”(Auto-deny apps from auto starting");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"asus"));
    }

    public void Lenovo(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　联想P2-----1\n\n" +
                "　　***右滑进入下一页");
        list.add("联想P2");
        list2.add("为了使应用在后台运行：\n\n" +
                "◎在正在运行的应用列表中的某个应用的右上角启用挂锁图标，然后才真正作为前台进程运行。\n\n" +
                "◎在设置->应用程序->您的应用程序->电池中打开或关闭电池/电源优化。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"lenovo"));
    }

    public void Oppo(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　Oppo F1s-----1\n" +
                "　　Oppo F1s续-----2\n\n" +
                "　　***右滑进入下一页");
        list.add("Oppo F1S");
        list.add("Oppo F1S续");
        list2.add("每次关闭屏幕时，后台服务都会被杀死，然后需要重新启用这些服务。到目前为止，一种解决方法是：\n\n" +
                "◎将您的应用固定到最近的应用屏幕\n" +
                "◎在安全应用程序的“启动管理器”和“浮动应用程序列表”内的应用程序列表中启用您的应用程序\n" +
                "◎关闭电池优化\n" +
                "◎给服务一个持久的通知以保留在前台\n\n" +
                "注意：在应用程序运行之前，所有这四个步骤都需要完成。");
        list2.add("◎安全中心-权限隐私-应用权限管理-选择应用-信任该应用-自启动管理-允许应用自启动\n\n" +
                "◎安全中心-电量节省-省电设置-纯净后台设置-添加应用-勾选该应用\n\n" +
                "◎选择手机设置里面的WLAN-高级-打开随时扫描和保持WLAN连接-选择应用程序管理-正在运行列表，锁住该应用");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"oppo"));
    }

    public void Nokia(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　大多数诺基亚手机-----1\n" +
                "　　大多数诺基亚机型续-----2\n" +
                "　　诺基亚1（Android Go）-----3\n" +
                "　　诺基亚3.1和5.1-----4\n" +
                "　　诺基亚3.1和5.1续-----5\n\n" +
                "　　***右滑进入下一页");
        list.add("大多数诺基亚手机");
        list.add("大多数诺基亚机型续");
        list.add("诺基亚1（Android Go）");
        list.add("诺基亚3.1和5.1");
        list.add("诺基亚3.1和5.1续");
        list2.add("要解决此问题，请执行以下操作：\n" +
                "◎转到手机设置>应用>查看所有应用>点击右上角菜单>显示系统。\n" +
                "◎在列表中找到节电应用，选择它并强制关闭。它将保持停止一段时间，但最终将重新启动。\n" +
                "◎手机设置>锁屏清理>勾选后台保留软件，或者进入设置>电池>锁屏及后台管理，勾选保留。\n\n" +
                "从现在开始，后台应用程序应可正常运行，并使用标准的Android电池优化功能。");
        list2.add("通过以下adb命令禁用com.evenwell.powersaving.g3软件包：\n" +
                "adb shell\n" +
                "pm disable-user com.evenwell.powersaving.g3" );
        list2.add("通过以下adb命令禁用com.evenwell.emm软件包：\n" +
                "adb shell\n" +
                "pm disable-user com.evenwell.emm");
        list2.add("◎首先，使用adb授予MacroDroid写入全局设置存储的能力：\n" +
                "adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS");
        list2.add("◎然后创建一个在设备启动时触发的任务，该任务执行以下操作：\n" +
                "　　系统设置：键入Global，\n　名称setting.duraspeed.enabled，值2\n" +
                "　　系统设置：类型System，\n　名称setting.duraspeed.enabled，值2\n" +
                "　　系统设置：键入Global，\n　名称setting.duraspeed.enabled，值0\n" +
                "　　系统设置：键入System，\n　名称setting.duraspeed.enabled，值0\n" +
                "注意：您既需要“全局”类型，又需要“系统”类型设置");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"nokia"));
    }

    public void Sony(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　Sony-----1\n" +
                "　　Sony续-----2\n\n" +
                "　　***右滑进入下一页");
        list.add("SONY");
        list.add("SONY续");
        list2.add("　　索尼在我们的Android供应商列表中排名很高，因为历史上是索尼推出了第一个非常有效的非标准后台流程优化程序，并打开了潘多拉的盒子。\n" +
            "　　这称为耐力模式，如果启用，它将立即中断所有后台进程和所有警报。");
        list2.add("　　如果您想在不使用手机时做一些有用的事情，请不要使用耐力模式。\n\n" +
            "◎在手机设置>电池>右上角的三个点>电池优化>应用>您的应用中，尝试使您的应用不经过电池优化。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"sony"));
    }

    public void HTC(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　电池优化-----1\n\n" +
                "　　***右滑进入下一页");
        list.add("电池优化");
        list2.add("如果某些应用程序不希望启用电池优化，则可以在这些应用程序中关闭该功能。\n" +
                "◎打开“电话设置”>点击“电源”>点击“电池优化”。\n" +
                "◎点“按未优化”>”所有应用程序“，以查看应用程序的完整列表。\n" +
                "◎要关闭应用程序中的电池优化，请点击应用程序名称，然后点击不优化>完成。重复此过程以关闭其他应用程序中的优化。\n" +
                "◎要过滤列表并查看禁用了电池优化的应用程序，请点击所有应用程序>未优化。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"htc"));
    }

    public void Oneplus(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　电池优化-----1\n" +
                "　　电池优化续-----2\n" +
                "　　应用自动启动-----3\n" +
                "　　增强/高级优化-----4\n" +
                "　　增强/高级优化续-----5\n" +
                "　　最近的应用清除行为-----6\n\n" +
                "　　***右滑进入下一页");
        list.add("电池优化");
        list.add("电池优化续");
        list.add("应用自动启动");
        list.add("增强/高级优化");
        list.add("增强/高级优化续");
        list.add("最近的应用清除行为");
        list2.add("◎关闭系统设置>应用程序>齿轮图标>特殊访问>电池优化。\n" +
                "* 警告：最近，OnePlus手机开始随机恢复随机设置的此设置。因此，如果将其设置为未优化，则第二天可能会恢复到优化状态。\n\n" +
                "　　为了避免系统自动还原未优化的设置，您还必须将应用锁定在后台列表中。\n" +
                "　　这样可以避免该应用在后台被杀死，并且还原的电池优化设置。\n");
        list2.add("　　但是，这不是100％，您可能需要不时检查一次系统设置，查看提交给OnePlus的错误报告。\n\n" +
                "◎关闭系统设置>电池>电池优化，在右上方菜单中切换到“所有应用”>“您的应用”>“不优化”\n" +
                "* 注意：有时您需要在“1+3”（或更早）的开发人员”选项中禁用打ze模式。");
        list2.add("　　应用自动启动（在某些OnePlus手机上）在本质上阻止了应用在后台运行。请为您的应用禁用它。");
        list2.add("OnePlus 6以及更多：\n" +
                "◎系统设置>电池>电池优化>三点菜单>高级优化。\n" +
                "您将在此处看到两个选项。两者都默认启用：\n" +
                "--深度优化\n" +
                "如果您需要任何应用程序在后台运行，请禁用它。\n" +
                "--睡眠待机优化\n" +
                "OnePlus尝试学习您通常何时处于睡眠状态，在这种情况下，它将禁用手机的网络连接，此设置将阻止传递推送通知。\n");
        list2.add("OnePlus 6以下：\n" +
                "◎关闭系统设置>电池>电池优化>三点菜单>增强优化。\n" +
                "注意：这将有助于解决您与智能手表/健身追踪器失去蓝牙连接的问题（例如，睡眠追踪）。");
        list2.add("　　通常，当您滑动某个应用程序时，它不会关闭。Android可以很好地自行处理。\n" +
                "　　但是，在OnePlus上，这可能会以不同的方式起作用。\n" +
                "　　可以通过滑动应用程序将其关闭将其杀死的方式来设置最新的应用程序清除行为管理器。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"oneplus"));
    }

    public void Huawei(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　EMUI 8、9、10-----1\n" +
                "　　EMUI 9+-----2\n" +
                "　　EMUI 9+续-----3\n" +
                "　　EMUI 6+和某些EMUI 5设备-----4\n" +
                "　　华为P9 Plus-----5\n" +
                "　　荣誉9 Lite，伴侣9 Pro-----6\n" +
                "　　EMUI 4-----7\n\n" +
                "　　***右滑进入下一页");
        list.add("EMUI 8、9、10");
        list.add("EMUI 9+");
        list.add("EMUI 9+续");
        list.add("EMUI 6+和某些EMUI 5设备");
        list.add("华为P9 Plus");
        list.add("荣誉9 Lite，伴侣9 Pro");
        list.add("EMUI 4");
        list2.add("◎手机设置>电池>应用启动，然后将您的应用设置为“手动管理”，并确保所有功能均已打开。\n" +
                "*电话设置>电池>应用启动*。此功能可能适用于所有设备，也可能不适用于所有设备，或者标记不同。\n\n"+
                "◎关闭“自动管理所有内容”");
        list2.add("PowerGenie，它会杀死不在其白名单中的所有应用程序。您无法将自定义应用添加到其预定义白名单中。\n" +
                "为了获得可靠的后台进程，您可能需要按照以下说明卸载PowerGenie。\n" +
                "你需要：\n" +
                "1. 在计算机上安装ADB\n" +
                "2. 用数据线连接手机,启用开发者选项\n" +
                "3. 在手机的开发人员选项中启用USB调试\n");
        list2.add("4. 在计算机上运行以下命令：\n" +
                "adb shell pm uninstall -k --user 0 com.huawei.powergenie adb shell pm uninstall -k --user 0 com.huawei.android.hwaps\n" +
                "如果应用继续崩溃，请尝试运行adb shell pm stopservice hwPfwService。\n\n" +
                "　　* 我们尚未确认这一点，但有可能您在“ 手机设置”>“应用程序”中可以禁用PowerGenie。\n" +
                "　　但每次重新启动设备时，都需要重新应用此设置。");
        list2.add("1.手机设置>高级设置>电池管理器>电源管理设置为性能\n" +
                "2.手机设置>高级设置>电池管理器>受保护的应用程序 –将您的应用程序设置为受保护的\n" +
                "3.手机设置>应用>您的应用>电池>耗电量大的提示 [取消选中]，并在屏幕关闭后继续运行 [选中]\n" +
                "4.手机设置>应用程序>高级（在底部）>忽略优化>按允许>所有应用程序>在列表中找到您的应用程序并设置为允许");
        list2.add("◎手机设置>应用程序>设置>特殊访问>忽略电池优化>选择允许您的应用程序。");
        list2.add("◎手机设置>电池>启动，然后将您的应用设置为“手动管理”，并确保所有功能均已打开。");
        list2.add("抱歉，在EMUI 4上没有出路，但是您可以使用应用的开发人员实施的“开发人员”部分中所述的解决方法");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"huawei"));
    }

    public void common(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("　　请根据本教程加入白名单\n" +
                "　　将APP授予开机启动权限(无教程，请自行到设置中寻找)\n\n" +
                "　　目录：\n" +
                "　　Android 6+-----1\n" +
                "　　Android 8+-----2\n" +
                "　　Android 6.0及之前版本-----3\n" +
                "　　Android 7+-----4\n" +
                "　　如果全部失败-----5\n" +
                "　　如果全部失败续-----6\n\n" +
                "　　***右滑进入下一页");
        list.add("Android 6+");
        list.add("Android 8+");
        list.add("Android 6.0及之前版本");
        list.add("Android 7+");
        list.add("如果全部失败");
        list.add("如果全部失败续");
        list2.add("始终检查以下设置\n" +
                "◎手机设置>电池和省电>电池使用情况>忽略优化>开启以忽略应用程序的电池优化。");
        list2.add("◎检查是否为应用程序启用\n" +
                "◎“手机设置”>“应用程序和通知”>“您的应用程序”>“背景限制”或“ 背景限制 ”。\n\n" +
                "*如果全部失败，则可以完全关闭Doze模式。");
        list2.add("关闭Doze模式:\n" +
                "◎打开设置应用程序，然后点击电池。点击“选项”菜单按钮,然后点击“电池优化”。\n" +
                "◎点击向下的箭头，然后从出现的菜单中点击所有应用。\n" +
                "◎点击您要关闭“Doze”模式的应用程序的名称，然后在出现的框中，点击“不优化”。\n\n" +
                "　　您可以随时重新打开Doze模式-只需重复上述过程，但是在出现提示时，请点击优化。\n");
        list2.add(
                "关闭Doze模式需要专家技能\n" +
                "dumpsys deviceidle disable");
        list2.add("　　在设备上寻找任何特定于供应商的省电模式，并且最好卸载，在失败的情况下禁用。\n" +
                "　　如果没有，您可以选择通过adb来生根或卸载设备（不过需要一些专家技能）：\n" +
                "　　◎adb shell\n\n" +
                "　　◎pm uninstall --user 0 　　com.useless.piece.of.trash\n");
        list2.add("　　查看特定于供应商的电话设置，并搜索与电池优化或后台处理有关的任何内容。如果找到它，请尝试将其禁用。\n\n" +
                "◎手机设置>电池和省电>电池使用情况>忽略优化>开启可忽略应用的电池优化。");
        mviewPager2.setAdapter(new WhiteListAdapter(this, list,list2, mviewPager2,"common"));
    }

}