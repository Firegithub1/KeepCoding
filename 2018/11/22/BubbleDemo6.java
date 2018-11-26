/**
 * 242：设置起气泡颜色（气泡图）
 */

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 设置气泡颜色
 * @author baiweiming
 *
 */
public class BubbleDemo6 extends ApplicationFrame {

    public BubbleDemo6(String title) {
        super(title);
    }

    /**
     * 创建数据集
     *
     * @return
     */
    private XYZDataset getDataset() {

        // 系例关键字
        final String series1 = "JAVA图书";
        final String series2 = "VC图书";
        final String series3 = "VB图书";

        // 创建分类数据集
        DefaultXYZDataset dataset = new DefaultXYZDataset();
        double data1 [] [] =    new double[][] {{600}, {10}, {600/(10*10)}};
        double data2 [] [] =    new double[][] {{650}, {10}, {650/(10*10)}};
        double data3 [] [] =    new double[][] {{800}, {16}, {800/(16*10)}};

        dataset.addSeries(series1, data1);
        dataset.addSeries(series2, data2);
        dataset.addSeries(series3, data3);

        return dataset;
    }

    /**
     * 生成JFreeChart
     *
     * @return
     */
    private JFreeChart getJFreeChart() {
        XYZDataset dataset = getDataset();
        JFreeChart chart = ChartFactory.createBubbleChart("2010年上半年销售量", // 图表标题
                "页数", // x轴标签
                "章数", // y轴标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 是否显示图例
                false, // 是否生成工具
                false // 是否生成URL链接
        );
        return chart;
    }

    /**
     * 修改字体
     *
     * @param chart
     */
    private void updateFont(JFreeChart chart) {

        // 标题
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
        //图示
        LegendTitle legendTitle = chart.getLegend();
        legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));

        XYPlot plot = chart.getXYPlot();
        //X轴
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
        //Y轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
    }

    /**
     * 更新图表显示
     *
     * @param chart
     */
    private void updatePlot(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        //设置透明度
        plot.setForegroundAlpha(0.8f);
        //设置气泡颜色
        XYBubbleRenderer renderer =(XYBubbleRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.YELLOW);
    }

    /**
     * 设置图表
     *
     * @param chart
     */
    public void createPlot() {
        JFreeChart chart = getJFreeChart();
        // 修改字体
        updateFont(chart);
        //修改图表
        updatePlot(chart);
        setContentPane(new ChartPanel(chart));
    }

    public static void main(String[] args) {
        BubbleDemo6 demo = new BubbleDemo6("气泡图");
        demo.createPlot();
        demo.pack();
        // 把窗体显示到显示器中央
        RefineryUtilities.centerFrameOnScreen(demo);
        // 设置可以显示
        demo.setVisible(true);
    }
}
