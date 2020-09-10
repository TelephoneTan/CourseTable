package com.telephone.coursetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class WhiteList extends AppCompatActivity {
    ViewPager2 mviewPager2;

    public static String getBrand() {
        return android.os.Build.BRAND;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Intent intent=new Intent();
//        intent.setClass(WhiteList.this, MainActivity.class);
//        startActivity(intent);
        startActivity(new Intent(this, MainActivity.class));
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.whitelist, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_list);

        String Brand =  getBrand();
        Brand="huawei";


        switch ( Brand.toLowerCase()){
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
    public void Samsung(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +
                "\n" +
                "\n" +
                "目录：\n" +
                "Galaxy S9 / S10-----1\n" +
                "Galaxy S8（j6ltedx）或以上-----2\n" +
                "在其他三星手机上-----3\n" +
                "*右滑为下一页");
        list.add("Galaxy S9 / S10");
        list.add("Galaxy S8（j6ltedx）或以上");
        list.add("在其他三星手机上，路径可能如下所示：");
        list2.add("睡眠应用\n" +
                "“睡眠应用程序”菜单是三星应用程序终止策略的狙击手。确保非常仔细地按照说明进行操作，以防止应用被杀死。\n" +
                "清单：\n" +
                "禁用将未使用的应用程序置于睡眠状态\n" +
                "禁用自动禁用未使用的应用程序\n" +
                "从正在休眠的应用程序列表中删除您的应用程序\n" +
                "禁用应用程序的背景限制" +
                "1.点击电池" +
                "2.点击三点菜单>设置\n" +
                "4.禁用所有切换（通知除外)\n" +
                "5.点击睡眠应用\n" +
                " 使用垃圾桶图标唤醒所有应用程序");
        list2.add("打开设置>设备维护>电池，然后在底部看到最常用的应用程序列表。您可以选择应用程序然后点按大的“ 省电”按钮来单独或成组管理应用程序。正在休眠的应用程序将显示在底部的“正在休眠的应用程序”列表中（点按以展开列表）。一直滚动到最底端，您将找到Unmonitored应用程序。这些应用是您明确想要从“ 应用程序电源监控器”不良影响范围中排除的（白名单）。\n" +
                "\n" +
                "在“ 不受监视的应用程序”菜单中，您可以点击3点菜单以从列表中添加或删除应用程序。不必担心任何事情，您可以完全关闭App电源监控器功能，因为它对电池寿命几乎没有影响，并且只会妨碍您Galaxy手机的正常运行。\n" +
                "\n" +
                "这太过分了，在某些情况下甚至完全是误导性的，使用恐吓手段让您依赖三星的软件，而其他Android设备在没有三星的情况下也可以。");
        list2.add("手机设置>应用程序>选择三个点菜单（右上角）>特殊访问>优化电池使用率>在列表中找到您的应用程序，并确保未选中该应用程序。\n" +
                "\n" +
                "注意：如果您为应用程序启用Edge Lighting，则该应用程序将无法唤醒屏幕。要允许您的应用唤醒屏幕，请从Edge Lighting应用列表中将其删除。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"samsung"));

    }
    public void Xiaomi(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "能源管理-----1\n" +
                "应用程式省电模式-----2\n" +
                "自动启动-----3\n" +
                "应用固定-----4\n" +
                "***右滑进入下一页");

        list.add("能源管理");
        list.add("应用程式省电模式");
        list.add("自动启动");
        list.add("应用固定");
        list2.add("请启用：\n" +
                "设置>高级设置>电池管理器>电源计划设置为性能\n" +
                "设备设置>高级设置>电池管理器>受保护的应用程序 –您的应用程序需要受保护\n" +
                "设备设置>应用程序>您的应用程序>电池>耗电量大的提示并在屏幕关闭后保持运行\n" +
                "设置>其他设置>电池和性能>管理应用的电池使用量，如下：\n" +
                "1.将省电模式切换为关闭\n" +
                "2.选择以下选项：在后台节能>选择应用程序>选择您的应用程序>背景设置>无限制");
        list2.add("安全性>电池>应用程序省电>您的应用程序>无限制");
        list2.add("打开安全性应用>权限>自动启动\n" +
                "\n" +
                "为所需的应用程序启用自动启动。");
        list2.add("当您打开“最近使用的应用程序”托盘时，向下拖动您的应用程序-它会被锁定。因此，即使您清除了最近使用的应用程序，也不会从后台清除它。再次向下拖动可从后台清除您的应用。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"xiaomi"));

    }
    public void Meizu(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "调整设备-----1\n" +
                "***右滑进入下一页");
        list.add("调整设置");
        list2.add("设备设置>高级设置>电池管理器>电源计划设置为性能\n" +
                "设备设置>高级设置>电池管理器>受保护的应用 –将您的应用检查为受保护\n" +
                "启用设备设置>应用>您的应用>电池>耗电量大的提示，并在屏幕关闭后继续运行");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"meizu"));

    }

    public void Asus(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "调整设备-----1\n" +
                "***右滑进入下一页");
        list.add("调整设置");
        list2.add("华硕上的恶意应用称为Power Master.为确保应用程序后台处理正常进行，请进行以下设置：\n" +
                "\n" +
                "取消选中“ 移动管理器”>“ PowerMaster”>“设置”（或“省电”选项）>“暂停中清理”\n" +
                "取消选中“ 移动管理器”>“ PowerMaster”>“设置”（或“省电”选项）>“自动启动时自动拒绝应用”。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"asus"));
    }
    public void Lenovo(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "联想P2-----1\n" +
                "***右滑进入下一页");
        list.add("联想P2");
        list2.add("联想P2的电池寿命非常长，但要付出一定的代价。\n" +
                "\n" +
                "为了使应用在后台运行：\n" +
                "\n" +
                "在正在运行的应用程序概述的右上角的某个应用程序上启用挂锁图标。然后才真正作为前台进程运行。如果将其擦去，其后台进程将被无情地杀死。\n" +
                "在设置->应用程序->您的应用程序->电池中打开或关闭电池/电源优化都没关系。");

        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"lenovo"));
    }
    public void Oppo(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "Oppo F1s(大多数oppo机型）-----1\n" +
                "***右滑进入下一页");
        list.add("Oppo F1S");
        list2.add("每次关闭屏幕时，后台服务都会被杀死（包括可访问性服务，然后需要重新启用这些服务）。到目前为止，一种解决方法是：\n" +
                "\n" +
                "将您的应用固定到最近的应用屏幕\n" +
                "在安全应用程序的“启动管理器”和“浮动应用程序列表”内的应用程序列表中启用您的应用程序（com.coloros.safecenter / com.coloros.safecenter.permission.Permission）\n" +
                "关闭电池优化\n" +
                "给服务一个持久的通知以保留在前台\n" +
                "在应用程序运行之前，所有这四个步骤都需要完成。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"oppo"));
    }
    public void Nokia(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "大多数诺基亚手机-----1\n" +
                "大多数诺基亚机型-----2\n" +
                "诺基亚1（Android Go）-----3\n" +
                "诺基亚3.1和5.1-----4\n" +
                "***右滑进入下一页");
        list.add("大多数诺基亚手机");
        list.add("大多数诺基亚机型");
        list.add("诺基亚1（Android Go）");
        list.add("诺基亚3.1和5.1");
        list2.add("（“节电器”又名com.evenwell.powersaving.g3）\n" +
                "要解决此问题，请执行以下操作：\n" +
                "转到手机设置>应用>查看所有应用。\n" +
                "点击右上角菜单>显示系统。\n" +
                "在列表中找到节电应用，选择它并强制关闭。它将保持停止一段时间，但最终将重新启动。\n" +
                "从现在开始，后台应用程序应可正常运行，并使用标准的Android电池优化功能。\n" +
                "在我们的初步测试中，强制停止或卸载节电应用似乎还可以修复警报和启动前台服务，直到节电重新启动为止。");
        list2.add("从8/2019起，HMD Global已为运行Pie或更高版本的设备禁用了Evenwell省电*（com.evenwell.power Saving.g3）*。\n" +
                "通过以下adb命令禁用com.evenwell.powersaving.g3软件包：\n" +
                "adb shell\n" +
                "pm disable-user com.evenwell.powersaving.g3\n" );
        list2.add("通过以下adb命令禁用com.evenwell.emm软件包：\n" +
                "\n" +
                "adb shell\n" +
                "pm disable-user com.evenwell.emm");
        list2.add("首先，使用adb授予MacroDroid（或您选择的自动化应用程序）写入全局设置存储的能力：\n" +
                "\n" +
                "adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS\n" +
                "\n" +
                "然后创建一个在设备启动时触发的任务，该任务执行以下操作：\n" +
                "\n" +
                "系统设置：键入Global，名称setting.duraspeed.enabled，值2\n" +
                "系统设置：类型System，名称setting.duraspeed.enabled，值2\n" +
                "系统设置：键入Global，名称setting.duraspeed.enabled，值0\n" +
                "系统设置：键入System，名称为setting.duraspeed.enabled，值为0\n" +
                "注意：您既需要“全局”类型，又需要“系统”类型设置（");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"nokia"));
    }

    public void Sony(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "Sony-----1\n" +
                "***右滑进入下一页");
        list.add("SONY");
    list.add("SONY");
    list2.add("索尼在我们有毒的Android供应商列表中排名很高，因为历史上是索尼推出了第一个非常有效的非标准后台流程优化程序，并打开了Pandora的盒子。\n" +
            "\n" +
            "这称为耐力模式，如果启用，它将立即中断所有后台进程和所有警报。");
    list2.add("如果您不想在不使用手机时做一些有用的事情，请不要使用耐力模式。\n" +
            "\n" +
            "在手机设置>电池>右上角的三个点>电池优化>应用>您的应用中，尝试使您的应用没有经过电池优化。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"sony"));
    }
    public void HTC(){ mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "电池优化-----1\n" +
                "***右滑进入下一页");
        list.add("电池优化");
        list2.add("如果某些应用程序不希望启用电池优化，则可以在这些应用程序中关闭该功能。\n" +
                "\n" +
                "打开电话设置。\n" +
                "点击电源。\n" +
                "点击电池优化。\n" +
                "点按未优化>所有应用程序以查看应用程序的完整列表。\n" +
                "要关闭应用程序中的电池优化，请点击应用程序名称，然后点击不优化>完成。重复此过程以关闭其他应用程序中的优化。要过滤列表并查看禁用了电池优化的应用程序，请点击所有应用程序>未优化。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"htc"));

    }
    public void Oneplus(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "电池优化-----1\n" +
                "应用自动启动-----2\n" +
                "增强/高级优化-----3\n" +
                "最近的应用清除行为-----4\n" +
                "***右滑进入下一页");
        list.add("电池优化");
        list.add("应用自动启动");
        list.add("增强/高级优化");
        list.add("最近的应用清除行为");
        list2.add("关闭系统设置>应用程序>齿轮图标>特殊访问>电池优化。\n" +
                "* 警告：最近，OnePlus手机开始随机恢复随机设置的此设置。因此，如果将其设置为未优化，则第二天可能会恢复到优化状态。\n" +
                "为了避免系统自动还原未优化的设置，您还必须将应用锁定在“最近的应用”列表中。（https://forum.xda-developers.com/showpost.php?p=78588761&postcount=7）\n" +
                "启动您要保护的应用。转到最近使用的应用程序（应用程序切换器）。切换应用右上角的“ 锁定”按钮。\n" +
                "这样可以避免该应用在后台被杀死，并且要还原的电池优化设置。\n" +
                "但是，这不是100％。您可能需要不时检查一次系统设置。查看提交给OnePlus的错误报告。\n" +
                "关闭系统设置>电池>电池优化，在右上方菜单中切换到“所有应用” >您的应用>不优化\n" +
                "注意：我们的某些用户表示您需要在1 + 3的“开发人员”选项中禁用打ze模式，然后较早。");
        list2.add("应用自动启动（在某些OnePlus手机上）在本质上阻止了应用在后台运行。请为您的应用禁用它。");
        list2.add("OnePlus 6以及更多：\n" +
                "系统设置>电池>电池优化>（三个点）>高级优化。\n" +
                "您将在此处看到两个选项。两者都默认启用：\n" +
                "深度优化\n" +
                "这是主要的应用杀手。如果您需要任何应用程序在后台运行，请禁用它。\n" +
                "睡眠待机优化\n" +
                "OnePlus尝试学习您通常何时处于睡眠状态，在这种情况下，它将禁用手机的网络连接。此设置将阻止传递推送通知。\n" +
                "OnePlus 6以下：\n" +
                "关闭系统设置>电池>电池优化>（三个点）>增强优化。\n" +
                "注意：这将有助于解决您与智能手表/健身追踪器失去蓝牙连接的问题（例如，睡眠追踪）。");
        list2.add("通常，当您滑动某个应用程序时，它不会关闭。Android可以很好地自行处理。但是，在OnePlus上，这可能会以不同的方式起作用。可以通过滑动应用程序将其关闭将其杀死的方式来设置最新的应用程序清除行为管理器。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"oneplus"));
    }
    public void Huawei(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "EMUI 8、9、10-----1\n" +
                "EMUI 9+-----2\n" +
                "EMUI 6+和某些EMUI 5设备-----3\n" +
                "华为P9 Plus-----4\n" +
                "荣誉9 Lite，伴侣9 Pro-----5\n" +
                "EMUI 4-----6\n" +
                "***右滑进入下一页");
        list.add("EMUI 8、9、10");
        list.add("EMUI 9+");
        list.add("EMUI 6+和某些EMUI 5设备");
        list.add("华为P9 Plus");
        list.add("荣誉9 Lite，伴侣9 Pro");
        list.add("EMUI 4");
        list2.add("手机设置>电池>应用启动，然后将您的应用设置为“手动管理”，并确保所有功能均已打开。\n" +
                "1. *电话设置>电池>应用启动*。此功能可能适用于所有设备，也可能不适用于所有设备，或者标记不同。\n"+
                "2.关闭“自动管理所有内容”\n"+"为了获得可靠的后台进程，您可能需要按照以下说明卸载PowerGenie。");
        list2.add("PowerGenie，它会杀死不在其白名单中的所有应用程序。您无法将自定义应用添加到其预定义白名单中。这意味着除卸载PowerGenie外，没有其他方法可以在华为上修复适当的应用程序功能。\n" +
                "你需要：\n" +
                "1. 在计算机上安装ADB\n" +
                "2. 用数据线连接手机,启用开发者选项\n" +
                "3. 在手机的开发人员选项中启用USB调试\n" +
                "4. 在计算机上运行以下命令： adb shell pm uninstall -k --user 0 com.huawei.powergenie adb shell pm uninstall -k --user 0 com.huawei.android.hwaps 如果应用继续崩溃，请尝试运行adb shell pm stopservice hwPfwService。我们尚未确认这一点，但有可能您可以在“ 手机设置”>“应用程序”中禁用PowerGenie 。每次重新启动设备时，都需要重新应用此设置。");
        list2.add("1.手机设置>高级设置>电池管理器>电源计划设置为性能\n" +
                "2.手机设置>高级设置>电池管理器>受保护的应用程序 –将您的应用程序设置为受保护的\n" +
                "3.手机设置>应用>您的应用>电池>耗电量大的提示 [取消选中]，并在屏幕关闭后继续运行 [选中]\n" +
                "4.手机设置>应用程序>高级（在底部）>忽略优化>按允许>所有应用程序>在列表中找到您的应用程序并设置为允许");
        list2.add("手机设置>应用程序>设置>特殊访问>忽略电池优化>选择允许您的应用程序。");
        list2.add("手机设置>电池>启动，然后将您的应用设置为“手动管理”，并确保所有功能均已打开。");
        list2.add("抱歉，在EMUI 4上没有出路，但是您可以要求应用的开发人员实施“ 开发人员”部分中所述的解决方法");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"huawei"));
    }
    public void common(){
        mviewPager2 = findViewById(R.id.huaweiviewppager);
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("总览");
        list2.add("请根据本教程加入白名单\n" +
                "将APP加入开机启动/授予开机启动权限（无教程，请自行到设置/手机管家中寻找）" +"\n" +
                "\n" +
                "目录：\n" +
                "Android 6+-----1\n" +
                "Android 8+-----2\n" +
                "在Android 6.0和更早版本上关闭打ze-----3\n" +
                "在Android 7+上关闭打ze-----4\n" +
                "如果全部失败-----5\n" +
                "***右滑进入下一页");
        list.add("Android 6+");
        list.add("Android 8+");
        list.add("在Android 6.0和更早版本上关闭打ze");
        list.add("在Android 7+上关闭打ze");
        list.add("如果全部失败");
        list2.add("始终检查以下设置 手机设置>电池和省电>电池使用情况>忽略优化>开启以忽略应用程序的电池优化。");
        list2.add("检查是否未为应用程序启用“ 手机设置”>“应用程序和通知”>“您的应用程序”>“背景限制”或“ 背景限制 ”。\n" +
                "\n" +
                "如果全部失败，则可以完全关闭打ze模式。");
        list2.add("“打ze”模式:打开设置应用程序，然后点击电池。点击“ 选项”菜单按钮,然后点击“ 电池优化”。点击向下的箭头，然后从出现的菜单中点击所有应用,接下来，点击您要关闭“打ze”模式的应用程序的名称，然后在出现的框中，点击“不优化”。完成后，点击完成。\n" +
                "您可以随时重新打开打ze模式-只需重复上述过程，但是在出现提示时，请点击优化  。\n"+"在设置>开发人员选项中。（如果您不知道如何启用开发人员选项，则Google应该提供帮助。）");
        list2.add(
                "需要专家技能\n" +
                "\n" +
                "dumpsys deviceidle disable");
        list2.add("在设备上寻找任何特定于供应商的节电器，并且在可能的情况下最好卸载，在可能的情况下禁用。\n" +

                "如果没有，您可以选择通过adb来生根或卸载设备（不过需要一些专家技能）：\n" +
                "adb shell\n" +
                "pm uninstall --user 0 com.useless.piece.of.trash\n" +
                "查看特定于供应商的电话设置，并搜索与电池优化或后台处理有关的任何内容。如果找到它，请尝试将其禁用。\n" +
                "请尝试以下通用方法，因为某些供应商倾向于将比AOSP更具功能性\n" +
                "手机设置>电池和省电>电池使用情况>忽略优化>开启可忽略应用的电池优化。");
        mviewPager2.setAdapter(new ViewPagerAdapter(this, list,list2, mviewPager2,"common"));
    }
}