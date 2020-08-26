//group#4
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HomeFrame extends JFrame implements ActionListener{
   JButton openButton;
   JComboBox <String> list;
   JLabel PreviousLabel,NewLabel;
   JPanel openPanel;
   JTextField text;
   String courseName;

   ExamManager [] exams=new ExamManager[5];
   public static void main(String [] args){
      HomeFrame obj=new HomeFrame();
      obj.setVisible(true);
}//end main

   public HomeFrame(){
      this.setContentPane(new JLabel());
      setTitle("Exam Manager ");
      setLocation(200,100);
      this.pack();
      setSize(500, 500);
      setResizable(false);
 
      openPanel = new JPanel();
      openPanel.setBorder(BorderFactory.createTitledBorder("Open"));
      openPanel.setBounds(10,70,230,280);
      add(openPanel);
      openPanel.setLayout(null);
   
      PreviousLabel = new JLabel("Previous Courses");
      PreviousLabel.setBounds(20,30,120,20);
      openPanel.add(PreviousLabel);
   
      NewLabel = new JLabel("New Course");
      NewLabel.setBounds(20,100,120,20);
      openPanel.add(NewLabel);

      list= new JComboBox<String>();
      list.setBounds(40,60,160,30);
      openPanel.add(list);
   
      text=new JTextField();
      text.setColumns(10);
      text.setBounds(40,130,160,30);
      openPanel.add(text);
   
      openButton=new JButton("Open Question Bank");
      openButton.setBounds(40,190,160,30);
      openPanel.add(openButton);
      openButton.addActionListener(this);
      
      
      //if there is no files then the drop-down menu should be empty

      list.setEnabled(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   
      File folder =new File (".");
      File[] listOfFiles=folder.listFiles();
   
      for(int i=0; i<listOfFiles.length ;i++){
         if(listOfFiles[i].isFile()){
            if(listOfFiles[i].getName().endsWith(".ser")){
               list.setEnabled(true);
            
               courseName=listOfFiles[i].getName().substring(0,listOfFiles[i].getName().indexOf('.'));
               list.addItem(courseName);}}
      }}
   
   public void actionPerformed(ActionEvent event){
   // a new Question Bank Viewer frame (for the selected course from the drop-down menu or for the entered text) is displayed.

      if(event.getSource()==(JButton) openButton){
         String course="";
         if(text.getText().length()!=0)
            course=text.getText();
         else
            course=list.getSelectedItem().toString();
      
         ExamManager exams = new ExamManager(course);
         QuestionBankViewer obj = new QuestionBankViewer(exams);
         return;
      }}

        
}//end of class