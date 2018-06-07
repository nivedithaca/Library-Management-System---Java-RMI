/* 
 * Copyright (C) 2018 Suzn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.sujan.lms.ui.book.stock;

import com.sujan.lms.action.AuthorListener;
import com.sujan.lms.action.PublisherListener;
import com.sujan.lms.action.ShelfListener;
import com.sujan.lms.action.SubjectListener;
import com.sujan.lms.bll.AuthorBLL;
import com.sujan.lms.bll.BookBLL;
import com.sujan.lms.bll.PublisherBLL;
import com.sujan.lms.bll.ShelfBLL;
import com.sujan.lms.bll.SubjectBLL;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.entity.author.Author;
import com.sujan.lms.common.entity.book.BookInfo;
import com.sujan.lms.common.entity.publisher.Publisher;
import com.sujan.lms.common.entity.shelf.Shelf;
import com.sujan.lms.common.entity.subject.Subject;
import com.sujan.lms.ui.book.author.BookAuthorInsertDialog;
import com.sujan.lms.ui.book.publisher.BookPublisherInsertDialog;
import com.sujan.lms.ui.book.shelf.BookShelfInsertDialog;
import com.sujan.lms.ui.book.subject.BookSubjectInsertDialog;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.Utils;
import com.sujan.lms.validation.book.BookValidation;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author Suzn
 */
public class BookStockInsertDialog extends javax.swing.JDialog {

    private final BookValidation validation;
    private SubjectListener subjectListener;
    private AuthorListener authorListener;
    private PublisherListener publisherListener;
    private ShelfListener shelfListener;

    private ItemAddedListener itemAddedListener;

    private void notifyDataSetChanged(BookInfo bookInfo) {
        if (getItemAddedListener() != null) {
            getItemAddedListener().onNewItemAdded(bookInfo);
        }
    }

    public interface ItemAddedListener {

        void onNewItemAdded(BookInfo bookInfo);
    }

    /**
     * Creates new form BookStockInsertDialog
     *
     * @param parent
     * @param modal
     */
    public BookStockInsertDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.loadData();
        validation = new BookValidation(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        subjectComboBox = new javax.swing.JComboBox<Subject>();
        jLabel4 = new javax.swing.JLabel();
        authorComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        publisherComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        editionTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        isbnTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        quantityTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        shelfComboBox = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        subjectAddButton = new javax.swing.JButton();
        authorAddButton = new javax.swing.JButton();
        publisherAddButton = new javax.swing.JButton();
        shelfAddButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setPreferredSize(new java.awt.Dimension(480, 600));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.CardLayout());

        rootPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(39, 26, 252));
        topPanel.setPreferredSize(new java.awt.Dimension(482, 200));
        topPanel.setLayout(new java.awt.GridLayout(2, 0));

        jPanel1.setOpaque(false);
        topPanel.add(jPanel1);

        jPanel2.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(153, 153, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Book");
        jLabel1.setPreferredSize(new java.awt.Dimension(113, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        topPanel.add(jPanel2);

        rootPanel.add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(214, 215, 217));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        jPanel4.setPreferredSize(new java.awt.Dimension(380, 326));

        jPanel5.setOpaque(false);

        jLabel2.setLabelFor(titleTextField);
        jLabel2.setText("Title");

        jLabel3.setText("Subject");

        subjectComboBox.setModel(new javax.swing.DefaultComboBoxModel<Subject>());
        subjectComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                if (o != null) {
                    Subject subject = (Subject) o;
                    setText(subject.getTitle());
                }
                return this;
            }

        });

        jLabel4.setText("Author");

        authorComboBox.setModel(new javax.swing.DefaultComboBoxModel<Author>());
        authorComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                if (o != null) {
                    Author author = (Author) o;
                    setText(author.getTitle());
                }
                return this;
            }

        });

        jLabel5.setText("Publisher");

        publisherComboBox.setModel(new javax.swing.DefaultComboBoxModel<Publisher>());
        publisherComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                if (o != null) {
                    Publisher publisher = (Publisher) o;
                    setText(publisher.getTitle());
                }
                return this;
            }

        });

        jLabel6.setText("Edition");

        editionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char enter = evt.getKeyChar();
                if(!(Character.isDigit(enter))){
                    evt.consume();
                }
            }
        });

        jLabel7.setText("ISBN");

        jLabel8.setText("Quantity");

        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char enter = evt.getKeyChar();
                if(!(Character.isDigit(enter))){
                    evt.consume();
                }
            }
        });

        jLabel9.setText("Shelf");

        shelfComboBox.setModel(new javax.swing.DefaultComboBoxModel<Shelf>());
        shelfComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int i, boolean bln, boolean bln1) {
                super.getListCellRendererComponent(jlist, o, i, bln, bln1);
                if (o != null) {
                    Shelf shelf = (Shelf) o;
                    setText(shelf.getLocation());
                }
                return this;
            }

        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(authorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(publisherComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(shelfComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(255, 51, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setOpaque(false);

        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, saveButton});

        jPanel7.setOpaque(false);

        subjectAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        subjectAddButton.setMinimumSize(new java.awt.Dimension(53, 27));
        subjectAddButton.setPreferredSize(new java.awt.Dimension(53, 27));
        subjectAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectAddButtonActionPerformed(evt);
            }
        });

        authorAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        authorAddButton.setMinimumSize(new java.awt.Dimension(53, 27));
        authorAddButton.setPreferredSize(new java.awt.Dimension(53, 27));
        authorAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorAddButtonActionPerformed(evt);
            }
        });

        publisherAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        publisherAddButton.setMinimumSize(new java.awt.Dimension(53, 27));
        publisherAddButton.setPreferredSize(new java.awt.Dimension(53, 27));
        publisherAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherAddButtonActionPerformed(evt);
            }
        });

        shelfAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        shelfAddButton.setMinimumSize(new java.awt.Dimension(53, 27));
        shelfAddButton.setPreferredSize(new java.awt.Dimension(53, 27));
        shelfAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(authorAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(subjectAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(shelfAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(subjectAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(authorAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(publisherAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(shelfAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout centerPanelLayout = new javax.swing.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerPanelLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centerPanelLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        rootPanel.add(centerPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(rootPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authorAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorAddButtonActionPerformed
        BookAuthorInsertDialog bookAuthorInsertDialog = new BookAuthorInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookAuthorInsertDialog.setItemAddedListener((Author author) -> {
            authorComboBox.addItem(author);
            if (authorListener != null) {
                authorListener.onAuthorDataChanged(author);
            }
        });
        bookAuthorInsertDialog.setVisible(true);
    }//GEN-LAST:event_authorAddButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validation.isStockFormValid(titleTextField.getText(),
                editionTextField.getText(), isbnTextField.getText(), quantityTextField.getText())) {

            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(Utils.generateRandomID());
            bookInfo.setTitle(titleTextField.getText());
            bookInfo.setSubject(subjectComboBox.getItemAt(subjectComboBox.getSelectedIndex()));
            bookInfo.setAuthor(authorComboBox.getItemAt(authorComboBox.getSelectedIndex()));
            bookInfo.setPublisher(publisherComboBox.getItemAt(publisherComboBox.getSelectedIndex()));
            bookInfo.setEdition(editionTextField.getText());
            bookInfo.setIsbn(isbnTextField.getText());
            bookInfo.setNumberOfCopy(Integer.parseInt(quantityTextField.getText()));
            bookInfo.setAvailableCopies(bookInfo.getNumberOfCopy());
            bookInfo.setShelfNo(shelfComboBox.getItemAt(shelfComboBox.getSelectedIndex()));

            try {
                BookBLL.insertBook(bookInfo);
                notifyDataSetChanged(bookInfo);
                Alert.showInformation(this, "Book inserted successfully!");

                resetFields();
            } catch (Exception ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
            }

        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void publisherAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherAddButtonActionPerformed
        BookPublisherInsertDialog bookPublisherInsertDialog = new BookPublisherInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookPublisherInsertDialog.setItemAddedListener((Publisher publisher) -> {
            publisherComboBox.addItem(publisher);
            if (publisherListener != null) {
                publisherListener.onPublisherDataChanged(publisher);
            }
        });
        bookPublisherInsertDialog.setVisible(true);
    }//GEN-LAST:event_publisherAddButtonActionPerformed

    private void shelfAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfAddButtonActionPerformed
        BookShelfInsertDialog bookShelfInsertDialog = new BookShelfInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookShelfInsertDialog.setItemAddedListener((Shelf shelf) -> {
            shelfComboBox.addItem(shelf);
            if (shelfListener != null) {
                shelfListener.onShelfDataChanged(shelf);
            }
        });
        bookShelfInsertDialog.setVisible(true);
    }//GEN-LAST:event_shelfAddButtonActionPerformed

    private void subjectAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectAddButtonActionPerformed
        BookSubjectInsertDialog bookSubjectInsertDialog = new BookSubjectInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookSubjectInsertDialog.setItemAddedListener((Subject subject) -> {
            subjectComboBox.addItem(subject);
            if (subjectListener != null) {
                subjectListener.onSubjectDataChanged(subject);
            }
        });
        bookSubjectInsertDialog.setVisible(true);
    }//GEN-LAST:event_subjectAddButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookStockInsertDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            BookStockInsertDialog dialog = new BookStockInsertDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorAddButton;
    private javax.swing.JComboBox<Author> authorComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JTextField editionTextField;
    private javax.swing.JTextField isbnTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton publisherAddButton;
    private javax.swing.JComboBox<Publisher> publisherComboBox;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton shelfAddButton;
    private javax.swing.JComboBox<Shelf> shelfComboBox;
    private javax.swing.JButton subjectAddButton;
    private javax.swing.JComboBox<Subject> subjectComboBox;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private void loadData() {

        SwingUtilities.invokeLater(() -> {

            try {
                SubjectBLL.getAllSubject().stream()
                        .forEach(subject -> {
                            subjectComboBox.addItem(subject);
                        });
                AuthorBLL.getAllAuthor().stream()
                        .forEach(author -> {
                            authorComboBox.addItem(author);
                        });
                PublisherBLL.getAllPublisher().stream()
                        .forEach(publisher -> {
                            publisherComboBox.addItem(publisher);
                        });
                ShelfBLL.getAllShelf().stream()
                        .forEach(shelf -> {
                            shelfComboBox.addItem(shelf);
                        });
            } catch (Exception ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
            }
        });
    }

    /**
     * @return the subjectListener
     */
    public SubjectListener getSubjectListener() {
        return subjectListener;
    }

    /**
     * @param subjectListener the subjectListener to set
     */
    public void setSubjectListener(SubjectListener subjectListener) {
        this.subjectListener = subjectListener;
    }

    /**
     * @return the authorListener
     */
    public AuthorListener getAuthorListener() {
        return authorListener;
    }

    /**
     * @param authorListener the authorListener to set
     */
    public void setAuthorListener(AuthorListener authorListener) {
        this.authorListener = authorListener;
    }

    /**
     * @return the publisherListener
     */
    public PublisherListener getPublisherListener() {
        return publisherListener;
    }

    /**
     * @param publisherListener the publisherListener to set
     */
    public void setPublisherListener(PublisherListener publisherListener) {
        this.publisherListener = publisherListener;
    }

    /**
     * @return the shelfListener
     */
    public ShelfListener getShelfListener() {
        return shelfListener;
    }

    /**
     * @param shelfListener the shelfListener to set
     */
    public void setShelfListener(ShelfListener shelfListener) {
        this.shelfListener = shelfListener;
    }

    private void resetFields() {
        titleTextField.setText(null);
        editionTextField.setText(null);
        isbnTextField.setText(null);
        quantityTextField.setText(null);

        subjectComboBox.setSelectedIndex(0);
        authorComboBox.setSelectedIndex(0);
        publisherComboBox.setSelectedIndex(0);
        shelfComboBox.setSelectedIndex(0);
    }

    /**
     * @return the itemAddedListener
     */
    public ItemAddedListener getItemAddedListener() {
        return itemAddedListener;
    }

    /**
     * @param itemAddedListener the itemAddedListener to set
     */
    public void setItemAddedListener(ItemAddedListener itemAddedListener) {
        this.itemAddedListener = itemAddedListener;
    }

}
