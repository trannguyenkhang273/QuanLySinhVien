/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.DAO.DiemDAO;
import com.QLSV.DAO.LopDAO;
import com.QLSV.DAO.LopSinhVienDAO;
import com.QLSV.DAO.MonHocDAO;
import com.QLSV.DAO.NganhDAO;
import com.QLSV.DAO.SinhVienDAO;
import com.QLSV.DAO.ThongKeDAO;
import com.QLSV.Model.Diem;
import com.QLSV.Model.Lop;
import com.QLSV.Model.LopSinhVien;
import com.QLSV.Model.MonHoc;
import com.QLSV.Model.Nganh;
import com.QLSV.Model.SinhVien;
import com.QLSV.Model.ThongKe;
import com.QLSV.Utility.Other;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Menu;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Tho
 */
public class ThongKePanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKePanel
     */
    public ThongKePanel() {
        initComponents();
        showBarChart();
        tron();
        fillcomboxMon1();
        fillComboBoxNganh();
        fillcomboxMon2();
//        Sinhvien();
//        TopSV();
        Other.setTable(tblDiem);
        
    }

    
    XSSFWorkbook workbook;
    JFileChooser chooser = new JFileChooser();

    private CellStyle headerCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THICK);

        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 350);
        cellStyle.setFont(font);
        return cellStyle;
    }

    private CellStyle coCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THIN);

        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);
        return cellStyle;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBieuDoTron = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tab3 = new javax.swing.JPanel();
        panelMon1 = new javax.swing.JPanel();
        panelMon2 = new javax.swing.JPanel();
        cbomon2 = new javax.swing.JComboBox<>();
        cboMon1 = new javax.swing.JComboBox<>();
        tab4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiem = new javax.swing.JTable();
        txtExcel = new javax.swing.JLabel();
        cboNganh = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        panelBieuDoTron.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelBieuDoTron.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Tỉ lệ sinh viên theo ngành", panelBieuDoTron);

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );

        panel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Số lượng sinh viên theo từng năm", panel);

        tab3.setBackground(new java.awt.Color(255, 255, 255));

        panelMon1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelMon1.setPreferredSize(new java.awt.Dimension(400, 351));
        panelMon1.setLayout(new java.awt.BorderLayout());

        panelMon2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelMon2.setPreferredSize(new java.awt.Dimension(400, 351));
        panelMon2.setLayout(new java.awt.BorderLayout());

        cbomon2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbomon2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbomon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomon2ActionPerformed(evt);
            }
        });

        cboMon1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMon1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMon1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cboMon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelMon1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbomon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbomon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMon2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kết quả học tật của sinh viên theo môn", tab3);

        tab4.setBackground(new java.awt.Color(255, 255, 255));

        tblDiem.setAutoCreateRowSorter(true);
        tblDiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "XH", "Mã sinh viên", "Tên sinh viên", "Điểm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDiem);
        if (tblDiem.getColumnModel().getColumnCount() > 0) {
            tblDiem.getColumnModel().getColumn(0).setMinWidth(100);
            tblDiem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDiem.getColumnModel().getColumn(0).setMaxWidth(100);
            tblDiem.getColumnModel().getColumn(3).setMinWidth(100);
            tblDiem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblDiem.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        txtExcel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtExcel.setForeground(new java.awt.Color(255, 255, 255));
        txtExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        txtExcel.setText("Xuất Excel");
        txtExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExcelMouseClicked(evt);
            }
        });

        cboNganh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNganhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4Layout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addComponent(txtExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(519, 519, 519))
            .addGroup(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1145, Short.MAX_VALUE)
                    .addGroup(tab4Layout.createSequentialGroup()
                        .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtExcel)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Điểm sinh viên kì vừa qua", tab4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbomon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomon2ActionPerformed
        // TODO add your handling code here:
        //fillcomboxMon2()
        loadTk2();
    }//GEN-LAST:event_cbomon2ActionPerformed

    private void cboMon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMon1ActionPerformed
        // TODO add your handling code here:
        //fillcomboxMon1();
        loadTk1();
    }//GEN-LAST:event_cboMon1ActionPerformed

    private void txtExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExcelMouseClicked
        // TODO add your handling code here:
        if (tblDiem.getRowCount()== 0) {
            return;
        }
        excel();
    }//GEN-LAST:event_txtExcelMouseClicked

    private void cboNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNganhActionPerformed
        // TODO add your handling code here:
        if (cboNganh.getItemCount() == 0) {
            return;
        }
        TopSV();
    }//GEN-LAST:event_cboNganhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboMon1;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JComboBox<String> cbomon2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelBieuDoTron;
    private javax.swing.JPanel panelMon1;
    private javax.swing.JPanel panelMon2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JTable tblDiem;
    private javax.swing.JLabel txtExcel;
    // End of variables declaration//GEN-END:variables
    ThongKeDAO tkdao = new ThongKeDAO();
    DiemDAO ddao = new DiemDAO();
    MonHocDAO mdao = new MonHocDAO();
    LopSinhVienDAO lsvdao = new LopSinhVienDAO();
    LopDAO lopdao = new LopDAO();
    List<MonHoc> listMonHoc = mdao.selectAll();
    SinhVienDAO svdao = new SinhVienDAO();
    List<SinhVien> listsv ;
    List<Diem> listDiem ;
    List<Diem> listDiem1 ;
    List<LopSinhVien> listLopSinhVien ;
    List<Lop> listLop ;
    
    NganhDAO nganhDao = new NganhDAO();
    
    void fillComboBoxNganh(){
        DefaultComboBoxModel cbomodel = (DefaultComboBoxModel) cboNganh.getModel();
        cbomodel.removeAllElements();
        List<Nganh> list = nganhDao.selectAll();
        cbomodel.addElement("Tất cả các ngành");
        for(Nganh c: list){
            cbomodel.addElement(c);
        }
    }
    
    public void showBarChart(){
        // bieu do cot 
        panel.removeAll();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart("Số sinh viên tham gia học hằng năm","Year","Số sinh viên", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        List<ThongKe> list = tkdao.selectcot();
        for (ThongKe k : list) {
            dataset.setValue(k.getSolong(), "số người", k.getTennganh());
            CategoryPlot categoryPlot = chart.getCategoryPlot();
            //categoryPlot.setRangeGridlinePaint(Color.BLUE);
            categoryPlot.setBackgroundPaint(Color.WHITE);
            BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
            Color clr3 = new Color(204,0,51);
            renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        
        panel.add(barpChartPanel, BorderLayout.CENTER);
        }
        panel.validate();
    }
    
    public void tron(){
         DefaultPieDataset barDataset = new DefaultPieDataset( );
        List<ThongKe> list = tkdao.selectAll();
        panelBieuDoTron.removeAll();
        for(ThongKe k : list){
            barDataset.setValue( k.getTennganh(), new Double(k.getSolong() ) );    
            JFreeChart piechart = ChartFactory.createPieChart("Tỉ lệ sinh viên theo ngành",barDataset, false,true,false);//explain
            PiePlot piePlot =(PiePlot) piechart.getPlot();

            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            piePlot.setSectionPaint(k.getTennganh(), (randomColor));
            piePlot.setBackgroundPaint(Color.white);
            ChartPanel barChartPanel = new ChartPanel(piechart);
            
            
            panelBieuDoTron.add(barChartPanel, BorderLayout.CENTER);
        }
        panelBieuDoTron.validate();
//        System.out.println(listMonHoc.size());
    }
    
    void fillcomboxMon1(){
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cboMon1.getModel();
            model.removeAllElements();
            for(int i = 0; i<listMonHoc.size()/2;i++){
                model.addElement(listMonHoc.get(i).getMaMon()+"-"+listMonHoc.get(i).getTenMon());
            }
            
        } catch (Exception e) {
        }
        
    }
    void loadTk1(){
        Object mamon = (Object) cboMon1.getSelectedItem();
        String chuyen = String.valueOf(mamon);
        String[] parts = chuyen.split("-");
        String parts1 = parts[0];
        List<Diem> listD = ddao.selectAllThongKe(parts1);
        int Gioi = 0;
        int kha = 0;
        int trungbinh = 0;
        int rot=0;
        for(Diem d : listD){
            float dtb = (d.getDiemChuyenCan()*2+ d.getDiemGiuaKi()*3+ d.getDiemCuoiKi()*5)/10;
            if(dtb>=8){
                Gioi++;
            }else if(dtb>=6.5){
                kha++;
            }else if(dtb>=5){
                trungbinh++;
            }else{
                rot++;
            }
        }
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        List<ThongKe> list = tkdao.selectAll();
        panelMon1.removeAll();
        //for(ThongKe k : list){
            barDataset.setValue( "Sinh viên giỏi", Gioi ) ;
            barDataset.setValue( "Sinh viên khá", kha ) ;
            barDataset.setValue( "Sinh viên trung bình", trungbinh ) ;
            barDataset.setValue( "Sinh viên rớt", rot ) ;
            JFreeChart piechart = ChartFactory.createPieChart(chuyen,barDataset, false,true,false);//explain
            PiePlot piePlot =(PiePlot) piechart.getPlot();

            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            piePlot.setSectionPaint(chuyen, (randomColor));
            piePlot.setBackgroundPaint(Color.white);
            ChartPanel barChartPanel = new ChartPanel(piechart);
            
            
            panelMon1.add(barChartPanel, BorderLayout.CENTER);
        //}
        panelMon1.validate();
    }
    void fillcomboxMon2(){
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) cbomon2.getModel();
            model.removeAllElements();
            int a = (int) Math.ceil(listMonHoc.size()/2);
            for(int i = a; i<listMonHoc.size();i++){
                model.addElement(listMonHoc.get(i).getMaMon()+"-"+listMonHoc.get(i).getTenMon());
            }
        } catch (Exception e) {
        }
    }
    
    void loadTk2(){
        Object mamon = (Object) cbomon2.getSelectedItem();
        String chuyen = String.valueOf(mamon);
        String[] parts = chuyen.split("-");
        String parts1 = parts[0];
        List<Diem> listD = ddao.selectAllThongKe(parts1);
        int Gioi = 0;
        int kha = 0;
        int trungbinh = 0;
        int rot=0;
        for(Diem d : listD){
            float dtb = (d.getDiemChuyenCan()*2+ d.getDiemGiuaKi()*3+ d.getDiemCuoiKi()*5)/10;
            if(dtb>=8){
                Gioi++;
            }else if(dtb>=6.5){
                kha++;
            }else if(dtb>=5){
                trungbinh++;
            }else{
                rot++;
            }
        }
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        List<ThongKe> list = tkdao.selectAll();
        panelMon2.removeAll();
        //for(ThongKe k : list){
            barDataset.setValue( "Sinh viên giỏi", Gioi ) ;
            barDataset.setValue( "Sinh viên khá", kha ) ;
            barDataset.setValue( "Sinh viên trung bình", trungbinh ) ;
            barDataset.setValue( "Sinh viên rớt", rot ) ;
            JFreeChart piechart = ChartFactory.createPieChart(chuyen,barDataset, false,true,false);//explain
            PiePlot piePlot =(PiePlot) piechart.getPlot();

            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            piePlot.setSectionPaint(chuyen, (randomColor));
            piePlot.setBackgroundPaint(Color.white);
            ChartPanel barChartPanel = new ChartPanel(piechart);
            
            panelMon2.add(barChartPanel, BorderLayout.CENTER);
        //}
        panelMon2.validate();
    }
    
    void tinhdiem(){
        Object mamon = (Object) cboMon1.getSelectedItem();
        String chuyen = String.valueOf(mamon);
        String[] parts = chuyen.split("-");
        String parts1 = parts[0];
        List<Diem> listD = ddao.selectAllThongKe(parts1);
        int Gioi = 0;
        int kha = 0;
        int trungbinh = 0;
        int rot=0;
        for(Diem d : listD){
            float dtb = (d.getDiemChuyenCan()*2+ d.getDiemGiuaKi()*3+ d.getDiemCuoiKi()*5)/10;
            if(dtb>=8){
                Gioi++;
            }else if(dtb>=6.5){
                kha++;
            }else if(dtb>=5){
                trungbinh++;
            }else{
                rot++;
            }
        }
    }
    
