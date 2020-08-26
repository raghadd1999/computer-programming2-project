//group#4
public class FillBlankQ extends Question{

   private String correctAnswer;

   public FillBlankQ(String text, String qID, double pGrade, String correctAnswer){
      super(text, qID, pGrade);
      this.correctAnswer=correctAnswer;
   }

   public FillBlankQ(Question q){
      super(q);
      correctAnswer=((FillBlankQ)q).correctAnswer;
   
   }
    public String getCorrectAnswer(){
    return correctAnswer ;
   }
   public void setCorrectAnswer(String correctAnswer){
    this.correctAnswer=correctAnswer;
   }

   public String formattedQ(){
      return String.format("Fill the following blank%n: %s:%s",qID,text);
   
   }

   public String formattedQwithA(){
      return String.format("%s %nCorrect Answer is %s ",formattedQ(),correctAnswer);
   
   }



}