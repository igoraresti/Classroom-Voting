 

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import database.DataBase;
import model.FreeTime;
 
@ManagedBean
public class GraphicImageViewBean {
 
         
    private StreamedContent chartPie;
    private StreamedContent chartBar;
    private DataBase database = DataBase.getInstance();
 
    @PostConstruct
    public void init() {
        try {
        	// Bar Chart
    		JFreeChart barChart = ChartFactory.createBarChart("","Hora", "Votos", createBarDataset(),PlotOrientation.VERTICAL, true, true, false);
    		
    	    CategoryPlot plot = barChart.getCategoryPlot();
    		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    		
    		File chartBarFile = new File("barchart");
            ChartUtilities.saveChartAsPNG(chartBarFile, barChart, 375, 300);
            chartBar = new DefaultStreamedContent(new FileInputStream(chartBarFile), "image/png");
            
            // Pie Chart
            JFreeChart jfreechart = ChartFactory.createPieChart("", createPieDataset(), true, true, false);
            File chartPieFile = new File("dynamichart");
            ChartUtilities.saveChartAsPNG(chartPieFile, jfreechart, 375, 300);
            chartPie = new DefaultStreamedContent(new FileInputStream(chartPieFile), "image/png");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public StreamedContent getBarChart() {
        return chartBar;
    }
         
    public StreamedContent getPieChart() {
        return chartPie;
    }
    
    private CategoryDataset createBarDataset() {
    	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(FreeTime field: database.getVotes()){
			dataset.addValue(field.getTimeVotes(), field.getTimeOptions(), "");
		}
		return dataset;
    }
     
    private PieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(FreeTime field: database.getVotes()){
			dataset.setValue(field.getTimeOptions(), field.getTimeVotes());
		}
 
        return dataset;
    }
}