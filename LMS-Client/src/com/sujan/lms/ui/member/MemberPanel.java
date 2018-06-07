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
package com.sujan.lms.ui.member;

import com.sujan.lms.bll.MemberBLL;
import com.sujan.lms.common.widget.Alert;
import com.sujan.lms.common.entity.member.MemberInfo;
import com.sujan.lms.common.entity.user.UserInfo;
import com.sujan.lms.common.params.MemberParams;
import com.sujan.lms.ui.BaseUserPanel;
import com.sujan.lms.common.util.Logy;
import com.sujan.lms.util.Utils;
import com.sujan.lms.view.MemberView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @member Suzn
 */
public final class MemberPanel extends BaseUserPanel implements MemberView {

    private List<MemberInfo> memberList;
    private final UserInfo userInfo;

    /**
     * Creates new form LibrarianBookPanel
     *
     * @param userInfo
     */
    public MemberPanel(UserInfo userInfo) {
        initComponents();
        this.userInfo = userInfo;
        setupUserView(userInfo);
        memberList = new ArrayList<>();

        Logy.d("Librarian member panel initialized");
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

        topPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
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
        addMemberButton = new javax.swing.JButton();
        updateMemberButton = new javax.swing.JButton();
        deleteMemberButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(249, 249, 249));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(367, 80));
        topPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(120, 60));

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("Member");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        topPanel.add(titlePanel);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

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

        tableModel.addColumn(MemberParams.ID.toUpperCase());
        tableModel.addColumn(MemberParams.NAME.toUpperCase());
        tableModel.addColumn(MemberParams.EMAIL.toUpperCase());
        tableModel.addColumn(MemberParams.DOB.toUpperCase());
        tableModel.addColumn(MemberParams.COURSE.toUpperCase());
        tableModel.addColumn(MemberParams.TP_NUMBER.toUpperCase());
        tableModel.addColumn(MemberParams.YEAR.toUpperCase());
        tableModel.addColumn(MemberParams.USERNAME.toUpperCase());
        tableModel.addColumn(MemberParams.PASSWORD.toUpperCase());
        tableModel.addColumn(MemberParams.JOINED_DATE.toUpperCase());
        tableModel.addColumn(MemberParams.EXPIRY_DATE.toUpperCase());
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

        addMemberButton.setText("Add New");
        addMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addMemberButton);

        updateMemberButton.setText("Update");
        updateMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        updateMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(updateMemberButton);

        deleteMemberButton.setText("Delete");
        deleteMemberButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteMemberButton.setPreferredSize(new java.awt.Dimension(80, 40));
        deleteMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteMemberButton);

        bottomPanel.add(jPanel3);

        jPanel4.add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        centerPanel.add(jPanel4, "card2");

        add(centerPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void updateMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMemberButtonActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            MemberInfo b = getBeanFromRow(table.getRowSorter().convertRowIndexToModel(row));
            if (b != null) {
                MemberUpdateDialog memberMemberUpdateDialog = new MemberUpdateDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                        true, b);
                memberMemberUpdateDialog.setItemUpdatedListener((MemberInfo memberInfo) -> {
                    updateMemberData(memberInfo, row);
                });
                memberMemberUpdateDialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_updateMemberButtonActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        MemberInsertDialog memberInsertDialog = new MemberInsertDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
        memberInsertDialog.setItemAddedListener((MemberInfo memberInfo) -> {
            appendMemberData(memberInfo);
        });

        memberInsertDialog.setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void deleteMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberButtonActionPerformed
        if (Utils.isTableRowSelected(table)) {
            if (Alert.showDeleteConfirmDialog(this) == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                int id = Utils.getIdFromTable(table, table.getRowSorter().convertRowIndexToModel(row));
                try {
                    MemberInfo member = new MemberInfo(id);
                    MemberBLL.deleteMember(member);
                    removeMemberData(member, row);
                } catch (Exception ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_deleteMemberButtonActionPerformed

    @Override
    public final void loadTableData() {
        SwingUtilities.invokeLater(() -> {
            if (memberList == null || memberList.isEmpty()) {
                Logy.d("Loading member from file for first Time");
                try {
                    memberList = MemberBLL.getAllMember();
                } catch (Exception ex) {
                    Logy.e(ex);
                    Alert.showError(this, ex.getMessage());
                    return;
                }
            } else {
                Logy.d("member already loaded");
            }
            this.fillTableData(memberList);
        });
    }

    @Override
    public final void fillTableData(List<MemberInfo> list) {
        memberList.stream().forEach((memberInfo) -> {
            onMemberRowDataAdd(memberInfo);
        });
    }

    @Override
    public void onMemberRowDataAdd(MemberInfo member) {
        ((DefaultTableModel) table.getModel()).insertRow(0, new Object[]{
            member.getId(),
            member.getName(),
            member.getEmail(),
            Utils.millisToSql(member.getDob()),
            member.getCourse(),
            member.getTpNumber(),
            member.getYear(),
            member.getUsername(),
            member.getPassword(),
            Utils.millisToSql(member.getJoinedDate()),
            Utils.millisToSql(member.getExpiryDate())
        });
    }

    private void appendMemberData(MemberInfo member) {
        memberList.add(member);
        onMemberRowDataAdd(member);
    }

    private void updateMemberData(MemberInfo s, int row) {
        for (MemberInfo member : memberList) {
            if (member.getId() == s.getId()) {
                member.setName(s.getName());
                member.setEmail(s.getEmail());
                member.setDob(s.getDob());
                member.setCourse(s.getCourse());
                member.setTpNumber(s.getTpNumber());
                member.setYear(s.getYear());
                member.setPassword(s.getPassword());
                member.setExpiryDate(s.getExpiryDate());
                break;
            }
        }

        updateMemberInfoRowData(s, row);
    }

    private void updateMemberInfoRowData(MemberInfo member, int row) {
        ((DefaultTableModel) table.getModel()).setValueAt(member.getName(), row, 1);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getEmail(), row, 2);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getDob(), row, 3);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getCourse(), row, 4);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getTpNumber(), row, 5);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getYear(), row, 6);
        ((DefaultTableModel) table.getModel()).setValueAt(member.getPassword(), row, 8);
        ((DefaultTableModel) table.getModel()).setValueAt(Utils.millisToSql(member.getExpiryDate()), row, 10);
    }

    private void removeMemberData(MemberInfo m, int row) {
        onMemberDataRemove(m);
        ((DefaultTableModel) table.getModel()).removeRow(row);
    }

    @Override
    public void onMemberDataRemove(MemberInfo m) {
        for (MemberInfo member : memberList) {
            if (member.getId() == m.getId()) {
                memberList.remove(member);
                break;
            }
        }
    }

    private MemberInfo getBeanFromRow(int row) {
        int id = (int) table.getModel().getValueAt(row, 0);
        return memberList.stream()
                .filter((member) -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMemberButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JPanel centerSubPanel;
    private javax.swing.JButton deleteMemberButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton updateMemberButton;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void setupAdminView() {
    }

    @Override
    protected void setupLibrarianView() {
        this.deleteMemberButton.setVisible(false);
    }

    @Override
    protected void setupMemberView() {
        addMemberButton.setVisible(false);
        updateMemberButton.setVisible(false);
        this.deleteMemberButton.setVisible(false);
    }

}