//    void Sinhvien(){
//        listsv = svdao.selectAll();
//        DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
//        model.setRowCount(0);
//        
//        Menu:for(SinhVien sv : listsv){
//            try {
//                listDiem = ddao.selectThongkeDiem(sv.getMaSinhVien());
//            } catch (Exception e) {
//                continue Menu;
//            }
//            float diemtb =0;
//            int i =0;
//            for(Diem d : listDiem){
//                diemtb += (listDiem.get(0).getDiemChuyenCan()*2+listDiem.get(0).getDiemGiuaKi()*3+listDiem.get(0).getDiemCuoiKi()*5)/10;
////                float diemtb = (d.getDiemChuyenCan()*)
//                i++;
//            }
//                if((diemtb/i>=0&&diemtb/i<=10)){
//                model.addRow(new Object[]{sv.getMaSinhVien(),sv.getTenSinhVien(),diemtb/i});
//                
//            }
////            model.addRow(new Object[]{sv.getMaSinhVien(),diemtb/i});
//            listDiem.removeAll(listDiem);
//        }
//
////        for(Diem d:listDiem){
////            
////        }
//    }
    
    public void TopSV(){
        DefaultTableModel model = (DefaultTableModel) tblDiem.getModel();
        Object manganh1 = (Object) cboNganh.getSelectedItem();
        String manganhString = String.valueOf(manganh1);
        String[] parts = manganhString.split("-");
        String parts1 = parts[0];
        if (manganhString.equals("Tất cả các ngành")) {
            listsv = svdao.selectAll();
        }else{
            listsv = svdao.selectThongKe(parts1);
        }
        model.setRowCount(0);
        
        int maky = 0;
        int makycu = 0;
        boolean check = false;
        int i = 1;
        String manganh = null;
        
        for(SinhVien sv :listsv){
            listLop = lopdao.SelectThongKe(sv.getMaSinhVien());
            for(Lop l : listLop){
                maky = l.getMaky();
                manganh = l.getMaNganh();
            }
            if(maky == -1 || manganh ==null){
                check = false;
            }else{
                check = true;
            }
            if(check == true){
                makycu = maky -1;
                listDiem = ddao.selectMonCuaSinhVien(sv.getMaSinhVien(), manganh, makycu);
                for(Diem d : listDiem){
                    if((d.getDiemChuyenCan()==-1) || (d.getDiemGiuaKi()==-1) || (d.getDiemCuoiKi()==-1)){
                        check = false;
                    }else{
                        check = true;
                    }
                }
            }
            if(check == true){
                listDiem1 = ddao.selectThongkeDiem1(sv.getMaSinhVien(), makycu, maky);
                for(Diem d :listDiem1){
                    float diem = (d.getDiemChuyenCan()*2 + d.getDiemGiuaKi()* 3 + d.getDiemCuoiKi()*5)/10;
                    String diemtb = String.format("%.2f", diem);
                    diem = Float.parseFloat(diemtb);
                    String xephang = String.valueOf(i);
                    Object row[] = {xephang,sv.getTenSinhVien(),d.getMaSinhVien(),diem};
                    model.addRow(row);
                    i++;
                }
            }
        }
        try {
                    listDiem.removeAll(listDiem1);        listDiem.removeAll(listDiem);
        listsv.removeAll(listsv);
        listLop.removeAll(listLop);

        } catch (Exception e) {
        }
            
     
        maky = 0;
        makycu = 0;
        check = false;
        i = 1;
        manganh = null;
        
        int tongrow = tblDiem.getRowCount();
        
        // Sắp xếp bảng tbl theo cột
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tblDiem.getModel());
        tblDiem.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        //Sếp hạng 
