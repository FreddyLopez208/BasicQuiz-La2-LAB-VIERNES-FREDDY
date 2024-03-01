package es.ulpgc.eite.da.basicquizlab;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

@SuppressWarnings("ALL")
public class QuizEspressoSteps {

  private static final int DELAY_IN_SECS = 0 * 1000;

  Context appContext =
          InstrumentationRegistry.getInstrumentation().getTargetContext();
  String[] questionArray =
          appContext.getResources().getStringArray(R.array.question_array);

  public void iniciarPantallaQuestion() {

    /*
    try {
      UiDevice device = UiDevice.getInstance(getInstrumentation());
      device.setOrientationNatural();
    } catch (RemoteException e) {
    }
    */

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

  }

  public void mostrarPregunta(int index) {
    onView(withId(R.id.questionText)).check(matches(isDisplayed()));
    onView(withId(R.id.questionText)).check(matches(withText(questionArray[index-1])));
  }

  /*
  public void mostrarPregunta(String q) {
    onView(withId(R.id.questionText)).check(matches(isDisplayed()));
    onView(withId(R.id.questionText)).check(matches(withText(q)));
  }
  */

  public void ocultarResultado() {
    //onView(withId(R.id.questionText)).check(matches(not(isDisplayed())));
    //onView(withId(R.id.replyText)).check(matches(isDisplayed()));
    //onView(withId(R.id.replyText)).check(matches(withText("???")));
    onView(withId(R.id.resultText))
      .check(matches(withText(appContext.getResources().getString(R.string.empty_text))));
  }

  /*
  public void ocultarResultado(String res) {
    //onView(withId(R.id.questionText)).check(matches(not(isDisplayed())));
    //onView(withId(R.id.replyText)).check(matches(isDisplayed()));
    //onView(withId(R.id.replyText)).check(matches(withText("???")));
    onView(withId(R.id.resultText)).check(matches(withText(res)));
    //onView(withId(R.id.resultText))
    //  .check(matches(withText(activity.getString(R.string.empty_text))));
  }
  */

  public void ocultarRespuesta() {
    //onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    //onView(withId(R.id.answerText)).check(matches(withText("???")));
    onView(withId(R.id.answerText))
      .check(matches(withText(appContext.getString(R.string.empty_text))));
  }

  /*
  public void ocultarRespuesta(String res) {
    //onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    //onView(withId(R.id.answerText)).check(matches(withText("???")));
    onView(withId(R.id.answerText)).check(matches(withText(res)));
    //onView(withId(R.id.answerText))
    //  .check(matches(withText(activity.getString(R.string.empty_text))));
  }
  */

  public void mostrarBotonesTrueYFalseYCheatActivados() {
    onView(withId(R.id.trueButton)).check(matches(isEnabled()));
    onView(withId(R.id.falseButton)).check(matches(isEnabled()));
    onView(withId(R.id.cheatButton)).check(matches(isEnabled()));
  }

  public void mostrarBotonNextDesactivado() {
    onView(withId(R.id.nextButton)).check(matches(not(isEnabled())));
  }

