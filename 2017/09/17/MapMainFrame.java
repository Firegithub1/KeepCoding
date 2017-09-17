/**
 * 059：Map 映射集合实现省市级联选择框
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MapMainFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox comboBox;
    private JComboBox cityComboBox;
    private JComboBox comboBox_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MapMainFrame frame = new MapMainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MapMainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 获取默认的市/县
        String province = (String) getProvince()[0];
        setTitle("输入指定省/直辖市查询对应的市县");

        JLabel label = new JLabel("\u59D3  \u540D\uFF1A");
        label.setBounds(25, 10, 54, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u6027  \u522B\uFF1A");
        label_1.setBounds(25, 47, 54, 15);
        contentPane.add(label_1);

        comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { // 选项状态更改事件
                itemChange();
            }
        });
        comboBox.setBounds(25, 103, 89, 21);
        contentPane.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel(getProvince())); // 添加省份信息

        cityComboBox = new JComboBox();
        cityComboBox.setBounds(203, 103, 89, 21);
        contentPane.add(cityComboBox);
        cityComboBox.setModel(new DefaultComboBoxModel(getCity(province))); // 添加城市信息

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(87, 44, 75, 21);
        contentPane.add(comboBox_1);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{"男", "女"}));

        JLabel lblNewLabel = new JLabel("\u7701/\u76F4\u8F96\u5E02");
        lblNewLabel.setBounds(126, 104, 54, 18);
        contentPane.add(lblNewLabel);

        JLabel label_2 = new JLabel("\u5E02/\u53BF");
        label_2.setBounds(302, 106, 54, 18);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u8BE6\u7EC6\u5730\u5740\uFF1A");
        label_3.setBounds(25, 159, 94, 15);
        contentPane.add(label_3);

        JLabel lblEmail = new JLabel("E-mail\uFF1A");
        lblEmail.setBounds(25, 198, 94, 15);
        contentPane.add(lblEmail);

        textField = new JTextField();
        textField.setBounds(82, 7, 122, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(87, 156, 308, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(87, 195, 308, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton button = new JButton("\u4FDD\u5B58");
        button.setBounds(87, 228, 93, 23);
        contentPane.add(button);

        JButton button_1 = new JButton("\u91CD\u7F6E");
        button_1.setBounds(224, 228, 93, 23);
        contentPane.add(button_1);
    }

    /**
     * 获取省、直辖市，自治区
     */
    public Object[] getProvince() {
        Map<String, String[]> map = CityMap.model; // 获取省份信息保存到Map中
        Set<String> set = map.keySet(); // 获取Map集合中的键，并以Set集合返回
        Object[] province = set.toArray(); // 转换为数组
        return province; // 返回获取的省份信息
    }

    /**
     * 获取指定省对应的市/县
     *
     * @param selectProvince
     * @return
     */
    public String[] getCity(String selectProvince) {
        Map<String, String[]> map = CityMap.model; // 获取省份信息保存到Map中
        String[] arrCity = map.get(selectProvince); // 获取指定键的值
        return arrCity; // 返回获取的市/县
    }

    public void itemChange() {
        String selectProvince = (String) comboBox.getSelectedItem();
        cityComboBox.removeAllItems(); // 清空市/县列表
        String[] arrCity = getCity(selectProvince); // 获取市/县
        cityComboBox.setModel(new DefaultComboBoxModel(arrCity)); // 重新添加市/县列表的值
    }
}

class CityMap {
    /**
     * 全国（省，直辖市，自治区）映射集合
     */
    public static Map<String, String[]> model = new LinkedHashMap();

