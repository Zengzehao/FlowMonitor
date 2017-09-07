package flow;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*

* 绘制柱状图

* */

public class BarGraph

{

	
	//public static void main(String[] args)
	public static void paintBarGraph()

	{

		StandardChartTheme sct = new StandardChartTheme("CN");
	
			// 设置主题

		   ChartFactory.setChartTheme(sct);

			// 构造数据

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.addValue(100, "JAVA", "1");

			dataset.addValue(200, "js", "1");

			dataset.addValue(200, "C++", "2");

			dataset.addValue(300, "C", "3");

			dataset.addValue(400, "HTML", "4");

			dataset.addValue(400, "CSS", "5");
			
			dataset.addValue(100, "JAVA", "6");

			dataset.addValue(200, "js", "7");

			dataset.addValue(200, "C++", "8");

			
			
			

			JFreeChart chart = ChartFactory.createBarChart3D("编程语言统计", "语言",

					"学习人数", dataset, PlotOrientation.VERTICAL, true, false,

					false);

			// 保存图表
			
		
			ChartFrame frame = new ChartFrame("报表练习", chart);

			frame.setVisible(true);

			frame.pack();

			//保存图片到本地
			//ChartUtilities.saveChartAsPNG(new File("f:BarChart3D.png"), chart, 800, 500);

			System.out.println("绘图完成");

		}

/*		catch (IOException e)

		{

		e.printStackTrace();

		}
*/
	}