  public void pulsarBoton(int button) {

    //String tb = activity.getString(R.string.true_button_text);
    //int button = (b.equals("True")) ? R.id.trueButton : R.id.falseButton;
    //int button = (b.equals(tb)) ? R.id.trueButton : R.id.falseButton;
    onView(withId(button)).check(matches(isDisplayed()));
    onView(withId(button)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  /*
  public void pulsarBoton(String b, String tb) {

    //String tb = activity.getString(R.string.true_button_text);
    //int button = (b.equals("True")) ? R.id.trueButton : R.id.falseButton;
    int button = (b.equals(tb)) ? R.id.trueButton : R.id.falseButton;
    onView(withId(button)).check(matches(isDisplayed()));
    onView(withId(button)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }
  */

  public void mostrarResultadoARespuesta(int res) {
    String txt =  appContext.getResources().getString(res);
    onView(withId(R.id.resultText)).check(matches(isDisplayed()));
    onView(withId(R.id.resultText)).check(matches(withText(txt)));
  }

  /*
  public void mostrarResultadoARespuesta(String r, String a) {
    onView(withId(R.id.resultText)).check(matches(isDisplayed()));
    onView(withId(R.id.resultText)).check(matches(withText(r)));
  }
  */

  public void mostrarBotonesTrueYFalseYCheatDesactivados() {
    onView(withId(R.id.trueButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.falseButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.cheatButton)).check(matches(not(isEnabled())));

  }

  public void mostrarBotonNextActivado() {
    onView(withId(R.id.nextButton)).check(matches(isEnabled()));
  }

  /*
  public void pulsarBotonCheat() {

    onView(withId(R.id.cheatButton)).check(matches(isDisplayed()));
    onView(withId(R.id.cheatButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }
  */

  public void iniciarPantallaCheat() {
    //getInstrumentation().waitForIdleSync();

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }


  public void mostrarMensajeWarning() {
    onView(withId(R.id.warningText)).check(matches(isDisplayed()));
    //onView(withId(R.id.warningText))
    //    .check(matches(withText("Are you sure?")));

    onView(withId(R.id.warningText))
        .check(matches(withText(appContext.getString(R.string.warning_text))));

  }

  /*
  public void mostrarMensajeWarning(String msg) {
    onView(withId(R.id.warningText)).check(matches(isDisplayed()));
    //onView(withId(R.id.warningText))
    //    .check(matches(withText("Are you sure?")));
    onView(withId(R.id.warningText)).check(matches(withText(msg)));

    // onView(withId(R.id.warningText))
    //    .check(matches(withText(activity.getString(R.string.warning_text))));

  }

  */

  public void mostrarBotonesYesYNoActivados() {
    onView(withId(R.id.yesButton)).check(matches(isEnabled()));
    onView(withId(R.id.noButton)).check(matches(isEnabled()));
  }

  /*
  public void pulsarBotonNo() {

    onView(withId(R.id.noButton)).check(matches(isDisplayed()));
    onView(withId(R.id.noButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }
  */

  public void finalizarPantallaCheat() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  public void resumirPantallaQuestion() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  /*
  public void pulsarBotonYes() {

    onView(withId(R.id.yesButton)).check(matches(isDisplayed()));
    onView(withId(R.id.yesButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }
  */


  public void mostrarRespuestaAPregunta(int res) {
    onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    onView(withId(R.id.answerText))
            .check(matches(withText(appContext.getString(res))));
  }

  /*
  public void mostrarRespuestaAPregunta(String a, String q) {
    onView(withId(R.id.answerText)).check(matches(isDisplayed()));
    onView(withId(R.id.answerText)).check(matches(withText(a)));
  }
  */


  public void mostrarBotonesYesYNoDesactivados() {
    onView(withId(R.id.yesButton)).check(matches(not(isEnabled())));
    onView(withId(R.id.noButton)).check(matches(not(isEnabled())));

  }

  public void pulsarBotonBack() {
    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }

    //getInstrumentation().waitForIdleSync();
    pressBack();
  }

  public void pulsarBotonNext() {

    onView(withId(R.id.nextButton)).check(matches(isDisplayed()));
    onView(withId(R.id.nextButton)).perform(click());

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }

  /*
  public void girarPantalla() {

    int orientation = activity.getRequestedOrientation();

//    if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
//
//    } else {
//      orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
//    }
//
//    activity.setRequestedOrientation(orientation);

    try {

      UiDevice device = UiDevice.getInstance(getInstrumentation());

      if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        device.setOrientationNatural();

      } else {
        device.setOrientationLeft();
      }

    } catch (RemoteException e) {
    }

    try {
      Thread.sleep(DELAY_IN_SECS);
    } catch (InterruptedException e) {
    }
  }
  */

}
