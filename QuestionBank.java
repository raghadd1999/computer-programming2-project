//group#4
import java.io.*;
class QuestionBank{

   private String courseName; 
   private int nOfQ; 
   private Question[] qList;

   public QuestionBank (String courseName){
      this.courseName=courseName; 
      nOfQ=0; 
      qList=new Question[100];} 

   public String getCourseName(){
      return courseName;} 
      
   public void setCourseName(String courseName){
    this.courseName=courseName;}

   public Question[] getqList(){ 
      return qList;} 
      
   public void setqList(Question[]qList ){
    this.qList=qList;}

   public int getnOfQ(){ 
      return nOfQ;} 
      
   public void setnOfQ(int nOfQ){
       this.nOfQ=nOfQ;}

   public int findQuestion (Question q){
      for (int i=0; i<nOfQ; i++){ 
         if (q.getqID().toLowerCase().equals(qList[i].getqID().toLowerCase()) || q.getText().toLowerCase().equals(qList[i].getText().toLowerCase()))
            return i;}
      return -1; } 

   public boolean addQustion (Question q){ 
   
      if (qList.length==nOfQ){
         return false;}//correct
   
      if (findQuestion(q)!= -1){
         return false;}//correct
   
   
      if (q instanceof FillBlankQ) {
            qList[nOfQ++] = new FillBlankQ(q);}

         else if (q instanceof MCQ) {

            qList[nOfQ++] = new MCQ(q);}

         else { qList[nOfQ++] = new TrueFalseQ(q);}
        

        return true;}



   public Question[] getRandomQuestions (int n){ 
      if (nOfQ<n || n<=0){ 
         throw new IllegalArgumentException("Sorry, input is invalid");}
   
      Question[] array= new Question[n]; 
      int[] Numbers= new int[n];
      int index=0;
      boolean flag=true;
      
      int max=nOfQ-1; //largest index in the array
      int j=0; 
      
      
      for (int i=0 ; i<n ; i++){
      flag = true;

         int randomNumber= (int)( Math.random()*100);
         if(randomNumber>=nOfQ){
         i--;
         continue;}
         else{
         if(index==n)
         break;
         for(int x=0 ; x< index; x++)
         if(Numbers[x]==randomNumber){
         flag=false;
         i--;}
         
         if(flag){
         Numbers[index++]=randomNumber;

         if(qList[randomNumber] instanceof TrueFalseQ)
            array[i]= new TrueFalseQ (qList[randomNumber]); 
         else if (qList[randomNumber] instanceof MCQ)
            array[i]= new MCQ (qList[randomNumber]);
         else if (qList[randomNumber] instanceof FillBlankQ)
            array[i]= new FillBlankQ (qList[randomNumber]);}
            }
            }      
      return array;}//End method  
 
  

   public int countChapterQuestions(String cName){
      int count =0; 
      for (int i=0 ; i<nOfQ ; i++){ 
         if (qList[i].getqID().substring(0,qList[i].getqID().indexOf('_')).toLowerCase().equals(cName))
            count++; }
      return count; }

   public Question[] getChapterQuestion(int n, String cName){
      Question[] array; 
      int count= countChapterQuestions(cName); 
   
      if (count<n)
         array= new Question[count];
      else array= new Question[n];
   
   

      int j=0; 
      for (int i=0; i<array.length; i++){ 
         if (qList[i].getqID().substring(0,qList[i].getqID().indexOf('_')).toLowerCase().equals(cName.toLowerCase()))
            if(qList[i] instanceof TrueFalseQ)
               array[j++]= new TrueFalseQ (qList[i]); 
            else if (qList[i] instanceof MCQ)
               array[j++]= new MCQ (qList[i]);
            else if (qList[i] instanceof FillBlankQ)
               array[j++]= new FillBlankQ (qList[i]);  }//End for 
      return array;} //End method
    

   public void removeAllQuestion(String[] ids){ 
      for (int i=0; i<ids.length; i++){ 
         for (int j=0 ; j<nOfQ ; j++){
            if (ids[i].toLowerCase().equals(qList[j].qID.toLowerCase())){
               for (int h=j; h<nOfQ-1 ; h++){
                  qList[h]= qList[h+1];}//End for 
               qList[--nOfQ]=null;
                break;} //End if 
         }//End nested for
      }// End for 
   }//End  the methood 
        
        
        
            
   public void saveQuestions()throws FileNotFoundException,IOException{ 
   
      FileOutputStream file = new FileOutputStream (courseName.toLowerCase()+".ser");
      ObjectOutputStream obj= new ObjectOutputStream (file); 
   
      try{ 
         for (int i=0; i<nOfQ ; i++){ 
            obj.writeObject(qList[i]);}}
      
      finally{
         obj.close(); }
   }//End method 

   
   
   public int loadQuestions(String fname) throws FileNotFoundException,ClassNotFoundException,IOException{ 
   
      if (!(fname.substring(0,fname.indexOf('.')).toLowerCase().equals(courseName.toLowerCase())))
         throw new IllegalArgumentException("Sorry, the file name is not same course name"); 
   
      FileInputStream file= new FileInputStream (fname);
      ObjectInputStream obj= new ObjectInputStream(file);
   
      int count=0; 
      boolean flag=true;
      while (flag){
         try{ 
            addQustion((Question)obj.readObject()); 
            count++; // if the file is  stop from the read by default throws EOFE
         } 
         
         catch (EOFException e){ 
            System.out.print("End of load, the number of Qusetion"+count);
            flag=false;} }//End while
    
      obj.close(); 
      return count; } 
  
   
   
   
   
   
   
} 
   
    
  
   
     
        


        
        
   
   
   

  


 





 







