package MainPackage;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.swing.JFrame;
import java.sql.*;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import swing.DataSearch;
import swing.EventClick;
import swing.PanelSearch;




public class Dashboard extends javax.swing.JFrame implements ActionListener {

    String email;
    private JPopupMenu menu;
    private PanelSearch search;
    private JPopupMenu menu2;
    private PanelSearch search2;
    private JPopupMenu menu3;
    private PanelSearch search3;
    private JPopupMenu menu4;
    private PanelSearch search4;
    private JPopupMenu menu5;
    private PanelSearch search5;
    private JPopupMenu menu6;
    private PanelSearch search6;
    public Dashboard() {
        initComponents();
         connect();
        setVisible(true);
        setSize(1160, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getConnection();
//          autoid();
        suggestprop();
        suggest_alloy_size() ;
        suggest_tyre_brand() ;
        suggest_tyre_size() ;
        update_brand_search();
        update_size_search();
       
          dt();
          times();
        
          
          

    }

    public Dashboard(Component parent, String Uname) {
        initComponents();
        
        setVisible(true);
        setSize(1160, 610);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.email = Uname;
        
    }
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    
    DefaultTableModel df;
    ResultSet rs;
   
    
      public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dimuthu_tyre","root","");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    
    }
      
      
   
        
    public void dt(){

    java.util.Date d  =new java.util.Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
    
    String dd = sdf.format(d);
    dashdate.setText(dd.toUpperCase());
    
    
    
   


}
   
// display time dash
 Timer t ;
 SimpleDateFormat st ;
 int x;
    
public void times(){

   
    
  t = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        java.util.Date dt  =new java.util.Date();
        st = new SimpleDateFormat("hh:mm:ss");
        
        String tt = st.format(dt);
        dashtime.setText(tt);
        //comment
       
        
        }
    });
  
    t.start();
}


public void suggestprop() 
      {
      
      menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });

        
        
      }

