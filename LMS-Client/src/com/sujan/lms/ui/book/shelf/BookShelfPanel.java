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
package com.sujan.lms.ui.book.shelf;

import com.sujan.lms.action.ShelfListener;
import com.sujan.lms.bll.ShelfBLL;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.entity.shelf.Shelf;
import com.sujan.lms.common.entity.user.UserInfo;
import com.sujan.lms.common.params.ShelfParams;
import com.sujan.lms.ui.BaseUserPanel;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.Utils;
import com.sujan.lms.view.BookView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @shelf Suzn
 */
public final class BookShelfPanel extends BaseUserPanel implements BookView<Shelf>, ShelfListener {

    private List<Shelf> shelfList;

    /**
     * Creates new form BookShelfPanel
     *
     * @param userInfo
     */
    public BookShelfPanel(UserInfo userInfo) {
        initComponents();
        setupUserView(userInfo);
        shelfList = new ArrayList<>();
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
        jPanel8 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        centerSubPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bottomPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        addBookShelfButton = new javax.swing.JButton();
        updateBookShelfButton = new javax.swing.JButton();
        deleteBookShelfButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        centerPanel.setLayout(new java.awt.CardLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        searchPanel.setBackground(new java.awt.Color(249, 249, 249));
        searchPanel.setPreferredSize(new java.awt.Dimension(367, 70));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout();
        flowLayout3.setAlignOnBaseline(true);
        searchPanel.setLayout(flowLayout3);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(280, 65));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_blue.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        searchPanel.add(jPanel9);

        jPanel8.add(searchPanel, java.awt.BorderLayout.PAGE_START);

        centerSubPanel.setLayout(new java.awt.CardLayout());

        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        tableModel.addColumn(ShelfParams.ID.toUpperCase());
        tableModel.addColumn(ShelfParams.LOCATION.toUpperCase());
        table.setModel(tableModel);
        table.setRowHeight(26);
        table.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(table);
        javax.swing.table.TableRowSorter<javax.swing.table.TableModel> rowSorter = new javax.swing.table.TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        centerSubPanel.add(jScrollPane3, "card2");

        jPanel8.add(centerSubPanel, java.awt.BorderLayout.CENTER);

        bottomPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING));

        jPanel10.setOpaque(false);

        addBookShelfButton.setText("Add New");
        addBookShelfButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBookShelfButton.setPreferredSize(new java.awt.Dimension(80, 40));
        addBookShelfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookShelfButtonActionPerformed(evt);
            }
        });
        jPanel10.add(addBookShelfButton);

        updateBookShelfButton.setText("Update");
        updateBookShelfButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateBookShelfButton.setPreferredSize(new java.awt.Dimension(80, 40));
        updateBookShelfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBookShelfButtonActionPerformed(evt);
            }
        });
        jPanel10.add(updateBookShelfButton);

        deleteBookShelfButton.setText("Delete");
        deleteBookShelfButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteBookShelfButton.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteBookShelfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookShelfButtonActionPerformed(evt);
            }
        });
        jPanel10.add(deleteBookShelfButton);

        bottomPanel2.add(jPanel10);

        jPanel8.add(bottomPanel2, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel8, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBookShelfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBookShelfButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            Shelf s = getBeanFromRow(table.getRowSorter().convertRowIndexToModel(row));
            if (s != null) {
                BookShelfUpdateDialog bookShelfUpdateDialog = new BookShelfUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, s);
                bookShelfUpdateDialog.setItemUpdatedListener((Shelf shelf) -> {
                    updateShelfData(shelf, row);
                });
                bookShelfUpdateDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_updateBookShelfButtonActionPerformed

    private void addBookShelfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookShelfButtonActionPerformed
        BookShelfInsertDialog bookShelfInsertDialog = new BookShelfInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        bookShelfInsertDialog.setItemAddedListener((Shelf shelf) -> {
            appendShelfData(shelf);
        });
        bookShelfInsertDialog.setVisible(true);
    }//GEN-LAST:event_addBookShelfButtonActionPerformed

    private void deleteBookShelfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookShelfButtonActionPerformed
        if (Utils.isTableRowSelected(table)) {
            if (Alert.showDeleteConfirmDialog(this) == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                int id = Utils.getIdFromTable(table, table.getRowSorter().convertRowIndexToModel(row));
                try {
                    Shelf shelf = new Shelf();
                    shelf.setId(id);
                    ShelfBLL.deleteShelf(shelf);
                    removeShelfData(shelf, row);
                } catch (Exception ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_deleteBookShelfButtonActionPerformed

    @Override
    public final void loadTableData() {

        if (shelfList == null || shelfList.isEmpty()) {
            Logy.d("Loading shelf from file for first Time");
            try {
                shelfList = ShelfBLL.getAllShelf();
            } catch (Exception ex) {
                Logy.e(ex);
                Alert.showError(this, ex.getMessage());
                return;
            }

        } else {
            Logy.d("shelf already loaded");
        }
        this.fillTableData(shelfList);

    }

    /**
     *
     * @param shelfInfoList
     */
    @Override
    public final void fillTableData(List<Shelf> shelfInfoList) {

        shelfInfoList.stream().forEach((shelfInfo) -> {
            addShelfRowData(shelfInfo);
        });

    }

    public void addShelfRowData(Shelf shelf) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            shelf.getId(),
            shelf.getLocation()
        });
    }

    private void updateShelfData(Shelf s, int row) {
        for (Shelf shelf : shelfList) {
            if (shelf.getId() == s.getId()) {
                shelf.setLocation(s.getLocation());
                break;
            }
        }

        updateShelfRowData(s, row);
    }

    private void updateShelfRowData(Shelf shelf, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(shelf.getLocation(), row, 1);
    }

    private Shelf getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return shelfList.stream()
                .filter((shelf) -> shelf.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookShelfButton;
    private javax.swing.JPanel bottomPanel2;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteBookShelfButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JButton updateBookShelfButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onShelfDataChanged(Shelf s) {
        appendShelfData(s);
    }

    private void appendShelfData(Shelf s) {
        shelfList.add(s);
        addShelfRowData(s);
    }

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
        this.deleteBookShelfButton.setVisible(false);
    }

    @Override
    protected void setupMemberView() {
        addBookShelfButton.setVisible(false);
        updateBookShelfButton.setVisible(false);
        this.deleteBookShelfButton.setVisible(false);
    }

    @Override
    public void onShelfDataRemoved(Shelf s) {
        for (Shelf auth : shelfList) {
            if (auth.getId() == s.getId()) {
                shelfList.remove(auth);
                break;
            }
        }

    }

    private void removeShelfData(Shelf a, int row) {
        onShelfDataRemoved(a);
        ((DefaultTableModel) table.getModel()).removeRow(row);
    }

}