    static {
        model.put("北京", new String[]{"北京"});
        model.put("上海", new String[]{"上海"});
        model.put("天津", new String[]{"天津"});
        model.put("重庆", new String[]{"重庆"});
        model.put("黑龙江", new String[]{"哈尔滨", "齐齐哈尔", "牡丹江", "大庆", "伊春", "双鸭山", "鹤岗", "鸡西", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"});
        model.put("吉林", new String[]{"长春", "延边", "吉林", "白山", "白城", "四平", "松原", "辽源", "大安", "通化"});
        model.put("辽宁", new String[]{"沈阳", "大连", "葫芦岛", "旅顺", "本溪", "抚顺", "铁岭", "辽阳", "营口", "阜新", "朝阳", "锦州", "丹东", "鞍山"});
        model.put("内蒙古", new String[]{"呼和浩特", "呼伦贝尔", "锡林浩特", "包头", "赤峰", "海拉尔", "乌海", "鄂尔多斯", "通辽"});
        model.put("河北", new String[]{"石家庄", "唐山", "张家口", "廊坊", "邢台", "邯郸", "沧州", "衡水", "承德", "保定", "秦皇岛"});
        model.put("河南", new String[]{"郑州", "开封", "洛阳", "平顶山", "焦作", "鹤壁", "新乡", "安阳", "濮阳", "许昌", "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"});
        model.put("山东", new String[]{"济南", "青岛", "淄博", "威海", "曲阜", "临沂", "烟台", "枣庄", "聊城", "济宁", "菏泽", "泰安", "日照", "东营", "德州", "滨州", "莱芜", "潍坊"});
        model.put("山西", new String[]{"太原", "阳泉", "晋城", "晋中", "临汾", "运城", "长治", "朔州", "忻州", "大同", "吕梁"});
        model.put("江苏", new String[]{"南京", "苏州", "昆山", "南通", "太仓", "吴县", "徐州", "宜兴", "镇江", "淮安", "常熟", "盐城", "泰州", "无锡", "连云港", "扬州", "常州", "宿迁"});
        model.put("安徽", new String[]{"合肥", "巢湖", "蚌埠", "安庆", "六安", "滁州", "马鞍山", "阜阳", "宣城", "铜陵", "淮北", "芜湖", "毫州", "宿州", "淮南", "池州"});
        model.put("陕西", new String[]{"西安", "韩城", "安康", "汉中", "宝鸡", "咸阳", "榆林", "渭南", "商洛", "铜川", "延安"});
        model.put("宁夏", new String[]{"银川", "固原", "中卫", "石嘴山", "吴忠"});
        model.put("甘肃", new String[]{"兰州", "白银", "庆阳", "酒泉", "天水", "武威", "张掖", "甘南", "临夏", "平凉", "定西", "金昌"});
        model.put("青海", new String[]{"西宁", "海北", "海西", "黄南", "果洛", "玉树", "海东", "海南"});
        model.put("湖北", new String[]{"武汉", "宜昌", "黄冈", "恩施", "荆州", "神农架", "十堰", "咸宁", "襄樊", "孝感", "随州", "黄石", "荆门", "鄂州"});
        model.put("湖南", new String[]{"长沙", "邵阳", "常德", "郴州", "吉首", "株洲", "娄底", "湘潭", "益阳", "永州", "岳阳", "衡阳", "怀化", "韶山", "张家界"});
        model.put("浙江", new String[]{"杭州", "湖州", "金华", "宁波", "丽水", "绍兴", "雁荡山", "衢州", "嘉兴", "台州", "舟山", "温州"});
        model.put("江西", new String[]{"南昌", "萍乡", "九江", "上饶", "抚州", "吉安", "鹰潭", "宜春", "新余", "景德镇", "赣州"});
        model.put("福建", new String[]{"福州", "厦门", "龙岩", "南平", "宁德", "莆田", "泉州", "三明", "漳州"});
        model.put("贵州", new String[]{"贵阳", "安顺", "赤水", "遵义", "铜仁", "六盘水", "毕节", "凯里", "都匀"});
        model.put("四川", new String[]{"成都", "泸州", "内江", "凉山", "阿坝", "巴中", "广元", "乐山", "绵阳", "德阳", "攀枝花", "雅安", "宜宾", "自贡", "甘孜州", "达州", "资阳", "广安", "遂宁", "眉山", "南充"});
        model.put("广东", new String[]{"广州", "深圳", "潮州", "韶关", "湛江", "惠州", "清远", "东莞", "江门", "茂名", "肇庆", "汕尾", "河源", "揭阳", "梅州", "中山", "德庆", "阳江", "云浮", "珠海", "汕头", "佛山"});
        model.put("广西", new String[]{"南宁", "桂林", "阳朔", "柳州", "梧州", "玉林", "桂平", "贺州", "钦州", "贵港", "防城港", "百色", "北海", "河池", "来宾", "崇左"});
        model.put("云南", new String[]{"昆明", "保山", "楚雄", "德宏", "红河", "临沧", "怒江", "曲靖", "思茅", "文山", "玉溪", "昭通", "丽江", "大理"});
        model.put("海南", new String[]{"海口", "三亚", "儋州", "琼山", "通什", "文昌"});
        model.put("新疆", new String[]{"乌鲁木齐", "阿勒泰", "阿克苏", "昌吉", "哈密", "和田", "喀什", "克拉玛依", "石河子", "塔城", "库尔勒", "吐鲁番", "伊宁"});
    }
}