public void suggest_alloy_size() 
      {
      
      menu2 = new JPopupMenu();
        search2 = new PanelSearch();
        menu2.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu2.add(search2);
        menu2.setFocusable(false);
        search2.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu2.setVisible(false);
                alloy_size_s.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search2.remove(com);
                removeHistory(data.getText());
                menu2.setPopupSize(menu2.getWidth(), (search2.getItemSize() * 35) + 2);
                if (search2.getItemSize() == 0) {
                    menu2.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
      }

public void suggest_tyre_brand() 
      {
      
      menu3 = new JPopupMenu();
        search3 = new PanelSearch();
        menu3.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu3.add(search3);
        menu3.setFocusable(false);
        search3.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu3.setVisible(false);
                tyre_brand_s.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search3.remove(com);
                removeHistory(data.getText());
                menu3.setPopupSize(menu3.getWidth(), (search3.getItemSize() * 35) + 2);
                if (search3.getItemSize() == 0) {
                    menu3.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
      }


      public void suggest_tyre_size() 
      {
      
      menu4 = new JPopupMenu();
        search4 = new PanelSearch();
        menu4.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu4.add(search4);
        menu4.setFocusable(false);
        search4.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu4.setVisible(false);
                tyre_size_s.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search4.remove(com);
                removeHistory(data.getText());
                menu4.setPopupSize(menu4.getWidth(), (search4.getItemSize() * 35) + 2);
                if (search4.getItemSize() == 0) {
                    menu4.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
      }
      
      
      public void update_brand_search() 
      {
      
      menu5 = new JPopupMenu();
        search5 = new PanelSearch();
        menu5.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu5.add(search5);
        menu5.setFocusable(false);
        search5.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu5.setVisible(false);
                update_brand_s.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search5.remove(com);
                removeHistory(data.getText());
                menu5.setPopupSize(menu5.getWidth(), (search5.getItemSize() * 35) + 2);
                if (search5.getItemSize() == 0) {
                    menu5.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
      }
      
      
       public void update_size_search() 
      {
      
      menu6 = new JPopupMenu();
        search6 = new PanelSearch();
        menu6.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu6.add(search6);
        menu6.setFocusable(false);
        search6.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu6.setVisible(false);
                update_size_s.setText(data.getText());
                addStory(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search6.remove(com);
                removeHistory(data.getText());
                menu6.setPopupSize(menu6.getWidth(), (search6.getItemSize() * 35) + 2);
                if (search6.getItemSize() == 0) {
                    menu6.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
      }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utilCalendarModel1 = new org.jdatepicker.impl.UtilCalendarModel();
        utilCalendarModel2 = new org.jdatepicker.impl.UtilCalendarModel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        dashbtn = new javax.swing.JPanel();
        dashlbl = new javax.swing.JLabel();
        itembtn = new javax.swing.JPanel();
        itemlbl = new javax.swing.JLabel();
        salesbtn = new javax.swing.JPanel();
        saleslbl = new javax.swing.JLabel();
        updatebtn = new javax.swing.JPanel();
        updatelbl = new javax.swing.JLabel();
        purchasebtn = new javax.swing.JPanel();
        purchaselbl = new javax.swing.JLabel();
        statisticsbtn = new javax.swing.JPanel();
        statisticslbl = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dashlbl1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dashdate = new javax.swing.JLabel();
        dashtime = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        dashp = new javax.swing.JPanel();
        custom2 = new MainPackage.custom();
        custom3 = new MainPackage.custom();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        itemp = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        alloysecp = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        tyresecp = new javax.swing.JPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        alloyp = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        alloytb = new javax.swing.JTable();
        alloysearch = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        refreshalltbl = new javax.swing.JPanel();
        saleslbl1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtSearch = new swing.MyTextField();
        alloy_size_s = new swing.MyTextField();
        tyrep = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tyretbl = new javax.swing.JTable();
        tyresearch1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        refreshtyretbl1 = new javax.swing.JPanel();
        saleslbl2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tyre_brand_s = new swing.MyTextField();
        tyre_size_s = new swing.MyTextField();
        salesp = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Balance = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        sales_size = new javax.swing.JTextField();
        sales_brand = new javax.swing.JTextField();
        sales_category = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        sales_retailp = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        sales_quantity = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        sales_discount = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        txtPay = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        sales_size_s = new swing.MyTextField();
        sales_brand_s = new swing.MyTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        sales_select = new javax.swing.JTable();
        updatep = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        update_search = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        refreshalltbl1 = new javax.swing.JPanel();
        saleslbl3 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        update_brand_s = new swing.MyTextField();
        update_size_s = new swing.MyTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        update_brand = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        update_size = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        update_quantity = new javax.swing.JTextField();
        update_dis = new javax.swing.JTextField();
        update_category = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        update_sellingp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        purchasep = new javax.swing.JPanel();
        purtb_del = new javax.swing.JPanel();
        itemlbl1 = new javax.swing.JLabel();
        pur_add_details2 = new javax.swing.JPanel();
        itemlbl4 = new javax.swing.JLabel();
        pur_clear_details = new javax.swing.JPanel();
        itemlbl2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pur_totalcost = new javax.swing.JLabel();
        purtb_clear = new javax.swing.JPanel();
        itemlbl3 = new javax.swing.JLabel();
        pur_addstock = new javax.swing.JPanel();
        itemlbl5 = new javax.swing.JLabel();
        pur_add_details = new javax.swing.JPanel();
        itemlbl6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pur_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        purs = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        purbrand = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pursize = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        purbprice = new javax.swing.JTextField();
        purquantity = new javax.swing.JTextField();
        purdiscount = new javax.swing.JTextField();
        purcategory = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pursprice = new javax.swing.JTextField();
        errortxt = new javax.swing.JLabel();
        statisticsp = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        chart2st = new javax.swing.JPanel();
        chart1st = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashbtn.setBackground(new java.awt.Color(255, 255, 255));
        dashbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        dashbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashbtnMouseClicked(evt);
            }
        });
        dashbtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dashlbl.setForeground(new java.awt.Color(51, 51, 255));
        dashlbl.setText("DASHBOARD");
        dashbtn.add(dashlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jPanel1.add(dashbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 140, 40));

        itembtn.setBackground(new java.awt.Color(51, 51, 255));
        itembtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        itembtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itembtnMouseClicked(evt);
            }
        });
        itembtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl.setText("ITEMS");
        itembtn.add(itemlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jPanel1.add(itembtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 140, 40));

        salesbtn.setBackground(new java.awt.Color(51, 51, 255));
        salesbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        salesbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesbtnMouseClicked(evt);
            }
        });
        salesbtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleslbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saleslbl.setForeground(new java.awt.Color(255, 255, 255));
        saleslbl.setText("SALES");
        salesbtn.add(saleslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jPanel1.add(salesbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 40));

        updatebtn.setBackground(new java.awt.Color(51, 51, 255));
        updatebtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        updatebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebtnMouseClicked(evt);
            }
        });
        updatebtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updatelbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatelbl.setForeground(new java.awt.Color(255, 255, 255));
        updatelbl.setText("UPDATE");
        updatebtn.add(updatelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jPanel1.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 140, 40));

        purchasebtn.setBackground(new java.awt.Color(51, 51, 255));
        purchasebtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purchasebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchasebtnMouseClicked(evt);
            }
        });
        purchasebtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        purchaselbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purchaselbl.setForeground(new java.awt.Color(255, 255, 255));
        purchaselbl.setText("PURCHASES");
        purchasebtn.add(purchaselbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 0, 70, 40));

        jPanel1.add(purchasebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 140, 40));

        statisticsbtn.setBackground(new java.awt.Color(51, 51, 255));
        statisticsbtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        statisticsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statisticsbtnMouseClicked(evt);
            }
        });
        statisticsbtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        statisticslbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statisticslbl.setForeground(new java.awt.Color(255, 255, 255));
        statisticslbl.setText("STATISTICS");
        statisticsbtn.add(statisticslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        jPanel1.add(statisticsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 140, 40));

        jPanel9.setBackground(new java.awt.Color(51, 51, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("YuGothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 140, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainPackage/icons8-man-in-blue-jacket-100.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 120, 120));

        dashlbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dashlbl1.setForeground(new java.awt.Color(51, 51, 255));
        dashlbl1.setText("Admin ");
        jPanel1.add(dashlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        kGradientPanel1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 200, 840));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel2.setText("TYRE HOUSE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("DIMUTHU");

        dashdate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        dashdate.setText("Date");

        dashtime.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        dashtime.setText("Time");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashtime, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashdate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashtime)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -10, 1480, 110));

        jPanel10.setMinimumSize(new java.awt.Dimension(1366, 768));
        jPanel10.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel10.setLayout(new java.awt.CardLayout());

        dashp.setBackground(new java.awt.Color(255, 255, 255));

        custom2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout custom2Layout = new javax.swing.GroupLayout(custom2);
        custom2.setLayout(custom2Layout);
        custom2Layout.setHorizontalGroup(
            custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        custom2Layout.setVerticalGroup(
            custom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        custom3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout custom3Layout = new javax.swing.GroupLayout(custom3);
        custom3.setLayout(custom3Layout);
        custom3Layout.setHorizontalGroup(
            custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        custom3Layout.setVerticalGroup(
            custom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("Today's");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setText("Income");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setText("Sales");

        javax.swing.GroupLayout dashpLayout = new javax.swing.GroupLayout(dashp);
        dashp.setLayout(dashpLayout);
        dashpLayout.setHorizontalGroup(
            dashpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashpLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(dashpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashpLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(custom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dashpLayout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 753, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(490, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashpLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        dashpLayout.setVerticalGroup(
            dashpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashpLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dashpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(dashpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jPanel10.add(dashp, "card2");

        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alloysecp.setBackground(new java.awt.Color(255, 255, 255));
        alloysecp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        alloysecp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alloysecpMouseClicked(evt);
            }
        });
        alloysecp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel3.setkEndColor(new java.awt.Color(51, 51, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(51, 51, 255));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alloy Wheels");
        kGradientPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        alloysecp.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 260, 50));

        kGradientPanel2.add(alloysecp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 260, 380));

        tyresecp.setBackground(new java.awt.Color(255, 255, 255));
        tyresecp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        tyresecp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tyresecpMouseClicked(evt);
            }
        });
        tyresecp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setkEndColor(new java.awt.Color(51, 51, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(51, 51, 255));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tyres");
        kGradientPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        tyresecp.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 260, 50));

        kGradientPanel2.add(tyresecp, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        javax.swing.GroupLayout itempLayout = new javax.swing.GroupLayout(itemp);
        itemp.setLayout(itempLayout);
        itempLayout.setHorizontalGroup(
            itempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1460, Short.MAX_VALUE)
        );
        itempLayout.setVerticalGroup(
            itempLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        jPanel10.add(itemp, "card2");

        alloyp.setBackground(new java.awt.Color(255, 255, 255));

        alloytb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_id", "Brand", "Size", "Category", "Buying_price", "Selling_Price", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(alloytb);

        alloysearch.setBackground(new java.awt.Color(51, 51, 255));
        alloysearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        alloysearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alloysearchMouseClicked(evt);
            }
        });
        alloysearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("YuGothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SEARCH");
        alloysearch.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 30));

        refreshalltbl.setBackground(new java.awt.Color(51, 51, 255));
        refreshalltbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        refreshalltbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshalltblMouseClicked(evt);
            }
        });
        refreshalltbl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleslbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saleslbl1.setForeground(new java.awt.Color(255, 255, 255));
        saleslbl1.setText("REFRESH");
        refreshalltbl.add(saleslbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 60, 50));

        jLabel35.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel35.setText("Brand");

        jLabel36.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel36.setText("Size");

        txtSearch.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        alloy_size_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        alloy_size_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alloy_size_sMouseClicked(evt);
            }
        });
        alloy_size_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alloy_size_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                alloy_size_sKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout alloypLayout = new javax.swing.GroupLayout(alloyp);
        alloyp.setLayout(alloypLayout);
        alloypLayout.setHorizontalGroup(
            alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, alloypLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(alloypLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alloy_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(alloysearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshalltbl, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(154, 154, 154))
        );
        alloypLayout.setVerticalGroup(
            alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alloypLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alloy_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(alloypLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(refreshalltbl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(alloysearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addGap(171, 171, 171))
        );

        jPanel10.add(alloyp, "card2");

        tyrep.setBackground(new java.awt.Color(255, 255, 255));

        tyretbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_id", "Brand", "Size", "Category", "Buying_price", "Selling_Price", "Quantity"
            }
        ));
        jScrollPane4.setViewportView(tyretbl);

        tyresearch1.setBackground(new java.awt.Color(51, 51, 255));
        tyresearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        tyresearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tyresearch1MouseClicked(evt);
            }
        });
        tyresearch1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("YuGothic", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("SEARCH");
        tyresearch1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 30));

        refreshtyretbl1.setBackground(new java.awt.Color(51, 51, 255));
        refreshtyretbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        refreshtyretbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshtyretbl1MouseClicked(evt);
            }
        });
        refreshtyretbl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleslbl2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saleslbl2.setForeground(new java.awt.Color(255, 255, 255));
        saleslbl2.setText("REFRESH");
        refreshtyretbl1.add(saleslbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 60, 50));

        jLabel32.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel32.setText("Brand");

        jLabel34.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel34.setText("Size");

        tyre_brand_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        tyre_brand_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tyre_brand_sMouseClicked(evt);
            }
        });
        tyre_brand_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tyre_brand_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tyre_brand_sKeyReleased(evt);
            }
        });

        tyre_size_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        tyre_size_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tyre_size_sMouseClicked(evt);
            }
        });
        tyre_size_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tyre_size_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tyre_size_sKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout tyrepLayout = new javax.swing.GroupLayout(tyrep);
        tyrep.setLayout(tyrepLayout);
        tyrepLayout.setHorizontalGroup(
            tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tyrepLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tyre_brand_s, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tyre_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tyresearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshtyretbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(338, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tyrepLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        tyrepLayout.setVerticalGroup(
            tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tyrepLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tyrepLayout.createSequentialGroup()
                        .addGroup(tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tyre_brand_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tyre_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tyrepLayout.createSequentialGroup()
                        .addGroup(tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tyrepLayout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(tyrepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(refreshtyretbl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(tyresearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                        .addGap(183, 183, 183))))
        );

        jPanel10.add(tyrep, "card2");

        salesp.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel21.setText("Sales Section");
        salesp.add(jLabel21);
        jLabel21.setBounds(16, 19, 121, 27);

        jLabel8.setText("Size");
        salesp.add(jLabel8);
        jLabel8.setBounds(50, 470, 40, 14);

        jLabel9.setText("Brand");
        salesp.add(jLabel9);
        jLabel9.setBounds(50, 510, 28, 14);

        jLabel12.setText("Category");
        salesp.add(jLabel12);
        jLabel12.setBounds(50, 550, 70, 14);

        Balance.setText("Balance");
        salesp.add(Balance);
        Balance.setBounds(820, 550, 80, 14);
        salesp.add(txtTotalPrice);
        txtTotalPrice.setBounds(920, 460, 200, 30);
        salesp.add(sales_size);
        sales_size.setBounds(140, 460, 200, 30);
        salesp.add(sales_brand);
        sales_brand.setBounds(140, 500, 200, 30);
        salesp.add(sales_category);
        sales_category.setBounds(140, 540, 200, 30);

        jLabel16.setText("Retail Price");
        salesp.add(jLabel16);
        jLabel16.setBounds(360, 470, 70, 14);

        sales_retailp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sales_retailpActionPerformed(evt);
            }
        });
        salesp.add(sales_retailp);
        sales_retailp.setBounds(450, 460, 200, 30);

        jLabel26.setText("Quantity");
        salesp.add(jLabel26);
        jLabel26.setBounds(360, 500, 60, 14);
        salesp.add(sales_quantity);
        sales_quantity.setBounds(450, 500, 200, 30);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Size", "Brand", "Category", "Retail Price", "Quantity", "Discount", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSales);

        salesp.add(jScrollPane2);
        jScrollPane2.setBounds(800, 130, 520, 290);

        btnPrint.setText("PRINT INVOICE");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        salesp.add(btnPrint);
        btnPrint.setBounds(920, 630, 160, 70);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        salesp.add(btnClear);
        btnClear.setBounds(200, 630, 120, 70);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        salesp.add(btnAdd);
        btnAdd.setBounds(360, 630, 120, 70);
        salesp.add(sales_discount);
        sales_discount.setBounds(450, 540, 200, 30);

        jLabel28.setText("Discount");
        salesp.add(jLabel28);
        jLabel28.setBounds(360, 550, 60, 14);
        salesp.add(txtBalance);
        txtBalance.setBounds(920, 540, 200, 30);

        txtPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPayKeyReleased(evt);
            }
        });
        salesp.add(txtPay);
        txtPay.setBounds(920, 500, 200, 30);

        jLabel42.setText("Total Price");
        salesp.add(jLabel42);
        jLabel42.setBounds(820, 470, 80, 14);

        jLabel46.setText("Pay");
        salesp.add(jLabel46);
        jLabel46.setBounds(820, 510, 80, 14);

        jLabel47.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel47.setText("Brand");
        salesp.add(jLabel47);
        jLabel47.setBounds(30, 80, 42, 19);

        sales_size_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        sales_size_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_size_sMouseClicked(evt);
            }
        });
        sales_size_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sales_size_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sales_size_sKeyReleased(evt);
            }
        });
        salesp.add(sales_size_s);
        sales_size_s.setBounds(400, 80, 210, 28);

        sales_brand_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        sales_brand_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_brand_sMouseClicked(evt);
            }
        });
        sales_brand_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sales_brand_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sales_brand_sKeyReleased(evt);
            }
        });
        salesp.add(sales_brand_s);
        sales_brand_s.setBounds(80, 80, 210, 28);

        sales_select.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_id", "brand", "size", "category", "buying_price", "selling_price", "discount", "quantity"
            }
        ));
        sales_select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_selectMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(sales_select);
        if (sales_select.getColumnModel().getColumnCount() > 0) {
            sales_select.getColumnModel().getColumn(6).setResizable(false);
            sales_select.getColumnModel().getColumn(7).setResizable(false);
        }

        salesp.add(jScrollPane5);
        jScrollPane5.setBounds(40, 130, 710, 320);

        jPanel10.add(salesp, "card2");

        jLabel37.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel37.setText("Size");

        update_search.setBackground(new java.awt.Color(51, 51, 255));
        update_search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        update_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_searchMouseClicked(evt);
            }
        });
        update_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("YuGothic", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SEARCH");
        update_search.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 30));

        refreshalltbl1.setBackground(new java.awt.Color(51, 51, 255));
        refreshalltbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        refreshalltbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshalltbl1MouseClicked(evt);
            }
        });
        refreshalltbl1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saleslbl3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saleslbl3.setForeground(new java.awt.Color(255, 255, 255));
        saleslbl3.setText("REFRESH");
        refreshalltbl1.add(saleslbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 60, 50));

        jLabel38.setFont(new java.awt.Font("YuGothic", 1, 14)); // NOI18N
        jLabel38.setText("Brand");

        update_brand_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        update_brand_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_brand_sMouseClicked(evt);
            }
        });
        update_brand_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                update_brand_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_brand_sKeyReleased(evt);
            }
        });

        update_size_s.setPrefixIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        update_size_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_size_sMouseClicked(evt);
            }
        });
        update_size_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                update_size_sKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_size_sKeyReleased(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel39.setText("Brand                    :");

        update_brand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update_brand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        update_brand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        update_brand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_brandActionPerformed(evt);
            }
        });
        update_brand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                update_brandKeyPressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel40.setText("Size                        :");

        update_size.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update_size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        update_size.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        update_size.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                update_sizeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                update_sizeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                update_sizeKeyTyped(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel41.setText("Category               :");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel43.setText("Quantity                :");

        update_quantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update_quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        update_quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        update_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                update_quantityKeyTyped(evt);
            }
        });

        update_dis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update_dis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        update_dis.setText("0");
        update_dis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        update_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choose category", "Tyre", "Alloy Wheel" }));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel44.setText("Selling Discount   :");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel45.setText("Selling Price          :");

        update_sellingp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update_sellingp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        update_sellingp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        update_sellingp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                update_sellingpKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(23, 23, 23)
                        .addComponent(update_brand, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(22, 22, 22)
                        .addComponent(update_size, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(18, 18, 18)
                        .addComponent(update_sellingp, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(update_dis, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(20, 20, 20)
                        .addComponent(update_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(21, 21, 21)
                        .addComponent(update_category, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(update_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(update_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(update_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(update_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(update_sellingp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update_dis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addGap(31, 31, 31))
        );

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout updatepLayout = new javax.swing.GroupLayout(updatep);
        updatep.setLayout(updatepLayout);
        updatepLayout.setHorizontalGroup(
            updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatepLayout.createSequentialGroup()
                .addGroup(updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatepLayout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updatepLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_brand_s, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update_search, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(refreshalltbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(376, Short.MAX_VALUE))
        );
        updatepLayout.setVerticalGroup(
            updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatepLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update_brand_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update_size_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(updatepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(refreshalltbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(update_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jPanel10.add(updatep, "card2");

        purchasep.setBackground(new java.awt.Color(255, 255, 255));
        purchasep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        purtb_del.setBackground(new java.awt.Color(51, 51, 255));
        purtb_del.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purtb_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purtb_delMouseClicked(evt);
            }
        });
        purtb_del.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl1.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl1.setText("DELETE");
        purtb_del.add(itemlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, 40, 50));

        pur_add_details2.setBackground(new java.awt.Color(51, 51, 255));
        pur_add_details2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pur_add_details2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pur_add_details2MouseClicked(evt);
            }
        });
        pur_add_details2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl4.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl4.setText("ADD");
        pur_add_details2.add(itemlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        purtb_del.add(pur_add_details2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 140, 40));

        purchasep.add(purtb_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 430, 100, 30));

        pur_clear_details.setBackground(new java.awt.Color(51, 51, 255));
        pur_clear_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pur_clear_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pur_clear_detailsMouseClicked(evt);
            }
        });
        pur_clear_details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl2.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl2.setText("CLEAR");
        pur_clear_details.add(itemlbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        purchasep.add(pur_clear_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 140, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel18.setText("Purchase Section");
        purchasep.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 173, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setText("Total Cost");
        purchasep.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, -1));

        pur_totalcost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purchasep.add(pur_totalcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 110, 21));

        purtb_clear.setBackground(new java.awt.Color(51, 51, 255));
        purtb_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purtb_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purtb_clearMouseClicked(evt);
            }
        });
        purtb_clear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl3.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl3.setText("CLEAR");
        purtb_clear.add(itemlbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, 40, 50));

        purchasep.add(purtb_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 430, 100, 30));

        pur_addstock.setBackground(new java.awt.Color(51, 51, 255));
        pur_addstock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pur_addstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pur_addstockMouseClicked(evt);
            }
        });
        pur_addstock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl5.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl5.setText("ADD TO STOCK");
        pur_addstock.add(itemlbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 140, 40));

        purchasep.add(pur_addstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, 310, 40));

        pur_add_details.setBackground(new java.awt.Color(51, 51, 255));
        pur_add_details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pur_add_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pur_add_detailsMouseClicked(evt);
            }
        });
        pur_add_details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemlbl6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemlbl6.setForeground(new java.awt.Color(255, 255, 255));
        itemlbl6.setText("ADD");
        pur_add_details.add(itemlbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        purchasep.add(pur_add_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 140, 40));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setName(""); // NOI18N

        pur_table.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        pur_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Size", "Brand", "Category", "Buying_Price", "Selling_Price", "Discount", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(pur_table);

        purchasep.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 780, 270));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel7.setText("*press ENTER to search stock");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        purchasep.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, 40));

        purs.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        purs.setForeground(new java.awt.Color(255, 0, 0));
        purchasep.add(purs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 110, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setText("Brand                    :");

        purbrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purbrand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purbrand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purbrandActionPerformed(evt);
            }
        });
        purbrand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                purbrandKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Size                        :");

        pursize.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pursize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pursize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pursize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pursizeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pursizeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pursizeKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setText("Category               :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setText("Buying  Price        :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setText("Quantity                :");

        purbprice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purbprice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purbprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        purquantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purquantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        purquantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                purquantityKeyTyped(evt);
            }
        });

        purdiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purdiscount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        purdiscount.setText("0");
        purdiscount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        purcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choose category", "Tyre", "Alloy Wheel" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("Selling Discount   :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setText("Selling Price          :");

        pursprice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pursprice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pursprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        pursprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                purspriceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(23, 23, 23)
                        .addComponent(purbrand, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(22, 22, 22)
                        .addComponent(pursize, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(pursprice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(purdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(20, 20, 20)
                        .addComponent(purquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(purcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purbprice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(purbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(pursize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(purcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(purbprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(purquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(pursprice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(31, 31, 31))
        );

        purchasep.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 350, 420));

        errortxt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        errortxt.setForeground(new java.awt.Color(255, 0, 0));
        purchasep.add(errortxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 300, 20));

        jPanel10.add(purchasep, "card2");

        jLabel15.setText("statistics");

        javax.swing.GroupLayout chart2stLayout = new javax.swing.GroupLayout(chart2st);
        chart2st.setLayout(chart2stLayout);
        chart2stLayout.setHorizontalGroup(
            chart2stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        chart2stLayout.setVerticalGroup(
            chart2stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chart1stLayout = new javax.swing.GroupLayout(chart1st);
        chart1st.setLayout(chart1stLayout);
        chart1stLayout.setHorizontalGroup(
            chart1stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        chart1stLayout.setVerticalGroup(
            chart1stLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout statisticspLayout = new javax.swing.GroupLayout(statisticsp);
        statisticsp.setLayout(statisticspLayout);
        statisticspLayout.setHorizontalGroup(
            statisticspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticspLayout.createSequentialGroup()
                .addContainerGap(415, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(134, 134, 134)
                .addComponent(chart2st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart1st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        statisticspLayout.setVerticalGroup(
            statisticspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticspLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart1st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
            .addGroup(statisticspLayout.createSequentialGroup()
                .addGroup(statisticspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statisticspLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(chart2st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statisticspLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.add(statisticsp, "card2");

        kGradientPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 1460, 730));

        getContentPane().add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 1650, 830);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClick(JPanel panel){
    panel.setBackground(new Color(255,255,255));
    }
    
    private void onLeave(JPanel panel){
    panel.setBackground(new Color(51,51,255));
    }
            
            
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        salescircle();
    }//GEN-LAST:event_formWindowOpened

    public void salescircle()
    {
           new Thread(new Runnable() {
            @Override
            public void run() {
//                int num=0;
                int i=80;
//                    custom2.UpdateProgress(num);
//                    custom2.repaint();
//                    
                    custom3.UpdateProgress(i);
                    custom3.repaint();
                    
                for (int num = 1; num <= 100; num++) {
                    try {
                        custom2.UpdateProgress(num);
                        custom2.repaint();
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
        
     
    }
    
    private void addStory(String text) {
        try {
           
            boolean add = true;
            PreparedStatement p = con.prepareStatement("select StoryID from story where StoryName=? limit 1",ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
            p.setString(1, text);
            ResultSet r = p.executeQuery();
            if (r.first()) {
                add = false;
            }
            r.close();
            p.close();
            if (add) {
                p = con.prepareStatement("insert into story (StoryName) values (?)");
                p.setString(1, text);
                p.execute();
                p.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
       
       private void removeHistory(String text) {
        try {
            
            PreparedStatement p = con.prepareStatement("delete from story where StoryName=? limit 1");
            p.setString(1, text);
            p.execute();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
       private List<DataSearch> search(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT brand  , coalesce((select StoryID from story where brand=StoryName limit 1),'') as Story from products where brand like ? And category='alloy wheel' order by Story DESC, brand limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }
       
       private List<DataSearch> search2(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT size  , coalesce((select StoryID from story where size=StoryName limit 1),'') as Story from products where size like ? And category='alloy wheel' order by Story DESC, size limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }
       
       private List<DataSearch> search3(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT brand  , coalesce((select StoryID from story where brand=StoryName limit 1),'') as Story from products where brand like ? And category='tyre' order by Story DESC, brand limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }
       
       private List<DataSearch> search4(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT size  , coalesce((select StoryID from story where size=StoryName limit 1),'') as Story from products where size like ? And category='tyre' order by Story DESC, size limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }
       
       private List<DataSearch> search5(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT brand  , coalesce((select StoryID from story where brand=StoryName limit 1),'') as Story from products where brand like ?  order by Story DESC, brand limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }
       
       private List<DataSearch> search6(String search) {
        List<DataSearch> list = new ArrayList<>();
        try {
            
            PreparedStatement p = con.prepareStatement("select DISTINCT size  , coalesce((select StoryID from story where size=StoryName limit 1),'') as Story from products where size like ?  order by Story DESC, size limit 7");
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String text = r.getString(1);
                boolean story = !r.getString(2).equals("");
                list.add(new DataSearch(text, story));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return list;   }


    private void dashbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashbtnMouseClicked
        // TODO add your handling code here:
        onClick(dashbtn);
        onLeave(itembtn);
        onLeave(salesbtn);
        onLeave(updatebtn);
        onLeave(purchasebtn);
        onLeave(statisticsbtn);
              
        
        dashp.setVisible(true);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        dashlbl.setForeground(Color.blue);
        itemlbl.setForeground(Color.white);
        saleslbl.setForeground(Color.white);
        updatelbl.setForeground(Color.white);
        purchaselbl.setForeground(Color.white);
        statisticslbl.setForeground(Color.white);
        
        chartdash();
        salescircle();
       
    }//GEN-LAST:event_dashbtnMouseClicked

    private void itembtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itembtnMouseClicked
        // TODO add your handling code here:
        onLeave(dashbtn);
        onClick(itembtn);
        onLeave(salesbtn);
        onLeave(updatebtn);
        onLeave(purchasebtn);
        onLeave(statisticsbtn);
        
        dashp.setVisible(false);
        itemp.setVisible(true);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        dashlbl.setForeground(Color.white);
        itemlbl.setForeground(Color.blue);
        saleslbl.setForeground(Color.white);
        updatelbl.setForeground(Color.white);
        purchaselbl.setForeground(Color.white);
        statisticslbl.setForeground(Color.white);
    }//GEN-LAST:event_itembtnMouseClicked

    private void salesbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesbtnMouseClicked
        // TODO add your handling code here:
        onLeave(dashbtn);
        onLeave(itembtn);
        onClick(salesbtn);
        onLeave(updatebtn);
        onLeave(purchasebtn);
        onLeave(statisticsbtn);
        
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(true);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        dashlbl.setForeground(Color.white);
        itemlbl.setForeground(Color.white);
        saleslbl.setForeground(Color.blue);
        updatelbl.setForeground(Color.white);
        purchaselbl.setForeground(Color.white);
        statisticslbl.setForeground(Color.white);
        
        productstbl();
    }//GEN-LAST:event_salesbtnMouseClicked

    private void updatebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebtnMouseClicked
        // TODO add your handling code here:
        onLeave(dashbtn);
        onLeave(itembtn);
        onLeave(salesbtn);
        onClick(updatebtn);
        onLeave(purchasebtn);
        onLeave(statisticsbtn);
        
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(true);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        dashlbl.setForeground(Color.white);
        itemlbl.setForeground(Color.white);
        saleslbl.setForeground(Color.white);
        updatelbl.setForeground(Color.blue);
        purchaselbl.setForeground(Color.white);
        statisticslbl.setForeground(Color.white);
    }//GEN-LAST:event_updatebtnMouseClicked

    private void purchasebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchasebtnMouseClicked
        // TODO add your handling code here:
        onLeave(dashbtn);
        onLeave(itembtn);
        onLeave(salesbtn);
        onLeave(updatebtn);
        onClick(purchasebtn);
        onLeave(statisticsbtn);
        
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(true);
        statisticsp.setVisible(false);
        
        dashlbl.setForeground(Color.white);
        itemlbl.setForeground(Color.white);
        saleslbl.setForeground(Color.white);
        updatelbl.setForeground(Color.white);
        purchaselbl.setForeground(Color.blue);
        statisticslbl.setForeground(Color.white);
        
        
        
    }//GEN-LAST:event_purchasebtnMouseClicked

    private void statisticsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statisticsbtnMouseClicked
        // TODO add your handling code here:
        onLeave(dashbtn);
        onLeave(itembtn);
        onLeave(salesbtn);
        onLeave(updatebtn);
        onLeave(purchasebtn);
        onClick(statisticsbtn);
        
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(true);
        
        dashlbl.setForeground(Color.white);
        itemlbl.setForeground(Color.white);
        saleslbl.setForeground(Color.white);
        updatelbl.setForeground(Color.white);
        purchaselbl.setForeground(Color.white);
        statisticslbl.setForeground(Color.blue);
        
        chartdash();
        
    }//GEN-LAST:event_statisticsbtnMouseClicked

    private void alloysecpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alloysecpMouseClicked
        // TODO add your handling code here:
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(true);
        tyrep.setVisible(false);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        alloytbl();
    }//GEN-LAST:event_alloysecpMouseClicked

    private void tyresecpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tyresecpMouseClicked
        // TODO add your handling code here:
        dashp.setVisible(false);
        itemp.setVisible(false);
        alloyp.setVisible(false);
        tyrep.setVisible(true);
        salesp.setVisible(false);
        updatep.setVisible(false);
        purchasep.setVisible(false);
        statisticsp.setVisible(false);
        
        tyretbl();
    }//GEN-LAST:event_tyresecpMouseClicked


//    public void autoid()
//    {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dimuthu","root","");
//            Statement s=con.createStatement();
//                    
//            ResultSet rs = s.executeQuery("select MAX(id) from purchase");
//            rs.next();
//            rs.getString("MAX(id)");
//            
//             if(rs.getString("MAX(id)") == null)
//            {
//               purdislbl.setText("PS001");
//            }
//            else
//            {
//                long id1 = Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
//                id1++;
//                purdislbl.setText("PS" + String.format("%03d", id1));
//                
//                
//            }
//                    
//                    } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    
//    
//    }
    
    private void purtb_delMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purtb_delMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_purtb_delMouseClicked

    private void pur_clear_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pur_clear_detailsMouseClicked
        // TODO add your handling code here:
            purbrand.setText("");
            purcategory.setSelectedIndex(0);
            purbprice.setText("");
            pursprice.setText("");
            purdiscount.setText("");
            purquantity.setText("");
            pursize.setText("");
            jLabel7.setText("*press ENTER to search stock");
            jLabel7.setForeground(Color.BLACK);
        
        
    }//GEN-LAST:event_pur_clear_detailsMouseClicked

    private void purtb_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purtb_clearMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_purtb_clearMouseClicked

    private void pur_add_details2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pur_add_details2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pur_add_details2MouseClicked

    private void pur_addstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pur_addstockMouseClicked
        // TODO add your handling code here:
        
        addtostock();    
    }//GEN-LAST:event_pur_addstockMouseClicked

    
     
       
     
        
        

    private void pur_add_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pur_add_detailsMouseClicked
        // TODO add your handling code here:
        String checkbrand=purbrand.getText();
        String checksize=pursize.getText();
        String checkcategory=purcategory.getSelectedItem().toString();
        String checkbprice=purbprice.getText();
        String checkquantity=purquantity.getText();
        String checksprice=pursprice.getText();
        String checkdiscount=purdiscount.getText();
        
        if(checkbrand.equalsIgnoreCase("")){
            errortxt.setText("*Enter Brand");
         
        
         }else if(checksize.equalsIgnoreCase("")){
             
            errortxt.setText("*Enter Size");
         
         }else if(checkcategory.equals("choose category")){
              
            errortxt.setText("*Enter Category");
         
         }else if(checkbprice.equalsIgnoreCase("")){
             
            errortxt.setText("*Enter Buying Price");
         
         }else if(checkquantity.equalsIgnoreCase("")){
             
            errortxt.setText("*Enter Quantity");
         
         }else if(checksprice.equalsIgnoreCase("")){
         
            errortxt.setText("*Enter selling Price");
            
         }else if(checkdiscount.equalsIgnoreCase("")){
            errortxt.setText("*Enter Discount");
         
         }else{
        puradd();
            purbrand.setText("");
            purcategory.setSelectedIndex(0);
            purbprice.setText("");
            pursprice.setText("");
            purdiscount.setText("");
            purquantity.setText("");
            pursize.setText("");
            jLabel7.setText("*press ENTER to search stock");
            jLabel7.setForeground(Color.BLACK);
            dt();
        } 
        
    }//GEN-LAST:event_pur_add_detailsMouseClicked

    private void pursizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pursizeKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        purfindpr();
        
        }
    }//GEN-LAST:event_pursizeKeyPressed

    private void pursizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pursizeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_pursizeKeyTyped

    private void pursizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pursizeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_pursizeKeyReleased

    private void purquantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purquantityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_purquantityKeyTyped

    private void purbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purbrandActionPerformed

    private void alloysearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alloysearchMouseClicked
         //TODO add your handling code here:
       
        String alloy_size=alloy_size_s.getText();
        String alloy_brand=txtSearch.getText();
        String tp="alloy wheel";
        if(alloy_size.equalsIgnoreCase("")&&alloy_brand.equalsIgnoreCase("")){
         JOptionPane.showMessageDialog(null,"Enter Size or Brand");
         }else if( alloy_size != null&& alloy_brand.equalsIgnoreCase("")){
         
         
         try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND size=? ");
            pst.setString(1,tp );
            pst.setString(2,alloy_size );
            
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)alloytb.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         }
       
        else if( alloy_size.equalsIgnoreCase("")&& alloy_brand != null){
         
         
         try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND brand=?");
            pst.setString(1,tp );
           
            pst.setString(2,alloy_brand );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)alloytb.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         }
        else if( alloy_size != null && alloy_brand != null){
         
         
        
         
         try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND size=? AND brand=?");
            pst.setString(1,tp );
            pst.setString(2,alloy_size );
            pst.setString(3,alloy_brand );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)alloytb.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         }
        
    }//GEN-LAST:event_alloysearchMouseClicked

    private void refreshalltblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshalltblMouseClicked
        // TODO add your handling code here:
        alloytbl();
        txtSearch.setText("");
        alloy_size_s.setText("");
       
    }//GEN-LAST:event_refreshalltblMouseClicked

    private void tyresearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tyresearch1MouseClicked
        // TODO add your handling code here:
        connect();
        String tyre_size=tyre_size_s.getText();
        String tyre_brand=tyre_brand_s.getText();
        String tp="tyre";
        if(tyre_size.equalsIgnoreCase("")&&tyre_brand.equalsIgnoreCase("")){
         JOptionPane.showMessageDialog(null,"Enter Size or Brand");
         }else if( tyre_size != null&& tyre_brand.equalsIgnoreCase("")){
         
         
         try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND size=? ");
            pst.setString(1,tp );
            pst.setString(2,tyre_size );
            
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)tyretbl.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         }
       
        else if( tyre_size.equalsIgnoreCase("")&& tyre_brand != null){
         
         
         try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND brand=?");
            pst.setString(1,tp );
           
            pst.setString(2,tyre_brand );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)tyretbl.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         }
        else if( tyre_size != null && tyre_brand != null){
         
         
        
        try {
            
            pst=con.prepareStatement("SELECT * FROM products where category= ? AND size=? AND brand=?");
            pst.setString(1,tp );
            pst.setString(2,tyre_size );
            pst.setString(3,tyre_brand );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)tyretbl.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         }
    }//GEN-LAST:event_tyresearch1MouseClicked

    private void refreshtyretbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshtyretbl1MouseClicked
        // TODO add your handling code here:
        tyretbl();
        tyre_size_s.setText("");
         tyre_brand_s.setText("");
    }//GEN-LAST:event_refreshtyretbl1MouseClicked

    private void purbrandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purbrandKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        
        pursize.requestFocus();
        
        }
    }//GEN-LAST:event_purbrandKeyPressed

    private void purspriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purspriceKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_purspriceKeyTyped

    private void update_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_searchMouseClicked
        // TODO add your handling code here:
        
        updatefindpr();
        
        
        
    }//GEN-LAST:event_update_searchMouseClicked

    private void refreshalltbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshalltbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshalltbl1MouseClicked

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txtSearch.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void alloy_size_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alloy_size_sMouseClicked
        // TODO add your handling code here:
         if (search2.getItemSize() > 0) {
            menu2.show(alloy_size_s, 0, alloy_size_s.getHeight());
            search2.clearSelected();
        }
    }//GEN-LAST:event_alloy_size_sMouseClicked

    private void alloy_size_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alloy_size_sKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search2.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search2.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search2.getSelectedText();
            alloy_size_s.setText(text);
            menu2.setVisible(false);
        }
    }//GEN-LAST:event_alloy_size_sKeyPressed

    private void alloy_size_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alloy_size_sKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = alloy_size_s.getText().trim().toLowerCase();
            search2.setData(search2(text));
            if (search2.getItemSize() > 0) {
                //  * 2 top and bot border
                menu2.show(alloy_size_s, 0, alloy_size_s.getHeight());
                menu2.setPopupSize(menu2.getWidth(), (search2.getItemSize() * 35) + 2);
            } else {
                menu2.setVisible(false);
            }
        }
    }//GEN-LAST:event_alloy_size_sKeyReleased

    private void tyre_brand_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tyre_brand_sMouseClicked
        // TODO add your handling code here:
         if (search3.getItemSize() > 0) {
            menu3.show(tyre_brand_s, 0, tyre_brand_s.getHeight());
            search3.clearSelected();
        }
    }//GEN-LAST:event_tyre_brand_sMouseClicked

    private void tyre_brand_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_brand_sKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search3.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search3.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search3.getSelectedText();
            tyre_brand_s.setText(text);
            menu3.setVisible(false);
        }
    }//GEN-LAST:event_tyre_brand_sKeyPressed

    private void tyre_brand_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_brand_sKeyReleased
        // TODO add your handling code here:
          if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = tyre_brand_s.getText().trim().toLowerCase();
            search3.setData(search3(text));
            if (search3.getItemSize() > 0) {
                //  * 2 top and bot border
                menu3.show(tyre_brand_s, 0, tyre_brand_s.getHeight());
                menu3.setPopupSize(menu3.getWidth(), (search3.getItemSize() * 35) + 2);
            } else {
                menu3.setVisible(false);
            }
        }
    }//GEN-LAST:event_tyre_brand_sKeyReleased

    private void tyre_size_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tyre_size_sMouseClicked
        // TODO add your handling code here:
        if (search4.getItemSize() > 0) {
            menu4.show(tyre_size_s, 0, tyre_size_s.getHeight());
            search4.clearSelected();
        }
    }//GEN-LAST:event_tyre_size_sMouseClicked

    private void tyre_size_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_size_sKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search4.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search4.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search4.getSelectedText();
            tyre_size_s.setText(text);
            menu4.setVisible(false);
        }
    }//GEN-LAST:event_tyre_size_sKeyPressed

    private void tyre_size_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tyre_size_sKeyReleased
        // TODO add your handling code here:
           if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = tyre_size_s.getText().trim().toLowerCase();
            search4.setData(search4(text));
            if (search4.getItemSize() > 0) {
                //  * 2 top and bot border
                menu4.show(tyre_size_s, 0, tyre_size_s.getHeight());
                menu4.setPopupSize(menu4.getWidth(), (search4.getItemSize() * 35) + 2);
            } else {
                menu4.setVisible(false);
            }
        }
    }//GEN-LAST:event_tyre_size_sKeyReleased

    private void update_brand_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_brand_sMouseClicked
        // TODO add your handling code here:
        if (search5.getItemSize() > 0) {
            menu5.show(update_brand_s, 0, update_brand_s.getHeight());
            search5.clearSelected();
        }
        
    }//GEN-LAST:event_update_brand_sMouseClicked

    private void update_brand_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_brand_sKeyPressed
        // TODO add your handling code here:
        
         if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search5.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search5.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search5.getSelectedText();
            update_brand_s.setText(text);
            menu5.setVisible(false);
        }
    }//GEN-LAST:event_update_brand_sKeyPressed

    private void update_brand_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_brand_sKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = update_brand_s.getText().trim().toLowerCase();
            search5.setData(search5(text));
            if (search5.getItemSize() > 0) {
                //  * 2 top and bot border
                menu5.show(update_brand_s, 0, update_brand_s.getHeight());
                menu5.setPopupSize(menu5.getWidth(), (search5.getItemSize() * 35) + 2);
            } else {
                menu5.setVisible(false);
            }
        }
    }//GEN-LAST:event_update_brand_sKeyReleased

    private void update_size_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_size_sMouseClicked
        // TODO add your handling code here:
         if (search6.getItemSize() > 0) {
            menu6.show(update_size_s, 0, update_size_s.getHeight());
            search6.clearSelected();
        }
    }//GEN-LAST:event_update_size_sMouseClicked

    private void update_size_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_size_sKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search6.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search6.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search6.getSelectedText();
            update_size_s.setText(text);
            menu6.setVisible(false);
        }
         
    }//GEN-LAST:event_update_size_sKeyPressed

    private void update_size_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_size_sKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = update_size_s.getText().trim().toLowerCase();
            search6.setData(search6(text));
            if (search6.getItemSize() > 0) {
                //  * 2 top and bot border
                menu6.show(update_size_s, 0, update_size_s.getHeight());
                menu6.setPopupSize(menu6.getWidth(), (search6.getItemSize() * 35) + 2);
            } else {
                menu6.setVisible(false);
            }
        }
    }//GEN-LAST:event_update_size_sKeyReleased

    private void update_brandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_brandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_brandActionPerformed

    private void update_brandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_brandKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_brandKeyPressed

    private void update_sizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_sizeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_update_sizeKeyPressed

    private void update_sizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_sizeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_update_sizeKeyReleased

    private void update_sizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_sizeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_update_sizeKeyTyped

    private void update_sellingpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_sellingpKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_update_sellingpKeyTyped

    private void update_quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_update_quantityKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_update_quantityKeyTyped

    private void sales_retailpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sales_retailpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sales_retailpActionPerformed
    Double totalAmount=0.0;
    Double cash=0.0;
    Double balance=0.0;
    Double bHeight=0.0;
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now=LocalDateTime.now();
        String pdate=dt.format(now);
        try{
            int lastid=0;
            Double finalA;
            String query1="insert into sales(salesDate,totalAmount)values(?,?)";
            pst=con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, pdate);
            for(int i=0;i<tblSales.getRowCount();i++)
            {
                finalA = Double.parseDouble(tblSales.getValueAt(0, 6).toString());
                pst.setString(2, finalA.toString());
            }
            pst.executeUpdate();
            rs=pst.getGeneratedKeys();

            if(rs.next())
            {
                lastid=rs.getInt(1);

            }

            String query2="insert into salesitem(salesID,salesDate,brand,size,category,sellingPrice,discount,quantitiy,total) VALUES (?,?,?,?,?,?,?,?,?)";
            pst2=con.prepareStatement(query2);
            String pbrand;
            String psize;
            String pcategory;
            Double pbprice;

            Double pdis;
            Double pquantity;
            Double piAmount;

            for(int i=0;i<tblSales.getRowCount();i++)
            {

                psize=tblSales.getValueAt(i, 0).toString();
                pbrand=tblSales.getValueAt(i, 1).toString();
                pcategory=tblSales.getValueAt(i, 2).toString();
                pbprice=Double.parseDouble(tblSales.getValueAt(i, 3).toString());
                pquantity=Double.parseDouble(tblSales.getValueAt(i, 4).toString());
                pdis=Double.parseDouble(tblSales.getValueAt(i, 5).toString());

                piAmount=Double.parseDouble(tblSales.getValueAt(i, 6).toString());
                //
                pst2.setInt(1, lastid);
                pst2.setString(2, pdate);

                pst2.setString(3, pbrand);
                pst2.setString(4, psize);

                pst2.setString(5, pcategory);
                pst2.setDouble(6, pbprice);

                pst2.setDouble(7, pdis);
                pst2.setDouble(8, pquantity);
                pst2.setDouble(9, piAmount);
                pst2.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Balance();
        bHeight = Double.valueOf(tblSales.getRowCount());
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            pj.print();

        }
        catch (PrinterException ex) {
            ex.printStackTrace();
        }
        sales_brand.setText(" ");
        sales_size.setText(" ");
        sales_category.setText(" ");
        sales_retailp.setText(" ");
        sales_quantity.setText(" ");
        sales_discount.setText(" ");

    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        sales_brand.setText(" ");
        sales_size.setText(" ");
        sales_category.setText(" ");
        sales_retailp.setText(" ");
        sales_quantity.setText(" ");
        sales_discount.setText(" ");
        txtTotalPrice.setText(" ");
        txtBalance.setText(" ");
        txtPay.setText(" ");

    }//GEN-LAST:event_btnClearActionPerformed
    public void Balance(){
        
        Double total = Double.parseDouble(txtTotalPrice.getText());
        Double pay = Double.parseDouble(txtPay.getText());
        
        Double bal = pay - total;
        txtBalance.setText(String.valueOf(bal));
    }
    public void bill(){
        
        String total = txtTotalPrice.getText();
        String pay = txtPay.getText();
        String bal = txtBalance.getText();
        
           DefaultTableModel model = new DefaultTableModel();
           model=(DefaultTableModel)tblSales.getModel();
           
         // txtBill.setText(txt);
        
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        DefaultTableModel model = new DefaultTableModel();
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now=LocalDateTime.now();
        String pdate=dt.format(now);
        //
        String Brand =sales_brand.getText();
        String Size = sales_size.getText();
        String category = sales_category.getText();
        Double retailP = Double.parseDouble(sales_retailp.getText());
        Double quantity = Double.parseDouble(sales_quantity.getText());
        Double discount = Double.parseDouble(sales_discount.getText());
        //       Double totalP = Double.parseDouble(txtTotalPrice.getText());

        Double Amount = retailP * quantity;
        Double finalA = Amount - (Amount*discount);
        model=(DefaultTableModel)tblSales.getModel();
        model.addRow(new Object[]
            {
                Brand,
                Size,
                category,
                retailP,
                quantity,
                discount,
                finalA
            }   );

            Double sum=0.00;
            for(int i=0;i<tblSales.getRowCount();i++)
            {

                sum=sum+Double.parseDouble(tblSales.getValueAt(i, 6).toString());

            }
            txtTotalPrice.setText(String.valueOf(sum));

            sales_brand.setText(" ");
            sales_size.setText(" ");
            sales_category.setText(" ");
            sales_retailp.setText(" ");
            sales_quantity.setText(" ");
            sales_discount.setText(" ");
    }//GEN-LAST:event_btnAddActionPerformed

    private void sales_size_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_size_sMouseClicked
        // TODO add your handling code here:
         if (search6.getItemSize() > 0) {
            menu6.show(sales_size_s, 0, sales_size_s.getHeight());
            search6.clearSelected();
        }
    }//GEN-LAST:event_sales_size_sMouseClicked

    private void sales_size_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sales_size_sKeyPressed
        // TODO add your handling code here:
            if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search6.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search6.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search6.getSelectedText();
            sales_size_s.setText(text);
            menu6.setVisible(false);
        }
    }//GEN-LAST:event_sales_size_sKeyPressed

    private void sales_size_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sales_size_sKeyReleased
        // TODO add your handling code here:
          if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = sales_size_s.getText().trim().toLowerCase();
            search6.setData(search6(text));
            if (search6.getItemSize() > 0) {
                //  * 2 top and bot border
                menu6.show(sales_size_s, 0, sales_size_s.getHeight());
                menu6.setPopupSize(menu6.getWidth(), (search6.getItemSize() * 35) + 2);
            } else {
                menu6.setVisible(false);
            }
        }
    }//GEN-LAST:event_sales_size_sKeyReleased

    private void sales_brand_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_brand_sMouseClicked
        // TODO add your handling code here:
         if (search5.getItemSize() > 0) {
            menu5.show(sales_brand_s, 0, sales_brand_s.getHeight());
            search5.clearSelected();
        }
    }//GEN-LAST:event_sales_brand_sMouseClicked

    private void sales_brand_sKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sales_brand_sKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search5.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search5.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search5.getSelectedText();
            update_brand_s.setText(text);
            menu5.setVisible(false);
        }
    }//GEN-LAST:event_sales_brand_sKeyPressed

    private void sales_brand_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sales_brand_sKeyReleased
        // TODO add your handling code here:
          if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = sales_brand_s.getText().trim().toLowerCase();
            search5.setData(search5(text));
            if (search5.getItemSize() > 0) {
                //  * 2 top and bot border
                menu5.show(sales_brand_s, 0, sales_brand_s.getHeight());
                menu5.setPopupSize(menu5.getWidth(), (search5.getItemSize() * 35) + 2);
            } else {
                menu5.setVisible(false);
            }
        }
    }//GEN-LAST:event_sales_brand_sKeyReleased

    private void sales_selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_selectMouseClicked
        // TODO add your handling code here:
        DefaultTableModel Df = (DefaultTableModel)sales_select.getModel();

        int selectIndex = sales_select.getSelectedRow();

        sales_brand.setText(Df.getValueAt(selectIndex, 1).toString());
        sales_size.setText(Df.getValueAt(selectIndex, 2).toString());
        sales_category.setText(Df.getValueAt(selectIndex, 3).toString());
        sales_retailp.setText(Df.getValueAt(selectIndex, 5).toString());
        sales_discount.setText(Df.getValueAt(selectIndex, 6).toString());
        
        
        sales_quantity.requestFocus();
        

    }//GEN-LAST:event_sales_selectMouseClicked

    private void txtPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayKeyReleased
        // TODO add your handling code here:
        
      Double balance;
      Double salestot = Double.parseDouble(txtTotalPrice.getText());
      Double pay = Double.parseDouble(txtPay.getText());
      
      balance=salestot-pay;
      
     txtBalance.setText(String.valueOf(balance).trim());
      
      
      
    }//GEN-LAST:event_txtPayKeyReleased

    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    ArrayList<String> itemPrice = new ArrayList<>();
    ArrayList<String> subtotal = new ArrayList<>();
    
    public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double bodyHeight = bHeight;  
    double headerHeight = 5.0;                  
    double footerHeight = 5.0;        
    double width = cm_to_pp(8); 
    double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(0,10,width,height - cm_to_pp(1));  
            
    pf.setOrientation(PageFormat.PORTRAIT);  
    pf.setPaper(paper);    

    return pf;
}
    
     protected static double cm_to_pp(double cm)
    {            
	        return toPPI(cm * 0.393600787);            
    }
 
