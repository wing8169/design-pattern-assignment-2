/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ritz619
 */
public class MUI extends javax.swing.JFrame implements AcquaintanceIterator {

    /**
     * Creates new form MUI
     */
    private AcquaintanceFactory Acquaintancesfactory;
    private static ArrayList<ArrayList<Acquaintances>> acquaintances;
    private static ArrayList<Acquaintances> personalFriends;
    private static ArrayList<Acquaintances> relatives;
    private static ArrayList<Acquaintances> professionalFriends;
    private static ArrayList<Acquaintances> casualAcquaintances;
    private ArrayList<ArrayList<Acquaintances>> temp;
    private int categoryIndex;
    private int ArrayListIndex;
    private Scanner reader;
    private boolean addOrEditFlag;
    private boolean detailsFlag;
    private String op;
    private String searchString;
    private static MUI manager;

    private MUI() {
        initComponents();
        String[] columnNames = {"S.No", "Name", "Mobile", " Email"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        jXTable1.setModel(model);
        setUpTableData();
        reader = new Scanner(System.in);
        acquaintances = new ArrayList<>();
        personalFriends = new ArrayList<>();
        relatives = new ArrayList<>();
        professionalFriends = new ArrayList<>();
        casualAcquaintances = new ArrayList<>();
        acquaintances.add(personalFriends);
        acquaintances.add(relatives);
        acquaintances.add(professionalFriends);
        acquaintances.add(casualAcquaintances);
        Acquaintancesfactory = new AcquaintanceFactory();
    }

    public static MUI getInstance() {
        if (MUI.manager == null) {
            manager = new MUI();
        }
        return manager;
    }

    public void setDescription() {
        name.setText("");
        mobile.setText("");
        email.setText("");
        one.setText("");
        two.setText("");
        three.setText("");

        if (!detailsFlag) {
            name.setEditable(true);
            mobile.setEditable(true);
            email.setEditable(true);
            one.setEditable(true);
            two.setEditable(true);
            three.setEditable(true);
        }
        if (addOrEditFlag) {
            op = "Add";
            jButton10.setText("Add");
        } else {
            op = "Edit";
            jButton10.setText("Save");
            Acquaintances e = acquaintances.get(categoryIndex).get(ArrayListIndex);
            name.setText(e.getName());
            mobile.setText(e.getMobileNo());
            email.setText(e.getEmail());
            switch (categoryIndex) {
                case 0:
                    PersonalFriends perF = (PersonalFriends) e;
                    one.setText(perF.getEvents());
                    two.setText(perF.getAContext());
                    three.setText(perF.getADate());
                    break;
                case 1:
                    Relatives rel = (Relatives) e;
                    one.setText(rel.getBDate());
                    two.setText(rel.getLDate());
                    break;
                case 2:
                    ProfessionalFriends proF = (ProfessionalFriends) e;
                    one.setText(proF.getCommonInterests());
                    break;
                case 3:
                    CasualAcquaintances ca = (CasualAcquaintances) e;
                    one.setText(ca.getWhenWhere());
                    two.setVisible(true);
                    three.setVisible(true);
                    two.setText(ca.getCircumstances());
                    three.setText(ca.getOtherInfo());
                    break;
                default:
                    break;
            }
        }
        jButton10.setVisible(true);
        jButton11.setVisible(true);
        switch (categoryIndex) {
            case 0:
                one.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                jLabel7.setText("Specific Events:");
                jLabel8.setText("First Acquaintance Context:");
                jLabel9.setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
                Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane6.setVisible(true);
                break;
            case 1:
                one.setVisible(true);
                two.setVisible(true);
                three.setVisible(false);
                jLabel7.setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
                jLabel8.setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");
                jLabel9.setText("");
                Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(false);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(false);
                jScrollPane6.setVisible(true);
                break;
            case 2:
                one.setVisible(true);
                two.setVisible(false);
                three.setVisible(false);
                jLabel7.setText("Common Interests: ");
                jLabel8.setText("");
                jLabel9.setText("");
                Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setVisible(true);
                jLabel8.setVisible(false);
                jLabel9.setVisible(false);
                jScrollPane4.setVisible(false);
                jScrollPane5.setVisible(false);
                jScrollPane6.setVisible(true);
                break;
            case 3:
                one.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Casual Acquaintances Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("First meeting time & location:");
                jLabel8.setText("First meeting CIrcumstances:");
                jLabel9.setText("Other useful information:");
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane6.setVisible(true);
                break;
            default:
                break;
        }

        if (detailsFlag) {
            name.setEditable(false);
            mobile.setEditable(false);
            email.setEditable(false);
            one.setEditable(false);
            two.setEditable(false);
            three.setEditable(false);
            jButton10.setText("Back to main menu");
            jButton11.setVisible(false);
            Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
        }
    }

    public final void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jXTable1.getModel();
        tableModel.setRowCount(0);
        ArrayList<Acquaintances> list;
        try {
            list = acquaintances.get(Categories.getSelectedIndex());
        } catch (Exception e) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[4];
            data[0] = Integer.toString(i + 1);
            data[1] = list.get(i).getName();
            data[2] = list.get(i).getMobileNo();
            data[3] = list.get(i).getEmail();
            tableModel.addRow(data);
        }
        jXTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main_Menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addContact = new javax.swing.JButton();
        deleteContact = new javax.swing.JButton();
        searchContact = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Categories = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editContact = new javax.swing.JButton();
        detailOfContact = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Display_Details = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextPane();
        jButton9 = new javax.swing.JButton();
        Operation_Menu = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        two = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        three = new javax.swing.JTextArea();
        jButton10 = new javax.swing.JButton();
        mobile = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        one = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu Medium", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><u>Contact Management System</u></html>");

        addContact.setText("Add");
        addContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactActionPerformed(evt);
            }
        });

        deleteContact.setText("Delete");
        deleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactActionPerformed(evt);
            }
        });

        searchContact.setText("Search");
        searchContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchContactActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Categories.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Personal Friends", "Relatives", "Professional Friends", "Casual Acquaintances" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        Categories.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                CategoriesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Categories);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.No", "Name", "Mobile No", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jXTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
        jLabel1.setText("Select Category:");

        jLabel3.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
        jLabel3.setText("Details:");

        editContact.setText("Edit");
        editContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContactActionPerformed(evt);
            }
        });

        detailOfContact.setText("View full detail");
        detailOfContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailOfContactActionPerformed(evt);
            }
        });

        jButton7.setText("Read from file");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Save as file");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Main_MenuLayout = new javax.swing.GroupLayout(Main_Menu);
        Main_Menu.setLayout(Main_MenuLayout);
        Main_MenuLayout.setHorizontalGroup(
            Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Main_MenuLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Main_MenuLayout.createSequentialGroup()
                                .addComponent(detailOfContact)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7))
                            .addGroup(Main_MenuLayout.createSequentialGroup()
                                .addComponent(addContact, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main_MenuLayout.createSequentialGroup()
                                .addComponent(editContact, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchContact, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Main_MenuLayout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addComponent(jLabel2)
                    .addGroup(Main_MenuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Main_MenuLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Main_MenuLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addContact, deleteContact, detailOfContact, editContact, jButton4, jButton7, jButton8, searchContact});

        Main_MenuLayout.setVerticalGroup(
            Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Main_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteContact)
                        .addComponent(addContact))
                    .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchContact)
                        .addComponent(editContact)))
                .addGap(18, 18, 18)
                .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton8))
                    .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(detailOfContact)
                        .addComponent(jButton7)))
                .addGap(49, 49, 49)
                .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(Main_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Main_Menu, "card2");

        details.setEditable(false);
        jScrollPane3.setViewportView(details);

        jButton9.setText("Back to main menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Display_DetailsLayout = new javax.swing.GroupLayout(Display_Details);
        Display_Details.setLayout(Display_DetailsLayout);
        Display_DetailsLayout.setHorizontalGroup(
            Display_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Display_DetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Display_DetailsLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Display_DetailsLayout.setVerticalGroup(
            Display_DetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Display_DetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addGap(21, 21, 21))
        );

        getContentPane().add(Display_Details, "card3");

        Operation_Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

        jLabel4.setText("Name:");

        jLabel5.setText("Mobile No:");

        jLabel6.setText("Email:");

        jLabel7.setText("First meeting time & location:");

        jLabel8.setText("First meeting CIrcumstances:");

        jLabel9.setText("Other useful information:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        two.setColumns(20);
        two.setRows(5);
        two.setAutoscrolls(false);
        jScrollPane4.setViewportView(two);

        three.setColumns(20);
        three.setRows(5);
        jScrollPane5.setViewportView(three);

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        one.setColumns(20);
        one.setRows(5);
        jScrollPane6.setViewportView(one);

        jButton11.setText("Cancel");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Operation_MenuLayout = new javax.swing.GroupLayout(Operation_Menu);
        Operation_Menu.setLayout(Operation_MenuLayout);
        Operation_MenuLayout.setHorizontalGroup(
            Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Operation_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Operation_MenuLayout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(132, 132, 132)))
                .addContainerGap())
        );
        Operation_MenuLayout.setVerticalGroup(
            Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Operation_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Operation_MenuLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8))
                    .addGroup(Operation_MenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Operation_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addGap(3, 3, 3))
        );

        getContentPane().add(Operation_Menu, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactActionPerformed
        int index = Categories.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Select a category!");
            return;
        }
        Main_Menu.setVisible(false);
        Operation_Menu.setVisible(true);
        categoryIndex = index;
        addOrEditFlag = true;
        detailsFlag = false;
        setDescription();
    }//GEN-LAST:event_addContactActionPerformed

    private void deleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteContactActionPerformed
        int index = Categories.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Select a category!");
            return;
        }
        int table_index = jXTable1.getSelectedRow();
        if (table_index < 0) {
            JOptionPane.showMessageDialog(this, "Select an entry!");
            return;
        }
        int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            acquaintances.get(index).remove(table_index);
            JOptionPane.showMessageDialog(this, "Successfully Deleted");
            this.setUpTableData();
        }
    }//GEN-LAST:event_deleteContactActionPerformed

    private void searchContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchContactActionPerformed
        String s = (String) JOptionPane.showInputDialog(this, "Enter name: ", "Input", JOptionPane.PLAIN_MESSAGE, null, null, "");
        if (s == null) {
            return;
        }
        Main_Menu.setVisible(false);
        Display_Details.setVisible(true);
        searchString = s;
        details.setContentType("text/html");
        runn();
    }//GEN-LAST:event_searchContactActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CategoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_CategoriesValueChanged
        setUpTableData();
    }//GEN-LAST:event_CategoriesValueChanged

    private void editContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContactActionPerformed
        int index = Categories.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Select a category!");
            return;
        }
        int table_index = jXTable1.getSelectedRow();
        if (table_index < 0) {
            JOptionPane.showMessageDialog(this, "Select an entry!");
            return;
        }
        ArrayListIndex = table_index;
        addOrEditFlag = false;
        detailsFlag = false;
        categoryIndex = index;
        setDescription();
        Main_Menu.setVisible(false);
        Operation_Menu.setVisible(true);
    }//GEN-LAST:event_editContactActionPerformed

    private void detailOfContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailOfContactActionPerformed
        int index = Categories.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if (tindex < 0) {
            JOptionPane.showMessageDialog(this, "Select an entry!");
            return;
        }
        ArrayListIndex = tindex;
        addOrEditFlag = false;
        categoryIndex = index;
        Main_Menu.setVisible(false);
        Operation_Menu.setVisible(true);
        detailsFlag = true;
        setDescription();
    }//GEN-LAST:event_detailOfContactActionPerformed

    public void runn() {
        String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        int j = 0;
        for (int i = 0; i < acquaintances.get(0).size(); i++) {
            if (acquaintances.get(0).get(i).getName().matches(searchString)) {
                j++;
                PersonalFriends perF = (PersonalFriends) acquaintances.get(0).get(i);
                if (j == 1) {
                    s = s.concat("<br>I. Personal Friends<br>");
                }
                s = s.concat(j + ". Name: " + perF.getName() + "<br>");
                s = s.concat("Mobile No: " + perF.getMobileNo() + "<br>");
                s = s.concat("Email: " + perF.getEmail() + "<br>");
                s = s.concat("Specific events: " + perF.getEvents() + "<br>");
                s = s.concat("First Acquaintance context: " + perF.getAContext() + "<br>");
                s = s.concat("First Acquaintance date: " + perF.getADate() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < acquaintances.get(1).size(); i++) {
            if (acquaintances.get(1).get(i).getName().matches(searchString)) {
                j++;
                Relatives rel = (Relatives) acquaintances.get(1).get(i);
                if (j == 1) {
                    s = s.concat("<br>II. Relatives<br>");
                }
                s = s.concat(j + ". Name: " + rel.getName() + "<br>");
                s = s.concat("Mobile No: " + rel.getMobileNo() + "<br>");
                s = s.concat("Email: " + rel.getEmail() + "<br>");
                s = s.concat("Relatives Birthday: " + rel.getBDate() + "<br>");
                s = s.concat("Last met date: " + rel.getLDate() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < acquaintances.get(2).size(); i++) {
            if (acquaintances.get(2).get(i).getName().matches(searchString)) {
                j++;
                ProfessionalFriends proF = (ProfessionalFriends) acquaintances.get(2).get(i);
                if (j == 1) {
                    s = s.concat("<br>III. Professional Friends<br>");
                }
                s = s.concat(j + ". Name: " + proF.getName() + "<br>");
                s = s.concat("Mobile No: " + proF.getMobileNo() + "<br>");
                s = s.concat("Email: " + proF.getEmail() + "<br>");
                s = s.concat("Common Interests: " + proF.getCommonInterests() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < acquaintances.get(3).size(); i++) {
            if (acquaintances.get(3).get(i).getName().matches(searchString)) {
                j++;
                CasualAcquaintances ca = (CasualAcquaintances) acquaintances.get(3).get(i);
                if (j == 1) {
                    s = s.concat("<br>IV. Casual Acquaintances<br>");
                }
                s = s.concat(j + ". Name: " + ca.getName() + "<br>");
                s = s.concat("Mobile No: " + ca.getMobileNo() + "<br>");
                s = s.concat("Email: " + ca.getEmail() + "<br>");
                s = s.concat("First met location & time: " + ca.getWhenWhere() + "<br>");
                s = s.concat("First met circumstances: " + ca.getCircumstances() + "<br>");
                s = s.concat("Other useful information: " + ca.getOtherInfo() + "<br>");
            }
        }
        if (s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")) {
            s = "<html>No result found</html>";
        } else {
            s = s.concat("</html>");
        }
        details.setText(s);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                temp = (ArrayList<ArrayList<Acquaintances>>) SerializationUtil.deserialize(selectedFile);
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(this, "Error");
                return;
            }
        } else {
            return;
        }
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < temp.get(i).size(); j++) {
                    acquaintances.get(i).add(temp.get(i).get(j));
                }
            }
        } catch (Exception e) {

        }
        this.setUpTableData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                this,
                "Enter file name: (*.ser)",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "output.ser");
        if (s == null) {
            return;
        }
        if (!s.endsWith(".ser")) {
            JOptionPane.showMessageDialog(this, "File name should end with .ser");
            return;
        }
        File[] fileList = (new File(".")).listFiles((File pathname) -> pathname.getName().endsWith(".ser"));
        boolean flag = false;
        for (File f : fileList) {
            if (f.getName().matches(s)) {
                flag = true;
            }
        }
        if (flag) {
            int q = JOptionPane.showConfirmDialog(this, s + " already exists:\nAre you sure you want to overwrite?");
            if (q != 0) {
                return;
            }
        }
        try {
            SerializationUtil.serialize(acquaintances, s);
        } catch (IOException e) {
            return;
        }
        JOptionPane.showMessageDialog(this, s + " saved successfully");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Display_Details.setVisible(false);
        Main_Menu.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed


    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        detailsFlag = true;
        String Name = name.getText();
        if (Name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a name");
            return;
        }
        String Mobile = mobile.getText();
        if (!MobileNoChecker.MobileNoChecker(Mobile)) {
            JOptionPane.showMessageDialog(this, "Enter a valid mobile number (6-15 digits)");
            return;
        }
        String Email = email.getText();
        if (!Email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Enter a valid email");
            return;
        }
        String One, Two, Three;
        switch (categoryIndex) {
            case 0: //perF
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if (!DateChecker.validDate(Three)) {
                    JOptionPane.showMessageDialog(this, "Enter a valid date");
                    return;
                }
                if (Three.isEmpty() || Three.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                PersonalFriends personalF;
                if (addOrEditFlag) {
                    personalF = (PersonalFriends) Acquaintancesfactory.createAcquaintance("PersonalFriends");
                } else {
                    personalF = (PersonalFriends) acquaintances.get(categoryIndex).get(ArrayListIndex);
                }
                personalF.setName(Name);
                personalF.setMobileNo(Mobile);
                personalF.setEmail(Email);
                personalF.setEvents(One);
                personalF.setAContext(Two);
                personalF.setADate(Three);
                personalF.setAnnoyingAbility(new CantAnnoy());
                System.out.println(personalF.tryToAnnoy());
                if (addOrEditFlag) {
                    acquaintances.get(categoryIndex).add(personalF);
                }
                break;
            case 1: //rel
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if (!DateChecker.validDate(One)) {
                    JOptionPane.showMessageDialog(this, "Enter a valid date");
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if (!DateChecker.validDate(Two)) {
                    return;
                }
                Relatives rel;
                if (addOrEditFlag) {
                    rel = (Relatives) Acquaintancesfactory.createAcquaintance("Relatives");
                } else {
                    rel = (Relatives) acquaintances.get(categoryIndex).get(ArrayListIndex);
                }
                rel.setName(Name);
                rel.setMobileNo(Mobile);
                rel.setEmail(Email);
                rel.setBDate(One);
                rel.setLDate(Two);
                rel.setAnnoyingAbility(new CanAnnoy());
                System.out.println(rel.tryToAnnoy());
                if (addOrEditFlag) {
                    acquaintances.get(categoryIndex).add(rel);
                }
                break;
            case 2: //proF
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                ProfessionalFriends proF;
                if (addOrEditFlag) {
                    proF = (ProfessionalFriends) Acquaintancesfactory.createAcquaintance("ProfessionalFriends");
                } else {
                    proF = (ProfessionalFriends) acquaintances.get(categoryIndex).get(ArrayListIndex);
                }
                proF.setName(Name);
                proF.setMobileNo(Mobile);
                proF.setEmail(Email);
                proF.setCommonInterests(One);
                proF.setAnnoyingAbility(new CantAnnoy());
                System.out.println(proF.tryToAnnoy());
                if (addOrEditFlag) {
                    acquaintances.get(categoryIndex).add(proF);
                }
                break;
            case 3: //ca
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if (Three.isEmpty() || Three.length() > 300) {
                    JOptionPane.showMessageDialog(this, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                CasualAcquaintances ca;
                if (addOrEditFlag) {
                    ca = (CasualAcquaintances) Acquaintancesfactory.createAcquaintance("CasualAcquaintances");
                } else {
                    ca = (CasualAcquaintances) acquaintances.get(categoryIndex).get(ArrayListIndex);
                }
                ca.setName(Name);
                ca.setMobileNo(Mobile);
                ca.setEmail(Email);
                ca.setWhenWhere(One);
                ca.setCircumstances(Two);
                ca.setOtherInfo(Three);
                ca.setAnnoyingAbility(new CantAnnoy());
                System.out.println(ca.tryToAnnoy());
                if (addOrEditFlag) {
                    acquaintances.get(categoryIndex).add(ca);
                }
                break;
            default:
                break;
        }
        Main_Menu.setVisible(true);
        Operation_Menu.setVisible(false);
        this.setUpTableData();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Main_Menu.setVisible(true);
        Operation_Menu.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Categories;
    private javax.swing.JPanel Display_Details;
    private javax.swing.JPanel Main_Menu;
    private javax.swing.JPanel Operation_Menu;
    private javax.swing.JButton addContact;
    private javax.swing.JButton deleteContact;
    private javax.swing.JButton detailOfContact;
    private javax.swing.JTextPane details;
    private javax.swing.JButton editContact;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea one;
    private javax.swing.JButton searchContact;
    private javax.swing.JTextArea three;
    private javax.swing.JTextArea two;
    // End of variables declaration//GEN-END:variables

    @Override
    public Iterator getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < acquaintances.get(categoryIndex).size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return acquaintances.get(categoryIndex).get(index++);
            }
            return null;
        }
    }
}
