//group#4
public class TrueFalseQ extends Question{
private boolean correctAnswer;

public TrueFalseQ(String text, String qID, double pGrade , boolean correctAnswer){
super(text,qID,pGrade);
this.correctAnswer=correctAnswer;
}

public TrueFalseQ(Question q){
this(q.text, q.qID, q.pGrade,((TrueFalseQ) q).correctAnswer);//casting
}
   public boolean getCorrectAnswer(){
    return correctAnswer ;
   }
   public void setCorrectAnswer(boolean correctAnswer){
    this.correctAnswer=correctAnswer;
   }

public String formattedQ(){
return "True or False\n"+qID+":"+text;
}

public String formattedQwithA(){
return formattedQ()+ "\nCorrect Answer is "+correctAnswer;
}
}//end of class
