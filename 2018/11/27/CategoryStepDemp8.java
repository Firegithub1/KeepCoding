/**
 * 252：分步图 x 轴尺度标签角度（分步图）
 */

import java.awt.Font;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryStepRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 分步图X轴尺度标签角度
 *
 * @author
 *
 */
public class CategoryStepDemp8 extends ApplicationFrame {

    public CategoryStepDemp8(String title) {
        super(title);
    }

    /**
     * 创建数据集
     *
     * @return
     */
    private CategoryDataset getCategoryDataset() {

        // 行关键字
        final String series1 = "JAVA图书";
        final String series2 = "VC图书";
        final String series3 = "VB图书";
        // 列关键字
        final String category1 = "1月";
        final String category2 = "2月";
        final String category3 = "3月";
        final String category4 = "4月";
        final String category5 = "5月";
        final String category6 = "6月";

        // 创建分类数据集
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(310, series1, category1);
        dataset.addValue(489, series1, category2);
        dataset.addValue(512, series1, category3);
        dataset.addValue(589, series1, category4);
        dataset.addValue(359, series1, category5);
        dataset.addValue(402, series1, category6);

        dataset.addValue(501, series2, category1);
        dataset.addValue(200, series2, category2);
        dataset.addValue(308, series2, category3);
        dataset.addValue(580, series2, category4);
        dataset.addValue(418, series2, category5);
        dataset.addValue(315, series2, category6);

        dataset.addValue(480, series3, category1);
        dataset.addValue(381, series3, category2);
        dataset.addValue(264, series3, category3);
        dataset.addValue(185, series3, category4);
        dataset.addValue(209, series3, category5);
        dataset.addValue(302, series3, category6);

        return dataset;
    }

    /**
     * 生成JFreeChart
     *
     * @return
     */
    private JFreeChart getJFreeChart() {
        CategoryDataset dataset = getCategoryDataset();
        // 设置分布图渲染
        CategoryItemRenderer renderer = new CategoryStepRenderer(true);
        // 创建X轴
        CategoryAxis domainAxis = new CategoryAxis("月份");
        // 创建Y轴
        ValueAxis rangeAxis = new NumberAxis("销售量（单位：本）");
        // 生成图表
        CategoryPlot plot = new CategoryPlot(dataset, domainAxis, rangeAxis,
                renderer);
        final JFreeChart chart = new JFreeChart("2010年上半年销售量", plot);
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
        LegendTitle legendTitle = chart.getLegend();
        legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
        // 图表
        CategoryPlot categoryPlot = chart.getCategoryPlot();

        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        // X轴字体
        categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
        // X轴标签字体
        categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));

        ValueAxis valueAxis = categoryPlot.getRangeAxis();
        // y轴字体
        valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
        // y轴标签字体
        valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
    }

    /**
     * 更新图表显示
     *
     * @param chart
     */
    private void updatePlot(JFreeChart chart) {
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis categoryAxis = plot.getDomainAxis();
        // 区域图X轴尺度标签角度
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
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
        // 更新图表
        updatePlot(chart);
        setContentPane(new ChartPanel(chart));
    }

    public static void main(String[] args) {
        CategoryStepDemp8 demo = new CategoryStepDemp8("分步图");
        demo.createPlot();
        demo.pack();
        // 把窗体显示到显示器中央
        RefineryUtilities.centerFrameOnScreen(demo);
        // 设置可以显示
        demo.setVisible(true);
    }
}