protected static double toPPI(double inch)
    {            
	        return inch * 72d;            
    }

public class BillPrintable implements Printable {
     public int print(Graphics graphics, PageFormat pageFormat,int pageIndex)throws PrinterException 
  {    
      
      int r= tblSales.getRowCount();
      ImageIcon icon=new ImageIcon("profile.png"); 
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    
            double width = pageFormat.getImageableWidth();                               
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 



          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        
        try{
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
           // int headerRectHeighta=40;
            
                
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);y+=yShift+30;
            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("       Dimuthu Tyre House        ",12,y);y+=yShift;
            g2d.drawString("   No 00000 Address Line One ",12,y);y+=yShift;
            g2d.drawString("   Address Line 02 SRI LANKA ",12,y);y+=yShift;
            g2d.drawString("   www.facebook.com/Softgenix ",12,y);y+=yShift;
            g2d.drawString("        +94700000000      ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

            g2d.drawString(" Brand                  Price   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
            
              for(int i=0;i<tblSales.getRowCount();i++)
             {
                
             g2d.drawString(" "+tblSales.getValueAt(i, 1).toString()+"                    "+tblSales.getValueAt(i, 6).toString()+" ",10,y);y+=yShift;
               
           
             }
          
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Total amount:               "+txtTotalPrice.getText()+"   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Cash      :                 "+txtPay.getText()+"   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString(" Balance   :                 "+txtBalance.getText()+"   ",10,y);y+=yShift;
  
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("       THANK YOU COME AGAIN            ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("       SOFTWARE BY:SOFTGENIX         ",10,y);y+=yShift;
            g2d.drawString("   CONTACT: softgenix@gmail.com       ",10,y);y+=yShift;       
           

    }
    catch(Exception e){
    e.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
} 
    
    public void purfindpr(){
    
        try {
            String psize=pursize.getText();
            String pbrand=purbrand.getText();
            
            if(psize.equalsIgnoreCase("")&&pbrand.equalsIgnoreCase("")){
                jLabel7.setForeground(Color.RED);
                jLabel7.setText("enter data to search stock");
            
         }else if( psize != null&& pbrand.equalsIgnoreCase("")){
             jLabel7.setForeground(Color.RED);
             jLabel7.setText("enter brand to search stock");
             
         
         }else if( psize.equalsIgnoreCase("")&& pbrand != null){
             jLabel7.setForeground(Color.RED);
             jLabel7.setText("enter size to search stock");
                     
         }else if( psize != null && pbrand != null){
            pst=con.prepareStatement("select *from products where size =? And brand=?");
            pst.setString(1,psize);
            pst.setString(2,pbrand);
            rs=pst.executeQuery();
            
            if(rs.next()==false)
            {
               jLabel7.setText("Item not found..\n Enter details manually");
               jLabel7.setForeground(Color.RED);
               purcategory.requestFocus();
               
            }
            else
            {
            pbrand=rs.getString("brand");
            String ptcategory=rs.getString("category");
            String pbuyingp=rs.getString("buying_price");
            String psellingp=rs.getString("selling_price");
            String pdiscount=rs.getString("selling_discount");
            purbrand.setText(pbrand.trim());
            
            if(ptcategory.equals("Alloy Wheel"))
                 {
                    purcategory.setSelectedIndex(2);
                     
                 }
                 else
                 {
                    purcategory.setSelectedIndex(1);
                 }
            
            
            purbprice.setText(pbuyingp.trim());
            pursprice.setText(psellingp.trim());
            purdiscount.setText(pdiscount.trim());
            
                
            
            
            purquantity.requestFocus();
            
            
            }
         }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

public void updatefindpr(){
    
        try {
            String psize=update_size_s.getText();
            String pbrand=update_brand_s.getText();
            
            if(psize.equalsIgnoreCase("")&&pbrand.equalsIgnoreCase("")){
                jLabel10.setForeground(Color.RED);
                jLabel10.setText("enter data to search stock");
            
         }else if( psize != null&& pbrand.equalsIgnoreCase("")){
             jLabel10.setForeground(Color.RED);
             jLabel10.setText("enter brand to search stock");
             
         
         }else if( psize.equalsIgnoreCase("")&& pbrand != null){
             jLabel10.setForeground(Color.RED);
             jLabel10.setText("enter size to search stock");
                     
         }else if( psize != null && pbrand != null){
            pst=con.prepareStatement("select *from products where size =? And brand=?");
            pst.setString(1,psize);
            pst.setString(2,pbrand);
            rs=pst.executeQuery();
            
            if(rs.next()==false)
            {
               jLabel10.setText("Item not found..\n Enter details manually");
               jLabel10.setForeground(Color.RED);
               update_brand_s.requestFocus();
               
            }
            else
            {
            pbrand=rs.getString("brand");
            String pcategory=rs.getString("category");
            
            String psellingp=rs.getString("selling_price");
            String pdiscount=rs.getString("selling_discount");
            String uqty=rs.getString("quantity");
            update_brand.setText(pbrand.trim());
            update_size.setText(psize.trim());
            
            if(pcategory.equals("Alloy Wheel"))
                 {
                    update_category.setSelectedIndex(2);
                     
                 }
                 else
                 {
                    update_category.setSelectedIndex(2);
                 }
            
            
            
            update_sellingp.setText(psellingp.trim());
            update_dis.setText(pdiscount.trim());
            update_quantity.setText(uqty.trim());
            
                
            
            
            
            
            
            }
         }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
public void puradd()
{
        
    
    
    
    
    
    
    
    
    
    
        Double bprice=Double.parseDouble(purbprice.getText());
        int purqty=Integer.parseInt(purquantity.getText());
        String p1size=pursize.getText();
        String p1brand=purbrand.getText();
        String p1cat=purcategory.getSelectedItem().toString().trim();
        Double p1sprice=Double.parseDouble(pursprice.getText());
        Double p1discount=Double.parseDouble(purdiscount.getText());
        Double purtot=bprice*purqty;
//        DateFormat da = new SimpleDateFormat("yyyy-MM-dd");
//        String pdate = da.format(purchasedate.getDate());

       
        
 
        df=(DefaultTableModel)pur_table.getModel();
        df.addRow(new Object[]
               
        {
       
           p1size,
           p1brand,
           p1cat,
           bprice,
           p1sprice,
           p1discount,
           purqty,
           purtot
        
        
        }   );
        
        
        Double sum=0.00;
        for(int i=0;i<pur_table.getRowCount();i++)
        {
        
        sum=sum+Double.parseDouble(pur_table.getValueAt(i, 7).toString());
        
        }
        
        pur_totalcost.setText(String.valueOf(sum));

}

public void addtostock()
{
         connect();
        try {
            DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now=LocalDateTime.now();
            String pdate=dt.format(now);
            
            String ptotalc=pur_totalcost.getText();
            
            
            int lastid=0;
            
            String query1="insert into purchase(P_Date,Total_cost)values(?,?)";
            pst=con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, pdate);
            pst.setString(2, ptotalc);
            pst.executeUpdate();
            rs=pst.getGeneratedKeys();
            
            if(rs.next())
            {
            lastid=rs.getInt(1);
            
            }
            
            
            String query2="insert into purchase_item(Purchase_id,Received_Date,Brand,Size,Category,Buying_Price,Selling_Price,Discount,Quantity,Total) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst1=con.prepareStatement(query2);
             String pbrand;
             String psize;
             String pcategory;
             Double pbprice;
             Double psprice;
             Double pdis;
             int pquantity;
             Double pitemtot;
             
             for(int i=0;i<pur_table.getRowCount();i++)
             {
              
              psize=pur_table.getValueAt(i, 0).toString();
              pbrand=pur_table.getValueAt(i, 1).toString();
              pcategory=pur_table.getValueAt(i, 2).toString();
//              pbprice=(int)pur_table.getValueAt(i, 3);
//              psprice=(int)pur_table.getValueAt(i, 4);
//              pdis=(int)pur_table.getValueAt(i, 5);
//              pquantity=(int)pur_table.getValueAt(i, 6);
//              pitemtot=(int)pur_table.getValueAt(i, 7);
              
              
              pbprice=Double.parseDouble(pur_table.getValueAt(i, 3).toString());
              psprice=Double.parseDouble(pur_table.getValueAt(i, 4).toString());
              pdis=Double.parseDouble(pur_table.getValueAt(i, 5).toString());
              pquantity=Integer.parseInt(pur_table.getValueAt(i, 6).toString());
              pitemtot=Double.parseDouble(pur_table.getValueAt(i, 7).toString());
//             

                pst1.setInt(1, lastid);
                pst1.setString(2, pdate);
                pst1.setString(3, psize);
                pst1.setString(4, pbrand);
                pst1.setString(5, pcategory);
                pst1.setDouble(6, pbprice);
                pst1.setDouble(7, psprice);
                pst1.setDouble(8, pdis);
                pst1.setInt(9, pquantity);
               pst1.setDouble(10, pitemtot);
               pst1.executeUpdate();
             }
             
            
             
             
             
             
             
             for(int i=0;i<pur_table.getRowCount();i++)
             {
             
              psize=pur_table.getValueAt(i, 0).toString();
              
              pst2=con.prepareStatement("select *from products where size =?");
              pst2.setString(1,psize);
              rs=pst2.executeQuery();
              
              if(rs.next()==false)
            {
               String query3="insert into productS(brand,size,category,buying_price,selling_price,selling_discount,quantity) VALUES (?,?,?,?,?,?,?)";
               pst2=con.prepareStatement(query3);
               
               
              
              psize=pur_table.getValueAt(i, 0).toString();
              pbrand=pur_table.getValueAt(i, 1).toString();
              pcategory=pur_table.getValueAt(i, 2).toString();
              pbprice=Double.parseDouble(pur_table.getValueAt(i, 3).toString());
              psprice=Double.parseDouble(pur_table.getValueAt(i, 4).toString());
              pdis=Double.parseDouble(pur_table.getValueAt(i, 5).toString());
              pquantity=Integer.parseInt(pur_table.getValueAt(i, 6).toString());
             
             

               
                
                pst2.setString(2, psize);
                pst2.setString(1, pbrand);
                pst2.setString(3, pcategory);
                pst2.setDouble(4, pbprice);
                pst2.setDouble(5, psprice);
                pst2.setDouble(6, pdis);
                pst2.setDouble(7, pquantity);
                 
                pst2.executeUpdate();
                
             
               
               
               
            }
              else
            {
                    String query3 ="update products set quantity=quantity+ ? where size=? ";
                    pst2=con.prepareStatement(query3);
                    pquantity=Integer.parseInt(pur_table.getValueAt(i, 6).toString());
              
               
                     pst2.setInt(1, pquantity);
                     pst2.setString(2, psize);
                     pst2.executeUpdate();
                    }
            
                
            
            }
              
              
            
              
              
              
              
              
              
              
            
             
             JOptionPane.showMessageDialog(this,"complete" );
             
             
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
          
}
public void chartdash()
{

 try
      {
          Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dimuthu_tyre", "root", "");
         final String SQL = "SELECT pattern,net_price_with_vat FROM tyre_products";
    Statement statement = con.createStatement( );
      ResultSet resultSet = statement.executeQuery("SELECT * FROM tyre_products" );
            DefaultPieDataset dataset = new DefaultPieDataset( );
             while( resultSet.next( ) ) {
         dataset.setValue(resultSet.getString("pattern"),Double.parseDouble( resultSet.getString( "net_price_with_vat" )));
      }
       JFreeChart chart = ChartFactory.createPieChart("Report", dataset,true,true,false );
        ChartPanel chartpanel = new ChartPanel(chart);
   
         final String SQL2 = "SELECT pattern,net_price_with_vat FROM tyre_products";
            final CategoryDataset dataset2 = new JDBCCategoryDataset(con, SQL2);
         JFreeChart chart2 = ChartFactory.createBarChart("Report","X-Axis","Y-Axis", dataset2, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot catplot = chart2.getCategoryPlot();
        catplot.setRangeGridlinePaint(Color.BLACK);
          ChartPanel chartpanel2 = new ChartPanel(chart2);
 GridLayout layout = new GridLayout(0,2);
   statisticsp.setLayout(layout);
     statisticsp.removeAll();
        statisticsp.add(chartpanel);
        statisticsp.add(chartpanel2);
        chartpanel.setVisible(true);
       chartpanel.setSize(1000,650);
        chartpanel2.setVisible(true);
       chartpanel2.setSize(1000,650);
       statisticsp.validate();    
      }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        


}

public void  alloytbl()
    {
        connect();
        try {
            String tp="alloy wheel";
            pst=con.prepareStatement("SELECT * FROM products where category= ?");
            pst.setString(1,tp );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)alloytb.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
             
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void  tyretbl()
    {
        connect();
        
        try {
            String tp="tyre";
            pst=con.prepareStatement("SELECT * FROM products where category= ?");
            pst.setString(1,tp );
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)tyretbl.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
             
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void  productstbl()
    {
      
        try {
            
            pst=con.prepareStatement("SELECT * FROM products ");
           
            
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
             int c;
             c = rsm.getColumnCount();
             
             DefaultTableModel Df = (DefaultTableModel)sales_select.getModel();
             Df.setRowCount(0);
             
             while(rs.next())
             {
                 Vector v4 = new Vector();
                 
                 for(int i = 1; i<= c; i ++)
                 {
                  
                  
                  v4.add(rs.getString("product_id"));
                  v4.add(rs.getString("brand"));
                  v4.add(rs.getString("size"));
                  v4.add(rs.getString("category"));
                  v4.add(rs.getString("buying_price"));
                  v4.add(rs.getString("selling_price"));
                  v4.add(rs.getString("selling_discount"));
                  v4.add(rs.getString("quantity"));
                  
                 }
                 
                 Df.addRow(v4);
                  
              
                 
                 
             }
             
             
             
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

    

    


    public static void main(String args[]) {

        /* Create and display the formss */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Balance;
    private swing.MyTextField alloy_size_s;
    private javax.swing.JPanel alloyp;
    private javax.swing.JPanel alloysearch;
    private javax.swing.JPanel alloysecp;
    private javax.swing.JTable alloytb;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JPanel chart1st;
    private javax.swing.JPanel chart2st;
    private MainPackage.custom custom2;
    private MainPackage.custom custom3;
    private javax.swing.JPanel dashbtn;
    private javax.swing.JLabel dashdate;
    private javax.swing.JLabel dashlbl;
    private javax.swing.JLabel dashlbl1;
    private javax.swing.JPanel dashp;
    private javax.swing.JLabel dashtime;
    private javax.swing.JLabel errortxt;
    private javax.swing.JPanel itembtn;
    private javax.swing.JLabel itemlbl;
    private javax.swing.JLabel itemlbl1;
    private javax.swing.JLabel itemlbl2;
    private javax.swing.JLabel itemlbl3;
    private javax.swing.JLabel itemlbl4;
    private javax.swing.JLabel itemlbl5;
    private javax.swing.JLabel itemlbl6;
    private javax.swing.JPanel itemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JPanel pur_add_details;
    private javax.swing.JPanel pur_add_details2;
    private javax.swing.JPanel pur_addstock;
    private javax.swing.JPanel pur_clear_details;
    private javax.swing.JTable pur_table;
    private javax.swing.JLabel pur_totalcost;
    private javax.swing.JTextField purbprice;
    private javax.swing.JTextField purbrand;
    private javax.swing.JComboBox<String> purcategory;
    private javax.swing.JPanel purchasebtn;
    private javax.swing.JLabel purchaselbl;
    private javax.swing.JPanel purchasep;
    private javax.swing.JTextField purdiscount;
    private javax.swing.JTextField purquantity;
    private javax.swing.JLabel purs;
    private javax.swing.JTextField pursize;
    private javax.swing.JTextField pursprice;
    private javax.swing.JPanel purtb_clear;
    private javax.swing.JPanel purtb_del;
    private javax.swing.JPanel refreshalltbl;
    private javax.swing.JPanel refreshalltbl1;
    private javax.swing.JPanel refreshtyretbl1;
    private javax.swing.JTextField sales_brand;
    private swing.MyTextField sales_brand_s;
    private javax.swing.JTextField sales_category;
    private javax.swing.JTextField sales_discount;
    private javax.swing.JTextField sales_quantity;
    private javax.swing.JTextField sales_retailp;
    private javax.swing.JTable sales_select;
    private javax.swing.JTextField sales_size;
    private swing.MyTextField sales_size_s;
    private javax.swing.JPanel salesbtn;
    private javax.swing.JLabel saleslbl;
    private javax.swing.JLabel saleslbl1;
    private javax.swing.JLabel saleslbl2;
    private javax.swing.JLabel saleslbl3;
    private javax.swing.JPanel salesp;
    private javax.swing.JPanel statisticsbtn;
    private javax.swing.JLabel statisticslbl;
    private javax.swing.JPanel statisticsp;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtPay;
    private swing.MyTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private swing.MyTextField tyre_brand_s;
    private swing.MyTextField tyre_size_s;
    private javax.swing.JPanel tyrep;
    private javax.swing.JPanel tyresearch1;
    private javax.swing.JPanel tyresecp;
    private javax.swing.JTable tyretbl;
    private javax.swing.JTextField update_brand;
    private swing.MyTextField update_brand_s;
    private javax.swing.JComboBox<String> update_category;
    private javax.swing.JTextField update_dis;
    private javax.swing.JTextField update_quantity;
    private javax.swing.JPanel update_search;
    private javax.swing.JTextField update_sellingp;
    private javax.swing.JTextField update_size;
    private swing.MyTextField update_size_s;
    private javax.swing.JPanel updatebtn;
    private javax.swing.JLabel updatelbl;
    private javax.swing.JPanel updatep;
    private org.jdatepicker.impl.UtilCalendarModel utilCalendarModel1;
    private org.jdatepicker.impl.UtilCalendarModel utilCalendarModel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
