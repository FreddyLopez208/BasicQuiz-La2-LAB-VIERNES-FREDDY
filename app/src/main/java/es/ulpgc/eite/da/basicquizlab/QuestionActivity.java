package es.ulpgc.eite.da.basicquizlab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

  public static final String TAG = "Quiz.QuestionActivity";

  public static final int CHEAT_REQUEST = 1;

  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, resultText;

  private String[] questionArray;
  private int quizIndex =0;
  private int[] answerArray;
  private boolean nextButtonEnabled;
  //private boolean falseButtonEnabled, trueButtonEnabled;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    getSupportActionBar().setTitle(R.string.question_title);

    initLayoutData();
    linkLayoutComponents();
    updateLayoutContent();
    enableLayoutButtons();
  }

/*
  private void enableLayoutButtons() {

    trueButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onTrueButtonClicked();
      }
    });

    falseButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onFalseButtonClicked();
      }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onNextButtonClicked();
      }
    });

    cheatButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        onCheatButtonClicked();
      }
    });
  }
  */


  private void enableLayoutButtons() {

//    trueButton.setOnClickListener(v -> onButtonClicked(v));
//    falseButton.setOnClickListener(v -> onButtonClicked(v));
//    nextButton.setOnClickListener(v -> onButtonClicked(v));
//    cheatButton.setOnClickListener(v -> onButtonClicked(v));

    trueButton.setOnClickListener(v -> onTrueButtonClicked());
    falseButton.setOnClickListener(v -> onFalseButtonClicked());
    nextButton.setOnClickListener(v -> onNextButtonClicked());
    cheatButton.setOnClickListener(v -> onCheatButtonClicked());
  }


  private void initLayoutData() {
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


  private void updateLayoutContent() {
    questionText.setText(questionArray[quizIndex]);

    if(!nextButtonEnabled) {
      resultText.setText(R.string.empty_text);
    }

    nextButton.setEnabled(nextButtonEnabled);
    cheatButton.setEnabled(!nextButtonEnabled);
    falseButton.setEnabled(!nextButtonEnabled);
    trueButton.setEnabled(!nextButtonEnabled);
  }


  private void onTrueButtonClicked() {

    /*
    if(nextButtonEnabled) {
      return;
    }
    */

    if(answerArray[quizIndex] == 1) {
      resultText.setText(R.string.correct_text);
    } else {
      resultText.setText(R.string.incorrect_text);
    }

    nextButtonEnabled = true;
    updateLayoutContent();
  }

  private void onButtonClicked(View v) {

    int viewId = v.getId();

    if (viewId == R.id.trueButton) {
      onTrueButtonClicked();
    }

    // ...

  }

  private void onFalseButtonClicked() {

    /*
    if(nextButtonEnabled) {
      return;
    }
    */

    if(answerArray[quizIndex] == 0) {
      resultText.setText(R.string.correct_text);
    } else {
      resultText.setText(R.string.incorrect_text);
    }

    nextButtonEnabled = true;
    updateLayoutContent();

  }

  private void onCheatButtonClicked() {

    /*
    if(nextButtonEnabled) {
      return;
    }
    */

    Intent intent = new Intent(this, CheatActivity.class);
    //intent.putExtra("RESPUESTA_A_PREGUNTA", answerArray[quizIndex]);
    intent.putExtra(CheatActivity.EXTRA_ANSWER, answerArray[quizIndex]);  //  state
    startActivityForResult(intent, CHEAT_REQUEST); // requestCode
    //startActivity(intent);
  }



  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);

    Log.d(TAG, "onActivityResult()");

    if (resultCode == RESULT_OK) {
      if (requestCode == CHEAT_REQUEST) {  //  le pregunté cual eera la respuesta correcta

        boolean answerCheated = // has visto la respuesta
              intent.getBooleanExtra(CheatActivity.EXTRA_CHEATED, false);

        /*boolean answerCheated =
              intent.getExtras().getBoolean(CheatActivity.EXTRA_CHEATED, false);*/

        Log.d(TAG, "answerCheated: " + answerCheated);

        if (answerCheated) {  // pasar a la si pregunta
          nextButtonEnabled = true;
          onNextButtonClicked();
        }
      }
    }
  }

  private void onNextButtonClicked() {
    Log.d(TAG, "onNextButtonClicked()");

    /*
    if(!nextButtonEnabled) {
      return;
    }
    */

    nextButtonEnabled = false;
    quizIndex++;

    // si queremos que el quiz acabe al llegar
    // a la ultima pregunta debemos comentar esta linea
    checkIndexData();

    if(quizIndex < questionArray.length) {
      updateLayoutContent();
    }

  }

  private void checkIndexData() {

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente
    if(quizIndex == questionArray.length) {
      quizIndex =0;
    }

  }

}
