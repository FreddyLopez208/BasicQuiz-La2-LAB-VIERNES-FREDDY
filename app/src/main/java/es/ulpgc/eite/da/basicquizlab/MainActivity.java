package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, resultText;

  private String[] questionArray;
  private int quizIndex =0;
  private int[] answerArray;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();
  }


  private void initLayoutData() {
    // Recuperar preguntas y  respuestas desde strings.xml
    questionArray=getResources().getStringArray(R.array.question_array);
    answerArray =getResources().getIntArray(R.array.answer_array);
  }


  private void linkLayoutComponents() {
    falseButton = findViewById(R.id.falseButton);
    trueButton = findViewById(R.id.trueButton);

    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);

    questionText = findViewById(R.id.questionText);
    resultText = findViewById(R.id.resultText);
  }


  private void initLayoutContent() {
    falseButton.setText(R.string.false_button_text);
    trueButton.setText(R.string.true_button_text);
    nextButton.setText(R.string.next_button_text);
    cheatButton.setText(R.string.cheat_button_text);

    //  codigo repetido
    updateQuestionData();

  }

  private void updateQuestionData(){

    //  codigo repetido
    questionText.setText(questionArray[quizIndex]);
    resultText.setText(R.string.empty_text);
  }

  //TODO: en vez de usar un metodo para cada boton, podemos
  // hacerlo usando un solo metodo para todos los botones
  public void onButtonClicked(View view) {

  }


  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onTrueButtonClicked(View view) { // pulsado "True"
    if(answerArray[quizIndex] == 1) { // 1 == True
      // correct
      resultText.setText(R.string.correct_text);
    } else {
      // incorrect
      resultText.setText(R.string.correct_text);
    }
  }


  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onFalseButtonClicked(View view) { // pulsado "False"
    if(answerArray[quizIndex] == 0) { // 0 == False
      // correct
      resultText.setText(R.string.correct_text);
    } else {
      // incorrect
      resultText.setText(R.string.incorrect_text);
    }
  }

  public void onCheatButtonClicked(View view) {
    // no implementado
  }

  //TODO: impedir que podamos hacer click en el boton
  // si aun no hemos contestado a la pregunta
  public void onNextButtonClicked(View view) {

    quizIndex++; //  sig. pregunta

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente
    //TODO: refactorizar en un método este codigo
    // por si queremos implementar otras opciones posibles
    if(quizIndex == questionArray.length) {
      quizIndex =0;  // volver  a  empezar
    }

    //  codigo repetido
    updateQuestionData();
  }
}
