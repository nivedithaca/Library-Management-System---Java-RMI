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
package com.sujan.lms.ui.book.transaction;

import com.sujan.lms.bll.TransactionBLL;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.entity.user.UserInfo;
import com.sujan.lms.ui.BaseUserPanel;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.Utils;
import com.sujan.lms.view.BookView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.sujan.lms.action.TransactionListener;
import com.sujan.lms.common.params.BorrowParams;
import com.sujan.lms.common.entity.transaction.Transaction;
import com.sujan.lms.common.params.ReturnParams;
import com.sujan.lms.common.params.TransactionParams;
import com.sujan.lms.ui.book.borrow.BookBorrowInsertDialog;
import com.sujan.lms.ui.book.returnn.BookReturnInsertDialog;

/**
 *
 * @borrow Suzn
 */
public final class BookTransactionPanel extends BaseUserPanel implements BookView<Transaction>,
        TransactionListener {

    private List<Transaction> transactionList;
    private final UserInfo userInfo;

    private TransactionListener transactionListener;

    /**
     * Creates new form BookBorrowPanel
     *
     * @param userInfo
     */
    public BookTransactionPanel(UserInfo userInfo) {
        initComponents();
        this.userInfo = userInfo;
        setupUserView(userInfo);
        transactionList = new ArrayList<>();
        this.loadTableData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centerPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        centerSubPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        borrowButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        centerPanel.setLayout(new java.awt.CardLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        searchPanel.setBackground(new java.awt.Color(249, 249, 249));
        searchPanel.setPreferredSize(new java.awt.Dimension(367, 70));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        searchPanel.setLayout(flowLayout1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(280, 65));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_blue.png"))); // NOI18N

        searchTextField.setBackground(new java.awt.Color(249, 249, 249));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setToolTipText("Search for title, publisher, author..");
        searchTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 26, 252)));
        searchTextField.setMinimumSize(new java.awt.Dimension(200, 15));
        searchTextField.setOpaque(false);
        searchTextField.setPreferredSize(new java.awt.Dimension(200, 15));
        searchTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String text = searchTextField.getText();
                System.out.println(text);
                if (text.trim().length() == 0) {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(null);
                } else {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(javax.swing.RowFilter.regexFilter("^(?i)" + text));
                }
                table.repaint();
            }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                String text = searchTextField.getText();
                if (text.trim().length() == 0) {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(null);
                } else {
                    ((javax.swing.table.TableRowSorter<javax.swing.table.TableModel>)table.getRowSorter()).setRowFilter(javax.swing.RowFilter.regexFilter("^(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                //not needed: throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        searchPanel.add(jPanel2);

        jPanel4.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        centerSubPanel.setLayout(new java.awt.CardLayout());

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        tableModel.addColumn(TransactionParams.ID.toUpperCase());
        tableModel.addColumn(TransactionParams.BOOK.toUpperCase());
        tableModel.addColumn(TransactionParams.MEMBER.toUpperCase());
        tableModel.addColumn(TransactionParams.USER.toUpperCase());
        tableModel.addColumn(BorrowParams.DAYS.toUpperCase());
        tableModel.addColumn(BorrowParams.BORROWED_DATE.toUpperCase());
        tableModel.addColumn(BorrowParams.RETURNING_DATE.toUpperCase());
        tableModel.addColumn(ReturnParams.RETURNED_DATE.toUpperCase());
        tableModel.addColumn(TransactionParams.STATUS.toUpperCase());
        table.setModel(tableModel);
        table.setRowHeight(26);
        table.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(table);
        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> rowSorter = new javax.swing.table.TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        centerSubPanel.add(jScrollPane1, "card2");

        jPanel4.add(centerSubPanel, java.awt.BorderLayout.CENTER);

        bottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jPanel3.setOpaque(false);

        borrowButton.setText("Borrow");
        borrowButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        borrowButton.setPreferredSize(new java.awt.Dimension(80, 40));
        borrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowButtonActionPerformed(evt);
            }
        });
        jPanel3.add(borrowButton);

        returnButton.setText("Return");
        returnButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        returnButton.setPreferredSize(new java.awt.Dimension(80, 40));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        jPanel3.add(returnButton);

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void borrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowButtonActionPerformed
        BookBorrowInsertDialog bookBorrowInsertDialog = new BookBorrowInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, userInfo);
        bookBorrowInsertDialog.setItemAddedListener((Transaction transaction) -> {
            appendTransactionData(transaction);
        });
        bookBorrowInsertDialog.setVisible(true);
    }//GEN-LAST:event_borrowButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        int row = table.getSelectedRow();
        if (row < 0) {
            return;
        }
        Transaction transaction = getBeanFromRow(table.getRowSorter().convertRowIndexToModel(row));
        if (transaction.isStatus()) {
            BookReturnInsertDialog bookReturnInsertDialog = new BookReturnInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, transaction);
            bookReturnInsertDialog.setItemAddedListener((Transaction t) -> {
                bookReturnedTransaction(t, row);
            });
            bookReturnInsertDialog.setVisible(true);
        } else {
            Alert.showInformation(this, "Book already returned");
        }
    }//GEN-LAST:event_returnButtonActionPerformed

    @Override
    public final void loadTableData() {

        if (transactionList == null || transactionList.isEmpty()) {
            Logy.d("Loading transaction from file for first Time");
            try {
                transactionList = TransactionBLL.getAllTransaction();
            } catch (Exception ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        } else {
            Logy.d("transaction already loaded");
        }

        this.fillTableData(transactionList);

    }

    /**
     *
     * @param transactionList
     */
    @Override
    public final void fillTableData(List<Transaction> transactionList) {

        transactionList.stream().forEach((transaction) -> {
            addTransactionRowData(transaction);
        });

    }

    public void addTransactionRowData(Transaction transaction) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            transaction.getId(),
            transaction.getBook().getTitle(),
            transaction.getMember().getName(),
            transaction.getUser().getName(),
            transaction.getBorrow().getNumOfDays(),
            transaction.getBorrow().getTimestamp(),
            Utils.millisToSql(transaction.getBorrow().getReturningDate()),
            transaction.getRetrn() == null ? "-" : Utils.millisToSql(transaction.getRetrn().getReturnedDate()),
            transaction.isStatus() ? TransactionParams.Status.BORROWED : TransactionParams.Status.RETURNED
        });
    }

    private Transaction getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return transactionList.stream()
                .filter((transaction) -> transaction.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onBookBorrowed(Transaction transaction) {
        transactionList.add(transaction);
        addTransactionRowData(transaction);
    }

    @Override
    public void onBookReturned(Transaction transaction) {
    }

    private void appendTransactionData(Transaction transaction) {
        onBookBorrowed(transaction);
        if (transactionListener != null) {
            transactionListener.onBookBorrowed(transaction);
        }
    }

    private void bookReturnedTransaction(Transaction transaction, int row) {

        ((DefaultTableModel) table.getModel()).setValueAt(Utils.millisToSql(transaction.getRetrn().getReturnedDate()), row, 7);
        ((DefaultTableModel) table.getModel()).setValueAt(transaction.isStatus() ? TransactionParams.Status.BORROWED : TransactionParams.Status.RETURNED, row, 8);

        if (transactionListener != null) {
            transactionListener.onBookReturned(transaction);
        }
    }

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
    }

    /**
     * @return the transactionListener
     */
    public TransactionListener getTransactionListener() {
        return transactionListener;
    }

    /**
     * @param borrowListener the transactionListener to set
     */
    public void setTransactionListener(TransactionListener borrowListener) {
        this.transactionListener = borrowListener;
    }

}
