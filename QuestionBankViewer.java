//group#4
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class  QuestionBankViewer extends JFrame implements ActionListener {
JPanel PanelNewQ, PanelGenE, PanelDelCQ, PanelAnsw_MCQ;
JLabel labelQT, labelQID, labelPGrade, labelTypeQ, labelCorrectA, labelExamHead, labelNoQ, labelChName_GE, labelChName_DCQ;
JTextField textQT, textQID, textPGrade, textCorrectA, textExamHead, textNoQ, textChName_GE, textChName_DCQ, text_AMCQ1, text_AMCQ2, text_AMCQ3, text_AMCQ4;
JRadioButton radioMCQ, radioT_F, radioFillB;
JButton buttonAdd, buttonExam, buttonRemove;
JCheckBox checkBoxWhitA;

static JTextArea textArea;
JScrollPane scrolltxt;
ExamManager exam;

public QuestionBankViewer(ExamManager obj) {
exam = obj;
addWindowListener(new CloseFrame());
Container contentPane = getContentPane();
setTitle("Question Bank");
setResizable(false);
setSize(950, 600);
contentPane.setLayout(null);
this.setVisible(true);
   
//panels
      
      
      //A panel for adding a new question to the bank.
      PanelNewQ = new JPanel();
      PanelNewQ.setBorder(BorderFactory.createTitledBorder("Add a New Question"));
      PanelNewQ.setBounds(20, 110, 400, 400);
      PanelNewQ.setLayout(null);
      contentPane.add(PanelNewQ);
      
      //A panel for generating an exam
      PanelGenE = new JPanel();
      PanelGenE.setBorder(BorderFactory.createTitledBorder("Generate Exam"));
      PanelGenE.setBounds(430, 110, 500, 280);
      PanelGenE.setLayout(null);
      contentPane.add(PanelGenE);
      
      //A panel for removing a chapter questions
      PanelDelCQ = new JPanel();
      PanelDelCQ.setBorder(BorderFactory.createTitledBorder("Delete Chapter Questions"));
      PanelDelCQ.setBounds(430, 400, 500, 110);
      PanelDelCQ.setLayout(null);
      contentPane.add(PanelDelCQ);
      
      PanelAnsw_MCQ = new JPanel();
      PanelAnsw_MCQ.setBorder(BorderFactory.createTitledBorder("Answers for MCQ"));
      PanelAnsw_MCQ.setBounds(20, 230, 220, 160);
      PanelAnsw_MCQ.setLayout(null);
      PanelNewQ.add(PanelAnsw_MCQ);
     
//labels


      //panel add a new question contains text fields for all the Question’s information.
      labelQT = new JLabel("Question Text");
      labelQT.setBounds(20, 20, 150, 30);
      PanelNewQ.add(labelQT);
   
      textQT = new JTextField();
      textQT.setColumns(10);
      textQT.setBounds(160, 20, 170, 20);
      PanelNewQ.add(textQT);
   
      labelQID = new JLabel("Quesetion ID");
      labelQID.setBounds(20, 50, 150, 30);
      PanelNewQ.add(labelQID);
   
      textQID = new JTextField();
      textQID.setColumns(10);
      textQID.setBounds(160, 50, 150, 20);
      PanelNewQ.add(textQID);
   
      labelPGrade = new JLabel("Possible Grade");
      labelPGrade.setBounds(20, 80, 150, 30);
      PanelNewQ.add(labelPGrade);
   
      textPGrade = new JTextField();
      textPGrade.setColumns(10);
      textPGrade.setBounds(160, 80, 150, 20);
      PanelNewQ.add(textPGrade);
   
      labelTypeQ = new JLabel("Choose the type of the question:");
      labelTypeQ.setBounds(20, 100, 200, 50);
      PanelNewQ.add(labelTypeQ);
   
      radioMCQ = new JRadioButton("MCQ");
      radioMCQ.setBounds(30, 140, 80, 40);
      PanelNewQ.add(radioMCQ);
      radioMCQ.addActionListener(this);
   
      radioT_F = new JRadioButton("True/False");
      radioT_F.setBounds(110, 140, 100, 40);
      PanelNewQ.add(radioT_F);
      radioT_F.addActionListener(this);
   
      radioFillB = new JRadioButton("Fill Blank");
      radioFillB.setBounds(210, 140, 80, 40);
      PanelNewQ.add(radioFillB);
      radioFillB.addActionListener(this);
   
      labelCorrectA = new JLabel("Correct Answer");
      labelCorrectA.setBounds(20, 190, 150, 30);
      PanelNewQ.add(labelCorrectA);
   
      textCorrectA = new JTextField();
      textCorrectA.setColumns(10);
      textCorrectA.setBounds(160, 195, 150, 20);
      PanelNewQ.add(textCorrectA);
   
      text_AMCQ1 = new JTextField();
      text_AMCQ1.setColumns(50);
      text_AMCQ1.setBounds(20, 30, 180, 20);
      PanelAnsw_MCQ.add(text_AMCQ1);
   
      text_AMCQ2 = new JTextField();
      text_AMCQ2.setColumns(50);
      text_AMCQ2.setBounds(20, 60, 180, 20);
      PanelAnsw_MCQ.add(text_AMCQ2);
   
      text_AMCQ3 = new JTextField();
      text_AMCQ3.setColumns(50);
      text_AMCQ3.setBounds(20, 90, 180, 20);
      PanelAnsw_MCQ.add(text_AMCQ3);
   
      text_AMCQ4 = new JTextField();
      text_AMCQ4.setColumns(50);
      text_AMCQ4.setBounds(20, 120, 180, 20);
      PanelAnsw_MCQ.add(text_AMCQ4);
      
      buttonAdd = new JButton("Add Question");
      buttonAdd.setBounds(250, 340, 120, 30);
      PanelNewQ.add(buttonAdd);
      buttonAdd.addActionListener(this);
   
   
      /*
      panel generate exam contains text fields for all the Exam’s information.
      A check box to determine if the exam should contains answers.
      An uneditable text area for displaying the generated exam.
      */
      labelExamHead = new JLabel("Exam Header");
      labelExamHead.setBounds(20, 20, 150, 30);
      PanelGenE.add(labelExamHead);
   
      textExamHead = new JTextField();
      textExamHead.setColumns(10);
      textExamHead.setBounds(160, 20, 150, 20);
      PanelGenE.add(textExamHead);
   
      labelNoQ = new JLabel("Number of Questions");
      labelNoQ.setBounds(20, 50, 150, 30);
      PanelGenE.add(labelNoQ);
   
      textNoQ = new JTextField();
      textNoQ.setColumns(10);
      textNoQ.setBounds(160, 50, 150, 20);
      PanelGenE.add(textNoQ);
   
      labelChName_GE = new JLabel("Chapter Name");
      labelChName_GE.setBounds(20, 80, 150, 30);
      PanelGenE.add(labelChName_GE);
   
      textChName_GE = new JTextField();
      textChName_GE.setColumns(10);
      textChName_GE.setBounds(160, 80, 150, 20);
      PanelGenE.add(textChName_GE);
   
      checkBoxWhitA = new JCheckBox("With Answers");
      checkBoxWhitA.setBounds(160, 100, 120, 70);
      PanelGenE.add(checkBoxWhitA);
   
      buttonExam = new JButton("Generate Exam");
      buttonExam.setBounds(320, 125, 140, 20);
      PanelGenE.add(buttonExam);
      buttonExam.addActionListener(this);
   
      textArea = new JTextArea();
      scrolltxt = new JScrollPane(textArea);
      scrolltxt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      scrolltxt.setBounds(20, 170, 450, 100);
      PanelGenE.add(scrolltxt);
   
   
   
      //panel Delete Chapter Questions contains a text field for the chapter name.
      
      labelChName_DCQ = new JLabel("Chapter Name");
      labelChName_DCQ.setBounds(20, 40, 150, 30);
      PanelDelCQ.add(labelChName_DCQ);
   
      textChName_DCQ = new JTextField();
      textChName_DCQ.setColumns(10);
      textChName_DCQ.setBounds(150, 45, 150, 20);
      PanelDelCQ.add(textChName_DCQ);
   
      buttonRemove = new JButton("Remove");
      buttonRemove.setBounds(320, 45, 140, 20);
      PanelDelCQ.add(buttonRemove);
      buttonRemove.addActionListener(this);
      PanelAnsw_MCQ.setVisible(false);
}//end of method Question

public void clearTexts() {
      textQT.setText("");
      textQID.setText("");
      textPGrade.setText("");
      textCorrectA.setText("");
      textExamHead.setText("");
      textNoQ.setText("");
      textChName_GE.setText("");
      textChName_DCQ.setText("");
      text_AMCQ1.setText("");
      text_AMCQ2.setText("");
      text_AMCQ3.setText("");
      text_AMCQ4.setText("");
      radioMCQ.setSelected(false);
      radioT_F.setSelected(false);
      radioFillB.setSelected(false);
      checkBoxWhitA.setSelected(false);
}//end of method clearTexts
public void actionPerformed(ActionEvent e) {

/* The user should be allowed to select only one radio button for the
Question type (MCQ, True/False , Fill Blank).

If “MCQ” radio button is selected; “Answers for MCQ” text fields should appear
*/

if (e.getSource() == (JRadioButton) radioMCQ){
         radioMCQ.setSelected(true);
         radioT_F.setSelected(false);
         radioFillB.setSelected(false);
         PanelAnsw_MCQ.setVisible(true);
}else if (e.getSource() == (JRadioButton) radioT_F){
         radioMCQ.setSelected(false);
         radioT_F.setSelected(true);
         radioFillB.setSelected(false);
         PanelAnsw_MCQ.setVisible(false);
}else if (e.getSource() == (JRadioButton) radioFillB){
         radioMCQ.setSelected(false);
         radioT_F.setSelected(false);
         radioFillB.setSelected(true);
         PanelAnsw_MCQ.setVisible(false);}
if (e.getSource() == (JButton) buttonAdd){
try {
if (textQT.getText().length() == 0 || textQID.getText().length() == 0 || textPGrade.getText().length() == 0 || textCorrectA.getText().length() == 0) {
               JOptionPane.showMessageDialog(this, "you must enter all information");
               return;
}//end if
            Question Q = null;
            String[] answers = new String[4];
         
if (radioMCQ.isSelected()) {
if (text_AMCQ1.getText().length() == 0 || text_AMCQ2.getText().length() == 0 || text_AMCQ3.getText().length() == 0 || text_AMCQ4.getText().length() == 0) {
                  JOptionPane.showMessageDialog(this, "you must enter all choices");
                  return;}
               answers[0] = text_AMCQ1.getText();
               answers[1] = text_AMCQ2.getText();
               answers[2] = text_AMCQ3.getText();
               answers[3] = text_AMCQ4.getText();
            
               Q = new MCQ(textQT.getText(), textQID.getText(), Double.parseDouble(textPGrade.getText()),
                  	Integer.parseInt(textCorrectA.getText()), answers);
if (exam.addNewQuestion(Q))
                  JOptionPane.showMessageDialog(this, "Question added successfully!");
else
                  System.out.print("No more place or question already exist");
} else if (radioT_F.isSelected()) {
               Q= new TrueFalseQ(textQT.getText(), textQID.getText(), Double.parseDouble(textPGrade.getText()),
                  	Boolean.parseBoolean(textCorrectA.getText()));//
if (exam.addNewQuestion(Q))
                  JOptionPane.showMessageDialog(this, "Question added successfully!");
else
                  System.out.print("No more place or question already exist");
} else if (radioFillB.isSelected()) {
               Q = new FillBlankQ(textQT.getText(), textQID.getText(), Double.parseDouble(textPGrade.getText()),
                  	textCorrectA.getText());
if (exam.addNewQuestion(Q))
                  JOptionPane.showMessageDialog(this, "Question added successfully!");
else
                  JOptionPane.showMessageDialog(this, "No more place or question already exist");}
} catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, " NumberFormatException");
            return;
} finally{
            clearTexts();}
}//end if