//        tblDiem.setValueAt(1, 0, 0);
        for(int j = 0;j<tongrow;j++){
            tblDiem.setValueAt(j+1, j, 0);
        }
    }
    
    
    void excel(){
        chooser.setDialogTitle ("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;

        chooser.setFileFilter (f);
        int excel = chooser.showSaveDialog(null);
        if (excel == JFileChooser.APPROVE_OPTION) {
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet1 = workbook.createSheet("Điểm sinh viên");
                XSSFRow rows1 = null;
                Cell cells1 = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                rows1 = spreadsheet1.createRow((short) 1);
                rows1.setHeight((short) 500);
                cells1 = rows1.createCell(0, CellType.STRING);
                cells1.setCellValue("Điểm sinh viên");
                rows1 = spreadsheet1.createRow((short) 2);
                rows1.setHeight((short) 500);
                cells1 = rows1.createCell(0, CellType.STRING);
                cells1.setCellValue("Xếp hạng");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(1, CellType.STRING);
                cells1.setCellValue("Mã sinh viên");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(2, CellType.STRING);
                cells1.setCellValue("Tên sinh viên");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(3, CellType.STRING);
                cells1.setCellValue("Điểm trung bình");
                cells1.setCellStyle(cs);
                
                int tongrow = tblDiem.getRowCount();
                for (int row : tblDiem.getSelectedRows()) {
                    rows1 = spreadsheet1.createRow((short) 3 + row);
                    rows1.setHeight((short) 500);
                    cells1 = rows1.createCell(0,CellType.STRING);
                    cells1.setCellValue(tblDiem.getValueAt(row, 0).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(1,CellType.STRING);
                    cells1.setCellValue(tblDiem.getValueAt(row, 1).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(2,CellType.STRING);
                    cells1.setCellValue(tblDiem.getValueAt(row, 2).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(3,CellType.STRING);
                    cells1.setCellValue(tblDiem.getValueAt(row, 3).toString());
                    cells1.setCellStyle(csc);
                }
                for (int i = 0; i < 4; i++) {
                    spreadsheet1.autoSizeColumn(i);
                }
                out = new FileOutputStream(chooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(this, "Xuất file thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn ổ đĩa");
//        }
    }
    
    
}
