//group#4
import java.util.*;
import java.io.*;
public class ExamManager{ 
   private QuestionBank qBank;
  

   public  ExamManager(String courseName){
   
      qBank=new QuestionBank(courseName);
   
      File file=new File (courseName+".ser");
      if(!(file.exists())){
         System.out.println("thers no such file whith this name! ");
         return;}
     try {

   qBank.loadQuestions(courseName+".ser");}

         catch (FileNotFoundException e){

            System.err.println("Error: "+e.getMessage());}

         catch (IOException e) {

            System.err.println("Error: "+e.getMessage());}

        catch (ClassNotFoundException e) {

            System.err.println("Error: "+e.getMessage());}
        
   
   
   }
   
   public boolean addNewQuestion(Question q){
   
      return qBank.addQustion(q);
   }
 
 
   public void removeChapterQuestions(String chapterName){
   
      int size =qBank.countChapterQuestions(chapterName);
      Question[] Que=qBank.getChapterQuestion(size,chapterName);  
      String allIds[]=new String[size];
      for(int i=0;i<size;i++)
         allIds[i]= Que[i].getqID();
   
      qBank.removeAllQuestion(allIds);
   
   }
 
public double generateExam (String header, int n, String chapterName, boolean withAnswers )throws FileNotFoundException{
      String textName= qBank.getCourseName()+"Exam.txt";
      Question array[];
      File File=new File (textName); 
      FileOutputStream FileS=new FileOutputStream(File);
      PrintWriter toWrite=new PrintWriter(FileS);
      double grades=0;
      
     try{
   
      toWrite.println(header);
   
      if (chapterName== null ||chapterName == "")
         array =qBank.getRandomQuestions(n);
      else
         array=qBank.getChapterQuestion(n,chapterName);
   
      for (int i=0;i<n;i++){
         if(withAnswers!=false)
            toWrite.println(array[i].formattedQwithA());
         else
            toWrite.println(array[i].formattedQ());
      
         grades+=array[i].getpGrade();
      
      }//end of loop
   } //end of try
   finally{
      toWrite.close();}
      return grades;}





   public void exportQBank() throws IOException{
      qBank.saveQuestions();
   
   }

}//end of the clss