if (e.getSource() == (JButton) buttonExam) {
try {
if (textExamHead.getText().length() == 0 || textNoQ.getText().length() == 0) {
               JOptionPane.showMessageDialog(this, "you must enter all information");
               return;}
            double total = exam.generateExam(textExamHead.getText(), Integer.parseInt(textNoQ.getText()), textChName_GE.getText(),
               	checkBoxWhitA.isSelected());
            
} catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, " NumberFormatException");
            return;
} catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(this, "Error while generating Exam! File Not Found!");
            return;}
            finally{
            clearTexts();}
}//end if
if (e.getSource() == (JButton) buttonRemove) {
if (textChName_DCQ.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "you must enter all information");
            return;}
         exam.removeChapterQuestions(textChName_DCQ.getText());
         JOptionPane.showMessageDialog(this, "Chapter delted successfully!");
         clearTexts();
}//end if 
}//end of method action

class CloseFrame extends WindowAdapter {
      public void windowClosing(WindowEvent evt) {
         int answer = JOptionPane.showConfirmDialog(null, "do you want to save the changes?", "Alert!",
            	JOptionPane.YES_NO_OPTION);
if (answer == JOptionPane.YES_OPTION) {
try{
               exam.exportQBank();
} catch (IOException e){
               JOptionPane.showMessageDialog(null, "error while saving questions of this course");}
            JOptionPane.showMessageDialog(null,"Thank you for using the Exam Manager. \n" + "All questions have been saved ");
} else
            JOptionPane.showMessageDialog(null, "Thank you for using the Exam Manager.");
}//end of method windoClosing
}//end of class CloseFrame
}//end class