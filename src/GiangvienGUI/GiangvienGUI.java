package GiangvienGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import QLGV.Item;
import QLGV.Major;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class GiangvienGUI extends JFrame {

    public static List<Major> list = new ArrayList<>();
    private GiangvienManagerDetail cmd = new GiangvienManagerDetail();
    Locale locale = new Locale("en", "EN");
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    private static int id;

    private JPanel contentPane;
    private JLabel lblNewLabel2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JTextField textName;
    private JTextField textPrice;
    private JTextField textCredits;
    private JTextField textNamesv;
    private JTextField textYear;
    private JTable table = new JTable();
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private JButton btnReset;
    private JComboBox comboBox;
    private JTextField textSearch;
    private JButton btnSearch;
    private JComboBox cbSort;
    private JButton btnSort;
    private JComboBox cbIsNC;
    /**
     * @wbp.nonvisual location=-60,454
     */
    private final JTextField textField = new JTextField();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GiangvienGUI frame = new GiangvienGUI();
                    frame.setTitle("QUẢN LÍ GIẢNG VIÊN");
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public GiangvienGUI() throws IOException, ClassNotFoundException {
        textField.setToolTipText("");
        textField.setColumns(10);
        initTable();
        list = FileGiangvien.binaryInputFile("Giangvien.bin", FileGiangvien.countObject());
        fillTable(list);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 759, 661);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBackground(Color.WHITE);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(10, 351, 730, 23);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnExit.setBounds(260, 593, 158, 25);
        contentPane.add(btnExit);

        JLabel lblNewLabel = new JLabel("QUẢN LÍ GIẢNG VIÊN");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(180, 0, 381, 41);
        contentPane.add(lblNewLabel);

        lblNewLabel2 = new JLabel("SỐ TÍN DẠY");
        lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel2.setBounds(10, 121, 169, 28);
        contentPane.add(lblNewLabel2);

        lblNewLabel_3 = new JLabel("GIẢNG VIÊN");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 41, 149, 28);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("LƯƠNG");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 81, 169, 28);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("NGÀNH");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(10, 161, 169, 28);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("NĂM DẠY");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(10, 201, 169, 28);
        contentPane.add(lblNewLabel_6);

        textName = new JTextField();
        textName.setToolTipText("");
        textName.setColumns(10);
        textName.setBounds(153, 48, 181, 20);
        contentPane.add(textName);

        textPrice = new JTextField();
        textPrice.setColumns(10);
        textPrice.setBounds(153, 88, 181, 20);
        contentPane.add(textPrice);

        textCredits = new JTextField();
        textCredits.setColumns(10);
        textCredits.setBounds(153, 128, 181, 20);
        contentPane.add(textCredits);

        textNamesv = new JTextField();
        textNamesv.setColumns(10);
        textNamesv.setBounds(153, 168, 181, 20);
        contentPane.add(textNamesv);

        textYear = new JTextField();
        textYear.setColumns(10);
        textYear.setBounds(153, 208, 181, 20);
        contentPane.add(textYear);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.WHITE);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkValidData()) {
                    return;
                }
                Major com = new Major();
                com.setGiangvien_id(100 + list.size() + 1);
                com.setGiangvien_name(textName.getText().trim());
                com.setGiangvien_price(Double.valueOf(textPrice.getText().trim()));
                com.setGiangvien_credits(Integer.valueOf(textCredits.getText().trim()));
                com.setNameMJ(textNamesv.getText().trim());
                com.setYear(Integer.valueOf(textYear.getText().trim()));
                for (Major c : list) {
                    if (com.getGiangvien_name().compareTo(c.getGiangvien_name()) == 0) {
                        JOptionPane.showMessageDialog(contentPane, "Giangvien already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                cmd.addGiangvien(com);
                JOptionPane.showMessageDialog(contentPane, "Add Success", "Successful", JOptionPane.PLAIN_MESSAGE);
                try {
                    list = FileGiangvien.binaryInputFile("Giangvien.bin", FileGiangvien.countObject());
                    fillTable(list);
                    resetField();
                } catch (IOException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAdd.setBounds(10, 238, 80, 23);
        contentPane.add(btnAdd);

        JButton btnEdit = new JButton("Edit");
        btnEdit.setBackground(Color.WHITE);
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!checkValidData()) {
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to fix it?", "Question", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                    resetField();
                    return;
                }
                for (Major c : list) {
                    if (c.getGiangvien_id() == id) {
                        c.setGiangvien_id(id);
                        c.setGiangvien_name(textName.getText().trim());
                        c.setGiangvien_price(Double.valueOf(textPrice.getText().trim()));
                        c.setGiangvien_credits(Integer.valueOf(textCredits.getText().trim()));
                        c.setNameMJ(textNamesv.getText().trim());
                        c.setYear(Integer.valueOf(textYear.getText().trim()));
                        break;
                    }
                }
                try {
                    writeToFile();
                    list = FileGiangvien.binaryInputFile("Giangvien.bin", FileGiangvien.countObject());
                    fillTable(list);
                    resetField();
                } catch (IOException | ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
                JOptionPane.showMessageDialog(contentPane, "Edit Success", "Successful", JOptionPane.PLAIN_MESSAGE);
            }
        });
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnEdit.setBounds(103, 238, 80, 23);
        contentPane.add(btnEdit);

        JButton btnDelete = new JButton("Del");
        btnDelete.setBackground(Color.WHITE);
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(contentPane, "You have not selected to delete", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(contentPane, "Bạn chắc chắn muốn xóa không? " + (String) table.getValueAt(row, 0), "Question", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                    return;
                }
                for (Major com : list) {
                    if (com.getGiangvien_id() == Integer.parseInt((String) table.getValueAt(row, 0))) {
                        cmd.delGiangvien(com);
                        break;
                    }
                }
                try {
                    writeToFile();
                    list = FileGiangvien.binaryInputFile("Giangvien.bin", FileGiangvien.countObject());
                    fillTable(list);
                    resetField();
                } catch (IOException | ClassNotFoundException e3) {
                    e3.printStackTrace();
                }
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnDelete.setBounds(196, 238, 80, 23);
        contentPane.add(btnDelete);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                textName.setText((String) table.getValueAt(row, 1));
                textPrice.setText(GiangvienGUI.formatString((String) table.getValueAt(row, 2)));
                textCredits.setText((String) table.getValueAt(row, 3));
                textNamesv.setText((String) table.getValueAt(row, 4));
                textYear.setText((String) table.getValueAt(row, 5));
                id = Integer.parseInt((String) table.getValueAt(row, 0));
            }
        });
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 385, 730, 203);
        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        contentPane.add(scrollPane);
        scrollPane.setViewportView(table);

        btnReset = new JButton("Reset");
        btnReset.setBackground(Color.WHITE);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetAll();
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(289, 238, 89, 23);
        contentPane.add(btnReset);

        comboBox = new JComboBox();
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        comboBox.addItem(new Item("Search by Luong", "price"));
        comboBox.addItem(new Item("Search by Year", "year"));
        comboBox.setBounds(10, 279, 142, 23);
        contentPane.add(comboBox);

        textSearch = new JTextField();
        textSearch.setBounds(153, 279, 126, 23);
        contentPane.add(textSearch);
        textSearch.setColumns(10);

        btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.WHITE);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object item = comboBox.getSelectedItem();
                String value = ((Item) item).getValue();
                List<Major> listSearch = new ArrayList<>();
                if (textSearch.getText().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(contentPane, "You have not entered the search value", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String textInput = textSearch.getText().trim();
                if (value.compareTo("price") == 0) {
                    try {
                        double price = Double.parseDouble(textInput);
                        if (price <= 0) {
                            JOptionPane.showMessageDialog(contentPane, "Price must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        listSearch = cmd.searchGiangvien(price);
                    } catch (Exception e4) {
                        JOptionPane.showMessageDialog(contentPane, "Price must be real numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (value.compareTo("year") == 0) {
                    try {
                        int year = Integer.parseInt(textInput);
                        if (year < 0) {
                            JOptionPane.showMessageDialog(contentPane, "Year of manufacture must be greater than 2000", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        listSearch = cmd.searchGiangvienbyNamHoc(year);
                    } catch (Exception e5) {
                        JOptionPane.showMessageDialog(contentPane, "Year must be whole numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                try {
                    fillTable(listSearch);
                    textSearch.setText("");
                } catch (IOException | ClassNotFoundException e6) {
                    e6.printStackTrace();
                }
            }
        });
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSearch.setBounds(289, 279, 89, 23);
        contentPane.add(btnSearch);

        cbSort = new JComboBox();
        cbSort.setBackground(Color.WHITE);
        cbSort.addItem(new Item("Sorted by Lương", "price"));
        cbSort.setFont(new Font("Tahoma", Font.BOLD, 12));
        cbSort.setBounds(10, 317, 142, 23);
        contentPane.add(cbSort);

        btnSort = new JButton("Sort");
        btnSort.setBackground(Color.WHITE);
        btnSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int creditsRow = table.getRowCount();
                int creditsColumn = table.getColumnCount();
                List<Major> listSort = new ArrayList<>();
                for (int i = 0; i < creditsRow; i++) {
                    Major com = new Major();
                    com.setGiangvien_id(Integer.parseInt((String) table.getValueAt(i, 0)));
                    com.setGiangvien_name((String) table.getValueAt(i, 1));
                    com.setGiangvien_price(Double.parseDouble(GiangvienGUI.formatString((String) table.getValueAt(i, 2))));
                    com.setGiangvien_credits(Integer.parseInt((String) table.getValueAt(i, 3)));
                    com.setNameMJ((String) table.getValueAt(i, 4));
                    com.setYear(Integer.parseInt((String) table.getValueAt(i, 5)));
                    listSort.add(com);
                }

                Object itemSort = cbSort.getSelectedItem();
                String valueSort = ((Item) itemSort).getValue();

                Object itemIsNC = cbIsNC.getSelectedItem();
                String valueIsNC = ((Item) itemIsNC).getValue();

                if (valueSort.compareTo("price") == 0) {
                    if (valueIsNC.compareTo("asc") == 0) {
                        Collections.sort(listSort, new sortedByPrice());
                    } else {
                        Collections.sort(listSort, new sortedByPrice().reversed());
                    }
                } else {
                    if (valueIsNC.compareTo("asc") == 0) {
                        Collections.sort(listSort, new sortedByNameMJ());
                    } else {
                        Collections.sort(listSort, new sortedByNameMJ().reversed());
                    }
                }
                try {
                    fillTable(listSort);
                } catch (ClassNotFoundException | IOException e7) {
                    e7.printStackTrace();
                }
            }
        });
        btnSort.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSort.setBounds(289, 317, 89, 23);
        contentPane.add(btnSort);

        cbIsNC = new JComboBox();
        cbIsNC.setBackground(Color.WHITE);
        cbIsNC.addItem(new Item("Ascending", "asc"));
        cbIsNC.addItem(new Item("Decreasing", "desc"));
        cbIsNC.setFont(new Font("Tahoma", Font.BOLD, 12));
        cbIsNC.setBounds(153, 317, 126, 23);
        contentPane.add(cbIsNC);

        //Set Icon
        URL ic = GiangvienGUI.class.getResource("giangvien.png");
        Image img = Toolkit.getDefaultToolkit().createImage(ic);
        this.setIconImage(img);
    }

    private void initTable() {
        String[] columns = {"ID", "Tên Giảng Viên", "Lương", "Số Tín Dạy", "Ngành", "Năm dạy"};
        tableModel.setColumnIdentifiers(columns);
        table.setModel(tableModel);
    }

    private void fillTable(List<Major> list) throws IOException, ClassNotFoundException {
        tableModel.setRowCount(0);
        for (Major com : list) {
            tableModel.addRow(new String[]{
                String.format("%d", com.getGiangvien_id()), com.getGiangvien_name(), decimalFormat.format(com.getGiangvien_price()),
                "" + com.getGiangvien_credits(), com.getNameMJ(), String.format("%d", com.getYear())
            });
        }
        table.setRowHeight(25);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 18));
        table.setAutoCreateRowSorter(true);
        tableModel.fireTableDataChanged();
    }

    public static String formatString(String s) {
        String str[] = s.split("");
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i].compareTo(",") != 0) {
                newString.append(str[i]);
            }
        }
        return newString.toString();
    }

    public boolean checkValidData() {
        if (!validataEmtyField()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        try {
            double price = Double.parseDouble(textPrice.getText());
            if (price <= 0) {
                sb.append("Lương phải lớn hơn  0");
            }
        } catch (Exception e8) {
            sb.append("Lương phải là 1 con số");
        }
        try {
            int credits = Integer.parseInt(textCredits.getText());
            if (credits <= 0) {
                sb.append("Số tín dạy phải lớn hơn 0");
            }
        } catch (Exception e9) {
            sb.append("Số tín dạy phải là 1 con số");
        }
        try {
            int year = Integer.parseInt(textYear.getText());
            if (year < 0) {
                sb.append("Năm dạy phải lớn hơn 0");
            }
        } catch (Exception e10) {
            sb.append("Năm dạy phải là số");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean validataEmtyField() {
        StringBuilder sb = new StringBuilder();
        if (textName.getText().equals("")) {
            sb.append("Tên giảng viên không được để trống \n");
        }
        if (textPrice.getText().equals("")) {
            sb.append("Lương không được để trống \n");
        }
        if (textCredits.getText().equals("")) {
            sb.append("Số tín dạy không được để trống\n");
        }
        if (textNamesv.getText().equals("")) {
            sb.append("Tên ngành không được để trống \n");
        }
        if (textYear.getText().equals("")) {
            sb.append("Năm không được để trống \n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(contentPane, sb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void resetField() {
        textName.setText("");
        textPrice.setText("");
        textCredits.setText("");
        textNamesv.setText("");
        textYear.setText("");
        textSearch.setText("");
    }

    public void resetAll() {
        resetField();
        try {
            fillTable(list);
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeToFile() throws IOException {
        FileGiangvien.binaryOutputFile(list);
    }
}
