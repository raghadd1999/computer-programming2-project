public class MCQ extends Question{

   private int correctAnswer;
   private String[] choices= new String[4];

   public MCQ(String text, String qID, double pGrade, int correctAnswer, String[] choices){
      super(text, qID, pGrade);
      this.correctAnswer=correctAnswer;
      for(int i=0; i<4 ; i++)
      this.choices[i]=choices[i];
   }

   public MCQ(Question q){
      super(q);
      correctAnswer=((MCQ)q).correctAnswer;
      for(int i=0; i<4 ; i++)
      choices[i]=((MCQ)q).choices[i];
   
   }
   public int getCorrectAnswer(){
    return correctAnswer ;
   }
   public void setCorrectAnswer(int correctAnswer){
    this.correctAnswer=correctAnswer;
   }
   
   public String formattedQ(){
      String s="Choose the correct answer:/n"+qID+":"+text;
      for(int i=0; i<4 ; i++)
         s+="/n"+(i+1)+":"+choices[i];
      return s;
   }

   public String formattedQwithA(){
      return String.format("%s %nCorrect Answer is %s ",formattedQ(),choices[correctAnswer]);
   }

}